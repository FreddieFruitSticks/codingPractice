package com.dynamic;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class KnapSack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/home/freddie/Desktop/knapsack"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sizeOfKnapsack = Integer.valueOf(st.nextToken());
        int numOfItems = Integer.valueOf(st.nextToken());
        Item[] items = new Item[numOfItems];

        //Let F[i][j] be the maximum value that we can put the first i items in to knapsack size j
        int[][] F = new int[numOfItems + 1][sizeOfKnapsack + 1];

        for (int i = 0; i < numOfItems; i++) {
            st = new StringTokenizer(br.readLine());
            items[i] = new Item(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()));
        }

        fillTable(F, items, sizeOfKnapsack);
        System.out.println(F[numOfItems][sizeOfKnapsack]);
    }

    private static void fillTable(int[][] F, Item[] items, int sizeOfKnapsack) {
        //refer to items[i-1]
        for (int i = 1; i < items.length + 1; i++) {
            for (int j = 1; j < sizeOfKnapsack + 1; j++) {
                if (j - items[i - 1].getWeight() < 0) {
                    F[i][j] = F[i - 1][j];
                } else if (j - items[i - 1].getWeight() >= 0) {
                    F[i][j] = Math.max(F[i - 1][j], F[i][j - items[i - 1].getWeight()] + items[i - 1].getValue());
                }
            }
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
