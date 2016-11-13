package com.Hack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class LazyMayor {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfBuildings = Integer.valueOf(br.readLine());
        BigInteger[] heightOfBuildings = new BigInteger[numOfBuildings];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < numOfBuildings; i++) {
            heightOfBuildings[i] = new BigInteger(st.nextToken());
        }

        int numOfLasers = Integer.valueOf(br.readLine());
//        int[] posOfLasers = new int[numOfBuildings];
        List<Integer> posOfLasers1 = new ArrayList<Integer>();
        List<Integer> posOfLasers = new ArrayList<Integer>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < numOfLasers; i++) {
            posOfLasers1.add(Integer.valueOf(st.nextToken())-1);
        }
        posOfLasers1.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1;
            }
        });

        LinkedHashSet<Integer> set = new LinkedHashSet<>(posOfLasers1);
        posOfLasers = new ArrayList<>(set);
        Collections.sort(posOfLasers);
        Collections.reverse(posOfLasers);
        int nextLaser = 0;
        BigInteger num = BigInteger.ONE;
        for(int i = posOfLasers.get(0) - 1; i >= 0; i--){
            BigInteger minHeight = heightOfBuildings[i].compareTo(num) > 0 ? num : heightOfBuildings[i];
            heightOfBuildings[i] = minHeight;
            if(nextLaser < posOfLasers.size()-1 &&i == posOfLasers.get(nextLaser+1)){
                nextLaser++;
                num = BigInteger.ONE;
            }else{
                num = num.add(BigInteger.ONE);
            }
        }

        printSum(heightOfBuildings);

    }

    private static void printSum(BigInteger[] array){
        BigInteger sum = BigInteger.ZERO;

        for (BigInteger bigInteger : array) {
            sum = sum.add(bigInteger);
        }

        System.out.println(sum);
    }
}
