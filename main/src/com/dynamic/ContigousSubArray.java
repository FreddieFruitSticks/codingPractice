package com.dynamic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ContigousSubArray {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/home/freddie/Desktop/test1"));
        int[] array = new int[Integer.valueOf(br.readLine())];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i =0;
        while(st.hasMoreTokens()){
            array[i] = Integer.valueOf(st.nextToken());
            i++;
        }

        int[] MS = new int[array.length +1];
        MS[0] = 0;
        for(int j = 1; j < array.length+1; j++){
            MS[j] = Math.max(MS[j-1] + array[j-1], array[j-1]);
        }

        System.out.println(findMax(MS));
    }

    private static void printArray(int[] array){
        for (int i : array) {
            System.out.println(i);
        }
    }

    private static int findMax(int[] array){
        int max = array[0];
        for (int i : array) {
            if(i > max){
                max = i;
            }
        }

        return max;
    }
}
