import java.util.Scanner;

/*
Problem:
Add two numbers in a given base (2 to 10) and return the result
in the same base without converting them to decimal.

Example:
Input:
777
1
8

Output:
1000

Approach:
Extract the last digit of both numbers, add them along with the carry,
store the remainder in the answer, and propagate the carry to the next
digit. Repeat until both numbers and the carry become zero.

Time Complexity: O(n)
Space Complexity: O(1)

Note:
This works only for bases 2 to 10 because the input numbers
contain digits from 0 to 9.
*/

public class AnyBaseAddition {

    public static int add(int num1, int num2, int base) {

        int carry = 0;
        int place = 0;
        int answer = 0;

        while (num1 > 0 || num2 > 0 || carry > 0) {

            int digit1 = num1 % 10;
            int digit2 = num2 % 10;

            int sum = digit1 + digit2 + carry;

            int remainder = sum % base;
            carry = sum / base;

            answer += remainder * (int) Math.pow(10, place);

            place++;

            num1 /= 10;
            num2 /= 10;
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int base = sc.nextInt();

        System.out.println(add(num1, num2, base));

        sc.close();
    }
}