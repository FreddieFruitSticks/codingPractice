package com.DataStructure;

public class MyQueue<T> {
    Node first = null;
    Node last = null;

    public void push(T value) {
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

    public Node pop() {
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

    public boolean isEmpty(){
        return this.first==null && this.last == null;
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
