package com.ewan.test.btrace.sample1;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;

import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class TraceObject {
    @OnMethod(clazz = "com.ewan.test.btrace.sample1.ActionObject", method = "work",
            location = @Location(value = Kind.CALL, clazz = "/.*/", method = "/.*/"))
    public static void checkWhoCallMe() {
        println("check who ActionObject.work method:");
        jstack();
    }
}