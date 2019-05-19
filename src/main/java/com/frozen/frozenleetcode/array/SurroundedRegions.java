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
                {'X', 'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'O', 'X'},
                {'X', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X', 'X'}
        };
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        surroundedRegions.solve(board);
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
        //key是坐标位置h&w来表示,表示边界，高级的做法是用数组定位！！！！！！
        Set<String> boundarySet = new HashSet<>();
        Set<String> searchedSet = new HashSet<>();
        for (int h = 0; h < high; h++) {
            for (int w = 0; w < wide; w++) {
                char c = board[h][w];
                if ('X' == c) {
                    continue;
                }
                String key = getKey(h, w);
                if (searchedSet.contains(key)) {
                    continue;
                }
                searchedSet.add(key);
                //如果该点是边界
                if (h == 0 || w == 0 || h == high - 1 || w == wide - 1) {
                    boundarySet.add(key);
                    continue;
                }
                //保存这次的遍历值
                Set<String> set = new HashSet<>();
                set.add(key);
                char upper = board[h - 1][w];
                char lower = board[h + 1][w];
                char left = board[h][w - 1];
                char right = board[h][w + 1];
                boolean upperResult = search(board, upper,  boundarySet, set, h - 1, w, high, wide);
                boolean lowerResult = search(board, lower,  boundarySet, set, h + 1, w, high, wide);
                boolean leftResult = search(board, left,  boundarySet, set, h, w - 1, high, wide);
                boolean rightResult = search(board, right,  boundarySet, set, h, w + 1, high, wide);
                //被围住，则进行O->X转换
                if (upperResult && lowerResult && leftResult && rightResult) {
                    for (String s : set) {
                        String[] a = s.split("&");
                        board[Integer.valueOf(a[0])][Integer.valueOf(a[1])] = 'X';
                    }
                } else {
                    //没有被围住则记录边界
                    for (String s : set) {
                        boundarySet.add(s);
                    }
                }
            }
        }
    }

    /**
     *
     * @param board
     * @param c
     * @param boundarySet
     * @param set
     * @param h
     * @param w
     * @param high
     * @param wide
     * @return
     */
    private Boolean search(char[][] board, char c, Set<String> boundarySet, Set<String> set, int h, int w, int high, int wide) {
        if ('X' == c) {
            return true;
        }
        String key = getKey(h, w);
        if (set.contains(key)) {
            return true;
        }
        set.add(key);
        //如果该点是边界
        if (h == 0 || w == 0 || h == high - 1 || w == wide - 1) {
            boundarySet.add(key);
            return false;
        }
        if (boundarySet.contains(c)) {
            return false;
        }
        char upper = board[h - 1][w];
        char lower = board[h + 1][w];
        char left = board[h][w - 1];
        char right = board[h][w + 1];
        boolean upperResult = search(board, upper, boundarySet, set, h - 1, w, high, wide);
        boolean lowerResult = search(board, lower, boundarySet, set, h + 1, w, high, wide);
        boolean leftResult = search(board, left, boundarySet, set, h, w - 1, high, wide);
        boolean rightResult = search(board, right, boundarySet, set, h, w + 1, high, wide);
        if (upperResult && lowerResult && leftResult && rightResult) {
            return true;
        } else {
            return false;
        }
    }

    private String getKey(int h, int w) {
        return String.valueOf(h) + "&" + String.valueOf(w);
    }
}
