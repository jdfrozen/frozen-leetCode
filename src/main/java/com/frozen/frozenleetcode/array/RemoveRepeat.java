package com.frozen.frozenleetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Frozen
 * @create: 2019-05-12 22:15
 * @description: 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。  不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 **/
public class RemoveRepeat {
    public static void main(String[] args){
        RemoveRepeat removeRepeat = new RemoveRepeat();
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4,0};
        int length = removeRepeat.removeDuplicates(nums);
        System.out.println("nums length:"+length+"; nums:"+Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (nums==null||nums.length==0){
            return 0;
        }
        int length = nums.length;
        int newLength = length;
        int spacing = 0;
        Set<Integer> repeatSet = new HashSet<>();
        for (int i=0;i<length;i++){
            int temp = nums[i];
            if(repeatSet.contains(temp)){
                spacing++;
                newLength--;
            }else {
                repeatSet.add(temp);
                if(spacing>0){
                    nums[i-spacing] =temp;
                }
            }
        }
        return newLength;
    }
}
