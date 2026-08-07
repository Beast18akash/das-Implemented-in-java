import java.util.Scanner;

/*
Problem:
Multiply two numbers in the same base (2 to 10).

Example:
Input:
17
5
8

Output:
113

Approach:
Multiply the first number with each digit of the second number
from right to left. Generate a partial product for each digit,
shift it according to its position, and add it to the final
answer using any-base addition.

Time Complexity: O(n * m)
Space Complexity: O(1)

Note:
- Both numbers must be in the same base.
- This implementation works only for bases 2 to 10.
*/

public class AnyBaseMultiplication {

    // Adds two numbers in the given base.
    public static int anyBaseAddition(int num1, int num2, int base) {

        int carry = 0;
        int position = 0;
        int answer = 0;

        while (num1 > 0 || num2 > 0 || carry > 0) {

            int digit1 = num1 % 10;
            int digit2 = num2 % 10;

            int sum = digit1 + digit2 + carry;

            int digit = sum % base;
            carry = sum / base;

            answer += digit * (int) Math.pow(10, position);

            position++;

            num1 /= 10;
            num2 /= 10;
        }

        return answer;
    }

    // Multiplies two numbers in the given base.
    public static int anyBaseMultiplication(int num1, int num2, int base) {

        int answer = 0;
        int shift = 0;

        while (num2 > 0) {

            int carry = 0;

            int currentNumber = num1;
            int partialProduct = 0;
            int position = shift;

            int digit2 = num2 % 10;
            num2 /= 10;

            while (currentNumber > 0 || carry > 0) {

                int digit1 = currentNumber % 10;

                int product = (digit1 * digit2) + carry;

                carry = product / base;
                product %= base;

                partialProduct += product * (int) Math.pow(10, position);

                position++;
                currentNumber /= 10;
            }

            answer = anyBaseAddition(partialProduct, answer, base);

            shift++;
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = sc.nextInt();

        System.out.print("Enter the common base: ");
        int base = sc.nextInt();

        System.out.println("Result: " + anyBaseMultiplication(num1, num2, base));

        sc.close();
    }
}