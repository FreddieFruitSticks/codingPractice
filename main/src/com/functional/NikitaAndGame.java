package com.functional;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NikitaAndGame {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfCases = Integer.valueOf(br.readLine());
        for (int i = 0; i < numOfCases; i++) {
            int sizeOfArray = Integer.valueOf(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[sizeOfArray];
            long sum = 0;
            for (int j = 0; j < sizeOfArray; j++) {
                Integer val = Integer.valueOf(st.nextToken());
                arr[j] = val;
                sum += val;
            }

            System.out.println(optimalSubArray(arr, 0, sizeOfArray - 1, sum));

        }
    }

    private static int optimalSubArray(int[] array, int beginIndex, int endIndex, long sumOfArray) {
        long sum = 0;
        int i;
        if (array.length > 0 && beginIndex < endIndex && sumOfArray % 2 == 0) {

            for (i = beginIndex; i < endIndex; i++) {
                sum += array[i];
                if (sum == sumOfArray / 2) {
                    break;
                }
            }
            if (i < endIndex) {
                return 1 + Math.max(optimalSubArray(array, beginIndex, i, sumOfArray / 2), optimalSubArray(array, i + 1, endIndex, sumOfArray / 2));
            } else {
                return 0;
            }
        }
        return 0;
    }
}
