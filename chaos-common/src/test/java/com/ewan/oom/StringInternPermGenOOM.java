package com.ewan.oom;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:.
 *
 * @author zhiqiang.ge
 * @version V1.0
 * @since 2016/09/17 15:47
 */
public class StringInternPermGenOOM {
    private static List<Object> insList = new ArrayList<Object>();

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, MalformedURLException, InterruptedException {
        permLeak();
    }

    private static void permLeak() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, MalformedURLException, InterruptedException{
        for (int i = 0; i < 1000 ; i++) {
            URL[] urls = getURLS();
            URLClassLoader loader = new URLClassLoader(urls,null);
            Class<?> logfClass = Class.forName("org.apache.commons.logging.LogFactory",true,loader);
            Method getLog = logfClass.getMethod("getLog", String.class);
            Object result = getLog.invoke(logfClass, "TestStringInternPermGenOOM");
            insList.add(result);
            System.out.println(i + " : " + result);
            Thread.sleep(100);
        }
    }

    private static URL[] getURLS() throws MalformedURLException {
        File libDir = new File("/Users/bao/repository/commons-logging/commons-logging/1.1.1");
        File[] subFiles = libDir.listFiles();
        int count = subFiles.length;
        URL[] urls = new URL[count];
        for (int i = 0; i < count ; i++) {
            urls[i] = subFiles[i].toURI().toURL();
        }
        return urls;
    }


    //java -XX:PermSize=4m -XX:MaxPermSize=4m -XX:+PrintGCDetails com.ewan.oom.StringInternPermGenOOM
}
