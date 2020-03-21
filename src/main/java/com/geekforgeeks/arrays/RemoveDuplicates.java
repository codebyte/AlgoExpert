package com.geekforgeeks.arrays;

import java.util.Arrays;

public class RemoveDuplicates {

    public static int removeDuplicates(int a[]) {
        int j = 1;

        for (int i = 1; i < a.length; i++) {
            if(a[i] != a[i-1]) {
               a[j] = a[i];
               j++;
            }
        }
        return j;
    }


    public static void main(String args[]) {

        int a[] = {10, 12, 4, 4, 9, 6, 12, 9};


        Arrays.sort(a);
        int size = removeDuplicates(a);

        for (int i = 0; i < size; i++) {
            System.out.println(a[i]);
        }

    }
}
