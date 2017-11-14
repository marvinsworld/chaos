//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.ewan.fel;

import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.FelEngineImpl;
import com.greenpineyu.fel.compile.FelMethod;
import com.greenpineyu.fel.compile.SourceBuilder;
import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.Function;
import com.greenpineyu.fel.function.TolerantFunction;
import com.greenpineyu.fel.function.operator.Equal;
import com.greenpineyu.fel.parser.FelNode;
import com.greenpineyu.fel.parser.Stable;

import java.util.List;

public class GEQ implements Stable, Function {
    public GEQ() {
    }

    public Object call(FelNode node, FelContext context) {
        List children = node.getChildren();
        if(children != null && children.size() == 2) {
            Object left = context.get("version");
            Object right = TolerantFunction.eval(context, children.get(1));
            return Boolean.valueOf(this.compare(left, right));
        } else {
            throw new NullPointerException("传入参数数组为空或者参数个数不正确!");
        }
    }

    public boolean compare(Object left, Object right) {

        boolean result = MobileAppHelper.compareVersion((String) left, (String) right) >= 0;
        return result;
    }

    public static StringBuilder buildRelationExpr(FelNode node, FelContext ctx, String operator) {
        List child = node.getChildren();
        FelNode leftNode = (FelNode)child.get(0);
        FelNode rightNode = (FelNode)child.get(1);
        SourceBuilder leftM = leftNode.toMethod(ctx);
        SourceBuilder rightM = rightNode.toMethod(ctx);
        Class leftType = leftM.returnType(ctx, leftNode);
        Class rightType = rightM.returnType(ctx, rightNode);
        String left = "(" + leftM.source(ctx, leftNode) + ")";
        String right = "(" + rightM.source(ctx, rightNode) + ")";
        StringBuilder sb = new StringBuilder();
        if(Number.class.isAssignableFrom(leftType)) {
            sb.append(left);
            sb.append(operator);
            Equal.appendNumber(rightType, right, sb);
        } else if(Number.class.isAssignableFrom(rightType)) {
            Equal.appendNumber(leftType, left, sb);
            sb.append(operator);
            sb.append(right);
        } else {
            if(!Comparable.class.isAssignableFrom(leftType) || !Comparable.class.isAssignableFrom(rightType)) {
                throw new UnsupportedOperationException("类型" + leftType + "与类型" + rightType + "不支持比较操作。");
            }

            sb.append("NumberUtil.compare(" + left + "," + right + ")" + operator + "0");
        }

        return sb;
    }

    public String getName() {
        return "GEQ";
    }

    public FelMethod toMethod(FelNode node, FelContext ctx) {
        StringBuilder code = buildRelationExpr(node, ctx, this.getName());
        return new FelMethod(Boolean.class, code.toString());
    }

    public boolean stable() {
        return true;
    }

    public static void main(String[] args) {
        FelEngine engine = FelEngine.instance;

        FelEngine fel = new FelEngineImpl();
        //添加函数到引擎中。
        fel.addFun(new GEQ());
        FelContext ctx = fel.getContext();
        ctx.set("version","8.1.9");

        Object result = fel.eval("GEQ(version,'8.1.0') && GEQ(version,'8.2.0')",ctx);
        //

        System.out.println(result);
    }
}
