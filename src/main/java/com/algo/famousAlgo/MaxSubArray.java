package com.algo.famousAlgo;

public class MaxSubArray {

    public static int maxSum(int x, int bubbleSum) {
        if (x > (x + bubbleSum)) {
            bubbleSum = x;
        } else {
            bubbleSum += x;
        }
        return bubbleSum;
    }

    public static int maxSubArray(int a[]) {

        int maxSum = a[0];
        int bubbleSum = a[0];

        for (int i = 1; i < a.length; i++) {

            bubbleSum = maxSum(a[i], bubbleSum);

            if (maxSum < bubbleSum) {
                maxSum = bubbleSum;
            }
        }
        return maxSum;
    }


    public static void main(String args[]) {
        //int a[] = {-5, 1, -2, 3, -1, 2, -2};
        // int a[] = {-3, 8, -2, 4, -5, 6};
        int a[] = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};

        System.out.println(maxSubArray(a));

    }

}
