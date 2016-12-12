package com.ewan.common;

/**
 * Description:.
 *
 * @author zhiqiang.ge
 * @version V1.0
 * @since 2016/12/10 10:57
 */
public class InputFilterTest {

    public static void main(String[] args) {
        String result = InputFilter.filterEmoji("\uE107啊\uE107\uE415\uE40C\uE412\uE409\uE410\uE40D\uE107阿萨德发\uE437\uE11B\uE11A\uE40E\uE40A\uE405\uE403\uE41D\uE14C\uE12F\uE34B\uE312\uE112秦莞尔");
        System.out.println(result);
    }


}