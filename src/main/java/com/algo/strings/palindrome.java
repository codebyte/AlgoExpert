package com.algo.strings;

public class palindrome {


    public static boolean isPalindrome(char a[]) {

        int i = 0;
        int j = 0;
        boolean isPalindrome = false;

        for(i=0, j = a.length -1 ; (i < a.length -1) && (j > 0) ; i++, j--) {

            if(a[i] == a[j]) {
                isPalindrome = true;
            } else {
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }


    public static void main(String args[]) {

        String s = "SUJJUS";

        if(isPalindrome(s.toCharArray())) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }


    }

}
