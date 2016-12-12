import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.TLS;

import static com.sun.btrace.BTraceUtils.probeClass;
import static com.sun.btrace.BTraceUtils.timeMillis;

import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class ProfileScript {

    @TLS
    private static long startTime = 0;

    // com.alipay.sofa.rpc.process
    @OnMethod(clazz = "/com\\.hongweiyi\\.package\\.name\\..+/", method = "/.+/")
    public static void startMethod(){
        startTime = timeMillis();
    }

    @SuppressWarnings("deprecation")
    @OnMethod(clazz = "/com\\.hongweiyi\\.package\\.name\\..+/", method = "/.+/", location = @Location(Kind.RETURN))
    public static void endMethod() {

        long cost = timeMillis() - startTime;
        if (cost > 3) {
            print(strcat(strcat(strcat(strcat(name(probeClass()), "."), probeMethod()), ":"), str(probeLine())));
            print("  [");
            print(strcat("Time taken : ", str(timeMillis() - startTime)));
            println("]");
        }

    }
}