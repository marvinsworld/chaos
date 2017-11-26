package com.ewan.fel;

import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.FelEngineImpl;
import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.operator.LessThen;

/**
 * Created by ewan on 17/11/26.
 */
public class GreaterThanImpl2 extends LessThen {

    public GreaterThanImpl2() {
    }



    public String getName() {
        return ",";
    }

    public boolean compare(Object left, Object right) {
        return MobileAppHelper.compareVersion((String) left, (String) right) >= 0;
    }

    public static void main(String[] args) {
        FelEngine engine = FelEngine.instance;

        FelEngine fel = new FelEngineImpl();
        fel.getFunMgr().remove("greaterthenequal");
        fel.getFunMgr().remove(".");
        fel.getFunMgr().add(new GreaterThanImpl2());
        //添加函数到引擎中。
        //fel.addFun(new GreaterThanImpl());
        FelContext ctx = fel.getContext();
        ctx.set("version","8.1.9");
        //
        //Object result = fel.eval("8.1.9*8.1.0",ctx);
        Object result = fel.eval("version,'8.1.0'",ctx);
        //
        System.out.println(result);


        //System.out.println(fel.eval("3>=2"));


    }
}
