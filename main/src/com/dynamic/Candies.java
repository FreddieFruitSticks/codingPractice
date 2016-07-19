package com.dynamic;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Candies {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numOfCases = Integer.valueOf(br.readLine());
        int numOfCandies = 1;
        int totalNumOfCandies = 0;

        int previousKidsScore = 0;
        int[] scores = new int[numOfCases];
        for (int i = 0; i < numOfCases; i++) {
            scores[i] = Integer.valueOf(br.readLine());
        }
        for (int i = 0; i < numOfCases; i++) {
            int score = scores[i];

            if (i == 0) {
                totalNumOfCandies += numOfCandies;
                previousKidsScore = score;
                continue;
            }
            if (score < previousKidsScore) {
                numOfCandies=1;
                int nextHigherAndSumAll = findNextHigherAndSumAll(score, scores, 1, i);
                totalNumOfCandies += (summation(nextHigherAndSumAll) + 2);
                i += nextHigherAndSumAll;
            } else if (score == previousKidsScore) {
                totalNumOfCandies += 1;
            } else {
                numOfCandies++;
                totalNumOfCandies += numOfCandies;
            }
            previousKidsScore = score;
        }
        System.out.println(totalNumOfCandies);
    }

    private static int findNextHigherAndSumAll(int score, int[] scores, int num, int currentpupil) throws IOException {
        if (currentpupil < scores.length) {
            int nextScore = 0;
            if (currentpupil < scores.length - 1) {
                nextScore = scores[currentpupil + 1];
            }
            if (nextScore > 0 && nextScore <= score) {
                return findNextHigherAndSumAll(nextScore, scores, num + 1, currentpupil + 1);
            } else {
                return num;
            }
        } else {
            return num;
        }
    }

    private static int summation(int num) {
        if (num > 0) {
            return num + summation(num - 1);
        } else {
            return num;
        }
    }
}
