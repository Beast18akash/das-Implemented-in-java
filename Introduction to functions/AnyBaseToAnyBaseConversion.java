import java.util.Scanner;

/*
Problem:
Convert a number from one base to another base (2 to 10).

Example:
Input:
1111110010
2
8

Output:
1762

Approach:
1. Convert the given number to decimal.
2. Convert the decimal number to the destination base.

Time Complexity: O(log_sourceBase N + log_destinationBase N)
Space Complexity: O(1)

Note:
This works only for bases 2 to 10 because the number is stored
as an integer.
*/

public class AnyBaseToAnyBaseConversion {

    // Converts a number from any base to decimal.
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

    // Converts a decimal number to the given base.
    public static int decimalToAnyBase(int num, int base) {

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

    // Converts a number from source base to destination base.
    public static int anyBaseToAnyBase(int num, int sourceBase, int destinationBase) {

        int decimalNumber = anyBaseToDecimal(num, sourceBase);

        return decimalToAnyBase(decimalNumber, destinationBase);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int sourceBase = sc.nextInt();
        int destinationBase = sc.nextInt();

        System.out.println(anyBaseToAnyBase(num, sourceBase, destinationBase));

        sc.close();
    }
}