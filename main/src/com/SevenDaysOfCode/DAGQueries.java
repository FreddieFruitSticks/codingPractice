package com.SevenDaysOfCode;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class DAGQueries {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int numOfVertices = Integer.valueOf(st.nextToken());
        int numOfEdges = Integer.valueOf(st.nextToken());
        int numOfQueries = Integer.valueOf(st.nextToken());

        int[][] edges = new int[numOfVertices][numOfVertices];
        Node[] vertices = new Node[numOfVertices];
        for (int i = 0; i < numOfVertices; i++) {
            vertices[i] = new Node();
        }
        for (int i = 0; i < numOfEdges; i++) {
            st = new StringTokenizer(br.readLine());
            edges[Integer.valueOf(st.nextToken()) - 1][Integer.valueOf(st.nextToken()) - 1] = 1;
        }

        for (int i = 0; i < numOfQueries; i++) {
            st = new StringTokenizer(br.readLine());
            int queryNum = Integer.valueOf(st.nextToken());
            int startNode = Integer.valueOf(st.nextToken());
            if(st.hasMoreTokens()){
                BigInteger x = new BigInteger(st.nextToken());
                if (queryNum == 1) {
                    BFS(edges, vertices, startNode, x, 1);
                }else if(queryNum == 2){
                    BFS(edges, vertices, startNode, x, 2);
                }
            }
            if (queryNum == 3) {
                System.out.println(vertices[startNode-1].getValue());
            }

        }
    }

    private static void BFS(int[][] edges, Node[] vertices, int startNodeNum, BigInteger x, int option) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startNodeNum - 1);
        if(option == 2){
            if(vertices[startNodeNum-1].getValue().compareTo(x) == 1){
                vertices[startNodeNum-1].setValue(x);
            }
        }else{
            vertices[startNodeNum-1].setValue(x);
        }
        while (!queue.isEmpty()) {
            Integer nodeNum = queue.remove();
            for (int i = 0; i < edges.length; i++) {
                if (edges[nodeNum][i] == 1) {
                    if(option == 2 ){
                        if(vertices[i].getValue().compareTo(x) == 1){
                            vertices[i].setValue(x);
                        }
                    }else{
                        vertices[i].setValue(x);
                    }
                    queue.add(i);
                }
            }
        }
    }

    private static class Node {
        BigInteger value = BigInteger.ZERO;
        List<Integer> route = new ArrayList<>();

        public void addToRoute(Integer node) {
            route.add(node);
        }

        public BigInteger getValue() {
            return value;
        }

        public void setValue(BigInteger value) {
            this.value = value;
        }

        public List<Integer> getRoute() {
            return route;
        }

        public void setRoute(List<Integer> route) {
            this.route = route;
        }
    }

    private static void printArray(List<Integer> array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
