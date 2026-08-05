import java.util.Scanner;

/*
Problem:
Subtract two numbers in the same base (2 to 10).

Example:
Input:
645
376
8

Output:
247

Approach:
Subtract the digits from right to left. If a digit in the first
number is smaller than the corresponding digit in the second
number, borrow from the next digit and continue the subtraction.

Time Complexity: O(max(n, m))
Space Complexity: O(1)

Note:
- Both numbers must be in the same base.
- The first number should be greater than or equal to the second
  number.
*/

public class AnyBaseSubtraction {

    
    public static int anyBaseSubtraction(int num1, int num2, int base) {

        int digit1 = num1 % 10;
        int digit2 = num2 % 10;
        int position = 0;
        int answer = 0;

        while (num1 > 0 ) {

            int difference = digit1 - digit2;

            if (difference < 0) {
                difference += base;
            }

            answer += difference * (int) Math.pow(10, position);
            position++;

            num1 /= 10;
            num2 /= 10;

            if (digit2 > digit1) {
                digit1 = (num1 % 10) - 1;
            } else {
                digit1 = num1 % 10;
            }

            digit2 = num2 % 10;
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

    System.out.print("Enter the first number (greater than or equal to the second): ");
int num1 = sc.nextInt();

System.out.print("Enter the second number: ");
int num2 = sc.nextInt();

System.out.print("Enter the common base: ");
int base = sc.nextInt();

System.out.println("Result: " + anyBaseSubtraction(num1, num2, base));

sc.close();
    }
}