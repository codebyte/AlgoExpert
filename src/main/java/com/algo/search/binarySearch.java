package com.algo.search;

import java.util.Arrays;

public class binarySearch {

    public static void main(String args[]) {

        int a[] = {12, 4, 19, 20, 12};
       // {4, 12, 12, 19, 20};

        Arrays.sort(a);

        if (binarySearch(a, 0, a.length -1 , 20)) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
    }


    public static boolean binarySearch(int a[], int low, int high, int value) {

        int mid = (low + high) / 2;

        if(low > high) {
            return false;
        }

        if (value == a[mid]) {
            return true;
        }

        if (value < a[mid]) {
            return(binarySearch(a, low, mid -1, value));
        } else if (value > a[mid]) {
            return(binarySearch(a, mid +1, high, value));
        }

        return false;
    }

}
