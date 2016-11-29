package com.ewan.test.cache;

/**
 * Description:表面上看，第二个循环工作量为第一个循环的1/16；
 * 但是执行时间是相差不大的，假设在内存规整的情况下，每16个int 占用4*16=64字节，正好一个缓存行，也就是说这两个循环访问内存的次数是一致的。导致耗时相差不大。
 *
 * @author zhiqiang.ge
 * @version V1.0
 * @since 2016/11/22 09:44
 */
public class CacheLine {

    public static void main(String[] args) {
        int[] arr = new int[64 * 1024 * 1024];
        long start = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 3;
        }
        System.out.println(System.nanoTime() - start);

        long start2 = System.nanoTime();
        for (int i = 0; i < arr.length; i += 16) {
            arr[i] *= 3;
        }
        System.out.println(System.nanoTime() - start2);
    }
}
