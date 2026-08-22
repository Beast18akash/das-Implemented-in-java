import java.util.Scanner;
import java.util.Stack;

/*
Problem:
Find the Stock Span for each day.

The Stock Span of a day is the number of consecutive days
before that day, including the current day, for which the
stock price was less than or equal to the current day's price.

Example:
Input:
7
100 80 60 70 60 75 85

Output:
1
1
1
2
1
4
6

Approach:
Traverse the array from right to left using a stack.

The stack stores the indices of elements whose stock span
has not been determined yet.

For the current element, remove all elements from the stack
whose stock price is smaller than the current price.

For every removed index, the current index represents the
first greater element on its left. Therefore, its span is
the difference between the two indices.

After processing the entire array, the elements remaining
in the stack have no greater element on their left, so their
span is their index + 1.

Time Complexity: O(n)
Space Complexity: O(n)
*/

public class StockSpan {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of array");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter the elements in the array");

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int[] result = new int[size];

        Stack<Integer> st = new Stack<>();

        st.push(size - 1);

        for (int i = size - 2; i >= 0; i--) {

            while (!st.isEmpty() && arr[i] > arr[st.peek()]) {

                int index = st.peek();

                result[index] = index - i;

                st.pop();
            }

            st.push(i);
        }

        // Remaining elements have no greater element on their left.
        while (!st.isEmpty()) {
            int index = st.peek();

            result[index] = index + 1;

            st.pop();
        }

        System.out.println("Stock Span:");

        for (int i = 0; i < size; i++) {
            System.out.println(result[i]);
        }

        sc.close();
    }
}