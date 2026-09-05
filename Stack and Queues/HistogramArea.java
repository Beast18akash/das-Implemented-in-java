import java.util.Scanner;
import java.util.Stack;

/*
Problem:
Find the largest rectangular area that can be formed in a histogram.

Each element of the array represents the height of a bar.
For each bar, find how far the rectangle can extend to the
left and right without encountering a smaller bar.

Example:
Input:
6
2 1 5 6 2 3

Output:
10

Approach:
Use two monotonic stack traversals.

First traversal:
Traverse from right to left and find the first smaller element
on the left for each bar. Calculate the area that can extend
towards the left.

Second traversal:
Traverse from left to right and find the first smaller element
on the right for each bar. Calculate the area that can extend
towards the right.

The two areas are added for each bar to get the total area
that can be formed using that bar as the minimum height.

Equal-height bars are kept together in the stack so that they
can extend across each other.

Time Complexity: O(n)
Space Complexity: O(n)

Note:
If the array is empty, the maximum area is 0.
*/

public class HistogramArea {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of array");
        int size = sc.nextInt();

        if (size <= 0) {
            System.out.println("Maximum area: 0");
            sc.close();
            return;
        }

        int[] arr = new int[size];

        System.out.println("Enter the elements in the array");

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int[] rightArea = new int[size];
        int[] leftArea = new int[size];

        Stack<Integer> st = new Stack<>();

        // Find the area that can extend towards the left.
        st.push(size - 1);

        for (int i = size - 2; i >= 0; i--) {

            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {

                int index = st.peek();

                rightArea[index] = arr[index] * (index - i);

                st.pop();
            }

            st.push(i);
        }

        // Remaining elements can extend up to the beginning.
        while (!st.isEmpty()) {

            int index = st.peek();

            rightArea[index] = arr[index] * (index + 1);

            st.pop();
        }

        // Find the area that can extend towards the right.
        st.push(0);

        for (int i = 1; i < size; i++) {

            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {

                int index = st.peek();

                leftArea[index] = arr[index] * (i - index - 1);

                st.pop();
            }

            st.push(i);
        }

        // Remaining elements can extend up to the end.
        while (!st.isEmpty()) {

            int index = st.peek();

            leftArea[index] = arr[index] * (size - 1 - index);

            st.pop();
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {

            int area = rightArea[i] + leftArea[i];

            if (area > max) {
                max = area;
            }
        }

        System.out.println("Maximum area: " + max);

        sc.close();
    }
}