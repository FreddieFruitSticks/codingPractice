package com.Hack;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EasyGCD {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numOfPoints = Integer.valueOf(st.nextToken());
        long k = Long.valueOf(st.nextToken());

        long[] points = new long[numOfPoints];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < numOfPoints; i++) {
            points[i] = Long.valueOf(st.nextToken());
        }
        long gcd;
        if(numOfPoints > 1){
            gcd = findGCD(points[0], points[1]);
        }else{
            gcd = points[0];
        }
        for(int i = 2; i < numOfPoints; i++){
            gcd = findGCD(points[i], gcd);
        }
        long lowestMultiple = findLowestMultiple(gcd);

        System.out.println(k-(k%lowestMultiple));

//        System.out.println(findGCD(12,10));

    }

    private static long findLowestMultiple(long num){
        if(num%2 !=0){
            for(int i = 3; i <= num/2; i+=2){
                if(num%i == 0){
                    return i;
                }
            }
        }else{
            for(int i = 2; i <= num/2; i ++){
                if(num%i == 0){
                    return i;
                }
            }
        }
        return num;
    }

    private static long findGCD(long num1, long num2) {
        long bigger = num1 > num2 ? num1 : num2;
        long smaller = num1 > num2 ? num2 : num1;

        if (bigger % smaller == 0) {
            return smaller;
        } else {
            return findGCD(smaller, bigger % smaller);
        }
    }
}
