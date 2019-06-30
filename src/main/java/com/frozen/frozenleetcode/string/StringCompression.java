package com.frozen.frozenleetcode.string;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author: Frozen
 * @create: 2019-06-25 09:27
 * @description: 443. String Compression
 * Given an array of characters, compress it in-place.
 * <p>
 * The length after compression must always be smaller than or equal to the original array.
 * <p>
 * Every element of the array should be a character (not int) of length 1.
 * <p>
 * After you are done modifying the input array in-place, return the new length of the array.
 * <p>
 *  
 * Follow up:
 * Could you solve it using only O(1) extra space?
 **/
public class StringCompression {
    public static void main(String[] args) {
        StringCompression compression = new StringCompression();
        char[] chars = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compression.compress(chars));
        System.out.println(Arrays.toString(chars));
    }

    public int compress(char[] chars) {
        if(chars==null){
            return 0;
        }
        int n=chars.length;
        int car =0;
        for(int i=0;i<n;i++){
            char c=chars[i];
            chars[car++]=c;
            int j=i;
            while (j<n&&chars[j]==c){
                j++;
            }
            int num = j-i;
            if(num==1){
                continue;
            }
            for (char cm : String.valueOf(j - i).toCharArray()) {
                chars[car++] = cm;
            }
            i=j-1;
        }
        return car;
    }
}
