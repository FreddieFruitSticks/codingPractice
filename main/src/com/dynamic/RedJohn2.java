package com.dynamic;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RedJohn2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfCases = Integer.valueOf(br.readLine());

        for (int i = 0; i < numOfCases; i++) {
            int lengthOfWall = Integer.valueOf(br.readLine());

            System.out.println(numOfConfigs(lengthOfWall));
        }
    }

    public static int numOfConfigs(int lengthOfWall) {
        int count = 0;
        if (lengthOfWall < 4) {
            return 1;
        } else {
            count+=numOfConfigs(lengthOfWall - 1) + numOfConfigs(lengthOfWall - 4);
        }
        return count;
    }
}
