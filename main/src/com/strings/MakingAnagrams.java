package com.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by freddie on 2016/07/04.
 */
public class MakingAnagrams {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String string1 = br.readLine();
            String string2 = br.readLine();
            int[] charCount1 = getNumOfChars(string1);
            int[] charCount2 = getNumOfChars(string2);

            int sum = 0;

            for (int i = 0; i < charCount1.length; i++) {
                sum += absVal(charCount1[i] - charCount2[i]);
            }
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int absVal(int num) {
        return num > 0 ? num : (~num) + 1;
    }

    private static int[] getNumOfChars(String string) {
        int[] charCount = new int[26];
        int a = (int) 'a';
        for (char aChar : string.toCharArray()) {
            charCount[(int) aChar - a]++;
        }

        return charCount;
    }
}
