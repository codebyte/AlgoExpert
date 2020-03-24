package com.geekforgeeks.arrays;

public class max1s {

    public static int getMaxConsequitive1s(int a[]) {
        int max1s = 0;
        int cur1s = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                cur1s++;
            } else if (a[i] == 0) {
                if (max1s < cur1s) {
                    max1s = cur1s;
                    cur1s = 0;
                }
            }
        }
        return max1s;
    }


    public static void main(String args[]) {

        int a[] = {0, 1, 1, 1, 0, 1, 1};

        System.out.println(getMaxConsequitive1s(a));


    }

}
