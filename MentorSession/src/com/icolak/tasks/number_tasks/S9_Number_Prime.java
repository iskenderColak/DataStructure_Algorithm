package com.icolak.tasks.number_tasks;

public class S9_Number_Prime {

    public static void main(String[] args) {
        System.out.println(isPrime(13));
        displayPrimeNumbers(25);
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void displayPrimeNumbers(int number) {
        for (int i = 1; i < number; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }
}

/*
        Write a method that can check if a number is prime or not

        PRIME NUMBER: A prime number is a natural number greater than 1,
        which is only divisible by 1 and itself. First few prime numbers are : 2 3 5 7 11 13 17 19 23 …..
     */
