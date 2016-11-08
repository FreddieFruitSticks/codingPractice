package com.HourRank;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeatifulDays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i = Integer.valueOf(st.nextToken());
        int j = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());
        int numOfDays=0;
        for(int p = i; p < j; p++){
            if((Math.abs(p-Integer.valueOf(reverse(p)) ))%k == 0){
                numOfDays++;
            }
        }
        System.out.println(numOfDays);
    }

    private static String reverse(int num) {
        String number = String.valueOf(num);

        char[] numberCharArray = number.toCharArray();
        char[] numberCharArrayReversed = new char[numberCharArray.length];
        for (int i = 0; i < numberCharArray.length; i++) {
            numberCharArrayReversed[i] = numberCharArray[numberCharArray.length - 1 - i];

        }
        int leadingZeros = 0;
        for (int i = 0; i < numberCharArrayReversed.length; i++) {
            if (numberCharArrayReversed[i] != '0') {
                break;
            } else {
                leadingZeros++;
            }
        }
        String numberReversed = new String(numberCharArrayReversed);
        return numberReversed.substring(leadingZeros, numberReversed.length());
    }
}
