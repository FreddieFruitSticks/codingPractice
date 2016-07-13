package com.strings;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int numOfCases = Integer.valueOf(br.readLine());

            for (int i = 0; i < numOfCases; i++) {
                String string = br.readLine();
                int[] charBucket = new int[26];

                if (string.length() % 2 != 0) {
                    System.out.println(-1);
                } else {
                    String string1 = string.substring(0, string.length() / 2);
                    String string2 = string.substring(string.length() / 2, string.length());
                    int a = 97;
                    for (int j = 0; j < string1.length(); j++) {
                        charBucket[(int) string1.charAt(j) - a]++;
                    }
                    int total = printSum(charBucket);
                    for (int j = 0; j < string1.length(); j++) {
                        if (charBucket[(int) string2.charAt(j) - a] > 0){
                            charBucket[(int) string2.charAt(j) - a]--;
                        }
                    }
                    System.out.println(printSum(charBucket));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int printSum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }


}
