package com.dynamic;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RodCutting {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/home/freddie/Desktop/cutRod"));
        int sizeOfRod = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] valueOfSize = new int[sizeOfRod];

        for(int i = 0; i< sizeOfRod; i++){
            valueOfSize[i] = Integer.valueOf(st.nextToken());
        }

        RodCutting rodCutting = new RodCutting();
        System.out.println(rodCutting.calculateBestWayToCut(valueOfSize));

    }

    private int calculateBestWayToCut(int[] valueOfSizes){
        List<Integer> maxSalesPrices = new ArrayList<>();

        maxSalesPrices.add(0);

        for(int i = 1; i < valueOfSizes.length; i++){
            int max = maxSalesPrices.get(0);
            for (int j = 1; j <= maxSalesPrices.size(); j++) {
                if(max < maxSalesPrices.get(i-j) + valueOfSizes[j]){
                    max = maxSalesPrices.get(i-j) + valueOfSizes[j];
                }
            }
            maxSalesPrices.add(max);
        }

        return maxSalesPrices.get(maxSalesPrices.size()-1);
    }
}
