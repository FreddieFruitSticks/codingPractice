package com.dynamic;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class InfinteKnapsack {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/home/freddie/Desktop/knapsack"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sizeOfKnapsack = Integer.valueOf(st.nextToken());
        int numOfItems = Integer.valueOf(st.nextToken());
        Item[] items = new Item[numOfItems];

        //Let F[i][j] be the maximum value that we can put the first i items in to knapsack size j
        int[] F = new int[sizeOfKnapsack + 1];

        for (int i = 0; i < numOfItems; i++) {
            st = new StringTokenizer(br.readLine());
            items[i] = new Item(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()));
        }

        fillAnswer(F, items, sizeOfKnapsack);
        System.out.println(F[sizeOfKnapsack]);
    }

    private static void fillAnswer(int[] answer, Item[] items, int sizeOfKnapsack) {
        for (int i = 1; i < sizeOfKnapsack + 1; i++) {
            int max = answer[i - 1];
            for (Item item : items) {
                if (i - item.getWeight() >= 0) {
                    if (answer[i - item.getWeight()] + item.getValue() > max) {
                        max = answer[i - item.getWeight()] + item.getValue();
                    }
                }
            }
            answer[i] = max;
        }
    }

    private static class Item {
        private int weight;
        private int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public int getWeight() {
            return weight;
        }
    }
}
