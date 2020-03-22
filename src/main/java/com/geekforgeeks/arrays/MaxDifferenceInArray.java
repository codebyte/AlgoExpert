package com.geekforgeeks.arrays;

public class MaxDifferenceInArray {

    public static int maxDiff(int a[]) {

        int first = a[0];
        int diff = a[1] - a[0];

        for (int i = 1; i < a.length; i++) {
            if((a[i] - first) > diff) {
                diff = a[i] - first;
            }
            if(a[i] < first) {
                first = a[i];
            }
        }
        return diff;
    }

    public static void main(String args[]) {

        int a[] = {7, 10, 4, 10, 6, 5, 2};

        System.out.println(maxDiff(a));
    }
}
