package com.concurrent;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Description:.
 *
 * @author zhiqiang.ge
 * @version V1.0
 * @since 2016/10/10 18:12
 */
public class CpuCore {

    public static void threadStatus() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //assertTrue(threadMXBean.isThreadCpuTimeSupported());
        //assertTrue(threadMXBean.isCurrentThreadCpuTimeSupported());

        threadMXBean.setThreadContentionMonitoringEnabled(true);
        threadMXBean.setThreadCpuTimeEnabled(true);
        //assertTrue(threadMXBean.isThreadCpuTimeEnabled());

        ThreadInfo[] threadInfo = threadMXBean.getThreadInfo(threadMXBean.getAllThreadIds());
        for (ThreadInfo threadInfo2 : threadInfo) {
            long blockedTime = threadInfo2.getBlockedTime();
            long waitedTime = threadInfo2.getWaitedTime();
            long cpuTime = threadMXBean.getThreadCpuTime(threadInfo2.getThreadId());
            long userTime = threadMXBean.getThreadUserTime(threadInfo2.getThreadId());

            String msg = String.format("%s: %d ns cpu time, %d ns user time, blocked for %d ms, waited %d ms",
                    threadInfo2.getThreadName(), cpuTime, userTime, blockedTime, waitedTime);
            System.out.println(msg);
        }
    }

    public static int getCoreNum() {
        return Runtime.getRuntime().availableProcessors();
    }


    public static void main(String[] args) {
        threadStatus();
    }

}
