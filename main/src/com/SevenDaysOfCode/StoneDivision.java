package com.SevenDaysOfCode;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class StoneDivision {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger sizeOfPile = new BigInteger(st.nextToken());
        int numberOfDividers = Integer.valueOf(st.nextToken());
        BigInteger[] dividers = new BigInteger[numberOfDividers];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < numberOfDividers; i++){
            dividers[i] = new BigInteger(st.nextToken());
        }

        if(isWinning(sizeOfPile, dividers)){
            System.out.println("First");
        }else{
            System.out.println("Second");
        }
    }

    private static boolean isWinning(BigInteger position, BigInteger[] dividers){
        ArrayList<BigInteger> possiblePositions = new ArrayList<>();
        for (BigInteger i : dividers) {
            if(Objects.equals(position.mod(i), BigInteger.ZERO)){
                possiblePositions.add(position.divide(i));
            }
        }

        for(BigInteger possiblePosition: possiblePositions){
            if(!isWinning(possiblePosition, dividers)){
                return true;
            }
        }
        return false;
    }
}
