package com.eason.ip;

import java.net.SocketException;

/**
 * Description:.
 *
 * @author zhiqiang.ge
 * @version V1.0
 * @since 2016/08/19 15:34
 */
public class IPUtilsTest {

    public static void main(String[] args) {
        try {
            System.out.println(IPUtils.getRealIp());
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
