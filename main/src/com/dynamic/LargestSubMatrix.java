package com.dynamic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LargestSubMatrix {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/home/freddie/Desktop/subMatrix"));
        String[] dimensions = br.readLine().split(" ");
        int[][] solution = new int[Integer.valueOf(dimensions[0]) + 1][Integer.valueOf(dimensions[1]) + 1];
        int[][] matrix = new int[Integer.valueOf(dimensions[0])][Integer.valueOf(dimensions[1])];

        for (int i = 0; i < Integer.valueOf(dimensions[0]); i++) {
            String s = br.readLine();
            String[] matrixRow = s.split(" ");
            for (int j = 0; j < Integer.valueOf(dimensions[1]); j++) {
                matrix[i][j] = Integer.valueOf(matrixRow[j]);
            }
        }

        for (int i = 1; i < solution.length; i++) {
            for (int j = 1; j < solution[0].length; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    solution[i][j] = 0;
                } else {
                    solution[i][j] = 1 + Math.min(Math.min(solution[i][j - 1], solution[i - 1][j]), solution[i - 1][j - 1]);
                }
            }
        }

        System.out.println(findMaxInMatrix(solution));
    }

    private static int findMaxInMatrix(int[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }
}
