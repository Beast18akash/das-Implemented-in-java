import java.util.Scanner;

/*
Problem:
Find an element in an array and return its index.

Example:
Input:
5
10 20 30 40 50
30

Output:
2

Approach:
Traverse the array from left to right. If the target element
is found, store its index and stop the loop using break.
If the element is not found, return -1.

Time Complexity:
Best Case: O(1)
Worst Case: O(n)

Space Complexity: O(1)

Note:
If the target appears multiple times, this returns the index
of its first occurrence.
*/

public class FindElement {

    public static int find(int[] arr, int target) {

        int result = -1;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == target) {
                result = i;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of array");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter the elements of array of size " + size);

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the value you want to find");
        int target = sc.nextInt();

        int result = find(arr, target);

        System.out.println("The value was found at index " + result);

        sc.close();
    }
}