import java.util.Scanner;
import java.util.Stack;

/*
Problem:
Find the Next Greater Element to the Right for every element
in an array.

The Next Greater Element of an element is the first element
to its right that is greater than it. If no greater element
exists, the answer is -1.

Example:
Input:
5
2 5 3 7 1

Output while processing from right to left:
-1
7
7
-1
5

Approach:
Traverse the array from right to left using a stack.

For each element, remove all elements from the stack that are
smaller than or equal to the current element. After removing
them, the top of the stack is the next greater element.

If the stack becomes empty, there is no greater element to the
right, so the answer is -1.

Finally, push the current element into the stack.

Time Complexity: O(n)
Space Complexity: O(n)

Output Note:
The array is processed from right to left, so the results are
also printed from right to left.

If the results need to be displayed from left to right, store
them in a separate result array and print that array after
the traversal.

Note:
The array should contain at least one element.
*/

public class NextGreaterElementToRight {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of arr");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter the elements in the arr");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> st = new Stack<>();

        st.push(arr[size - 1]);

        System.out.println(-1);

        for (int i = size - 2; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                System.out.println(-1);
            } else {
                System.out.println(st.peek());
            }

            st.push(arr[i]);
        }

        sc.close();
    }
}