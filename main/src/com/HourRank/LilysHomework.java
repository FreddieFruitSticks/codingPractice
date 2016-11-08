package com.HourRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class LilysHomework {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sizeOfArray = Integer.valueOf(br.readLine());
        int[] array = new int[sizeOfArray];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sizeOfArray; i++) {
            array[i] = Integer.valueOf(st.nextToken());
        }
        int numOfSwaps = 0;
        int minIndex = findMin(array, 0, array.length-1);
        if (minIndex == 0) {
            for (int i = 1; i < array.length - 1; i++) {
                minIndex = findMin(array, i, array.length);
                if (minIndex != i) {
                    swap(array, minIndex, i);
                    numOfSwaps++;
                }
            }
        } else if (minIndex == array.length - 1) {
            for (int i = array.length - 2; i > 0; i--) {
                minIndex = findMin(array, 0, i);
                if (minIndex != i) {
                    swap(array, minIndex, i);
                    numOfSwaps++;
                }
            }
        } else {
            swap(array, 0, minIndex);
            numOfSwaps++;
            for (int i = 1; i < array.length - 1; i++) {
                minIndex = findMin(array, i, array.length);
                if (minIndex != i) {
                    swap(array, minIndex, i);
                    numOfSwaps++;
                }
            }
        }


        System.out.println(numOfSwaps);

    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int findMin(int[] array, int start, int end) {
        int min = Integer.MAX_VALUE;
        int minIndex = start;
        for (int i = start; i < end+1; i++) {
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }


}
