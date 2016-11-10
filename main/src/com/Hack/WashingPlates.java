package com.Hack;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class WashingPlates {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numberOfPlates = Integer.valueOf(st.nextToken());
        int numberToWash = Integer.valueOf(st.nextToken());
        List<BigInteger> positiveDiffs = new ArrayList<>();
        BigInteger dSum = BigInteger.ZERO;

        for (int i = 0; i < numberOfPlates; i++) {
            st = new StringTokenizer(br.readLine());
            BigInteger p = new BigInteger(st.nextToken());
            BigInteger d = new BigInteger(st.nextToken());
            dSum = dSum.subtract(d);
            BigInteger add = p.add(d);
            positiveDiffs.add(add);

        }
        positiveDiffs.sort(new Comparator<BigInteger>() {
            @Override
            public int compare(BigInteger o1, BigInteger o2) {
                return o1.compareTo(o2) * (-1);
            }
        });
        for (int i = 0; i < numberToWash; i++) {
            dSum = dSum.add(positiveDiffs.get(i));
        }
        if(dSum.compareTo(BigInteger.ZERO) > 0){
            System.out.println(dSum);
        }else{
            System.out.println(0);
        }

    }

    private static void printArray(List<BigInteger> list) {
        for (BigInteger bigInteger : list) {
            System.out.print(bigInteger + " ");
        }
    }
}
