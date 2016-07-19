package com.dynamic;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumSubArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numOfCases = Integer.valueOf(br.readLine());

        for (int i = 0; i < numOfCases; i++) {
            int sizeOfArray = Integer.valueOf(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] array = new int[sizeOfArray];
            int sumOfNonContigiousSubArray = 0;
            int maxNegNum=0;
            boolean firstNegNum = true;
            for (int j = 0; j < sizeOfArray; j++) {
                int num = Integer.valueOf(st.nextToken());
                if (num < 0 && firstNegNum) {
                    maxNegNum = num;
                    firstNegNum = false;
                }
                if(num < 0 && num > maxNegNum){
                    maxNegNum = num;
                }
                if (num > 0) {
                    sumOfNonContigiousSubArray += num;
                }
                array[j] = num;
            }
            if(sumOfNonContigiousSubArray == 0){
                sumOfNonContigiousSubArray = maxNegNum;
            }
            int maxSum = array[0];
            int sumSoFar = array[0];
            for (int j = 1; j < array.length; j++) {
                sumSoFar = Math.max(array[j], sumSoFar+array[j]);
                maxSum = Math.max(maxSum, sumSoFar);
            }

            System.out.println(maxSum+" "+sumOfNonContigiousSubArray);

        }
    }
}
