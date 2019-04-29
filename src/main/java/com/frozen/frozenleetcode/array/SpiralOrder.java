package com.frozen.frozenleetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: Frozen
 * @create: 2019-04-08 20:44
 * @description: Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 **/
public class SpiralOrder {

    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        int[][] matrix = new int[][]{{1, 2, 3,4}, { 5, 6,7, 8}, {9,10,11,12}};
        List<Integer> list =  spiralOrder.spiralOrder(matrix);
        System.out.println(Arrays.asList(list).toString());
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        int[] arr = matrix[0];
        if (arr == null || arr.length == 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        this.spiralOrder(list, matrix, matrix.length, arr.length, 0);
        return list;
    }

    public void spiralOrder(List<Integer> list, int[][] matrix, int m, int n, int age) {
        int mStart = age;
        int mEnd = m - age;
        int nStart = age;
        int nEnd = n - age;
        for (int i = nStart; i < nEnd; i++) {
            list.add(matrix[mStart][i]);
        }
        for (int i = mStart + 1; i < mEnd; i++) {
            list.add(matrix[i][nEnd-1]);
        }
        for (int i = nEnd - 2; i > nStart; i--) {
            list.add(matrix[mEnd-1][i]);
        }
        for (int i = mEnd - 2; i > mStart; i--) {
            list.add(matrix[i][nStart]);
        }
        age++;
        if ((m - 2 * age) > 0 && (n - 2 * age) > 0) {
            this.spiralOrder(list, matrix, m, n, age);
        }
    }
}
