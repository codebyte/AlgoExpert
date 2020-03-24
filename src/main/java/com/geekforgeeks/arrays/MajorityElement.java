package com.geekforgeeks.arrays;

// Find the majority Element from the array,
// MajorityElement is a element whose count > n/2
// The below program uses Moore Voting Algorithm

public class MajorityElement {

    public static int majorityElement(int a[]) {

        int me = a[0];
        int count = 1;

        for (int i = 1; i < a.length; i++) {

            if (a[i] == me) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    me = a[i];
                    count = 1;
                }
            }
        }

        return confirmMajority(a, me);
    }

    public static int confirmMajority(int a[], int me) {
        int count = 0;
        boolean found = false;

        for (int i = 0; i < a.length; i++) {
            if (me == a[i]) {
                count++;
            }
            if (count > (a.length / 2)) {
                found = true;
            }
        }
        if (found) {
            return me;
        } else {
            return -1;
        }
    }


    public static void main(String args[]) {
        int a[] = {8, 8, 6, 6, 6, 4, 6, 8, 8, 8, 8, 8};

        int me = majorityElement(a);

        System.out.println(me);
    }

}
