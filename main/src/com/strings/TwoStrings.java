package com.strings;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class TwoStrings {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int numOfCases = Integer.valueOf(br.readLine());
            for (int i = 0; i < numOfCases; i++) {
                String answer = "NO";
                HashSet<Character> chars = new HashSet<>();
                String string1 = br.readLine();
                for (Character aChar : string1.toCharArray()) {
                    chars.add(aChar);
                }
                String string2 = br.readLine();
                for (Character aChar: string2.toCharArray()){
                    if(chars.contains(aChar)){
                        answer = "YES";
                    }
                }
                System.out.println(answer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
