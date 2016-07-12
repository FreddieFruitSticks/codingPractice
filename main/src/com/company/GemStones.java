package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GemStones {

    public static void main(String[] args) {
        GemStones gemStones = new GemStones();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int numOfCases = Integer.parseInt(br.readLine());
            String row1 = br.readLine();
            HashSet<Character> commonHashSet = gemStones.sortThenRemoveDuplicates(row1.toCharArray());

            for (int i = 1; i < numOfCases; i++) {
                String row = br.readLine();
                HashSet<Character> map = gemStones.sortThenRemoveDuplicates(row.toCharArray());
                commonHashSet.retainAll(map);
            }
            System.out.println(commonHashSet.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printArray(char[] chars) {
        for (char achar : chars) {
            System.out.println(achar);
        }
    }

    private HashSet<Character> sortThenRemoveDuplicates(char[] chars) {
        HashSet<Character> uniqueChars = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            uniqueChars.add(chars[i]);
        }
        return uniqueChars;
    }
}
