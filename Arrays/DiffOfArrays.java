import java.util.Scanner;

/*
Problem:
Find the difference between two arrays where each array represents
a number.

Example:
Input:
3
3
5 0 0
1 2 5

Output:
375

Approach:
Start from the last element of both arrays and subtract the digits
from right to left. If the current digit of the first array is
smaller than the second array, borrow from the next position.

If one array is shorter, treat its missing digits as 0.

Time Complexity: O(max(n, m))
Space Complexity: O(1)

Note:
- Array 1 should represent the greater number.
- The arrays should contain decimal digits from 0 to 9.
*/

public class DiffOfArrays {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the greater size for array 1");
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

        int borrow = 0;
        int result = 0;
        int position = 1;

        int i = arr1.length - 1;
        int j = arr2.length - 1;

        while (i >= 0 || j >= 0) {

            int digit1 = 0;
            int digit2 = 0;

            if (i >= 0) {
                digit1 = arr1[i];
            }

            if (j >= 0) {
                digit2 = arr2[j];
            }

            int difference = digit1 - digit2 + borrow;
            borrow = 0;

            if (digit1 < digit2) {
                borrow--;
                difference += 10;
            }

            result += difference * position;
            position *= 10;

            i--;
            j--;
        }

        System.out.println("Diff of the arrays: " + result);

        sc.close();
    }
}