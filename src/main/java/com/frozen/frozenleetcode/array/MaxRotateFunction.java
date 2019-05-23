package com.frozen.frozenleetcode.array;

/**
 * @author: Frozen
 * @create: 2019-05-20 09:50
 * @description: 给定一个长度为 n 的整数数组 A 。
 * 假设 Bk 是数组 A 顺时针旋转 k 个位置后的数组，我们定义 A 的“旋转函数” F 为：
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]。
 * 计算F(0), F(1), ..., F(n-1)中的最大值。
 * 注意:
 * 可以认为 n 的值小于 105。
 **/
public class MaxRotateFunction {
    public static void main(String[] args) {
        MaxRotateFunction function = new MaxRotateFunction();
        int[] A = new int[]{2, 3, 2};
        System.out.println(function.maxRotateFunction(A));
    }

    public int maxRotateFunction(int[] A) {
        if (A == null) {
            return 0;
        }
        int n = A.length;
        if (n == 0 || n > 105) {
            return 0;
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            int result = this.f(A,i);
            if(result>max){
                max = result;
            }
        }
        return max;
    }

    /**
     *
     * @param Bk
     * @param k
     * @return
     */
    private int f(int[] Bk, int k) {
        int n = Bk.length;
        int sum = 0;
        //对旋转后的数组进行公式的求和
        for (int i = 0; i < n; i++) {
            int index = i + k;
            //如果index大于等于N
            if (index >= n) {
                index = index-n;
            }
            int result = i * Bk[index];
            sum = sum + result;
        }
        return sum;
    }
}
