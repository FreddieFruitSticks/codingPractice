package com.strings;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FunnyString {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int numOfCases = Integer.valueOf(br.readLine());

            for (int i = 0; i < numOfCases; i++) {
                String string = br.readLine();
                boolean isFunny = isFunny(string);

                if(isFunny){
                    System.out.println("Funny");
                }else{
                    System.out.println("Not Funny");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isFunny(String string) {
        for (int i = 0; i < string.length()/2; i++) {
            if(Math.abs((int)string.charAt(i) - (int)string.charAt(i+1)) != Math.abs((int)string.charAt(string.length()-1-i) - (int)string.charAt(string.length()-1-i-1))){
                return false;
            }
        }
        return true;
    }
}
