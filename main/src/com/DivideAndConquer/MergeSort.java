package com.DivideAndConquer;


public class MergeSort {

    public static void main(String[] args) {
        int[] array = {4, 45, 6, 7, 89, 1, 0, 45};
        int[] sorted = mergeSort(array);
        printArray(sorted);
    }

    private static int[] mergeSort(int[] array) {
        if (array.length > 1) {
            int[] leftArray = new int[array.length / 2];
            int[] rightArray = new int[array.length - array.length / 2];

            for (int i = 0; i < leftArray.length; i++) {
                leftArray[i] = array[i];
            }
            for (int i = 0; i < rightArray.length; i++) {
                rightArray[i] = array[leftArray.length + i];
            }
            int[] leftSortedArray = mergeSort(leftArray);
            int[] rightSortedArray = mergeSort(rightArray);
            return merge(leftSortedArray, rightSortedArray);
        } else {
            return array;
        }

    }

    private static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int indexOfLeft = 0;
        int indexOfRight = 0;
        for (int i = 0; i < merged.length; i++) {
            if (left.length <= indexOfLeft && right.length > indexOfRight) {
                merged[i] = right[indexOfRight];
                indexOfRight++;
            } else if (right.length <= indexOfRight && left.length > indexOfLeft) {
                merged[i] = left[indexOfLeft];
                indexOfLeft++;
            } else if (left[indexOfLeft] < right[indexOfRight]) {
                merged[i] = left[indexOfLeft];
                indexOfLeft++;
            } else {
                merged[i] = right[indexOfRight];
                indexOfRight++;
            }
        }
        return merged;
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
