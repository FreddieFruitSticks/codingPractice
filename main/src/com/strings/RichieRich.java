package com.strings;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//THis was my first incorrect try
public class RichieRich {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int SizeOfNumber = Integer.valueOf(st.nextToken());
        int maxNumsToChange = Integer.valueOf(st.nextToken());
        String numberToChange = br.readLine();

        RichieRich richieRich = new RichieRich();
        System.out.println(richieRich.highestPalindrome(numberToChange, maxNumsToChange));

    }

    private String highestPalindrome(String numToChange, int maxNumsToChange) {
        char[] numAsCharArray = numToChange.toCharArray();

        for (int i = 0; i <= numAsCharArray.length / 2; i++) {
            if (maxNumsToChange <= 0 && !arePalindromicNumsEqual(numAsCharArray, i)) {
                System.out.println(new String(numAsCharArray));
                return "-1";
            } else if (maxNumsToChange >= 2) {
                if(numAsCharArray[i] != '9'){
                    numAsCharArray[i] = '9';
                    maxNumsToChange --;
                }
                if(numAsCharArray[numAsCharArray.length - 1 - i] != '9'){
                    numAsCharArray[numAsCharArray.length - 1 - i] = '9';
                    maxNumsToChange --;
                }
            } else if (maxNumsToChange == 1 && !arePalindromicNumsEqual(numAsCharArray, i)) {
                int max = Math.max(numAsCharArray[i], numAsCharArray[numAsCharArray.length - 1 - i]);

                char max1 = (char) max;

                numAsCharArray[i] = max1;
                numAsCharArray[numAsCharArray.length - 1 - i] = max1;
                maxNumsToChange--;
            }else if(i == numAsCharArray.length - 1 - i && maxNumsToChange == 1){
                numAsCharArray[i] = '9';
            }
        }
        return new String(numAsCharArray);
    }

    private boolean arePalindromicNumsEqual(char[] numAsCharArray, int i) {
        return numAsCharArray[i] == numAsCharArray[numAsCharArray.length - 1 - i];
    }
}
