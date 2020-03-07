package com.algo.sorting;

public class BubbleSort {


    public static void sort(int a[]) {

        int i = 0;
        int j = 0;
        int temp = 0;

        for (i = 0; i < a.length; i++) {

            for (j = 1; j < a.length - i ; j++) {

                if (a[j - 1 ] < a[j]) {
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }


    public static void main(String args[]) {

        int a[] = {10, 5, 12, 25, 2};

        System.out.println("Bubble Sort");

        sort(a);

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }


    }
}
