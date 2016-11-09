package com.memory;

public class SynchronizedTest {
    public void methodA() {
        synchronized (this) {
            System.out.println("MethodA start");
        }
    }
}

