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
        System.out.println(duplicatesArray.removeDuplicates(nums));
    }
    public int removeDuplicates(int[] nums) {
        if(nums==null&&nums.length==0){
            return 0;
        }
        return 0;
    }

}
