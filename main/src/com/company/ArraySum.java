package com.company;

import java.io.*;
import java.util.*;

public class ArraySum {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = null;
        try {
            int numOfEl = Integer.valueOf(br.readLine());
            tk = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int i = 0; i < numOfEl; i++) {
                int m = Integer.parseInt(tk.nextToken());
                sum += m;
            }
            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
