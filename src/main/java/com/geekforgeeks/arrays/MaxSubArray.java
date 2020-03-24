package com.geekforgeeks.arrays;

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
        int a[] = {-5, 1, -2, 3, -1, 2, -2};

        System.out.println(maxSubArray(a));

    }

}
