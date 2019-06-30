package com.frozen.frozenleetcode.string;

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
        char[] chars = new char[]{'g','s','f','e','b'};
        System.out.println(compression.compress(chars));
    }

    public int compress(char[] chars) {
        return -1;
    }
}
