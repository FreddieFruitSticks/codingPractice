package com.DataStructure;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MyGraph {
    public static void main(String[] args) {
        int[] vertices;
        int[][] edges;

        try {
            BufferedReader br = new BufferedReader(new FileReader("/home/freddie/Desktop/tescase"));
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int numOfVertices = Integer.valueOf(st.nextToken());
            vertices = new int[numOfVertices];
            edges = new int[numOfVertices][numOfVertices];

            line = br.readLine();
            while (line != null) {
                st = new StringTokenizer(line);
                int row = Integer.valueOf(st.nextToken());
                int column = Integer.valueOf(st.nextToken());
                edges[row][column] = 1;
                edges[column][row] = 1;
                line = br.readLine();
            }
            printMatrix(edges);
            for (int i = 0; i < numOfVertices; i++) {
                vertices[i] = i;
            }
//            printAllPaths(4, 1, edges, new ArrayList<>());
//            DFS(4, 1, edges);
//            BFS(4, 1, edges);

        } catch (FileNotFoundException e) {
            System.out.println("cant find file" + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void BFS(int positionOfStartVertex, int positionOfEndVertex, int[][] edges) {
        MyQueue<Node> queue = new MyQueue<>();
        List<Integer> visited = new ArrayList<>();
        queue.push(new Node(positionOfStartVertex, new ArrayList<Integer>()));

        while (!queue.isEmpty()) {
            Node node = queue.pop().getValue();
            int value = node.getValue();
            visited.add(value);
            if(value == positionOfEndVertex){
                List<Integer> route = node.getRoute();
                route.add(value);
                printList(route);
            }
            for (int i = 0; i < edges[value].length; i++) {
                if (!visited.contains(i) && edges[value][i] == 1) {
                    List<Integer> route = new ArrayList<>(node.getRoute());
                    route.add(value);
                    queue.push(new Node(i, route));
                }
            }
        }

    }

    private static void printAllPaths(int positionOfStartVertex, int positionOfEndVertex, int[][] edges, List<Integer> visited) {
        int v = positionOfStartVertex;
        visited.add(v);
        if (positionOfStartVertex == positionOfEndVertex) {
            printList(visited);
            System.out.println();
        }
        for (int i = 0; i < edges[v].length; i++) {
            if (!visited.contains(i) && edges[v][i] == 1) {
                printAllPaths(i, positionOfEndVertex, edges, new ArrayList<>(visited));
            }
        }
    }

    private static void DFS(int positionOfStartVertex, int positionOfEndVertex, int[][] edges) {
        MyStack<Node> stack = new MyStack<>();
        List<Integer> visited = new ArrayList<>();

        Node node = new Node(positionOfStartVertex, new ArrayList<Integer>());
        stack.push(node);

        while (!stack.isEmpty()) {
            Node my = stack.pop().getValue();
            int v = my.getValue();
            visited.add(v);

            if (v == positionOfEndVertex) {
                List<Integer> route = my.getRoute();
                route.add(v);
                printList(route);
            }

            for (int i = 0; i < edges[v].length; i++) {
                if (!visited.contains(i) && edges[v][i] == 1) {
                    List<Integer> route = new ArrayList<>(my.getRoute());
                    route.add(v);
                    stack.push(new Node(i, route));
                }
            }
        }
    }

    private static void printList(List<Integer> list) {
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

    public static class Node {
        List<Integer> route = new ArrayList<>();
        int value;

        public Node() {
        }

        public Node(int value, List<Integer> route) {
            this.route = route;
            this.value = value;
        }

        public List<Integer> getRoute() {
            return route;
        }

        public void setRoute(List<Integer> route) {
            this.route = route;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
