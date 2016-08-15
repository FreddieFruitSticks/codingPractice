package com.SevenDaysOfCode;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Map;
import java.util.StringTokenizer;

public class NumberOfSeq {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sizeOfSeq = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] seq = new int[sizeOfSeq];

        for (int i = 0; i < sizeOfSeq; i++) {
            seq[i] = Integer.valueOf(st.nextToken());
        }

        System.out.println((int) (getNumOfOptions(seq) % (Math.pow(10, 9) + 7)));
    }

    public static long getNumOfOptions(int[] array) {
        int[] numOfPerms = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            numOfPerms[i] = i + 1;
        }
        for (int i = 1; i < array.length; i++) {

            int num = numOfPerms[i];
            if (num != 1) {
                int indexOfLastNum = 0;
                for (int j = 2 * (i + 1); j <= array.length; j += (i + 1)) {
                    if (array[j - 1] != -1) {
                        numOfPerms[j - 1] = 1;
                        indexOfLastNum = j;
                    } else {
                        numOfPerms[j - 1] = numOfPerms[j - 1] / num;
                    }
                }
                for (int k = indexOfLastNum; k >= i + 1; k -= (i + 1)) {
                    if (indexOfLastNum % k == 0) {
                        numOfPerms[k - 1] = 1;
                    }
                }
                if (array[i] != -1) {
                    numOfPerms[i] = 1;
                }
            } else {
                for (int j = 2 * (i + 1); j <= array.length; j += (i + 1)) {
                    if (array[j - 1] == -1) {
                        numOfPerms[j - 1] = Math.min(j / i, numOfPerms[j - 1]);
                    }
                }
                if (array[i] != -1) {
                    numOfPerms[i] = 1;
                }
            }
        }
        return multiplyArray(numOfPerms);
    }

    private static long multiplyArray(int[] array) {
        int num = 1;
        BigInteger bigInteger = BigInteger.valueOf(1);
        for (long i : array) {
            num *= Long.valueOf(i);
        }
        return num;
    }
}
