package com.algo.arrays;


// Given a array of integers and a key, move all the integers equals to key at the end

public class moveElementToEnd {

    public static void main(String args[]) {

        int a[] = {2, 1, 2, 2, 2, 2, 3, 4, 2};
        int key = 2;
        int temp = 0;

        for (int i = 0, j = a.length - 1; (i < a.length) && (j >= 0) && (i < j) ; ) {

            if (a[i] == a[j]) {
                j--;
                continue;
            } else if (a[i] == key) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                j--;
                i++;
            } else {
                i++;
            }
        }

        for (int k = 0; k < a.length; k++) {
            System.out.println(a[k]);
        }
    }
}

