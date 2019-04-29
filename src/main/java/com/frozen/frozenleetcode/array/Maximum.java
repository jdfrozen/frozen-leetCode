package com.frozen.frozenleetcode.array;

/**
 * @author: Frozen
 * @create: 2019-04-29 09:21
 * @description: Given an integer array, find three numbers whose product is maximum and output the maximum product.
 **/
public class Maximum {

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,-30,-40};
        int result =  maximumProduct(nums);
        System.out.println(result);
    }

    public static int maximumProduct(int[] nums) {
        if(nums==null||nums.length<3){
            throw new RuntimeException("数组不能为空");
        }
        //先排序
        quickSort(nums,0, nums.length-1);
        //只有正数||只有一个负数||只有负数
        if(nums[0]>=0||nums[1]>=0||nums[nums.length-1]<0){
            return nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        }
        //同时存在两个以上负数和正数，则对比最小的两个负数*最大的整数于最大的三个数
        int result0 = nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        int result1 = nums[nums.length-1]*nums[0]*nums[1];
        if(result0>result1){
            return 0;
        }else {
            return result1;
        }
    }
    /**
     * 快速排序 默认采用数组的第一个元素作为比较关键字
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSort(int[] arr,int start, int end) {
        int base = arr[start];
        int temp;
        int i = start;
        int j = end;
        do {
            //从尾部遍历
            while (arr[j] > base && j > start) {
                j--;
            }
            //从头部遍历
            while (arr[i] < base && i < end) {
                i++;
            }
            if (i <= j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);
        if (start < j) {
            quickSort(arr, start, j);
        }
        if (end > i){
            quickSort(arr, i, end);
        }
    }
}
