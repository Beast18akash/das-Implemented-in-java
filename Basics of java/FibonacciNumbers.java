/*
Question:
Print the first N Fibonacci numbers.

Example:
Input:
5

Output:
0
1
1
2
3

Approach:
Maintain the previous two Fibonacci numbers and generate the next one iteratively.

Time Complexity: O(n)
Space Complexity: O(1)
*/

//print the n fibonacci numbers

import java.util.Scanner;

public class FibonacciNumbers {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int num = src.nextInt();
        int num1 = 0;
        int num2 = 1;
        int sum = 0;
        for (int i =1;i<=num;i++){
            System.out.println(num1);
            sum = num1+num2;
            num1 =num2;
            num2 = sum;

            src.close();
        }
    }
}
