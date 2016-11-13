package com.Hack;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class NextTopologicalOrdering {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numOfVertices = Integer.valueOf(st.nextToken());
        int numOfEdges = Integer.valueOf(st.nextToken());

        int[][] edges = new int[numOfVertices][numOfVertices];

        for (int i = 0; i < numOfEdges; i++) {
            st = new StringTokenizer(br.readLine());

            edges[Integer.valueOf(st.nextToken()) - 1][Integer.valueOf(st.nextToken()) - 1] = 1;
        }
    }

    private static void DFS(int[][] edges, int startNode) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            System.out.print(node+ " ");
            for (int i = 0; i < edges.length; i++) {
                if(edges[node][i] == 1){
                    stack.push(i);
                }
            }
        }
    }
}
