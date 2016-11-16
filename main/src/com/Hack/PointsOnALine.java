package com.Hack;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PointsOnALine {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numOfPoints = Integer.valueOf(br.readLine());
        StringTokenizer st;
        int[] xcoord = new int[numOfPoints];
        int[] ycoord = new int[numOfPoints];

        for (int i = 0; i < numOfPoints; i++) {
            st = new StringTokenizer(br.readLine());
            xcoord[i] = Integer.valueOf(st.nextToken());
            ycoord[i] = Integer.valueOf(st.nextToken());
        }

        if(allItemsSame(xcoord) || allItemsSame(ycoord)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    private static boolean allItemsSame(int[] array) {
        int num = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] != num){
                return false;
            }
        }
        return true;
    }
}
