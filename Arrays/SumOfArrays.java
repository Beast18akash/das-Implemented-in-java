import java.util.Scanner;

/*
Problem:
Add two arrays where each array represents a number.

Example:
Input:
3
3
1 2 3
9 8 7

Output:
1110

Approach:
Add the elements from right to left while keeping track of the
carry. If one array is shorter, treat its missing elements as 0.

Time Complexity: O(max(n, m))
Space Complexity: O(1)

Note:
The arrays should contain decimal digits from 0 to 9.
*/

public class SumOfArrays {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size for array 1");
        int size1 = sc.nextInt();

        System.out.println("Enter the size for array 2");
        int size2 = sc.nextInt();

        int[] arr1 = new int[size1];
        int[] arr2 = new int[size2];

        for (int i = 0; i < size1; i++) {
            System.out.print("Enter element for arr1: ");
            arr1[i] = sc.nextInt();
        }

        for (int i = 0; i < size2; i++) {
            System.out.print("Enter element for arr2: ");
            arr2[i] = sc.nextInt();
        }

        int carry = 0;
        int result = 0;
        int position = 1;

        int i = arr1.length - 1;
        int j = arr2.length - 1;

        while (i >= 0 || j >= 0 || carry > 0) {

            int digit1 = 0;
            int digit2 = 0;

            if (i >= 0) {
                digit1 = arr1[i];
            }

            if (j >= 0) {
                digit2 = arr2[j];
            }

            int sum = digit1 + digit2 + carry;

            carry = sum / 10;
            sum = sum % 10;

            result += sum * position;
            position *= 10;

            i--;
            j--;
        }

        System.out.println("Sum of the arrays: " + result);

        sc.close();
    }
}