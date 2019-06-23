package com.frozen.frozenleetcode.array;

/**
 * @author: Frozen
 * @create: 2019-06-17 10:03
 * @description: 740. Delete and Earn
 * Given an array nums of integers, you can perform operations on the array.
 * <p>
 * In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.
 * <p>
 * You start with 0 points. Return the maximum number of points you can earn by applying such operations.
 **/
public class DeleteAndEarn {
    public static void main(String[] args) {
        DeleteAndEarn deleteAndEarn = new DeleteAndEarn();
        int[] nums = new int[]{3,1};
        System.out.println(deleteAndEarn.deleteAndEarn(nums));
    }

    public int deleteAndEarn(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int length = nums.length;
        if (length >= 20000) {
            return 0;
        }
        int result = -1;
        for (int i = 0; i < length; i++) {
            int sum = nums[i];
            int left = nums[i] - 1;
            int right = nums[i] + 1;
            int leftValue = 0;
            if (left >= 0 && left < length&&left!=i) {
                leftValue = nums[left];
            }
            int rightValue = 0;
            if (right >= 0 && right < length&&right!=i&&right!=left) {
                rightValue = nums[right];
            }
            sum = sum + leftValue + rightValue;
            if (sum > result) {
                result = sum;
            }
        }
        return result;
    }
}
