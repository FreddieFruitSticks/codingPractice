package com.dynamic;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommonChildBottomUp {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        char[] chars2 = s2.toCharArray();
        char[] chars1 = s1.toCharArray();
        int[][] wordMesh = new int[s1.length() + 1][s2.length() + 1];
        StringBuffer sb = new StringBuffer();
        int max = 0;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (chars1[i] == chars2[j]) {
                    wordMesh[i+1][j+1] = 1 + wordMesh[i][j];
                    if(wordMesh[i+1][j+1] > max){
                        sb.append(chars1[i]);
                        max = wordMesh[i+1][j+1];
                    }
                } else {
                    wordMesh[i+1][j+1] = Math.max(wordMesh[i+1][j], wordMesh[i][j+1]);
                }


            }
        }
        System.out.println(sb.toString());
        System.out.println(wordMesh[s1.length()][s2.length()]);
    }
}
