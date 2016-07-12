

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = bufferedReader.readLine();
            int numOfCases = Integer.valueOf(s);
            for (int i = 0; i < numOfCases; i++) {
                System.out.println(palindrome.turnPalindrome(bufferedReader.readLine()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //return min num of operation to make string a palindrome
    private int turnPalindrome(String string) {
        char[] chars = string.toCharArray();
        int i;
        if (string.length() % 2 == 0) {
            i = string.length() / 2;
        } else {
            i = string.length() / 2 + 1;
        }
        int num = 0;
        int j = (string.length() / 2) - 1;
        for (; i < string.length(); i++) {
            int diff = (int) chars[i] - (int) chars[j];
            num += diff;
            j--;
        }
        return num;
    }
}
