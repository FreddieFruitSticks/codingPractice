package com.Hack;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class EqualiseArray {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numOfEl = Integer.valueOf(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < numOfEl; i++) {
            Integer key = Integer.valueOf(st.nextToken());
            if (map.get(key) != null) {
                int value = map.get(key);
                map.put(key, value + 1);
            }else{
                map.put(key,1);
            }
        }
        int maxNum = getMaxVal(map.values().toArray());
        System.out.println(numOfEl-maxNum);
    }

    private static int getMaxVal(Object[] array){
        int max = 0;
        for (Object i : array) {
            if ((int)i > max){
                max = (int)i;
            }
        }
        return max;
    }
}
