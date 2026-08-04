import java.util.Scanner;

/*
Problem:
Convert a number from a given base (2 to 10) to its decimal equivalent.

Example:
Input:
1111110010
2

Output:
1010

Approach:
Extract each digit from right to left. Multiply the digit by the
corresponding power of the base and add it to the answer.

Time Complexity: O(log_base N)
Space Complexity: O(1)

Note:
This works only for bases 2 to 10 because the input number
contains digits from 0 to 9.
*/

public class AnyBaseToDecimalConversion {

    public static int anyBaseToDecimal(int num, int base) {

        int answer = 0;
        int power = 1;

        while (num > 0) {

            int digit = num % 10;
            num /= 10;

            answer += digit * power;
            power *= base;
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int base = sc.nextInt();

        System.out.println(anyBaseToDecimal(num, base));

        sc.close();
    }
}