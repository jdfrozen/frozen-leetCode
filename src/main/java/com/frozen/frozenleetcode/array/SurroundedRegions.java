package com.frozen.frozenleetcode.array;

import java.util.*;

/**
 * @author: Frozen
 * @create: 2019-05-13 09:40
 * @description: 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。  找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 解题思路：
 * 1、遍历
 * 2、判断是否是O
 * 3、根据0查询相邻的，是否0，如果是，递归再查询（结果存起来）
 * 4、查询是否达到边界。
 **/
public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', 'X'},
                {'X', 'O'}
        };
        for (char[] nums : board) {
            System.out.println(Arrays.toString(nums));
        }
    }

    /**
     * @param board
     */
    public void solve(char[][] board) {
        if (board == null) {
            return;
        }
        int high = board.length;
        if (high <= 0) {
            return;
        }
        int wide = board[0].length;
        Map<String, Integer> map = new HashMap<>();
        for (int i=0;i<=high;i++) {
            for (int j=0;j<=wide;j++) {
                char c = board[i][j];
                if ('X' == c) {
                    continue;
                }
                List<Character> characters = new ArrayList<>();
                char upper=;
                char lower=;
                char left=;
                char right=;
            }
        }
    }

    private Boolean search(char c, String direction, Map<String, Integer> map,int high,int wide) {
        if ('X' == c) {
            return false;
        }
        switch (direction) {
            case "upper":
                break;
            case "lower":
                break;
            case "left":
                break;
            case "right":
                break;
        }
        return false;
    }
}
