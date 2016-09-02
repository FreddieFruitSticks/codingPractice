package com.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class LCSReturns {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string1 = br.readLine();
        String string2 = br.readLine();
        Set<Character> setForString2 = new HashSet<>();

        for (char c : string2.toCharArray()) {
            setForString2.add(c);
        }


        int[][] LCSMatrix = new int[string1.length() + 1][string2.length() + 1];
        calcLCSMatrix(LCSMatrix, string1, string2);
        int lcs = LCSMatrix[string1.length()][string2.length()];
        int ans = 0;
        for (Character character : setForString2) {
            for(int i = 0; i <= string1.length(); i++){
                String newString = string1.substring(0,i) + character + string1.substring(i, string1.length());
                LCSMatrix = new int[newString.length() + 1][string2.length() + 1];
                calcLCSMatrix(LCSMatrix, newString, string2);
                if(LCSMatrix[newString.length()][string2.length()] == lcs+1){
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

    private static void calcLCSMatrix(int[][] LCSMatrix, String string1, String string2 ){
        for (int i = 1; i <= string1.length(); i++) {
            for (int j = 1; j <= string2.length(); j++) {
                if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
                    LCSMatrix[i][j] = 1 + LCSMatrix[i - 1][j - 1];
                } else {
                    LCSMatrix[i][j] = Math.max(LCSMatrix[i - 1][j], LCSMatrix[i][j - 1]);
                }
            }
        }
    }
}
