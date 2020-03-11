package com.algo.sorting;

public class SelectionSort {


    public static int[] selectionSort(int a[]) {

        int temp = 0;

        for(int i = 0; i < a.length; i++) {
            int min = i;

            for(int j = i; j < a.length; j++) {
                if(a[j] < a[min]) {
                    min = j;
                }
            }
            temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        return a;
    }



    public static void main(String args[]) {
        int a[] = {20,4,5,12,3,69};

        selectionSort(a);

        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

}
