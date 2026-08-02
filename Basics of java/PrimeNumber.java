/*
Question:
Check whether a given number is Prime or Not.

Example:
Input:
13

Output:
number is prime

Approach:
Check divisibility from 2 to n-1. If any number divides n exactly,
the number is not prime; otherwise it is prime.

Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int num = scr.nextInt();
        for (int i = 2; i <= num; i++) {
            if (num == i) {
                continue;
            } else if (num % i == 0) {
                System.out.println("number is not prime");
                break;
            } else {
                System.out.println("number is prime");
                break;
            }
        }

        scr.close();
    }

}