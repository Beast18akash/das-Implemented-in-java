import java.util.Scanner;
import java.util.Stack;

/*
Problem:
Find the Next Smaller Element to the Right for every element
in an array.

The Next Smaller Element of an element is the first element
to its right that is smaller than it. If no smaller element
exists, the answer is -1.

Example:
Input:
5
2 5 3 7 1

Output:
1 3 1 1 -1

Approach:
Traverse the array from left to right using a stack.

The stack stores the indices of elements whose Next Smaller
Element has not been found yet.

For every current element, compare it with the element at
the index stored on top of the stack.

If the current element is smaller, it is the Next Smaller
Element for all larger elements on the stack. Store the
current element in their corresponding positions of the
result array and remove those indices from the stack.

After processing the entire array, the elements still present
in the stack do not have a smaller element to their right,
so their result is -1.

Time Complexity: O(n)
Space Complexity: O(n)
*/

public class NextSmallerElementToRight {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter the elements in the array");

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int[] result = new int[size];

        Stack<Integer> st = new Stack<>();

        st.push(0);

        for (int i = 1; i < size; i++) {

            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                result[st.peek()] = arr[i];
                st.pop();
            }

            st.push(i);
        }

        // Elements remaining in the stack have no smaller element to their right.
        while (!st.isEmpty()) {
            result[st.peek()] = -1;
            st.pop();
        }

        System.out.println("Next Smaller Elements:");

        for (int i = 0; i < size; i++) {
            System.out.println(result[i]);
        }

        sc.close();
    }
}