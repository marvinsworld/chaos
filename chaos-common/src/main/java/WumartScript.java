import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.Self;

import static com.sun.btrace.BTraceUtils.jstack;
import static com.sun.btrace.BTraceUtils.println;

/**
 * Description:.
 *
 * @author zhiqiang.ge
 * @version V1.0
 * @since 2016/12/12 16:39
 */

@BTrace
public class WumartScript {

    //@OnMethod(clazz = "com.dmall.wellet.service.wumart.impl.WumartCardServiceImpl", method = "freeSecretPay", location = @Location(Kind.RETURN))
    //public static void pay(@Self Object self, @Return boolean result) {
    //    println("打印堆栈:");
    //    jstack();
    //    println(strcat("方法返回C：", str(result)));
    //}

    //com.dmall.wellet.facade.wumart.WumartFacadeImpl
    //com.dmall.wellet.service.wumart.impl.WumartCardServiceImpl

    //@OnMethod(clazz = "com.dmall.wellet.service.wumart.impl.WumartCardServiceImpl", method = "queryCardsInTimeForFreeSecretPay",
    //        location = @Location(value = Kind.CALL, clazz = "/.*/", method = "/.*/"))
    //public static void query(@Self Object self) {
    //    println("打印WumartCardServiceImpl堆栈:");
    //    //printArray(args);
    //    jstack();
    //}

    //@OnMethod(clazz = "com.dmall.wellet.service.wumart.impl.WumartCardServiceImpl", method = "queryCardsInTimeForFreeSecretPay",
    //        location = @Location(value = Kind.CALL, clazz = "/.*/", method = "/.*/"))
    //public static void query0(@Self Object self, @ProbeClassName String pcm, @ProbeMethodName String pmn,
    //                          @TargetInstance Object instance, @TargetMethodOrField String method) {
    //    println("打印WumartCardServiceImpl0堆栈:");
    //    println("ProbeClassName:" + pcm + "#ProbeMethodName:" + pmn + "#TargetInstance:" + instance + "#TargetMethod:" + method);
    //    //jstack();
    //}

    //@OnMethod(clazz = "com.dmall.wellet.service.wumart.impl.WumartCardServiceImpl", method = "queryCardsInTimeForFreeSecretPay",
    //        location = @Location(value = Kind.CALL, clazz = "com.dmall.wellet.domain.wumart.CardSummaryInTimeResult", method = "setTitle"
    //        ,where = Where.AFTER))
    //public static void query2(@Self Object self, @ProbeClassName String pcm, @ProbeMethodName String pmn,
    //                          @TargetInstance Object instance, @TargetMethodOrField String method) {
    //    //println("打印WumartCardServiceImpl2堆栈:");
    //    println("ProbeClassName:" + pcm + "#ProbeMethodName:" + pmn + "#TargetInstance:" + instance + "#TargetMethod:" + method);
    //
    //    //StackTraceElement[] st = Thread.currentThread().getStackTrace();
    //    //printArray(st);
    //    //BTraceUtils.Threads.jstack();
    //    jstack();
    //}


    //@OnMethod(clazz = "com.dmall.wellet.facade.wumart.WumartFacadeImpl", method = "queryCardsInTimeForFreeSecretPay",
    //        location = @Location(value = Kind.CALL, clazz = "/.*/", method = "/.*/"))
    //public static void query1(@Self Object self) {
    //    println("打印WumartFacadeImpl堆栈:");
    //    //printArray(args);
    //    jstack();
    //}

    //com.dmall.wellet.facade.wumart.WumartFacadeImpl.queryCardsInTimeForFreeSecretPay(WumartFacadeImpl.java:163)

    //@OnMethod(clazz = "/.*WumartCardServiceImpl/", method = "queryCardsInTimeForFreeSecretPay"
    //        , location=@Location(Kind.RETURN))
    //public static void query2(@Self Object self, String userId, Long payFee, String orderType) {
    //    println("堆栈:");
    //    //println("ProbeClassName:" + pcm + "#ProbeMethodName:" + pmn + "#time:" + time);
    //
    //    //StackTraceElement[] st = Thread.currentThread().getStackTrace();
    //    //printArray(st);
    //    //BTraceUtils.Threads.jstack();
    //    jstack();
    //}

    @OnMethod(clazz = "com.dmall.wellet.service.wumart.impl.WumartCardServiceImpl", method = "queryCardsInTimeForFreeSecretPay"
            , location=@Location(Kind.ENTRY))
    public static void query3(@Self Object self, String userId, Long payFee, String orderType) {
        println("堆栈:");
        //println("ProbeClassName:" + pcm + "#ProbeMethodName:" + pmn + "#time:" + time);

        //StackTraceElement[] st = Thread.currentThread().getStackTrace();
        //printArray(st);
        //BTraceUtils.Threads.jstack();
        jstack();
    }

}
