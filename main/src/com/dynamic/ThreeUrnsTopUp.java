package com.dynamic;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class ThreeUrnsTopUp {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int initialBeans = Integer.valueOf(st.nextToken());
        int maxBeansToMove = Integer.valueOf(st.nextToken());

        BigInteger[][] beanMatrix = new BigInteger[initialBeans + 1][initialBeans + 1];
        beanMatrix[0][0] = BigInteger.valueOf(1);

        getNumOfPermutationsIteratively(beanMatrix, initialBeans, maxBeansToMove);
        System.out.println(beanMatrix[0][initialBeans].mod(BigInteger.valueOf((long)Math.pow(10,8))));
    }

    private static void getNumOfPermutationsIteratively(BigInteger[][] beanMatrix, int initialBeans, int maxBeansToMove) {
        for (int i = 0; i <= initialBeans; i++) {
            for (int j = 0; j <= initialBeans - i; j++) {
                if (!(j == 0 && i == 0)) {
                    beanMatrix[j][i] = BigInteger.valueOf(0);
                }
                for (int k = 1; k <= Math.min(j, maxBeansToMove); k++) {
                    beanMatrix[j][i] = beanMatrix[j][i].add(beanMatrix[j - k][i]);
                }
                for (int k = 1; k <= Math.min(i, maxBeansToMove); k++) {
                    beanMatrix[j][i] = beanMatrix[j][i].add(beanMatrix[j + k][i - k]);
                }
            }
        }
    }
}
