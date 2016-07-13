package com.strings;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.StringTokenizer;

public class PrimePattern {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfCases = Integer.valueOf(br.readLine());

        for (int i = 0; i < numOfCases; i++) {
            int maxNum = Integer.valueOf(br.readLine());
            int[] cnsts = new int[6];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k = 0; k < 6; k++) {
                cnsts[k] = Integer.parseInt(st.nextToken());
            }

            FreddiesList<Character> list = new FreddiesList<>(Character.class, 0);
            int max = 10;
            int[] numbers = new int[max];
            for (int j = 1; j < max; j++) {
                numbers[j - 1] = j;
            }
            int numOfdeletions = 0;
            for (int n = 1; n < Math.floor(Math.sqrt(max)+1); n++) {
                int val = numbers[n];
                if (val != 0) {
                    for (int m =(int)Math.pow(val,2); m < max; m += val) {
                        if (numbers[m - 1] != 0) {
                            numbers[m - 1] = 0;
                            numOfdeletions++;
                        }
                    }
                }
            }
            System.out.println("Finished finding primes: "+ (max-numOfdeletions-2));

            FreddiesList<Integer> freddiesList = new FreddiesList<>(Integer.class, 0);
            for (int k = 1; k < numbers.length; k++) {
                if (numbers[k] != 0) {
                    freddiesList.add(numbers[k]);
                }
            }
            Integer[] primes = freddiesList.getArray();
            System.out.println("finished adding primes");

            int diffInCnsts = cnsts[5] - cnsts[0];
            FreddiesList<Double> freddiesListOfN = new FreddiesList<>(Double.class, 0);

            for (int j = 0; j < primes.length - 5; j++) {
                double n = Math.sqrt(primes[j+5] - cnsts[5]);
                if (primes[j + 5] - primes[j] == diffInCnsts) {
                    if (n < maxNum) {
                        if (checkConsecutivePrimes(cnsts, primes, diffInCnsts, j, n)) {
                            freddiesListOfN.add(n);
                        }
                    }

                }
//                n = Math.sqrt(primes[j + 5] - cnsts[5]);
            }
            if (freddiesListOfN.getArray().length > 0) {
                System.out.println((int)sumArray(freddiesListOfN.getArray()));
            } else {
                System.out.println(0);
            }
        }

    }

    private static boolean checkConsecutivePrimes(int[] cnsts, Integer[] primes, int diffInCnsts, int j, double n) {
        if (primes[j + 5] - primes[j] == diffInCnsts) {
            if (n == Math.floor(n)) {
                for (int i = 1; i < cnsts.length - 1; i++) {
                    if (Math.pow(n, 2) + cnsts[i] != primes[j + i]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private static double sumArray(Double[] array) {
        double sum = 0;
        for (double v : array) {
            sum += v;
        }
        return sum;
    }

    private static class FreddiesList<T> {
        T[] array;
        Class<T> aClass;

        public FreddiesList(Class<T> clazz, int size) {
            array = (T[]) Array.newInstance(clazz, size);
            aClass = clazz;
        }

        public void add(T element) {
            int size = array.length;
            T[] array1 = (T[]) Array.newInstance(aClass, size + 1);
            System.arraycopy(array, 0, array1, 0, size);
            array1[size] = element;
            array = array1;
        }

        public T[] getArray() {
            return array;
        }
    }
}
