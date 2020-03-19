package com.algo.arrays;

import java.util.Arrays;

// Program to find the pair of two numbers among the arrays which have a smallest difference

import static java.lang.Math.abs;

public class smallestDifference {

    static class Pair {
        int num1;
        int num2;
        int diff;

        Pair() {
            num1 = num2 = diff = 0;
        }

        public void update(int num1, int num2, int diff) {
            this.diff = num2 - num1;
            this.num1 = num1;
            this.num2 = num2;
        }

        public int getDiff() {
            return abs(diff);
        }

    }


    public static Pair smallestDifference(int a[], int b[]) {

        Arrays.sort(a);
        Arrays.sort(b);

        Pair pair = new Pair();

        for (int i = 0; i < a.length; i++) {

            if (a[i] == b[0]) {
                pair.update(a[i], b[0], b[0] - a[i]);
                return pair;
            }

            if (a[i] < b[0]) {
                if ((b[0] - a[i]) < pair.getDiff()) {
                    pair.update(a[i], b[0], b[0] - a[i]);
                }
            } else if (a[i] > b[0]) {
                int j = 0;
                while (j < b.length) {
                    if ((b[j] - a[i]) < pair.getDiff()) {
                        pair.update(a[i], b[j], b[j] - a[i]);
                    }
                    j++;
                }
            }
        }

        return pair;
    }


    public static void main(String args[]) {

        int a[] = {-1, 5, 10, 20, 28, 3};
        int b[] = {26, 134, 135, 15, 17};

        Pair pair = smallestDifference(a, b);

        System.out.println("Num 1 : " + pair.num1 + "Num 2 : " + pair.num2 + "Diff : " + pair.diff);
    }
}
