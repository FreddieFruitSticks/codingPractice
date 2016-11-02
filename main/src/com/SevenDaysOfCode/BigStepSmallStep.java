package com.SevenDaysOfCode;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BigStepSmallStep {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numOfQueries = Integer.valueOf(br.readLine());

        for (int i = 0; i < numOfQueries; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            int c = Integer.valueOf(st.nextToken());

            int longest = a > b ? a : b;
            int shortest = a > b ? b : a;
            int numOfSticks = 0;
            if (c % longest == 0) {
                if (c != 0) {
                    numOfSticks = c / longest;
                } else {
                    numOfSticks = 0;
                }
                System.out.println(numOfSticks);

            } else if (c < shortest) {
                System.out.println(2);
            } else if (c == shortest) {
                System.out.println(1);
            } else if(c < longest){
                System.out.println(2);
            }else {
                System.out.println(c / longest + 1);
            }
        }

    }
}
