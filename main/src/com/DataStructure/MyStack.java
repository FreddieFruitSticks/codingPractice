package com.DataStructure;


public class MyStack <T> {
    Node lastNode = null;
    Node firstNode = null;

    public void push(T value) {
        Node node = new Node();
        node.setValue(value);
        if (isEmpty()) {
            this.firstNode = node;
            this.lastNode = node;
        } else {
            this.lastNode.setNext(node);
            node.setPrevious(lastNode);
            this.lastNode = node;
        }
    }

    public Node pop() {
        if (this.lastNode != this.firstNode) {
            Node lastNode = this.lastNode;
            this.lastNode = lastNode.getPrevious();
            this.lastNode.setNext(null);
            return lastNode;
        }else {
            Node lastNode = this.lastNode;
            this.lastNode = null;
            firstNode = null;
            return lastNode;
        }
    }

    public boolean isEmpty() {
        return lastNode == null && firstNode == null;
    }

    public class Node {
        private Node next;
        private Node previous;
        private T value;

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
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
