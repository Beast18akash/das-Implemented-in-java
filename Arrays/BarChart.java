import java.util.Scanner;

/*
Problem:
Print a bar chart for the given array.

Example:
Input:
5
4
3
0
1
2

Output:
.
..
.. .
.. ..

Approach:
First, find the maximum value in the array. Use this maximum
value as the starting level of the bar chart.

For each level, traverse the array and print "." if the current
element is greater than or equal to that level. Otherwise, print
a space.

After printing each level, decrease the current maximum by one
to move to the next level.

Time Complexity: O(n * max)
Space Complexity: O(1)
*/

public class BarChart {

    public static int findMax(int[] arr) {

        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {

            if (max < arr[i]) {
                max = arr[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of array");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter the elements in the array of size " + size);

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int max = findMax(arr);
        int maxLevel = max;

        for (int i = 0; i < maxLevel; i++) {

            for (int j = 0; j < arr.length; j++) {

                if (arr[j] >= max) {
                    System.out.print(".");
                } else {
                    System.out.print(" ");
                }
            }

            max--;
            System.out.println();
        }

        sc.close();
    }
}