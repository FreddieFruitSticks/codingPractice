package com.Hack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class AriasLoop {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger n = new BigInteger(st.nextToken());
        BigInteger k = new BigInteger(st.nextToken());
        System.out.println(n);
        System.out.println(k);
        System.out.println(n.subtract(k).add(BigInteger.ONE));
        System.out.println((n.multiply(n.subtract(k).add(BigInteger.ONE))).divide(factorial(k)));
//
//        System.out.println(factorial(new BigInteger("3")));
    }

    private static BigInteger factorial(BigInteger n){
        if(n.compareTo(BigInteger.ONE) == 0){
            return BigInteger.ONE;
        }else{
            return n.multiply(factorial(n.subtract(BigInteger.ONE)));
        }
    }
}
