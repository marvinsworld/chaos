package com.ewan.test.btrace.sample1;

public class ActionObject {
    private static int totalTimes = 0;

    public int work(int sleepTime) throws InterruptedException {
        System.out.println("sleep " + sleepTime);
        totalTimes += sleepTime;
        Thread.sleep(sleepTime);
        return totalTimes;
    }
}