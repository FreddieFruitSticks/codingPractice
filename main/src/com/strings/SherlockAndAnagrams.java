package com.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

public class SherlockAndAnagrams {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfCases = Integer.valueOf(br.readLine());
//
        for (int i = 0; i < numOfCases; i++) {
            String string = br.readLine();
            int count = 0;
            for (int j = 1; j < string.length() + 1; j++) {
                for (int k = 0; k < string.length() - j; k++) {
                    String substring = string.substring(k, j + k);
                    for (int h = k + 1; h < string.length()-j+1; h++) {
                        String subString2 = string.substring(h, h + j);
                        if (areAnagrams(substring, subString2)) {
                            count++;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static boolean areAnagrams(String s1, String s2) {
        int[] numOfChars1 = new int[26];
        int[] numOfChars2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            numOfChars1[s1.charAt(i) - 'a']++;
            numOfChars2[s2.charAt(i) - 'a']++;
        }

        if (checkArraysEqual(numOfChars1, numOfChars2)) {
            return true;
        }
        return false;
    }

    private static boolean checkArraysEqual(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    private static class FreddieHashmap<T> {
        Node[] array;
        int result = 7;

        public FreddieHashmap(Class clazz, int size) {
            array = (Node[]) Array.newInstance(clazz, size);
        }

        private int hash(T element) {

            if (element instanceof Boolean) {
                int val = (Boolean) element ? 1 : 0;
                return 37 * result + val;
            } else if (element instanceof Byte || element instanceof Short || element instanceof Integer || element instanceof Character) {
                return 37 * result + Integer.valueOf((Character) element);
            } else if (element instanceof Long) {
                return result * 37 + Integer.valueOf((int) ((Long) element ^ ((Long) element >>> 32)));
            } else if (element instanceof Object) {
                return result * 37 + element.hashCode();
            }
            return result;
        }

        private void put(T element) {
            int index = hash(element) % array.length;

            Node node = array[index];
            boolean setNewNode = true;
            if (node == null) {
                array[index] = new Node(element, null, 1);
            } else {
                for (; ; ) {
                    if (node.getValue() == element) {
                        node.setCount(node.getCount() + 1);
                        setNewNode = false;
                        break;
                    }
                    if (node.getNext() != null) {
                        node = node.getNext();
                    } else {
                        break;
                    }
                }
                if (setNewNode) {
                    node.setNext(new Node(element, null, 1));
                }
            }
        }

        private boolean equals(FreddieHashmap map1) {
            Node[] nodeArray = map1.array;
            for (int i = 0; i < nodeArray.length; i++) {
                Node node = nodeArray[i];
                while (node != null) {
                    if (!nodeArray[i].equals(this.array[i])) {
                        return false;
                    }
                    node = node.getNext();
                }
            }
            return true;
        }

        public class Node {
            private T value;
            private int count = 0;
            private Node next = null;

            public Node getNext() {
                return next;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public T getValue() {
                return value;
            }

            public Node(T value, Node next, int count) {
                this.value = value;
                this.next = next;
                this.count = count;
            }

            public boolean equals(Node node) {
                if (this.getValue() == node.getValue() && this.getCount() == node.getCount()) {
                    return true;
                }
                return false;
            }

            public void setValue(T element) {
                value = element;
            }

            public void setNext(Node next) {
                this.next = next;
            }
        }
    }
}
