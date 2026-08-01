/*
Question:
Find the GCD and LCM of two numbers.

Approach:
Use Euclid's Algorithm to find GCD, then compute LCM using:
LCM = (a × b) / GCD

Time Complexity: O(log(min(a, b)))
Space Complexity: O(1)
*/

import java.util.Scanner;

public class GCDAndLCM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int onum1 = num1;
        int onum2= num2;
        while (num1%num2 != 0) {
            int rem = num1%num2;
            num1 =num2;
            num2 = rem;
        }
        int gcd = num2;
        int lcm = (onum1 * onum2)/gcd;
        System.out.println(gcd);
        System.out.println(lcm);
        sc.close();
    }
}
