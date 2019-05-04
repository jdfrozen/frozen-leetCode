package com.frozen.frozenleetcode.other;

import java.util.Arrays;

/**
 * @Auther: frozen
 * @Date: 2019/5/4 20:12
 * @Description: 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 */
public class SortColors {

    public static void main(String[] args){
        SortColors sortColors = new SortColors();
        int[] nums =  new int[]{2,1,0,2,2,1,0};
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        if(nums==null||nums.length<=0){
            return;
        }
        int start=0;
        int end = nums.length-1;
        int i=0;
        while (i<=end){
            if(nums[end]==2){
                end--;
                continue;
            }
            if(i<start){
                i++;
                continue;
            }
            if(nums[start]==0){
                start++;
                continue;
            }
            if(nums[i]==2){
                nums[i]=nums[end];
                nums[end]=2;
                continue;
            }
            if(nums[i]==0){
                nums[i]=nums[start];
                nums[start]=0;
            }
            i++;
        }
    }
}
