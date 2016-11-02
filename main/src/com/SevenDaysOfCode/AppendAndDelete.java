package com.SevenDaysOfCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AppendAndDelete {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String st1 =br.readLine();
        String st2 =br.readLine();
        int numOfOps = Integer.valueOf(br.readLine());
        char[] A = new char[st1.length()];
        char[] B = new char[st2.length()];

        for (int i = 0; i < st1.length(); i++) {
            A[i] = st1.charAt(i);
        }
        for (int i = 0; i < st2.length(); i++) {
            B[i] = st2.charAt(i);
        }

        int index = findIndexOfCommonDenom(A, B);
        int shortest = A.length > B.length ? B.length : A.length;
        int longest = A.length > B.length ? A.length : B.length;
        int i = numOfOps - (A.length - index + B.length - index - 2);
        if (numOfOps >= shortest+longest+2 || ((i) %2==0) ){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static int findIndexOfCommonDenom(char[] array1, char[] array2) {
        int shortest = array1.length > array2.length ? array2.length : array1.length;
        int index = -1;
        for (int i = 0; i < shortest; i++) {

            if (array1[i] != array2[i]) {
                index = i-1;
                break;
            }
            if( i == shortest-1){
                index = i;
            }

        }
        return index;
    }

}
