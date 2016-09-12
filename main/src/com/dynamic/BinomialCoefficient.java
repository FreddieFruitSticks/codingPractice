package com.dynamic;

public class BinomialCoefficient {
    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        int[][] pascalsTriangle = new int[n][n + 1];
        pascalsTriangle[0][1] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i + 2; j++) {
                pascalsTriangle[i][j] = pascalsTriangle[i-1][j-1] + pascalsTriangle[i-1][j];
            }
        }
        printMatrix(pascalsTriangle);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
