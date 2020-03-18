package com.algo.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void sort(int a[]) {

        int j = 0;
        int temp = 0;
        int current = 0;

        for(int i = 0; i < a.length; i++) {

            for( j = i ; (j > 0) && (a[j] < a[j-1]) ; j--) {
                    temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
            }
        }
    }


    public static void main(String args[]) {

        int a[] = {3,5,7,8,4,2,1,9,6};

        sort(a);
        System.out.println(Arrays.toString(a));

    }

}
