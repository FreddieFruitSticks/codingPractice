package com.SevenDaysOfCode;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Cookies {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        if (n / m == 0) {
            System.out.println((n - m % n)%n);
        } else {
            System.out.println(n - m);
        }
    }
}
