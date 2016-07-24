package com.dynamic;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CoinChange {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numToDivide = Integer.valueOf(st.nextToken());
        int numOfCoins = Integer.valueOf(st.nextToken());
        int[] coins = new int[numOfCoins];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < numOfCoins; i++) {
            coins[i] = Integer.valueOf(st1.nextToken());
        }
        quickSort(coins, 0, numOfCoins - 1);
//        printArray(coins);

        System.out.println(numOfDivisions(numToDivide, coins, 0, 0));

    }

    private static int numOfDivisions(int numToDivide, int[] coins, int coinIndex, int count) {
        //max num of coins that can go in to numToDivide
        count = 0;
        int maxNumOfCoins = (int) numToDivide / coins[coinIndex];

        for (int i = maxNumOfCoins; i >= 0; i--) {
            int remainder = numToDivide - coins[coinIndex] * i;
            if (coinIndex == coins.length-1) {
                if(numToDivide % coins[coinIndex] == 0){
                    return 1;
                }
                return 0;
            }
            if (remainder == 0) {
                count++;
                continue;
            } else {
                count += numOfDivisions(remainder, coins, coinIndex + 1, count);
            }
        }
        return count;
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
    }

    private static void quickSort(int[] array, int left, int right) {
        int pivot = partition(array, left, right);

        if (pivot > left) {
            quickSort(array, left, pivot - 1);
        }
        if (pivot < right) {
            quickSort(array, pivot + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int i = left;
        int j = right - 1;

        int pivot = right;

        while (i <= j) {
            while (array[i] > array[pivot]) {
                i++;
            }
            while (j >= i && array[j] < array[pivot]) {
                j--;
            }
            if (i <= j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }
        }
        int tmp = array[i];
        array[i] = array[pivot];
        array[pivot] = tmp;
        return i;
    }
}
