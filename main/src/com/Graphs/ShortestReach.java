package com.Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ShortestReach {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/home/freddie/Desktop/tescase"));
        int numOfQueries = Integer.valueOf(br.readLine());
        for (int j = 0; j < numOfQueries; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int numOfNodes = Integer.valueOf(st.nextToken());
            int numOfEdges = Integer.valueOf(st.nextToken());
            int edges[][] = new int[numOfNodes][numOfNodes];

            for (int i = 0; i < numOfEdges; i++) {
                st = new StringTokenizer(br.readLine());
                Integer integer1 = Integer.valueOf(st.nextToken());
                Integer integer2 = Integer.valueOf(st.nextToken());
                edges[integer1 - 1][integer2 - 1] = 1;
                edges[integer2 - 1][integer1 - 1] = 1;
            }
            st = new StringTokenizer(br.readLine());
            int startingNode = Integer.valueOf(st.nextToken());
            ShortestReach sr = new ShortestReach();
            Stack stack = new Stack();
            Queue queue = new Queue();
            printList(sr.search(edges, startingNode - 1, 4, queue));
            System.out.println();
        }
    }

    private int[] search(int[][] edges, int startNode, int destNode, SearchDataStructure stackOrQueue) {
        stackOrQueue.push(new Node(startNode, new ArrayList<>()));
        List<Integer> visitedNodes = new ArrayList<>();
        int[] nodeDist = new int[edges.length - 1];
        for (int i = 0; i < nodeDist.length; i++) {
            nodeDist[i] = -1;
        }

        while (!stackOrQueue.isEmpty()) {
            Node node = stackOrQueue.pop();
            if (node != null) {
                if (node.getKey() < startNode) {
                    nodeDist[node.getKey()] = node.getValue();
                } else if (node.getKey() > startNode) {
                    nodeDist[node.getKey() - 1] = node.getValue();
                }
                List<Node> route = new ArrayList<>(node.getRoute());
                route.add(node);
//                if (node.getKey() == destNode) {
//                    return route;
//                }
                int value = node.getValue();
                for (int i = 0; i < edges[node.getKey()].length; i++) {
                    if (edges[node.getKey()][i] == 1 && !visitedNodes.contains(i)) {
                        visitedNodes.add(i);
                        stackOrQueue.push(new Node(i, route, value + 6));
                    }
                }
            }
        }
        return nodeDist;
    }

    private static void printList(int[] nodes) {
        for (int i = 0; i < nodes.length; i++) {
            if (i != nodes.length - 1) {
                System.out.print(nodes[i] + " ");
            } else {
                System.out.print(nodes[i]);
            }
        }
    }

    private static class Queue implements SearchDataStructure {
        private Node firstNode;
        private Node lastNode;

        public void push(Node node) {
            if (this.isEmpty()) {
                firstNode = node;
                lastNode = node;
            } else {
                firstNode.setPrevious(node);
                node.setNext(firstNode);
                firstNode = node;
            }
        }

        public Node pop() {
            if (this.isEmpty()) {
                return null;
            } else if (firstNode == lastNode) {
                Node node = firstNode;
                firstNode = null;
                lastNode = null;
                return node;
            } else {
                Node node = lastNode;
                lastNode = lastNode.getPrevious();
                lastNode.setNext(null);
                return node;
            }
        }

        public boolean isEmpty() {
            return firstNode == null && lastNode == null;
        }
    }

    private static class Stack implements SearchDataStructure {
        private Node firstNode;
        private Node lastNode;

        public void push(Node node) {
            if (this.isEmpty()) {
                firstNode = node;
                lastNode = node;
            } else {
                lastNode.setNext(node);
                node.setPrevious(lastNode);
                lastNode = node;
            }
        }

        public Node pop() {
            if (this.isEmpty()) {
                return null;
            } else if (this.lastNode != this.firstNode) {
                Node node = lastNode;
                lastNode = lastNode.getPrevious();
                lastNode.setNext(null);
                return node;
            } else {
                Node node = lastNode;
                this.lastNode = null;
                this.firstNode = null;
                return node;
            }
        }

        public boolean isEmpty() {
            return firstNode == null && lastNode == null;
        }
    }

    private interface SearchDataStructure {
        void push(Node node);

        Node pop();

        boolean isEmpty();
    }

    private class Node {
        private int key;
        private int value;
        private Node next;
        private Node previous;
        private List<Node> route;

        public Node(int key, List<Node> route) {
            this.key = key;
            this.route = route;
        }

        public Node(int key, List<Node> route, int value) {
            this.key = key;
            this.route = route;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setRoute(List<Node> route) {
            this.route = route;
        }

        public List<Node> getRoute() {
            return route;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }
    }
}
