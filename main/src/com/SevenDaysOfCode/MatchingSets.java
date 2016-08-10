package com.SevenDaysOfCode;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MatchingSets {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int sizeOfArrays = Integer.valueOf(bufferedReader.readLine());
        long sumOfDiff = 0;
        long sumOfPositiveNums = 0;
        long diff;
        long[] X = new long[sizeOfArrays];
        long[] Y = new long[sizeOfArrays];

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        StringTokenizer st1 = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < sizeOfArrays; i++) {
            X[i] = Long.valueOf(st.nextToken());
            Y[i] = Long.valueOf(st1.nextToken());
            diff = X[i] - Y[i];
            sumOfDiff += diff;
        }
        quickSort(X, 0, sizeOfArrays - 1);
        quickSort(Y, 0, sizeOfArrays - 1);
        sumOfPositiveNums = getPositiveSumFromDiffArray(X, Y);

        if (sizeOfArrays > 1) {
            if (sumOfDiff == 0) {
                System.out.println(sumOfPositiveNums);
            } else {
                System.out.println(-1);
            }
        } else {
            System.out.println(-1);
        }
    }

    private static long getPositiveSumFromDiffArray(long[] array1, long[] array2) {
        long[] diff = new long[array1.length];
        long sumOfPos = 0;
        for (int i = 0; i < array2.length; i++) {
            diff[i] = array1[i] - array2[i];
            if (diff[i] > 0) {
                sumOfPos += diff[i];
            }
        }

        return sumOfPos;
    }

    private static void print(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static void quickSort(long[] array, int left, int right) {
        int pivot = partition(array, left, right);
        if (pivot > left) {
            quickSort(array, left, pivot - 1);
        }
        if (pivot < right) {
            quickSort(array, pivot + 1, right);
        }
    }

    private static int partition(long[] array, int left, int right) {
        int i = left;
        int j = right - 1;

        long pivot = array[right];

        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (j >= 0 && array[j] > pivot) {
                j--;
            }

            if (i <= j) {
                long temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        long temp = pivot;
        array[right] = array[i];
        array[i] = temp;

        return i;
    }
}
