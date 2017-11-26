package com.ewan.fel;

import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.FelEngineImpl;
import com.greenpineyu.fel.compile.FelMethod;
import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.TolerantFunction;
import com.greenpineyu.fel.function.operator.LessThen;
import com.greenpineyu.fel.parser.FelNode;

import java.util.List;

/**
 * Created by ewan on 17/11/26.
 */
public class GreaterThanImpl extends LessThen {

    public GreaterThanImpl() {
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

    public String getName() {
        return ">=";
    }

    public boolean compare(Object left, Object right) {
        return MobileAppHelper.compareVersion((String) left, (String) right) >= 0;
    }

    public FelMethod toMethod(FelNode node, FelContext ctx) {
        StringBuilder code = buildRelationExpr(node, ctx, this.getName());
        return new FelMethod(Boolean.class, code.toString());
    }

    public boolean stable() {
        return true;
    }

    public static void main(String[] args) {
        //FelEngine engine = FelEngine.instance;

        FelEngine fel = new FelEngineImpl();
        //fel.getFunMgr().getFun("GreaterThenEqual");
        fel.getFunMgr().remove("greaterthenequal");
        fel.addFun(new GreaterThanImpl());
        //添加函数到引擎中。
        //fel.addFun(new GreaterThanImpl());
        FelContext ctx = fel.getContext();
        ctx.set("version","8.1.9");
        //
        Object result = fel.eval("version>=8.1.0",ctx);
        //
        System.out.println(result);


        //System.out.println(fel.eval("3>=2"));


    }
}
