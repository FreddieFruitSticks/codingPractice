package com.Hack;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class NextTopologicalOrdering {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numOfVertices = Integer.valueOf(st.nextToken());
        int numOfEdges = Integer.valueOf(st.nextToken());

        int[][] edges = new int[numOfVertices][numOfVertices];
        List<Integer> vertices = new ArrayList<>();
        for (int i = 0; i < numOfVertices; i++) {
            vertices.add(i);
        }
        for (int i = 0; i < numOfEdges; i++) {
            st = new StringTokenizer(br.readLine());
            edges[Integer.valueOf(st.nextToken()) - 1][Integer.valueOf(st.nextToken()) - 1] = 1;
        }

        DFS(edges, 1, vertices);
    }

    private static void DFS(int[][] edges, int startNode, List<Integer> vertices) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> visited = new ArrayList<>();
        List<Integer> available = vertices;
        stack.push(startNode);
        available.remove(new Integer(startNode));
        visited.add(startNode);

        while (!stack.isEmpty()) {
            int peekNode = stack.peek();
            for (int i = 0; i < edges.length; i++) {
                if (edges[i][peekNode] == 1 && !visited.contains(i)) {
                    stack.push(i);
                    visited.add(i);
                    available.remove(new Integer(i));
                }
            }
            int node = stack.pop();
            System.out.print((node + 1) + " ");
            for (int i = 0; i < edges.length; i++) {
                if (edges[node][i] == 1 && !visited.contains(i)) {
                    stack.push(i);
                    visited.add(i);
                    available.remove(new Integer(i));
                }
            }
            if(stack.isEmpty() && !available.isEmpty()) {
                stack.push(available.get(0));
                available.remove(0);
            }
        }
    }
}

