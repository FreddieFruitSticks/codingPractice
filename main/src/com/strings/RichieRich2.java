package com.strings;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RichieRich2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int SizeOfNumber = Integer.valueOf(st.nextToken());
        int maxNumsToChange = Integer.valueOf(st.nextToken());
        String numberToChange = br.readLine();

        RichieRich2 richieRich2 = new RichieRich2();
        System.out.println(richieRich2.highestPaidPalindrome(numberToChange, maxNumsToChange));
    }

    private String highestPaidPalindrome(String numberToChange, int maxNumsToChange) {
        char[] numsAsChars = numberToChange.toCharArray();
        int lengthOfInstructions = (numsAsChars.length - 1) / 2 + 1;
        int[] instructionsArray = new int[lengthOfInstructions];
        int numOfChanges = 0;

        for (int i = 0; i < lengthOfInstructions; i++) {
            if (bothNine(numsAsChars, i)) {
                instructionsArray[i] = 0;
            } else if (i == lengthOfInstructions - 1 && isOddSizedNumber(numsAsChars) && numsAsChars[i] != '9') {
                instructionsArray[i] = 1;
                numOfChanges++;
            } else if (atLeastOneNine(numsAsChars, i)) {
                instructionsArray[i] = 1;
                numOfChanges++;
            } else {
                instructionsArray[i] = 2;
                numOfChanges += 2;
            }
        }
        int index = lengthOfInstructions - 1;
        if (isOddSizedNumber(numsAsChars) && numOfChanges > maxNumsToChange) {
            instructionsArray[lengthOfInstructions - 1] = 0;
            numOfChanges--;
            index--;
        }
        while (numOfChanges > maxNumsToChange && index >= 0) {
            if (numsAsChars[index] == numsAsChars[numsAsChars.length - 1 - index] && numsAsChars[index] != '9') {
                numOfChanges -= 2;
                instructionsArray[index] = 0;
                index--;
            } else if (bothNine(numsAsChars, index)) {
                instructionsArray[index] = 0;
                index--;
            } else if (atLeastOneNine(numsAsChars, index)) {
                index--;
            } else if (!arePalindromicPairsEqual(numsAsChars, index)) {
                instructionsArray[index] = 1;
                numOfChanges--;
                index--;
            }
        }
        if (numOfChanges > maxNumsToChange) {
            return "-1";
        }
        numOfChanges = maxNumsToChange;
        for (int i = 0; i < lengthOfInstructions; i++) {
            if (instructionsArray[i] == 1) {
                int max;
                if(i == numsAsChars.length - 1 - i){
                    max = '9';
                }else{
                    max = Math.max(numsAsChars[i], numsAsChars[numsAsChars.length - 1 - i]);
                }
                numsAsChars[i] = (char) max;
                numsAsChars[numsAsChars.length - 1 - i] = (char) max;
                numOfChanges--;

            } else if (instructionsArray[i] == 2) {
                numsAsChars[i] = '9';
                numsAsChars[numsAsChars.length - 1 - i] = '9';
                numOfChanges-=2;
            }
        }

        //this is an edge case
        if(isOddSizedNumber(numsAsChars) && numOfChanges == 1){
            numsAsChars[lengthOfInstructions-1] = '9';
        }
        return new String(numsAsChars);
    }

    private boolean isOddSizedNumber(char[] numsAsChars) {
        return numsAsChars.length % 2 != 0;
    }

    private boolean arePalindromicPairsEqual(char[] numsAsChars, int index) {
        return numsAsChars[index] == numsAsChars[numsAsChars.length - 1 - index];
    }

    private boolean bothNine(char[] numsAsChars, int i) {
        return numsAsChars[i] == '9' && numsAsChars[numsAsChars.length - 1 - i] == '9';
    }

    private boolean atLeastOneNine(char[] numsAsChars, int i) {
        return numsAsChars[i] == '9' || numsAsChars[numsAsChars.length - 1 - i] == '9';
    }

}
