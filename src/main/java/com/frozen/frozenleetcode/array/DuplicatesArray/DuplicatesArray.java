package com.frozen.frozenleetcode.array.DuplicatesArray;

/**
 * @Auther: frozen
 * @Date: 2019/4/6 23:43
 * @Description:
 */
public class DuplicatesArray {

    public static void main(String[] args){
        DuplicatesArray duplicatesArray = new DuplicatesArray();
        int[] nums = new int[]{0,1,2,2,3,3,4,5,6,7,7};
        int[] nums1 = new int[]{};
        System.out.println(duplicatesArray.removeDuplicates(nums1));
    }
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int newLength=1;
        int temp=nums[0];
        int i =1;
        while (i<nums.length) {
            if (nums[i]!= temp) {
                temp = nums[i];
                newLength++;
            }
            i++;
        }
        return newLength;
    }

}
