package com.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommonChild {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int option1 = longestCommonSubsequence(s1, s2);

        System.out.println(option1);
    }

    private static int longestCommonSubsequence(String s1, String s2) {
        if((s1.length() | s2.length()) == 0 || s1.equals("") || s2.equals("")){
            return 0;
        }
        if (s1.charAt(s1.length() - 1) == s2.charAt(s2.length() - 1)) {
            return 1 + longestCommonSubsequence(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length() - 1));
        } else {
            return Math.max(longestCommonSubsequence(s1, s2.substring(0, s2.length() - 1)), longestCommonSubsequence(s1.substring(0, s1.length() - 1), s2));
        }
    }
}
