/*
Question:
Print the digits of a number in reverse order.

Approach:
Extract the last digit using modulus and remove it using division.

Time Complexity: O(log10 n)
Space Complexity: O(1)
*/

// print the digits in a number in  reverse order
import java.util.Scanner;
public class ReverseDigits {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int num = sc.nextInt();
        int remainder;
        while (num !=0) {
            remainder = num%10;
            System.out.println(remainder);
            num =num/10;

            sc.close();
        }
    }
}
