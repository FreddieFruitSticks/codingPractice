package com.company;

/**
 * Created by freddie on 2016/06/20.
 */
public class QuickSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = {1,3,6,3,9,12,90,2,8,67,56,3,1,99};

        quickSort.quickSort(array,0,array.length-1);
        quickSort.printArray(array);
    }

    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left;
        int j = right - 1;

        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
                i++;
                j--;
            }
        }
        int temp = array[right];
        array[right] = array[i];
        array[i] = temp;
        return i;
    }

    public void quickSort(int[] array, int left, int right) {
        int pivotIndex = partition(array, left, right);
        if(pivotIndex < right){
            quickSort(array, pivotIndex + 1, right);
        }
        if(pivotIndex > left){
            quickSort(array, left, pivotIndex -1);
        }
    }
}
