package com.geekforgeeks.arrays;

public class LeftRotateArray {


    public static int leftRotateArray(int a[]) {

        int temp = a[0];
        int i = 0;

        for(i = 1; i < a.length; i++) {
            a[i-1] = a[i];
        }
        a[i-1] = temp;

        return i;
    }



    public static void main(String args[]) {

        int a[] = {5, 6, 10, 34, 4, 1};

        int size = leftRotateArray(a);

        for(int j = 0; j < size; j++) {
            System.out.println(a[j]);
        }



    }

}
