package com.algo.strings;

import java.util.Scanner;

// xyz -> zab

public class CaesarEncryption {

    public static String caesarEncrypt(String str, int key) {

        char []arr = str.toCharArray();
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < arr.length; i++) {

            char c = ' ';

            if(arr[i] >= 'a' && arr[i] <= 'z') {
                c = (char) (arr[i] + key);
                if(c > 'z') {
                    c = (char) (c - 26 );
                }
            } else if(arr[i] >= 'A' && arr[i] <= 'Z') {
                c = (char) (arr[i] + key);
                if( c > 'Z') {
                    c = (char) (c - 26 );
                }
            }

            sb.append(c);
        }
        return sb.toString();
    }


    public static void main(String args[]) {

            String nStr = caesarEncrypt("xyz", 2);
            System.out.println(nStr.toString());
    }

}
