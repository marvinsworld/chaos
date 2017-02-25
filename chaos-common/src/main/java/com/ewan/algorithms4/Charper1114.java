package com.ewan.algorithms4;

/**
 * Description:1.1.14 编写一个静态方法lg()，接受一个整型参数N，返回不大于log2N的最大整数。不要使用Math 库。
 * <p>
 * log2N是2的M次幂的逆运算
 *
 * @author zhiqiang.ge
 * @version V1.0
 * @since 2017/02/25 08:47
 */
public class Charper1114 {

    /**
     * 递归
     * 1.确定最简单的情况
     * 2.尝试缩小范围
     * 3.确定父问题和子问题之间的关联关系
     * 4.避免父问题和子文字之间有交集的情况
     *
     * @param n 接受一个整型参数N
     * @return 不大于log2N的最大整数
     */
    private static int recursion(int n) {
        int result = 1;

        if (n < 2) {//1.最简单的情况
            return 0;
        } else {
            return result + //3.确定父问题和子问题之间的关联
                    recursion(n / 2);//2.缩小范围
        }
    }

    /**
     * for循环
     * 1.确定循环的最小值
     * 2.尝试缩小范围
     * 3.确定父问题和子问题之间的关联关系
     *
     * @param n 接受一个整型参数N
     * @return 不大于log2N的最大整数
     */
    private static int forLoop(int n) {
        int result = 0;
        while (n > 1) {//1.确定循环的最小值
            n = n / 2;//2.尝试缩小范围
            result++;//3.确定父问题和子问题之间的关联关系
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(recursion(50));
        System.out.println(forLoop(50));
    }
}
