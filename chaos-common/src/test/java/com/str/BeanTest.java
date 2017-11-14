package com.str;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by ewan on 17/9/27.
 */
public class BeanTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        A a = new A();
        a.setA(1);

        B b = new B();

        BeanUtils.copyProperties(b,a);
        System.out.println(b);
    }
}
