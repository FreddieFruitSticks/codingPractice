package com.Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[0].length; j++) {
                edges[i][j] = -1;
            }
        }

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
        Integer[] citiesIndex = new Integer[numOfCities];
        for(int i = 0; i <numOfCities; i++){
            citiesIndex[i] = i;
        }

        List<Integer> visitedNodes = new ArrayList();
        List<Integer> unvisitedNodes = Arrays.asList(citiesIndex);

        while (visitedNodes.size() < numOfCities) {
            for (int i = 0; i < edges[startCity].length; i++) {
                Object[] fishOptionsOfCity = cities[startCity].getDistances().keySet().toArray();
                if (edges[startCity][i] >= 0) {
                    for (int j = 0; j < fishOptionsOfCity.length; j++) {
                        BitMaskAndDistance bitMaskAndDistanceOfCity = cities[i].getDistances().get((Integer) fishOptionsOfCity[j]);
                        if (bitMaskAndDistanceOfCity != null) {
                            int distanceToCity = cities[startCity].getDistances().get((Integer) fishOptionsOfCity[j]).getDistance() +
                                    edges[startCity][i];
                            if (cities[i].getDistances().get((Integer) fishOptionsOfCity[j]).getDistance() >
                                    distanceToCity) {
                                cities[i].setDistanceToCity(cities[startCity].getFish() | cities[i].getFish(), distanceToCity);
                            }
                        }
                    }
                }
            }

            visitedNodes.add(startCity);
            unvisitedNodes.remove(startCity);
        }
    }

    private static class City {
        int maxNumOfFish;
        int fish;
        HashMap<Integer, BitMaskAndDistance> distances = new HashMap();

        public City() {

        }

        public City(int fish, int maxNumOfFish) {
            this.maxNumOfFish = maxNumOfFish;
            this.fish = fish;
        }

        public City(HashMap<Integer, BitMaskAndDistance> distances) {
            this.distances = distances;
        }

        public void setDistanceToCity(int fish, int distance) {
            BitMaskAndDistance bit = new BitMaskAndDistance(fish, distance);
            distances.put(fish, bit);
        }

        public HashMap<Integer, BitMaskAndDistance> getDistances() {
            return distances;
        }

        public void setDistances(HashMap<Integer, BitMaskAndDistance> distances) {
            this.distances = distances;
        }

        public int getMaxNumOfFish() {
            return maxNumOfFish;
        }

        public void setMaxNumOfFish(int maxNumOfFish) {
            this.maxNumOfFish = maxNumOfFish;
        }

        public int getFish() {
            return fish;
        }

        public void setFish(int fish) {
            this.fish = fish;
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
