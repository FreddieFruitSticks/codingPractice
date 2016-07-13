package com.strings;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameOfThrones {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String string = br.readLine();
            boolean isKey = isKey(string);
            if (isKey) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static boolean isKey(String string) {
        int[] numOfChars = createCharArray(string);
        if (string.length() % 2 == 0) {
            for (int i = 0; i < numOfChars.length; i++) {
                if (numOfChars[i] % 2 != 0) {
                    return false;
                }
            }
            return true;
        } else {
            boolean oneOdd = false;
            for (int i = 0; i < numOfChars.length; i++) {
                if (numOfChars[i] % 2 != 0) {
                    if (oneOdd != true) {
                        oneOdd = true;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    private static int[] createCharArray(String string) {
        char[] chars = string.toCharArray();
        int[] numOfchars = new int[26];

        for (int i = 0; i < chars.length; i++) {
            numOfchars[(int) chars[i] - (int) 'a']++;
        }
        return numOfchars;
    }
}
