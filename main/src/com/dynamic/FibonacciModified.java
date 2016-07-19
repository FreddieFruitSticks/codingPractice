package com.dynamic;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class FibonacciModified {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger bigA = new BigInteger(st.nextToken());
        BigInteger bigB = new BigInteger(st.nextToken());
        int N = Integer.valueOf(st.nextToken());

//        int sum = a + (int)Math.pow(b,2);
        System.out.println(calcSum(bigA,bigB,N));
    }

    public static BigInteger calcSum(BigInteger a, BigInteger b, int N){
        if(N-3>0){
            return calcSum(b, a.add(b.pow(2)), N-1);
        }else {
            return a.add(b.pow(2));
        }
    }
}
