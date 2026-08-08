import java.util.Scanner;

/*
Problem:
Find the span of an array.

The span of an array is the difference between its maximum
and minimum elements.

Example:
Input:
5
10 20 5 30 15

Output:
25

Approach:
Traverse the array once and keep track of the maximum and
minimum elements. The span is the difference between them.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class ArraySpan {

    public static int spanOfArray(int[] arr) {

        int max = arr[0];
        int min = arr[0];

        for (int i = 0; i < arr.length; i++) {

            if (max < arr[i]) {
                max = arr[i];
            }

            if (min > arr[i]) {
                min = arr[i];
            }
        }

        return max - min;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter the array elements of size " + size);

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int result = spanOfArray(arr);

        System.out.println("The span of the array is " + result);

        sc.close();
    }
}