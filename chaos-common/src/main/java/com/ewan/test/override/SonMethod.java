package com.ewan.test.override;

/**
 * Description:.
 *
 * @author zhiqiang.ge
 * @version V1.0
 * @since 2017/01/13 15:07
 */
public class SonMethod extends AbstractMethod {

    @Override
    public void methodA(Father father) {
        super.methodA(father);

        System.out.println(father instanceof Father);

        System.out.println(((Son)father).getAge());
    }
}
