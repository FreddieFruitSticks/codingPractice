package com.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EvilForest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numOfCases = Integer.valueOf(br.readLine());

        for (int i = 0; i < numOfCases; i++) {
            int sizeOfArray = Integer.valueOf(br.readLine());
            int[] arrayOfHealths = new int[sizeOfArray];
            StringTokenizer st = new StringTokenizer(br.readLine());
            long exp = 0;
            for (int j = 0; j < sizeOfArray; j++) {
                arrayOfHealths[j] = Integer.valueOf(st.nextToken());
                exp+=arrayOfHealths[j];
            }

            quickSort(arrayOfHealths, 0, sizeOfArray - 1);
            int strength = 1;
            long aExp = exp;
            for (int l = 0; l < sizeOfArray; l++) {
                long newExp = (strength + 1) * (exp - (arrayOfHealths[l]));
                if (aExp < newExp) {
                    strength += 1;
                    aExp = newExp;
                    exp -= arrayOfHealths[l];
                } else {
                    break;
                }
            }
            System.out.println(aExp);
        }
    }

    private static void quickSort(int[] array, int left, int right) {
        int partitionIndex = partition(array, left, right);
        if (partitionIndex < right) {
            quickSort(array, partitionIndex + 1, right);
        }
        if (partitionIndex > left) {
            quickSort(array, left, partitionIndex - 1);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int i = left;
        int j = right - 1;

        int pivot = array[right];

        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (j >= 0 && array[j] > pivot) {
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
        array[i] = pivot;
        array[right] = tmp;
        return i;
    }
}
