package com.ewan.test.override;

/**
 * Description:.
 *
 * @author zhiqiang.ge
 * @version V1.0
 * @since 2017/01/13 15:06
 */
public abstract class AbstractMethod {

    public void methodA(Father father){
        System.out.println("father:"+father.getName());
    }
}
