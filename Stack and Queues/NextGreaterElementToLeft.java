import java.util.Scanner;
import java.util.Stack;

/*
Problem:
Find the Next Greater Element to the Left for every element
in an array.

The Next Greater Element to the Left of an element is the
first element on its left that is greater than it. If no
greater element exists, the answer is -1.

Example:
Input:
5
2 5 3 7 1

Output:
-1 -1 5 -1 7

Approach:
Traverse the array from left to right using a stack.

For each element, remove all elements from the stack that
are smaller than or equal to the current element. After
removing them, the top of the stack is the nearest greater
element to the left.

If the stack becomes empty, there is no greater element to
the left, so the answer is -1.

Finally, push the current element into the stack.

Time Complexity: O(n)
Space Complexity: O(n)

Note:
Equal elements are not considered greater elements.
*/

public class NextGreaterElementToLeft {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of array");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter the elements in the array");

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> st = new Stack<>();

        st.push(arr[0]);

        System.out.println(-1);

        for (int i = 1; i < size; i++) {

            while (!st.isEmpty() && arr[i] >= st.peek()) {
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