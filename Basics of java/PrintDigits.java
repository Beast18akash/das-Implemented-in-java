/*
Question:
Print each digit of a number from left to right.

Approach:
Find the highest power of 10, then extract digits one by one.

Time Complexity: O(log10 n)
Space Complexity: O(1)
*/

// print the digits in a number
import java.util.Scanner;

class PrintDigits {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int temp = n;
       int nod = 0;
       while (temp !=0) {
        temp = temp/10;
        nod++;

       }
       int result;
    int div = (int)Math.pow(10, nod-1);
       while (div != 0) {
        result = n/div;
        System.out.println(result);
        n = n%div;
       
        div = div/10;
         
        
       }
       sc.close();
    }
}