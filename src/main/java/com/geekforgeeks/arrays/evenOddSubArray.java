package com.geekforgeeks.arrays;

public class evenOddSubArray {

    public static boolean isNumberEven(int x) {
        return (x % 2) == 0 ? true : false;
    }

    public static int evenOddSubArray(int a[]) {
        int maxSum = 1;
        int currSum = 1;
        boolean isLastEvenStatus = isNumberEven(a[0]);

        for (int i = 1; i < a.length; i++) {

            if ((isLastEvenStatus == true) && (isNumberEven(a[i]) == false)) {
                currSum++;
            } else if ((isLastEvenStatus == false) && (isNumberEven(a[i]) == true)) {
                currSum++;
            } else {
                currSum = 1;
            }

            if (maxSum < currSum) {
                maxSum = currSum;
            }

            isLastEvenStatus = isNumberEven(a[i]);
        }
        return maxSum;
    }


    public static void main(String args[]) {
        int a[] = {5, 10, 20, 6, 3, 8};
        System.out.println(evenOddSubArray(a));
    }
}
