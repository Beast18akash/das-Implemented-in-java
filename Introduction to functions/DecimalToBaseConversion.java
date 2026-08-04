import java.util.Scanner;

/*
Problem:
Convert a decimal number into the given base (2 to 10).

Example:
Input:
1010
2

Output:
1111110010

Approach:
Keep dividing the number by the base and store the remainder.
The remainders are obtained in reverse order, so place each
digit using powers of 10.

Time Complexity: O(log_base N)
Space Complexity: O(1)

Note:
This works only for bases 2 to 10 because the answer is stored
as an integer.
*/

public class DecimalToBaseConversion {

    public static int decimalToBase(int num, int base) {

        int answer = 0;
        int position = 0;

        while (num > 0) {
            int remainder = num % base;
            num /= base;

            answer += remainder * (int) Math.pow(10, position);
            position++;
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int base = sc.nextInt();

        System.out.println(decimalToBase(num, base));

        sc.close();
    }
}