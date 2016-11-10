package com.HourRank;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class CoprimeConundrum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer n = new Integer(br.readLine());
        int sum = 0;
        for(int i = 6; i <= n; i ++){
            for(int k = 2; k < i/2; k++){
                if(i%k ==0 && i/k > k && findGCD(i/k,k) == 1){
                    sum++;
                }
            }
        }
        System.out.println(sum);
//        System.out.println(findGCD(100,49));
    }

    private static int findGCD(int numA, int numB){
        int num1;
        int num2;
        if(numA>numB){
            num1 = numA;
            num2 = numB;
        }else{
            num1 = numB;
            num2 = numA;
        }
        if(num1 == 0){
            return num2;
        }else if(num2 == 0){
            return num1;
        }else{
            int rem = num1%num2;
            int quotient = num1/num2;
            int newNum = (num1-rem)/quotient;
            return findGCD(newNum, rem);
        }

    }
}
