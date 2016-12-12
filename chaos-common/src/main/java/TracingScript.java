import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnError;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.Return;
import com.sun.btrace.annotations.Self;

import java.io.IOException;

import static com.sun.btrace.BTraceUtils.jstack;
import static com.sun.btrace.BTraceUtils.println;
import static com.sun.btrace.BTraceUtils.str;
import static com.sun.btrace.BTraceUtils.strcat;

@BTrace
public class TracingScript {
    @OnMethod(clazz="BTraceTest",method="add",location=@Location(Kind.RETURN))
    public static void func(@Self BTraceTest instance, int a, int b, @Return int result) {
        println("打印堆栈:");
        jstack();
        println(strcat("方法参数A：",str(a)));
        println(strcat("方法参数B：",str(b)));   
        println(strcat("方法返回C：",str(result)));
    }

    //@OnTimer(4000)
    //public static void printM() {
    //    // 打印内存信息
    //    println("heap:");
    //    heapUsage();
    //    printVmArguments();
    //}

    @OnMethod(clazz="BTraceTest",method="add",location=@Location(Kind.ERROR))
    @OnError
    public static void onerror(IOException t) {
        println("Encountered internal error2 " + str(t));
        jstack();
        //BTraceUtils.printArray(new String[]{"a"});
    }

}