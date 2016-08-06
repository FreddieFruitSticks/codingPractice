package com.dynamic;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ThreeUrns {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfBeans = Integer.valueOf(br.readLine());
        int maxNumberOfBeansToMove = Integer.valueOf(br.readLine());

        MyOwnMap<Integer, Integer, BigInteger> mapOfSubstructures = new MyOwnMap<>(100000000);
        ThreeUrns threeUrns = new ThreeUrns();
        double startTime = System.currentTimeMillis();
        System.out.println(threeUrns.getNumOfMoves(numberOfBeans, 0, maxNumberOfBeansToMove, mapOfSubstructures));
        double endTime = System.currentTimeMillis();
        double totalTime = endTime - startTime;
        System.out.println(totalTime / 1000D);
    }

    public BigInteger getNumOfMoves(int numberOfBeansInFirstUrn, int numberOfBeansInSecondUrn, int maxNumOfBeansToMove, MyOwnMap map) {
        BigInteger count = BigInteger.valueOf(0);
        if (map.get(numberOfBeansInFirstUrn, numberOfBeansInSecondUrn) != null) {
            return (BigInteger) map.get(numberOfBeansInFirstUrn, numberOfBeansInSecondUrn).getValue();
        }
        if (numberOfBeansInFirstUrn == 0 && numberOfBeansInSecondUrn == 0) {
            return BigInteger.valueOf(1);
        }
        for (int i = 1; i <= min(maxNumOfBeansToMove, numberOfBeansInFirstUrn); i++) {
            count = count.add(getNumOfMoves(numberOfBeansInFirstUrn - i, numberOfBeansInSecondUrn + i, maxNumOfBeansToMove, map));
        }
        for (int i = 1; i <= min(maxNumOfBeansToMove, numberOfBeansInSecondUrn); i++) {
            count = count.add(getNumOfMoves(numberOfBeansInFirstUrn, numberOfBeansInSecondUrn - i, maxNumOfBeansToMove, map));
        }
        map.put(numberOfBeansInFirstUrn, numberOfBeansInSecondUrn, count);
        return count;
    }

    private int min(int i, int j) {
        return i < j ? i : j;
    }


    //Map with a key that has two values. Collision resolution by means of linked list. Not the most efficient (could use tree)
    //Does not dynamically resize either. Need to implement this.
    private static class MyOwnMap<K1, K2, V extends BigInteger> {
        private MyOwnEntry<K1, K2, V>[] entries;
        private int size;

        public MyOwnMap(int size) {
            this.size = size;
            entries = new MyOwnEntry[size];
        }

        public void put(K1 key1, K2 key2, V value) {
            MyOwnKey<K1, K2> key = new MyOwnKey(key1, key2);
            MyOwnEntry<K1, K2, V> entry = new MyOwnEntry<>(key1, key2, value, null, null);

            MyOwnEntry<K1, K2, V> entryInEntries = entries[key.hashCode() % size];
            if (entryInEntries == null) {
                entries[key.hashCode() % size] = entry;
            } else {
                placeEntryInLinkedList(entry, entryInEntries);
            }
        }

        public MyOwnEntry get(K1 key1, K2 key2) {
            MyOwnKey<K1, K2> key = new MyOwnKey(key1, key2);
            MyOwnEntry<K1, K2, V> entry = entries[key.hashCode() % size];

            if (entry == null) {
                return null;
            } else {
                return findEntryInLinkedList(entry, key);
            }
        }

        private MyOwnEntry findEntryInLinkedList(MyOwnEntry entry, MyOwnKey key) {
            while (entry.getLeft() != null) {
                if (entry.getKey().equals(key)) {
                    return entry;
                }
                entry = entry.getLeft();
            }
            return null;
        }

        private void placeEntryInLinkedList(MyOwnEntry entry, MyOwnEntry entryInEntries) {
            while (entryInEntries.getLeft() != null) {
                if (entryInEntries.getValue().equals(entry.getValue())) {
                    return;
                }
                entryInEntries = entryInEntries.getLeft();
            }
            entryInEntries.setLeft(entry);
        }
    }

    private static class MyOwnEntry<K1, K2, V extends BigInteger> {
        private V value;
        private MyOwnKey<K1, K2> key;
        private MyOwnEntry left;
        private MyOwnEntry right;

        public MyOwnEntry(K1 key1, K2 key2, V value, MyOwnEntry left, MyOwnEntry right) {
            this.key = new MyOwnKey<>(key1, key2);
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public MyOwnKey getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public MyOwnEntry getLeft() {
            return left;
        }

        public void setLeft(MyOwnEntry left) {
            this.left = left;
        }

        public void setRight(MyOwnEntry right) {
            this.right = right;
        }

        public MyOwnEntry getRight() {
            return right;
        }

        public boolean lessThan(MyOwnEntry node) {
            return ((BigInteger) this.getValue()).compareTo((BigInteger) node.getValue()) < 0;
        }
    }

    private static class MyOwnKey<K1, K2> {
        private K1 key1;
        private K2 key2;

        public MyOwnKey(K1 key, K2 value) {
            this.key1 = key;
            this.key2 = value;
        }

        public K1 getKey1() {
            return key1;
        }

        public K2 getKey2() {
            return key2;
        }

        //this weird bit shifting voodoo has a proof in Donald Knuth's book somewhere. It's designed to disperse the values
        //evenly across the array.
        @Override
        public int hashCode() {
            int hash = 7;
            hash = hash * 31 + key1.hashCode();
            hash = hash * 31 + key2.hashCode();
            hash ^= (hash >>> 20) ^ (hash >>> 12);
            return hash ^ (hash >>> 7) ^ (hash >>> 4);

        }

        public boolean equals(MyOwnKey key) {
            return this.key1 == key.getKey1() && this.key2 == key.getKey2();
        }
    }

    public class MyOwnBinaryTree<K1, K2, V extends BigInteger> {
        private MyOwnEntry<K1, K2, V> root;

        public MyOwnBinaryTree(K1 key1, K2 key2, V value) {
            root = new MyOwnEntry<>(key1, key2, value, null, null);
        }

        public MyOwnEntry search(MyOwnEntry node, MyOwnEntry myOwnEntry) {
            if (node == null || node.getKey().equals(myOwnEntry.getKey())) {
                return node;
            } else if (myOwnEntry.lessThan(node)) {
                return search(node.getLeft(), myOwnEntry);
            } else {
                return search(node.getLeft(), myOwnEntry);
            }

        }
    }

}
