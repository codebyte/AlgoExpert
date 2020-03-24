package com.geekforgeeks.arrays;

public class reverseArray {

    public static int[] reverse(int a[]) {
        int temp = 0;

        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        return a;
    }


    public static void main(String args[]) {
        int a[] = {10, 30, 4, 6, 9};
        reverse(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

}
