package com.ewan.fel;

import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.FelEngineImpl;
import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.CommonFunction;
import com.greenpineyu.fel.function.Function;
import com.greenpineyu.fel.parser.FelNode;

/**
 * 自定义EL表达式
 * Created by ewan on 17/10/9.
 */
public class SelfEL {

    public static void main(String[] args) {

        //定义hello函数
        final Function fun = new CommonFunction() {
            public String getName() {
                return "GEQ";
            }

            @Override
            public Object call(FelNode node, FelContext context) {
                return super.call(node, context);
            }

            /*
                         * 调用hello("xxx")时执行的代码
                         */
            @Override
            public Object call(Object[] arguments) {
                return "11";
            }

            public Object call(Object[] arguments, FelContext context) {
                String msg = null;
                if(arguments!= null && arguments.length>0){
                    msg = (String) arguments[1];
                }

                return MobileAppHelper.compareVersion(msg, (String) context.get("version"))>=0;
            }

        };

        FelEngine fel = new FelEngineImpl();
        //添加函数到引擎中。
        fel.addFun(fun);
        FelContext ctx = fel.getContext();
        ctx.set("version","8.2.0");

        Object result = fel.eval("GEQ(version,'8.1.0')",ctx);
        System.out.println(result);

    }
}
