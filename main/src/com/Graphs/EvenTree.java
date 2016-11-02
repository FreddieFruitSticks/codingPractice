package com.Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EvenTree {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/home/freddie/Desktop/EvenTree"));

        StringTokenizer st = new StringTokenizer(br.readLine());

//        for(int i = Integer.valueOf(st.nextToken()));
    }

    private class Node{
        List<Node> children = new ArrayList();
        int value;

        public List<Node> getChildren() {
            return children;
        }

        public void addChild(Node child){
            children.add(child);
        }

        public void setChildren(List<Node> children) {
            this.children = children;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
