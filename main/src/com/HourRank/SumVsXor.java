package com.HourRank;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class SumVsXor {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger n = new BigInteger(br.readLine());
        BigInteger numOfEqualities = BigInteger.ZERO;
        int numOfZeros = 0;
        int i1 = n.bitLength();
        for(int i = 0; i < i1; i ++){
            if(!n.testBit(i) ){
//                numOfEqualities = numOfEqualities.add(BigInteger.ONE);
                numOfZeros++;
            }
        }

        System.out.println((long)Math.pow(2,numOfZeros));
    }

    private static void printArray(byte[] array){
        for (byte b : array) {
            System.out.print(b+" ");
        }
    }
}
