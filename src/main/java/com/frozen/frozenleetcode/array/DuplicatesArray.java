package com.frozen.frozenleetcode.array;

/**
 * @Auther: frozen
 * @Date: 2019/4/6 23:43
 * @Description:
 */
public class DuplicatesArray {

    public static void main(String[] args) {
        DuplicatesArray duplicatesArray = new DuplicatesArray();
        int[] nums = new int[]{0, 1, 2, 2, 3, 3, 4, 5, 6, 7, 7};
        int[] nums1 = new int[]{1, 1, 2};
        System.out.println(duplicatesArray.removeDuplicates(nums1));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] tempNums = new int[nums.length];
        int newLength = 0;
        int temp = nums[newLength];
        tempNums[newLength] = temp;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] != temp) {
                temp = nums[i];
                newLength++;
                tempNums[newLength] = temp;
            }
            i++;
        }
        int newSize = newLength+1;
        int[] newNums = new int[newSize];
        for (i = 0; i <= newLength; i++) {
            newNums[i] = tempNums[i];
        }
        nums = newNums;
        return newSize;
    }

}
