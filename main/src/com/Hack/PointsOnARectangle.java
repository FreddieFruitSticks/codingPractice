package com.Hack;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PointsOnARectangle {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfQueries = Integer.valueOf(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < numOfQueries; i++) {
            int numOfPoints = Integer.valueOf(br.readLine());
            int xMax;
            int xMin;
            int yMax;
            int yMin;
            int[][] points = new int[numOfPoints][2];
            boolean onRect = true;

            for (int j = 0; j < numOfPoints; j++) {
                st = new StringTokenizer(br.readLine());
                points[j][0] = Integer.valueOf(st.nextToken());
                points[j][1] = Integer.valueOf(st.nextToken());
            }

            xMin = points[0][0];
            for(int k = 0; k < numOfPoints; k++){
                if(points[k][0] < xMin){
                    xMin = points[k][0];
                }
            }
            xMax = points[0][0];
            for(int k = 0; k < numOfPoints; k++){
                if(points[k][0] > xMax){
                    xMax = points[k][0];
                }
            }
            yMax = points[0][1];
            for(int k = 0; k < numOfPoints; k++){
                if(points[k][1] > yMax){
                    yMax = points[k][1];
                }
            }
            yMin = points[0][1];
            for(int k = 0; k < numOfPoints; k++){
                if(points[k][1] < yMin){
                    yMin = points[k][1];
                }
            }


            for(int k = 0; k < numOfPoints; k++){
                if((points[k][0] < xMax && points[k][0] > xMin) && (points[k][1] != yMax && points[k][1] != yMin)){
                    System.out.println("NO");
                    onRect = false;
                    break;
                }else if((points[k][1] < yMax && points[k][1] > yMin) && (points[k][0] != xMax && points[k][0]!=xMin)){
                    System.out.println("NO");
                    onRect = false;
                    break;
                }
            }
            if(onRect){
                System.out.println("YES");
            }
        }
    }
}
