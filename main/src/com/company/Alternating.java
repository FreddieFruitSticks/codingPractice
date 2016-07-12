package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Alternating {

    public static void main(String[] args) {
        Alternating alternating = new Alternating();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner in = new Scanner(System.in);
        int val = 0;
        try {
            val = Integer.valueOf(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String string;
            for (int i = 0; i < val; i++) {
                System.out.println(alternating.minNumOfDeletions(br.readLine()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int minNumOfDeletions(String string) {
        int deletions = 0;
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) == string.charAt(i - 1)) {
                deletions++;
            }
        }
        return deletions;
    }
}
