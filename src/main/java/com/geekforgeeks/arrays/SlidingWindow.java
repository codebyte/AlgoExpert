package com.geekforgeeks.arrays;

public class SlidingWindow {


    public static boolean slidingWindowFindSubArraySum(int a[], int sum) {

        int curr_sum = 0;
        boolean found = false;

        for (int i = 0, j = 0; j < a.length && i < a.length; j++) {

            curr_sum += a[j];

            if (curr_sum > sum) {
                curr_sum -= a[i];
                i++;
            }

            if (curr_sum == sum) {
                found = true;
            }
        }
        return found;
    }

    public static int slidingWindow(int a[], int k) {

        int curr_sum = 0;
        int max_sum = 0;


        for (int i = 0; i < k; i++) {
            curr_sum += a[i];
        }

        max_sum = curr_sum;

        for (int i = k; i < a.length; i++) {

            curr_sum = curr_sum - a[i - k] + a[i];

            if (max_sum < curr_sum) {
                max_sum = curr_sum;
            }

        }

        return max_sum;
    }

    public static void main(String args[]) {

        //int a[] = {1, 8, 30, -5, 20, 7, 50};

        int b[] = {1, 4, 20, 3, 10, 5};
        System.out.println(slidingWindow(b, 2));

        System.out.println(slidingWindowFindSubArraySum(b, 14));

    }

}
