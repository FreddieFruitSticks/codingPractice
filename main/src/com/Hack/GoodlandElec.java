package com.Hack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoodlandElec {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());

        int[] cityLights = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i ++){
            cityLights[i] = Integer.valueOf(st.nextToken());
        }
        int tempLight;
        int lastLight;
        int numOfLights = 0;

        lastLight = findLastLightLessThanK(cityLights, k);
        tempLight = lastLight;
        numOfLights++;
        if(lastLight == -1){
            System.out.println(-1);
            return;
        }else{
            for(int i = k; i < n;i++){
                if(i - lastLight >=2*k){
                    if(lastLight==tempLight){
                        System.out.println(-1);
                        return;
                    }else{
                        lastLight=tempLight;
                        numOfLights++;
                    }
                }
                if(cityLights[i] == 1){
                    tempLight = i;
                }

                if(n-1 - tempLight < k){
                    numOfLights++;
                    break;
                }
            }
        }
        System.out.println(numOfLights);

    }

    private static int findLastLightLessThanK(int[] cityLights, int k){
        int indexOfLastLight = k;
        for(int i = 0; i < k;i++){
            if(cityLights[i] == 1){
                indexOfLastLight=i;
            }
        }

        if(indexOfLastLight < k){
            return indexOfLastLight;
        }else{
            return -1;
        }
    }
}
