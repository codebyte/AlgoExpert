package com.geekforgeeks.arrays;

public class LeadersInArray {

    public static void leaders(int a[]) {

        int greater = a[a.length-1];

        System.out.println(greater);

        for(int i = a.length-1; i >= 0; i--) {
            if(a[i] > greater) {
                greater = a[i];
                System.out.println(greater);
            }
        }
    }



    public static void main(String args[]) {

        int a[] = {7, 10, 4, 10, 6, 5, 2};

        leaders(a);


    }

}
