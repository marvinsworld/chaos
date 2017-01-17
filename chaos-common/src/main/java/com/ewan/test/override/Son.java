package com.ewan.test.override;

/**
 * Description:.
 *
 * @author zhiqiang.ge
 * @version V1.0
 * @since 2017/01/13 15:04
 */
public class Son extends Father {

    private String age;

    public Son() {
    }

    public Son(Integer id, String name, String age) {
        super(id, name);
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
