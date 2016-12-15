import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.*;

/**
 * Description:.
 *
 * @author zhiqiang.ge
 * @version V1.0
 * @since 2016/12/14 10:47
 */
@BTrace
public class BtraceScript {
    //@OnMethod(clazz = "Calculator", method = "add", location = @Location(Kind.RETURN))
    //public static void returnFunc(int a, int b, @Return int result, @Duration long time,
    //                              @Self Object self,  @ProbeMethodName String probeMethod) {
    //    println("returnFunc: =======================");
    //    jstack();
    //    println(strcat("a:", str(a)));
    //    println(strcat("b:", str(b)));
    //    println(strcat("result:", str(result)));
    //    println(strcat("time:", str(time)));
    //    println(strcat("probeMethod:", str(probeMethod)));
    //    //matches()
    //}

    //@OnMethod(clazz = "Calculator",method = "add",location = @Location(value = Kind.CALL,clazz = "/.*/",method = "/.*/"))
    //public static void callFunc(int a, int b) {
    //    println("callFunc: =======================");
    //    jstack();
    //    println(strcat("a:", str(a)));
    //    println(strcat("b:", str(b)));
    //}


    //@OnMethod(clazz = "Calculator",method = "add",location = @Location(Kind.ENTRY))
    //public static void enterFunc(int a, int b) {
    //    println("enterFunc: =======================");
    //    jstack();
    //    println(strcat("a:", str(a)));
    //    println(strcat("b:", str(b)));
    //}

    @OnMethod(clazz = "Calculator", method = "add", location = @Location(value = Kind.CALL, clazz = "/.*/", method = "/.*/"))
    public static void callALLFunc(@ProbeClassName String pcn, @ProbeMethodName String pmn,
                                   @TargetInstance Object instance, @TargetMethodOrField String method, String arg) {
        println("callALLFunc begin: =======================");
        jstack();
        println(strcat("arg:", str(arg)));
        println(strcat(strcat(strcat("call ", pcn), "."), pmn));
        println(strcat(strcat(strcat("called ", str(instance)), "."), method));
        println("callALLFunc end: =======================");
    }
}
