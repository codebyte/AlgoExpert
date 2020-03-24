package com.algo.timepass;

public class timepass {

    public static void main(String args[]) {

        int count = 0;
       for(int i = 100000; i <= 100999; i++) {
           if((i % 9127) == 0) {
               System.out.println("Number " + i);
               count++;
           }
       }
        System.out.println("Count " + count);

    }

}
