package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pangram {
    public static void main(String[] args) {
        Pangram pangram = new Pangram();
        BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println(pangram.isPangram(breader.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String isPangram(String pangramCandidate) {
        if (pangramCandidate == null || "".equals(pangramCandidate)) {
            return "not pangram";
        }
        int[] charsAsInts = createIntsArray();
        char[] chars = pangramCandidate.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            charsAsInts = isInArray(chars[i],charsAsInts);
        }

        int sum = sumArray(charsAsInts);

        if(sum == 0){
            return "pangram";
        }else{
            return "not pangram";
        }
    }

    private int sumArray(int[] array){
        int sum = 0;
        for (int num: array){
            sum+=num;
        }
        return sum;
    }

    private int absVal(int val) {
        return val > 0 ? val : (~val) + 1;
    }

    public int[] isInArray(char aChar, int[] array) {
        int a = (int) 'a';
        if((int)aChar >= 97 && (int)aChar <= 122){
            if ((int) aChar == array[absVal(a - (int) aChar)]) {
                array[absVal(a - (int) aChar)] = 0;
            }
        }else if((int)aChar >= 65 && (int)aChar <= 90){
            if((int) aChar + (a - (int)'A') == array[absVal(a - (int) aChar -32)]){
                array[absVal(a - (int) aChar-32)] = 0;

            }
        }

        return array;
    }

    public int[] createIntsArray() {
        int[] array = new int[26];
        int a = 97;
        for (int i = 0; i < array.length; i++) {
            array[i]= 97 + i;
        }
        return array;
    }

}
