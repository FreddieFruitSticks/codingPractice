package com.dynamic;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class MinDecent {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/home/freddie/Desktop/MinDecent"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int heightOfTriangle = st.countTokens();
        int[][] triangleOfSum = new int[heightOfTriangle + 1][heightOfTriangle + 2];

        for (int i = 1; i <= heightOfTriangle; i++) {
            int i1 = st.countTokens();
            for (int j = 1; j <= i1; j++) {
                int num = Integer.valueOf(st.nextToken());
                triangleOfSum[i][j] = Math.min(num + triangleOfSum[i - 1][j], num + triangleOfSum[i - 1][j + 1]);
            }
            try{
                st = new StringTokenizer(br.readLine());
            }catch (Exception e){
                System.out.println("overit");
            }
        }
        printMatrix(triangleOfSum);
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
