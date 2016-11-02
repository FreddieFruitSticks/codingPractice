package com.SevenDaysOfCode;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BetweenTwoSets {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int sizeOfA = Integer.valueOf(st.nextToken());
        int sizeOfB = Integer.valueOf(st.nextToken());
        int[] A = new int[sizeOfA];
        int[] B = new int[sizeOfB];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < sizeOfA; i ++){
            A[i] = Integer.valueOf(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < sizeOfB; i ++){
            B[i] = Integer.valueOf(st.nextToken());
        }
        int xMin = findMax(A);
        int xMax= findMin(B);
        int numOfXs =0;
        for(int i = xMin; i <= xMax; i ++){
            boolean valid = true;
            for(int j = 0; j < A.length; j++){
                if(i%A[j] != 0){
                    valid=false;
                    break;
                }

            }
            if(valid){
                for(int j = 0; j < B.length; j++){
                    if(B[j]%i != 0){
                        valid=false;
                        break;
                    }
                }
            }

            if(valid){
                numOfXs++;

            }
        }
        System.out.println(numOfXs);
    }

    private static int findMax(int[] array){
        int max = 0;
        for (int i = 0; i < array.length; i ++){
            if(array[i] > max){
                max = array[i];
            }
        }

        return max;
    }

    private static int findMin(int[] array){
        int min = 101;
        for (int i = 0; i < array.length; i ++){
            if(array[i] < min){
                min = array[i];
            }
        }

        return min;
    }
}
