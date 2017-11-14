package com.ewan.fel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by xuli on 14-12-4.
 */
@Service
public class MobileAppHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(MobileAppHelper.class);
    /**
     * 1：表示a版本新；
     * @param a
     * @param b
     * @return
     */
    public static int compareVersion(String a, String b) {
        try {
            if (org.apache.commons.lang3.StringUtils.isEmpty(a)) {
                return -1;
            }
            if (org.apache.commons.lang3.StringUtils.isEmpty(b)) {
                return 1;
            }
            if (a.equals(b)) {
                return 0;
            }
            String[] arrA = a.trim().split(" ")[0].split("\\.");
            String[] arrB = b.trim().split(" ")[0].split("\\.");

            List<String> firstVersion = new ArrayList<String>(Arrays.asList(arrA));
            List<String> secondVersion = new ArrayList<String>(Arrays.asList(arrB));
            int diffLen = Math.abs(firstVersion.size() - secondVersion.size());
            if (diffLen > 0) {
                if (firstVersion.size() < secondVersion.size()) {
                    firstVersion.addAll(Collections.nCopies(diffLen, "0"));
                } else {
                    secondVersion.addAll(Collections.nCopies(diffLen, "0"));
                }
            }

            for (int i = 0; i < firstVersion.size(); i++) {
                if (Integer.parseInt(firstVersion.get(i)) > Integer.parseInt(secondVersion.get(i))) {
                    return 1;
                } else if (Integer.parseInt(firstVersion.get(i)) < Integer.parseInt(secondVersion.get(i))) {
                    return -1;
                }
            }

//            for (int i = 0; i < Math.max(arrA.length, arrB.length); i++) {
//                if (i == arrA.length && arrA.length != arrB.length) {
//                    return -1;
//                }
//                if (i == arrB.length && arrA.length != arrB.length) {
//                    return 1;
//                }
//                if (Integer.parseInt(arrA[i]) > Integer.parseInt(arrB[i])) {
//                    return 1;
//                } else if (Integer.parseInt(arrA[i]) < Integer.parseInt(arrB[i])) {
//                    return -1;
//                }
//            }
        } catch (Exception e) {
            LOGGER.warn("Failed to invoke compareVersion() {}, {}", a, b, e);
            return -1;
        }
        return 0;
    }

    // 将127.0.0.1形式的IP地址转换成十进制整数，这里没有进行任何错误处理
    public static long ipToLong(String strIp) {
        strIp = StringUtils.trimAllWhitespace(strIp);
        if(strIp.indexOf(".") == -1){
            return 0;
        }
        if(strIp.indexOf(",") != -1){
            strIp = strIp.split(",")[0];
        }
        long[] ip = new long[4];
        // 先找到IP地址字符串中.的位置
        int position1 = strIp.indexOf(".");
        int position2 = strIp.indexOf(".", position1 + 1);
        int position3 = strIp.indexOf(".", position2 + 1);
        // 将每个.之间的字符串转换成整型
        ip[0] = Long.parseLong(strIp.substring(0, position1));
        ip[1] = Long.parseLong(strIp.substring(position1 + 1, position2));
        ip[2] = Long.parseLong(strIp.substring(position2 + 1, position3));
        ip[3] = Long.parseLong(strIp.substring(position3 + 1));
        return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
    }
}
