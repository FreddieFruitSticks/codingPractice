package com.strings;

import java.io.IOException;
import java.util.*;

public class PseudoIsomorphicSubstrings {


    public static void main(String[] args) throws IOException {
        PseudoIsomorphicSubstrings pseudoIsomorphicSubstrings = new PseudoIsomorphicSubstrings();
        System.out.println((char)91);

        //THIS IS FOR HACKERANK
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        pseudoIsomorphicSubstrings.createPseudoIsomorphicSubstrings(br.readLine());
    }

    private void createPseudoIsomorphicSubstrings(String string) {
        List<SimpleHashFunction> listOfSubsetSizes = new ArrayList<>();

        for (int i = 0; i < string.length(); i++) {
            listOfSubsetSizes.add(new SimpleHashFunction(string.length()-i + 1));

        }
        double elapsedTime = 0;
        long start = System.nanoTime();
        for (int k = 0; k < string.length(); k++) {
            int count = 0;
            for (int j = 0; j < k + 1; j++) {
                SimpleHashFunction substrings = listOfSubsetSizes.get(k - j);

                String candidate = string.substring(j, k + 1);
                String transformedCandidate = transformSubstring(candidate);
                substrings.put(transformedCandidate);
                count += substrings.getNumOfElements();
            }
            System.out.println(count);
        }
        elapsedTime = (System.nanoTime() - start) * (1.0e-9);
    }

    public String transformSubstring(String string) {
        char[] chars = string.toCharArray();
        char[] newChars = new char[string.length()];
        int charInt = 96; //a
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                newChars[i] = (char) (int) map.get(chars[i]);
            } else {
                charInt++;
                newChars[i] = (char) charInt;
                map.put(chars[i], charInt);
            }
        }
        return new String(newChars);
    }

    private static class SimpleHashFunction {
        Node[] hashtable;
        int size;
        int numOfElements = 0;

        public SimpleHashFunction(int size) {
            this.size = size;
            hashtable = new Node[size];
        }

        private long absoluteVal(long integer){
            return integer < 0 ? (~integer)+1 : integer;
        }

        private boolean put(String substring) {
            long hashValue = absoluteVal(hashMe(substring));
            int hash = (int)(hashValue % size);

            if (hashtable[hash] == null) {
                hashtable[hash] = new Node(hashValue, null);
                numOfElements++;
                return true;
            } else {
                Node node = hashtable[hash];
                while (node.getValue() != hashValue) {
                    if (node.getNext() != null) {
                        node = node.getNext();
                    } else {
                        node.setNext(new Node(hashValue, null));
                        numOfElements++;
                        return true;
                    }
                }
                return false;
            }
        }

        private long hashMe(String string) {
            int hash = 7;
            char[] chars = string.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                hash = hash * 17 + chars[j];
            }

            return hash;
        }

        private int getNumOfElements(){
            return numOfElements;
        }
    }

    private static class Node {
        long value;
        Node next;

        public Node(long value, Node next) {
            this.value = value;
            this.next = next;
        }

        private Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public long getValue() {
            return value;
        }

        public void setValue(long value) {
            this.value = value;
        }
    }

}