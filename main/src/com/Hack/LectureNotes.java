package com.Hack;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LectureNotes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numberOfStudents = Integer.valueOf(st.nextToken());
        int numberOfFriends = Integer.valueOf(st.nextToken());
        int[] friends = new int[numberOfFriends];
        String binaryString = br.readLine();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < numberOfFriends;i++){
            friends[i] = Integer.valueOf(st.nextToken());
        }

        System.out.println(ans(binaryString, friends));

    }

    private static String ans(String binString, int[] friends){
        for(int i = 0; i < binString.length(); i++){
            if(binString.charAt(i) == '0' && contains(friends, i+1)){
                return "YES";
            }
        }
        return "NO";
    }

    private static boolean contains(int[] array, int val){
        for (int i = 0; i < array.length; i++) {
            if(array[i] == val){
                return true;
            }
        }
        return false;
    }
}
