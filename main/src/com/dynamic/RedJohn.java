package com.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RedJohn {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfCases = Integer.valueOf(br.readLine());

        for (int i = 0; i < numOfCases; i++) {
            int lengthOfWall = Integer.valueOf(br.readLine());
            int[] numOfConfigurations = new int[lengthOfWall + 1];
            if (lengthOfWall >= 1) {
                numOfConfigurations[0] = 1;
            }
            if (lengthOfWall >= 2) {
                numOfConfigurations[1] = 1;
            }
            if (lengthOfWall >= 3) {
                numOfConfigurations[2] = 1;
            }
            if (lengthOfWall >= 4) {
                numOfConfigurations[3] = 1;
            }

            for (int j = 4; j < lengthOfWall + 1; j++) {
                numOfConfigurations[j] = numOfConfigurations[j - 1] + numOfConfigurations[j - 4];
            }
            int numOfPrimes = getNumberOfPrimesUnder(numOfConfigurations[lengthOfWall]);
            System.out.println(numOfPrimes);
        }
    }

    public static int getNumberOfPrimesUnder(int maxNumber) {
        int[] numbersUnderMax = new int[maxNumber + 1];
        for (int i = 0; i < maxNumber + 1; i++) {
            numbersUnderMax[i] = i;
        }

        for (int i = 2; i < Math.sqrt(maxNumber + 1); i++) {
            for (int j = 2 * i; j < maxNumber + 1; j += i) {
                if (numbersUnderMax[j] != 0) {
                    numbersUnderMax[j] = 0;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < maxNumber + 1; i++) {
            if (numbersUnderMax[i] != 0) {
                count++;
            }
        }
        return count;
    }

    public static class aMap<V extends Integer, K extends Integer> {
        private int size;
        private Entry<V, K>[] entries;

        public aMap(int size) {
            this.size = size;
            entries = new Entry[size];
        }

        public void put(V value, K key) {
            if (value != null && key != null) {
                Entry<V, K> entry = new Entry<>(value, key, null);
                setLinkedList(key, entry);
            } else {
                System.out.println("key or value was null");
            }
        }

        private void setLinkedList(K key, Entry<V, K> entry) {
            if (entries[key.hashCode() % size] != null) {
                Entry<V, K> oldEntry = entries[key.hashCode() % size];
                while (oldEntry.getNext() != null) {
                    oldEntry = oldEntry.getNext();
                }
                oldEntry.setNext(entry);
            }
        }

        public V get(K key) {
            if (key != null && entries[key.hashCode() % size] != null) {
                Entry<V, K> entry = entries[key.hashCode() % size];
                while (!entry.getKey().equals(key)) {
                    entry = entry.getNext();
                }
                return entry.getValue();
            } else {
                return null;
            }
        }

        public class Entry<V, K> {
            private V value;
            private K key;
            private Entry<V, K> next;

            public Entry(V value, K key, Entry<V, K> entry) {
                this.key = key;
                this.value = value;
                this.next = entry;
            }

            public Entry<V, K> getNext() {
                return next;
            }

            public void setNext(Entry<V, K> entry) {
                this.next = entry;
            }

            public K getKey() {
                return key;
            }

            public V getValue() {
                return value;
            }
        }
    }
}
