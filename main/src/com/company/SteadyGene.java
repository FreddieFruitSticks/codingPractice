package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SteadyGene {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int size = Integer.valueOf(br.readLine());
            String gene = br.readLine();
            char[] geneArray = gene.toCharArray();
            long start = System.nanoTime();
            int allowedNumOfGenes = size / 4;

            //A C T G
            int[] numOfEachGene = {-allowedNumOfGenes, -allowedNumOfGenes, -allowedNumOfGenes, -allowedNumOfGenes};
            for (int i = 0; i < size; i++) {
                incrementArray(geneArray[i], numOfEachGene);
            }
            int minSubStringSize = 0;
            for (int i = 0; i < 4; i++) {
                if (numOfEachGene[i] > 0) {
                    minSubStringSize += numOfEachGene[i];
                }
            }
            if(minSubStringSize == 0){
                System.out.println(0);
                return;
            }
            int[] copyOfNumOfEachGene = numOfEachGene.clone();

            while(sumPositiveArray(copyOfNumOfEachGene) != 0){
                copyOfNumOfEachGene = numOfEachGene.clone();

                String substring = gene.substring(0, minSubStringSize + 1);
                char[] substringArray = substring.toCharArray();

                for (int i = 0; i < substring.length(); i++) {
                    decrementArray(substringArray[i], copyOfNumOfEachGene);
                }
                int minSum = sumPositiveArray(copyOfNumOfEachGene);
                for (int i = 0; i < gene.length() - minSubStringSize; i++) {
                    char charAtI = gene.charAt(i);
                    char charAtISub = gene.charAt(i + minSubStringSize);
                    incrementArray(charAtI, copyOfNumOfEachGene);
                    decrementArray(charAtISub, copyOfNumOfEachGene);
                    int sum = sumPositiveArray(copyOfNumOfEachGene);
                    if(sum < minSum){
                        minSum = sum;
                    }
                    if(sumPositiveArray(copyOfNumOfEachGene) == 0){
                        System.out.println(minSubStringSize);
                        break;
                    }
                }
                minSubStringSize+=minSum;
            }

            double elapsedTime = (System.nanoTime() - start) * (1.0e-9);
            System.out.println(elapsedTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void incrementArray(char c, int[] numOfEachGene) {
        if (c == 'A') {
            numOfEachGene[0]++;
        } else if (c == 'C') {
            numOfEachGene[1]++;

        } else if (c == 'T') {
            numOfEachGene[2]++;

        } else if (c == 'G') {
            numOfEachGene[3]++;
        }
    }


    public static void decrementArray(char c, int[] numOfEachGene) {
        if (c == 'A' && numOfEachGene[0] != 0) {
            numOfEachGene[0]--;
        } else if (c == 'C') {
            numOfEachGene[1]--;

        } else if (c == 'T') {
            numOfEachGene[2]--;

        } else if (c == 'G') {
            numOfEachGene[3]--;
        }
    }

    public static int sumPositiveArray(int[] array) {
        int sum = 0;
        for (int i : array) {
            if (i > 0)
                sum += i;
        }
        return sum;
    }

}
