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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numOfNodes = Integer.valueOf(st.nextToken());
        int numOfEdges = Integer.valueOf(st.nextToken());

        int[][] graph = new int[numOfNodes][numOfNodes];

        for (int i = 0; i < numOfEdges; i++) {
            st = new StringTokenizer(br.readLine());
            graph[Integer.valueOf(st.nextToken()) - 1][Integer.valueOf(st.nextToken()) - 1] = Integer.valueOf(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int startNode = Integer.valueOf(st.nextToken()) - 1;
        printGraph(primsAlgo(graph, startNode));
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
    
}
