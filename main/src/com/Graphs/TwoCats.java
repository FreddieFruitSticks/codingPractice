package com.Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TwoCats {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/home/freddie/Desktop/TwoCats"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numOfCities = Integer.valueOf(st.nextToken());
        int numOfRoads = Integer.valueOf(st.nextToken());
        int numOfFish = Integer.valueOf(st.nextToken());
        int fishlist = 0;
        for (int i = 0; i < numOfFish; i++) {
            fishlist = (fishlist << 1) + 1;
        }
        City[] cities = new City[numOfCities];
        int[][] edges = new int[numOfRoads][numOfRoads];

        for (int i = 0; i < numOfCities; i++) {
            st = new StringTokenizer(br.readLine());
            int numOfFishForThisCity = Integer.valueOf(st.nextToken());
            int fish = 0;
            int fishListOfCity = 0;
            for (int j = 0; j < numOfFishForThisCity; j++) {
                fish = 1 << (Integer.valueOf(st.nextToken()) - 1);
                fishListOfCity = fishListOfCity | fish;
            }
            System.out.println(fishListOfCity);
            cities[i] = new City(numOfFish, fishListOfCity);
        }
        System.out.println(fishlist);
        for (int i = 0; i < numOfRoads; i++) {
            st = new StringTokenizer(br.readLine());
            int city1 = Integer.valueOf(st.nextToken()) - 1;
            int city2 = Integer.valueOf(st.nextToken()) - 1;
            int travelTime = Integer.valueOf(st.nextToken());

            edges[city1][city2] = travelTime;
            edges[city2][city1] = travelTime;
        }
    }

    private static void djikstra(int[][] edges, City[] cities, int startCity, int numOfCities) {
        int[] visitedNodes = new int[numOfCities];
        int[] unvisitedNodes = new int[numOfCities];

        for (int i = 0; i < edges[startCity].length; i++) {
            
        }
    }

    private static class City {
        int maxNumOfFish;
        int fish;
        List<BitMaskAndDistance> distances = new ArrayList<>(maxNumOfFish);

        private void initiateDistances() {
            for (int i = 0; i < maxNumOfFish; i++) {
                distances.add(new BitMaskAndDistance(fish, Integer.MAX_VALUE));
            }
        }

        public City() {
            initiateDistances();
        }

        public City(int fish, int maxNumOfFish) {
            this.maxNumOfFish = maxNumOfFish;
            this.fish = fish;
            initiateDistances();
        }

        public City(List<BitMaskAndDistance> distances) {
            this.distances = distances;
            initiateDistances();
        }

        public List<BitMaskAndDistance> getDistances() {
            return distances;
        }

        public void setDistances(List<BitMaskAndDistance> distances) {
            this.distances = distances;
        }
    }

    private static class BitMaskAndDistance {
        int bitmask;
        int distance;

        public BitMaskAndDistance(int bitmask, int distance) {
            this.bitmask = bitmask;
            this.distance = distance;
        }

        public int getBitmask() {
            return bitmask;
        }

        public void setBitmask(short bitmask) {
            this.bitmask = bitmask;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }
    }
}
