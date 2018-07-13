package com.ewan.test.override;

/**
 * Description:.
 *
 * @author zhiqiang.ge
 * @version V1.0
 * @since 2017/01/13 15:05
 */
public class Father {
    private Integer id;

    private String name;

    public Father() {
    }

    public Father(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
