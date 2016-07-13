package com.strings;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DiagonalDifference {
    public static void main (String[] args){
        DiagonalDifference diagonalDifference = new DiagonalDifference();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        try {
            int numOfCases= Integer.parseInt(br.readLine());
            for(int i = 0; i < numOfCases; i++){
                StringTokenizer tk = new StringTokenizer(br.readLine());
                int[] array = diagonalDifference.createIntArray(tk);
                sum+=array[i]-array[array.length-1-i];
            }
            System.out.println(Math.abs(sum));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] createIntArray(StringTokenizer tk){
        int[] array = new int[tk.countTokens()];

        for (int i = 0; i < array.length; i++){
            array[i] = Integer.valueOf(tk.nextToken());
        }
        return array;
    }

}
