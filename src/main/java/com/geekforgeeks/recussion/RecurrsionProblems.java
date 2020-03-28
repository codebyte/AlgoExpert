package com.geekforgeeks.recussion;

public class RecurrsionProblems {

    public static void print1ToN(int n) {
        if (n < 1) {
            return;
        }
        print1ToN(n - 1);
        System.out.println(n);
    }

    public static int printNTo1(int n) {
        if (n < 1) {
            return n;
        }
        System.out.println(n);
        return printNTo1(n - 1);
    }

    public static void printNTo1TailRecurse(int n, int k) {

        if (n == 0) {
            return;
        }
        System.out.println(k);
        printNTo1TailRecurse(n - 1, k + 1);
    }

    public static boolean palindrome(char arr[], int index, int length) {

        if (arr[index] != arr[length]) {
            return false;
        }

        if (index == length) {
            return true;
        }

        if (index > length) {
            return true;
        }

        return palindrome(arr, index + 1, length - 1);
    }

    public static int digitSum(int num, int val) {

        int rem = num % 10;

        if (rem == 0) {
            return num + val;
        }
        return digitSum(num / 10, rem + val);
    }

    public static void main(String args[]) {

        System.out.println("PrintNTo1");
        printNTo1(5);

        System.out.println("Print1ToN");
        print1ToN(5);

        System.out.println("PrintNTo1TailRecurse");
        printNTo1TailRecurse(5, 1);

        System.out.println("Palindrome");

        String arr = "aabaa";

        System.out.println(palindrome(arr.toCharArray(), 0, arr.length() - 1));

        System.out.println("Digit Sum");
        System.out.println(digitSum(253, 0));


    }
}
