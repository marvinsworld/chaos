package com.ewan.source.sample;

import com.ewan.source.GenerateCatch;

/**
 * Created by gezhiqiang on 18/6/7.
 */
public class MethodSample {

    @GenerateCatch
    public String test(int a){
        System.out.println(a);
        return a+"";
    }
}
