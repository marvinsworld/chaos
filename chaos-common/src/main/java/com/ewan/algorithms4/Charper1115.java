package com.ewan.algorithms4;

/**
 * Description:编写一个静态方法histogram()，接受一个整型数组a[]和一个整数M为参数并返回一个大小为M的数组，
 * 其中第i个元素为整数i在参数数组中出现的次数。如果a[]中的值均在0到M-1之间，返回数组中的所有元素之和应该和a.length相等
 *
 * @author zhiqiang.ge
 * @version V1.0
 * @since 2017/02/25 20:44
 */
public class Charper1115 {

    private static void histogram(int[] a, int M) {
        int[] b = new int[M];
        for (int j = 0; j < a.length; j++) {
            int index = a[j];

            if (index < b.length) {
                b[index] = ++b[index];
            }
        }

        for (int i = 0; i < b.length; i++) {
            System.out.println("Value of element " + i + " is " + b[i]);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 7, 8, 9};
        int M = 5;
        histogram(a, M);
    }
}
