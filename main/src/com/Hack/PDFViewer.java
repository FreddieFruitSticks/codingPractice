package com.Hack;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PDFViewer {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] heights = new int[26];

        for(int i = 0; i < 26; i ++){
            heights[i] = Integer.valueOf(st.nextToken());
        }

        String word = br.readLine();
        int height = 0;

        for(int i = 0; i < word.length(); i ++){
            int height1 = heights[word.charAt(i) - 97];
            if (height < height1){
                height = height1;
            }
        }

        System.out.println(word.length()*height);
    }
}
