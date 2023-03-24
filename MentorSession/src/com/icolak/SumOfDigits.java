package com.icolak;

public class SumOfDigits {

    public static void main(String[] args) {

        int a = 942;
        int sum = 0;
        String b = String.valueOf(a);
        System.out.println(b.length());
        for (int i = 0; i < b.length(); i++) {
            sum += Integer.parseInt(b.substring(i,(i+1)));
        }
        System.out.println(sum);
    }
}
