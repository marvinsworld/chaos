package com.ewan.fel;

import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.FelEngineImpl;
import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.Function;
import com.greenpineyu.fel.function.TolerantFunction;
import com.greenpineyu.fel.function.operator.LessThen;
import com.greenpineyu.fel.parser.FelNode;

import java.util.List;

/**
 * 自定义EL表达式
 * Created by ewan on 17/10/9.
 */
public class SelfEL2 {

    public static void main(String[] args) {

        //定义hello函数
        final Function fun = new LessThen() {

            @Override
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

            @Override
            public boolean compare(Object left, Object right) {
                String right_arr[] = ((String) right).split("-");
                String left_arr[] = ((String) left).split("-");

                String right_type = right_arr[0];
                String left_type = left_arr[0];
                if (right_type.equals(left_type)) {
                    boolean result = MobileAppHelper.compareVersion(left_arr[1], right_arr[1]) >= 0;
                    return result;
                } else {
                    return false;
                }


                //boolean result = MobileAppHelper.compareVersion((String) left, (String) right) >= 0;
                //return result;
            }

            @Override
            public String getName() {
                return "GEQ";
            }
        };

        //定义hello函数
        final Function fun2 = new LessThen() {

            @Override
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

            @Override
            public boolean compare(Object left, Object right) {
                String right_arr[] = ((String) right).split("-");
                String left_arr[] = ((String) left).split("-");

                String right_type = right_arr[0];
                String left_type = left_arr[0];
                if (right_type.equals(left_type)) {
                    boolean result = MobileAppHelper.compareVersion(left_arr[1], right_arr[1]) < 0;
                    return result;
                } else {
                    return false;
                }
            }

            @Override
            public String getName() {
                return "LES";
            }
        };

        FelEngine fel = new FelEngineImpl();
        //添加函数到引擎中。
        fel.addFun(fun);
        fel.addFun(fun2);
        FelContext ctx = fel.getContext();
        ctx.set("version","mtandroid-8.2");
        //ctx.set("type","android");

        //Object result = fel.eval("GEQ(version,'8.1.0')",ctx);
        Object result = fel.eval("(GEQ(version,'mtiphone-8.1')||GEQ(version,'mtandroid-8.1'))&&(LES(version,'mtiphone-8.4')||LES(version,'mtandroid-8.4'))",ctx);

        //
        //(GEQ(version,'mtiphone-8.1')||GEQ(version,'mtandroid-8.1'))&&(LES(version,'mtiphone-8.4')||LES(version,'mtandroid-8.4'))
        System.out.println(result);

    }
}
