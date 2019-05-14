package com.frozen.frozenleetcode.array;

import java.util.Arrays;

/**
 * @author: Frozen
 * @create: 2019-05-13 09:40
 * @description: 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。  找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 **/
public class SurroundedRegions {
    public static void main(String[] args){
        char[][] board = new char[][]{
                {'X','X'},
                {'X','O'}
        };
        for(char[] nums:board) {
            System.out.println(Arrays.toString(nums));
        }
    }

    public void solve(char[][] board) {

    }
}
