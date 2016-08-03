package com.dynamic;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CoinChange {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numToDivide = Integer.valueOf(st.nextToken());
        int numOfCoins = Integer.valueOf(st.nextToken());
        int[] coins = new int[numOfCoins];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < numOfCoins; i++) {
            coins[i] = Integer.valueOf(st1.nextToken());
        }
        quickSort(coins, 0, numOfCoins - 1);
        Map<Long> map = new Map<>(1000);


        System.out.println(numOfDivisions(numToDivide, coins, 0, map));
    }

    private static long numOfDivisions(int numToDivide, int[] coins, int coinIndex, Map<Long> map) {
        //max num of coins that can go in to numToDivide
        long count = 0;
        int maxNumOfCoins = (int) numToDivide / coins[coinIndex];
        if (map.get(new Map.MyKey(numToDivide, coinIndex)) != null) {
            return map.get(new Map.MyKey(numToDivide, coinIndex));
        }
        for (int i = maxNumOfCoins; i >= 0; i--) {
            int remainder = numToDivide - coins[coinIndex] * i;
            if (coinIndex == coins.length - 1) {
                if (numToDivide % coins[coinIndex] == 0) {
                    return 1;
                }
                return 0;
            }
            if (remainder == 0) {
                count++;
                continue;
            } else {
                count += numOfDivisions(remainder, coins, coinIndex + 1, map);
            }
        }
        map.put(new Map.MyKey(numToDivide, coinIndex), count);
        return count;
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
    }

    private static void quickSort(int[] array, int left, int right) {
        int pivot = partition(array, left, right);

        if (pivot > left) {
            quickSort(array, left, pivot - 1);
        }
        if (pivot < right) {
            quickSort(array, pivot + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int i = left;
        int j = right - 1;

        int pivot = right;

        while (i <= j) {
            while (array[i] > array[pivot]) {
                i++;
            }
            while (j >= i && array[j] < array[pivot]) {
                j--;
            }
            if (i <= j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }
        }
        int tmp = array[i];
        array[i] = array[pivot];
        array[pivot] = tmp;
        return i;
    }

    public static class Map<V extends Long> {

        private int size;
        private Entry<V>[] entries;

        public Map(int size) {
            this.size = size;
            entries = new Entry[size];
        }

        public void put(MyKey myKey, V value) {
            if (value != null && myKey != null) {
                Entry<V> entry = new Entry<>(myKey, value, null);
                if (entries[myKey.hashCode() % size] == null) {
                    entries[myKey.hashCode() % size] = entry;
                } else {
                    insertInLinkedList(entry, myKey);
                }
            } else {
                return;
            }
        }

        private void insertInLinkedList(Entry<V> entry, MyKey myKey) {
            Entry<V> oldEntry = entries[myKey.hashCode() % size];
            while (oldEntry.next != null) {
                oldEntry = oldEntry.next;
            }
            oldEntry.next = entry;
        }

        public V get(MyKey myKey) {
            Entry<V> entry = entries[myKey.hashCode() % size];
            if (entry != null) {
                return getValueFromLinkedList(entry, myKey);
            } else {
                return null;
            }
        }

        private V getValueFromLinkedList(Entry<V> entry, MyKey myKey) {
            while (!entry.getMyKey().equals(myKey)) {
                if (entry.next == null) {
                    return null;
                }
                entry = entry.next;
            }
            return entry.getValue();
        }

        private class Entry<V> {
            private MyKey myKey;
            private V value;
            private Entry<V> next;

            private Entry(MyKey myKey, V value, Entry<V> next) {
                this.myKey = myKey;
                this.value = value;
                this.next = next;
            }

            private V getValue() {
                return value;
            }

            private void setValue(V value) {
                this.value = value;
            }

            private MyKey getMyKey() {
                return myKey;
            }
        }

        public static class MyKey {
            private Integer key1;
            private Integer key2;

            public MyKey(Integer key1, Integer key2) {
                this.key1 = key1;
                this.key2 = key2;
            }

            public Integer getKey1() {
                return key1;
            }

            public Integer getKey2() {
                return key2;
            }

            public void setKey1(Integer key1) {
                this.key1 = key1;
            }

            public void setKey2(Integer key2) {
                this.key2 = key2;
            }

            public boolean equals(MyKey myKey) {
                return this.getKey1().equals(myKey.getKey1()) && this.getKey2().equals(myKey.getKey2());
            }


            @Override
            public int hashCode() {
                return key1.hashCode()*key2.hashCode();
            }
        }
    }
}
