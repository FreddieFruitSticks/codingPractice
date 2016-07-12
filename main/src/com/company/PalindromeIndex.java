package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeIndex {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int numOfCases = Integer.valueOf(br.readLine());

            for (int i = 0; i < numOfCases; i++) {
                String string = br.readLine();
                boolean changed = false;
                for (int j = 0; j < string.length() / 2; j++) {
                    if (string.charAt(j) != string.charAt(string.length() - 1 - j)) {
                        String substring = string.substring(j, string.length() - 1 - j);
                        if (isPalindrome(substring)) {
                            changed=true;
                            System.out.println(string.length() - 1 - j);
                            break;
                        } else if (isPalindrome(string.substring(j + 1, string.length() - j))) {
                            changed=true;
                            System.out.println(j);
                            break;
                        } else {
                            System.out.println(-1);
                            break;
                        }
                    }
                }
                if(!changed){
                    System.out.println(-1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String reverseString(String string) {
        char[] chars = string.toCharArray();
        int begin = 0;
        int end = chars.length - 1;
        char tmp;
        while (end > begin) {
            tmp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = tmp;
            begin++;
            end--;
        }
        return new String(chars);
    }

    private static boolean isPalindrome(String string) {
        return string.hashCode() == reverseString(string).hashCode();
    }


}
