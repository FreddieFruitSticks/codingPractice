package com.strings;

/**
 * Created by freddie on 2016/06/15.
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

//        String string = "aaaabbababbajkghhaqwudeuqawhqwqaaaalsjndjklansa";
//        String string = "aaaandjklans";
//        String string = "aaaabbababbajkghasvcxekljqeuihasidnlajhaqwudeuqawhqwqaaaalsjndjklanns";
        String string = "bbbbbcabccbabbbaaabcbaacbccaabbaacbccaababacccaabccaccbcaacbbbccccbcaaaaccacaccaabacaaaacabc" +
                "babaaabcbccaabbcababbbcacaaaaaaabcabcacacbbbcbbbbbcacbabacbccababaacaccbcbccacccacaabbacabacbccbcccbcba" +
                "bcccbcccacacaaacababcbacccbbccaccaacccabcabcbbbbccbcbcbbbbaabbbcacbccaacbbaacbaacabbababaabaccbccbbabc" +
                "baaabcbbcabcaccaacbccaccabaaacbacbbbcaaccacaabbabbcbacbbcbabaacabbccbcbababbbacaccabcabbccbbbbcccbaaaac" +
                "cccaabcbcccbaaaabbbbbbcaabaaaabcacabcabacabacaaaacaabacbacabbbcaacabbbccaaacaababbcccacbbabcbbccccacbaa" +
                "bcabbcabbbbbcccbbcbabccacbaabaabacaacccabaccccaabaacabaacccbbbcabcbcaaabcacbbccbbcacbcaaabaccccbbaabaac" +
                "bbaaabacabaaacaacbbbcbbaaacbbcbcabbaaaacaabbbbbabbaccaaaccbaccababbccbccacbbbbcbccabbbcbcaacbcaacaccca" +
                "ccbbaaabbbcbbccaaaaabacbccbccaaacbcacaaccacbabbbbcacbcbbcababbcbacaaaabbacbcbaacacabacaacaabbbaaacbaccbba" +
                "cacabbabacbbaacccccbbabbbabacacbabbabbcbccbabbccabbabaccaaaaccbabcaccbabbaacabcbbabcabcbcbbcabaccabcbaccb" +
                "bccbacaccccacbcbcbbccbcbabcbacbcabbcbbcbababbbaccaaccbaccbbccbaaaaabaacbbbbacbccab";
        solution2.printArray(solution2.constructSuffixArray(string));
//
        String[] suffixArray = solution2.constructSuffixArray(string);
        System.out.println("unsorted");
        solution2.printArray(suffixArray);
        System.out.println("---------------------");
        System.out.println("sorted");
        solution2.quickSortSuffixArray(suffixArray, 0, suffixArray.length - 1);
        solution2.printArray(suffixArray);

        boolean exists = solution2.binarySearchSuffixArray(suffixArray, 0, suffixArray.length - 1, "bbbbbabbaccaaaccbaccabab");
        System.out.println(exists);
//        System.out.println(solution2.lexographicComparatorFirstLessThanSecond("ndk","ndjklan"));
    }

    public void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private String[] constructSuffixArray(String string) {
        String[] suffixArray = new String[string.length()];
        for (int i = 0; i < string.length(); i++) {
            String suffix = string.substring(i, string.length());
            suffixArray[i] = suffix;
        }
        return suffixArray;
    }

    private int partitionSuffixArray(String[] suffixArray, int left, int right) {
        String pivot = suffixArray[right];
        int i = left;
        int j = right-1;

        while (i <= j) {
            while (lexographicComparatorFirstLessThanSecond(suffixArray[i], pivot)) {
                i++;
            }
            while (j>=0 && lexographicComparatorFirstLessThanSecond(pivot, suffixArray[j])) {
                j--;
            }
            if (i <= j) {
                String temp = suffixArray[j];
                suffixArray[j] = suffixArray[i];
                suffixArray[i] = temp;
                i++;
                j--;
            }
        }
        String temp = suffixArray[right];
        suffixArray[right] = suffixArray[i];
        suffixArray[i] = temp;
        return i;
    }

    public void quickSortSuffixArray(String[] array, int left, int right) {
        int index = partitionSuffixArray(array, left, right);

        if (index < right) {
            quickSortSuffixArray(array, index+1, right);
        }
        if (index > left) {
            quickSortSuffixArray(array, left, index-1);
        }
    }

    private boolean lexographicComparatorFirstLessThanSecond(String string1, String string2) {
        int lim = Math.min(string1.length(), string2.length());

        for (int i = 0; i < lim; i++) {
            char c1 = string1.charAt(i);
            char c2 = string2.charAt(i);
            if (c1 < c2) {
                return true;
            } else if (c2 < c1) {
                return false;
            } else {
                continue;
            }
        }
        if(string1.length() >= string2.length()){
            return false;
        }else{
            return true;
        }
//
//        return false;
    }

    private int stringComparator(String stringToSearchFor, String suffix) {
        char[] char1 = stringToSearchFor.toCharArray();
        char[] char2 = suffix.toCharArray();
        int char1Length = char1.length;
        int char2Length = char2.length;

        if (char1Length > char2Length) {
            boolean smaller = lexographicComparatorFirstLessThanSecond(stringToSearchFor, suffix);

            if(smaller){
                return 2;
            }else{
                return 1;
            }
        }

        int limit = char1Length >= char2Length ? char2Length : char1Length;
        for (int i = 0; i < limit; i++) {
            if (char1[i] == char2[i]) {
                continue;
            } else if (char1[i] > char2[i]) {
                return 1;
            } else {
                return 2;
            }
        }
        return 0;
    }

    private boolean binarySearchSuffixArray(String[] sortedSuffixArray, int left, int right, String stringToSearchFor) {
        int centerIndex = (left + right) / 2;
        String suffix = sortedSuffixArray[centerIndex];
        int larger = stringComparator(stringToSearchFor, suffix);
        if (larger == 0) {
            return true;
        } else if (larger == 1 && left <= right) {
            return binarySearchSuffixArray(sortedSuffixArray, centerIndex + 1, right, stringToSearchFor);
        } else if (larger == 2 && left <= right) {
            return binarySearchSuffixArray(sortedSuffixArray, left, centerIndex - 1, stringToSearchFor);
        } else {
            return false;
        }

    }

    private int[] constructLCPArray(String[] suffixArray) {
        return null;
    }
}
