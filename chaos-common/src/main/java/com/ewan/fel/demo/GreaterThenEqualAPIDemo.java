package com.ewan.fel.demo;

import com.ewan.fel.api.GreaterThanAPI;
import com.ewan.fel.api.GreaterThenEqualAPI;
import com.ewan.fel.api.LessThenAPI;
import com.ewan.fel.api.LessThenEqualAPI;
import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.FelEngineImpl;
import com.greenpineyu.fel.context.FelContext;

/**
 * Created by ewan on 17/11/26.
 */
public class GreaterThenEqualAPIDemo {

    public static void main(String[] args) {
        FelEngine fel = new FelEngineImpl();
        fel.getFunMgr().add(new GreaterThenEqualAPI());
        fel.getFunMgr().add(new LessThenEqualAPI());
        fel.getFunMgr().add(new LessThenAPI());
        fel.getFunMgr().add(new GreaterThanAPI());

        FelContext ctx = fel.getContext();
        ctx.set("func","android-5.10.1");


        //Object result = fel.eval("func>='ios-8.2.0' && func<='ios-8.3.0'",ctx);
        //Object result2 = fel.eval("func>='android-8.2.0' && func<='android-8.3.0'",ctx);
        Object result3 = fel.eval("func<'ios-6.1.0'",ctx);
        System.out.println(result3);
        //System.out.println(result);
        //System.out.println(result2);

        //ctx.set("func","mti");
        //Object result3 = fel.eval("func=='mti'||func=='i'||func=='wxi'",ctx);
        //System.out.println(result3);

        // version>='ios-8.2.0' && version<='ios-8.3.0'
        // func>='android-8.2.0'&&func<='android-8.3.0'
        // LogCons.CType.I.equals(cType) || LogCons.CType.MT_I.equals(cType) || LogCons.CType.WX_I.equals(cType);


    }
}
