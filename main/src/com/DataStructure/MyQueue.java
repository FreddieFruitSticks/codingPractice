package com.DataStructure;

public class MyQueue {
    Node first;
    Node last;

    public void enqueue(int value) {
        Node node = new Node();
        node.setValue(value);
        if (first == null) {
            this.first = node;
            this.last = node;
        } else {
            this.first.setPrevious(node);
            node.setNext(this.first);
            this.first = node;
        }
    }

    public Node dequeue() {
        if(this.last==null){
            return last;
        }else if(this.last == this.first){
            Node node = last;
            first = null;
            last = null;
            return node;
        }else{
            Node last = this.last;
            this.last = this.last.getPrevious();
            this.last.setNext(null);
            return last;
        }
    }

    public class Node {
        private Node next;
        private Node previous;
        private int value;

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }
}
