package com.ewan.test.btrace.sample1;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Duration;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.Return;
import com.sun.btrace.annotations.TLS;

import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class TraceObjectCost {
    @TLS
    static long startTime;

    @OnMethod(clazz = "com.ewan.test.btrace.sample1.ActionObject", method = "work", location = @Location(Kind.ENTRY))
    public static void start() {
        startTime = timeMillis();
    }

    @OnMethod(clazz = "com.ewan.test.btrace.sample1.ActionObject", method = "work", location = @Location(Kind.RETURN))
    public static void getMethodExecuteCost(int sleepTime, @Return int totalTime, @Duration long time) {
        String str = str(timeMillis() - startTime);
        String strcat = strcat("execute work method cost:", str);
        String strcat2 = strcat(strcat, " ms");
        println(time/ 1000000);
        println(strcat2+"=========");
    }
}