package com.Graphs;

import com.sun.javafx.geom.Edge;
import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class FindMinSpanningTree {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/home/freddie/Desktop/spanning"));
        String line;
        if ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            int numOfNodes = Integer.valueOf(st.nextToken());
            int numOfEdges = Integer.valueOf(st.nextToken());


            int[][] graph = new int[numOfNodes][numOfNodes];

            for (int i = 0; i < numOfEdges; i++) {
                if ((line = br.readLine()) != null) {
                    st = new StringTokenizer(line);
                    String first = st.nextToken();
                    String second = st.nextToken();
                    String weight = st.nextToken();
                    graph[Integer.valueOf(first) - 1][Integer.valueOf(second) - 1] = Integer.valueOf(weight);
                    graph[Integer.valueOf(second) - 1][Integer.valueOf(first) - 1] = Integer.valueOf(weight);
                } else {
                    System.out.println("buffered Reader ate null line");
                }
            }
            if ((line = br.readLine()) != null) {
                st = new StringTokenizer(line);
                int startNode = Integer.valueOf(st.nextToken()) - 1;
//                printGraph(graph);
//                System.out.println();
                System.out.println(sumGraph(primsAlgo(graph, startNode)));
            } else {
                System.out.println("null final line");
            }
        } else {
            System.out.println("null first line");
        }
    }

    private static void printGraph(int[][] graph) {
        if (graph != null && graph.length > 0 && graph[0].length > 0) {
            for (int[] ints : graph) {
                for (int anInt : ints) {
                    System.out.print(anInt + " ");
                }
                System.out.println();
            }
        }
    }

    private static int sumGraph(int[][] graph){
        int sum = 0;
        if (graph != null && graph.length > 0 && graph[0].length > 0) {
            for (int[] ints : graph) {
                for (int anInt : ints) {
                    sum+=anInt;
                }
            }
        }
        return sum;
    }

    private static int[][] primsAlgo(int[][] graph, int startNode) {
        if (graph != null && graph.length > 0 && graph[0].length > 0) {
            int[][] spanningTree = new int[graph.length][graph[0].length];
            Set<Integer> visitedNodes = new HashSet<>();
            Set<Integer> nodesToVisit = new HashSet<>();
            for (int i = 0; i < graph.length; i++) {
                nodesToVisit.add(i);
            }
            visitedNodes.add(startNode);
            nodesToVisit.remove(startNode);


            while (!nodesToVisit.isEmpty()) {
                int min = -1;
                int minStartNode = 0;
                int minEndNode = 0;
                for (Integer visitedNode : visitedNodes) {
                    for (Integer nodeToVisit : nodesToVisit) {
                        if (graph[visitedNode][nodeToVisit] < min && graph[visitedNode][nodeToVisit] != 0) {
                            min = graph[visitedNode][nodeToVisit];
                            minStartNode = visitedNode;
                            minEndNode = nodeToVisit;
                        } else if (min == -1 && graph[visitedNode][nodeToVisit] != 0) {
                            min = graph[visitedNode][nodeToVisit];
                            minStartNode = visitedNode;
                            minEndNode = nodeToVisit;
                        }
                    }
                }
                spanningTree[minStartNode][minEndNode] = min;
                visitedNodes.add(minEndNode);
                nodesToVisit.remove(minEndNode);
            }
            return spanningTree;
        }
        return null;
    }
}
