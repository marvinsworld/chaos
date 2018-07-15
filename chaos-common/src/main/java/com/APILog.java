//package com;
//
//import net.sf.cglib.proxy.Enhancer;
//import net.sf.cglib.proxy.InvocationHandler;
//import net.sf.cglib.proxy.MethodInterceptor;
//import net.sf.cglib.proxy.MethodProxy;
//import net.sf.cglib.proxy.Proxy;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.spi.LoggerRepository;
//import org.apache.logging.log4j.core.util.ReflectionUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.lang.reflect.Constructor;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//
///**
// * Created by gezhiqiang on 18/6/21.
// */
//public class APILog {
//
//    private static org.slf4j.Logger logger;
//    private static final String FQCN = Logger.class.getName();
//
//    static {
//        try {
//            Enhancer eh = new Enhancer();
//            eh.setSuperclass(org.apache.log4j.Logger.class);
//            eh.setCallbackType(LogInterceptor.class);
//            Class c = eh.createClass();
//            Enhancer.registerCallbacks(c, new LogInterceptor[]{new LogInterceptor()});
//
//            Constructor<org.apache.log4j.Logger> constructor = c.getConstructor(String.class);
//            org.apache.log4j.Logger loggerProxy = constructor.newInstance(Logger.class.getName());
//
//            LoggerRepository loggerRepository = LogManager.getLoggerRepository();
//            org.apache.log4j.spi.LoggerFactory lf = ReflectionUtil.getFieldValue(loggerRepository, "defaultFactory");
//            Object loggerFactoryProxy = Proxy.newProxyInstance(
//                    LoggerFactory.class.getClassLoader(),
//                    new Class[]{LoggerFactory.class},
//                    new NewLoggerHandler(loggerProxy)
//            );
//
//            ReflectionUtil.setFieldValue(loggerRepository, "defaultFactory", loggerFactoryProxy);
//            logger = org.slf4j.LoggerFactory.getLogger(Logger.class.getName());
//            ReflectionUtil.setFieldValue(loggerRepository, "defaultFactory", lf);
//        } catch (
//                IllegalAccessException |
//                        NoSuchMethodException |
//                        InvocationTargetException |
//                        InstantiationException e) {
//            throw new RuntimeException("初始化Logger失败", e);
//        }
//    }
//
//    private static class LogInterceptor implements MethodInterceptor {
//        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//            // 只拦截log方法。
//            if (objects.length != 4 || !method.getName().equals("log"))
//                return methodProxy.invokeSuper(o, objects);
//            objects[0] = FQCN;
//            return methodProxy.invokeSuper(o, objects);
//        }
//    }
//
//    private static class NewLoggerHandler implements InvocationHandler {
//        private final org.apache.log4j.Logger proxyLogger;
//
//        public NewLoggerHandler(org.apache.log4j.Logger proxyLogger) {
//            this.proxyLogger = proxyLogger;
//        }
//
//        @Override
//        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//            return proxyLogger;
//        }
//    }
//
//
//    // 剩下的Logger需要封装的方法可以根据自己的需要来实现
//    // 我个人认为slf4j的api足够好用了，所以大部分只是写了一些类似下面的代码
//    public static void debug(String msg) {
//        logger.debug(msg);
//    }
//
//    /**
//     * Error等级日志<br>
//     * @param log 日志对象
//     * @param format 格式文本，{} 代表变量
//     * @param arguments 变量对应的参数
//     */
//    public static void error(String format, Object... arguments) {
//        logger.error(format, arguments);
//    }
//
//}
