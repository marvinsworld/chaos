package com.ewan.fel.api;

import com.ewan.fel.MobileAppHelper;
import com.greenpineyu.fel.function.operator.GreaterThan;

/**
 * Created by ewan on 17/11/26.
 */
public class GreaterThanAPI extends GreaterThan {
    public boolean compare(Object left, Object right) {
        String right_arr[] = ((String) right).split("-");
        String left_arr[] = ((String) left).split("-");

        String right_type = right_arr[0];
        String left_type = left_arr[0];
        if (right_type.equals(left_type)) {
            boolean result = MobileAppHelper.compareVersion(left_arr[1], right_arr[1]) > 0;
            return result;
        } else {
            return false;
        }
    }
}
