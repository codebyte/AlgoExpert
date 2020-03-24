package com.geekforgeeks.arrays;

public class LeftRotateArrayDPlaces {


    // Additional Temp array,  O(n) time + O(d) space
    public static void leftRotateArrayDPlaces(int a[], int d) {

        int temp[] = new int[d];
        int n = a.length;

        for (int i = 0; i < d; i++) {
            temp[i] = a[i];
        }

        for (int i = 0; i < n - d; i++) {
            a[i] = a[i + d];
        }

        for (int i = 0; i < d; i++) {
            a[n - d + i] = temp[i];
        }

    }


    public static void main(String args[]) {

        int a[] = {5, 6, 10, 34, 4, 1};
        int d = 2;

        System.out.println("Original\n");
        for (int j = 0; j < a.length; j++) {
            System.out.print(" " + a[j]  + " |");
        }

        leftRotateArrayDPlaces(a, d);

        System.out.println("\n");

        for (int j = 0; j < a.length; j++) {
            System.out.print(" " + a[j]  + " |");
        }

    }

}
