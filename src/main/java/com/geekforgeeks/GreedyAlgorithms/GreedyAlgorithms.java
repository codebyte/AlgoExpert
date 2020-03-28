package com.geekforgeeks.GreedyAlgorithms;

import java.util.Arrays;

public class GreedyAlgorithms {

    public static int getMinimumCoins(int a[], int val) {

        Arrays.sort(a);
        int sum = val;
        int count = 0;

        for (int i = a.length - 1; i >= 0; ) {


            if ((sum - a[i]) < 0) {
                i--;
                continue;
            }

            sum = (sum - a[i]);
            count++;

            if (sum == 0) {
                break;
            }
        }

        return count;
    }

    public static void main(String args[]) {
        int a[] = {5, 10, 2, 1};
        System.out.println(getMinimumCoins(a, 99));
    }

}
