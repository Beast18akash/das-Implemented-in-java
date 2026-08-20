import java.util.Scanner;
import java.util.Stack;

/*
Problem:
Find the Next Greater Element to the Right for every element
in an array and print the result from left to right.

The Next Greater Element of an element is the first element
to its right that is greater than it. If no greater element
exists, the answer is -1.

Example:
Input:
5
2 5 3 7 1

Output:
5 7 7 -1 -1

Approach:
Use a stack to store the indices of elements whose Next Greater
Element has not been found yet.

Traverse the array from left to right. For every current element,
compare it with the element at the index stored on top of the stack.

If the current element is greater, it is the Next Greater Element
for all smaller elements on the stack. Store the current element
in their corresponding positions of the result array and remove
those indices from the stack.

After processing the entire array, all remaining elements in the
stack do not have a greater element to their right, so their
result is -1.

Time Complexity: O(n)
Space Complexity: O(n)
*/

public class NextGreaterElementToRightLeftToRight {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of array");
        int size = sc.nextInt();

        int[] arr1 = new int[size];
        int[] arr2 = new int[size];

        System.out.println("Enter the elements in the array of size: " + size);

        for (int i = 0; i < size; i++) {
            arr1[i] = sc.nextInt();
        }

        Stack<Integer> st = new Stack<>();

        st.push(0);

        for (int i = 1; i < size; i++) {

            if (arr1[i] > arr1[st.peek()]) {

                while (!st.isEmpty() && arr1[i] > arr1[st.peek()]) {
                    arr2[st.peek()] = arr1[i];
                    st.pop();
                }

                st.push(i);

                if (i == size - 1) {
                    while (!st.isEmpty()) {
                        arr2[st.peek()] = -1;
                        st.pop();
                    }
                }

            } else {

                st.push(i);

                if (i == size - 1) {
                    while (!st.isEmpty()) {
                        arr2[st.peek()] = -1;
                        st.pop();
                    }
                }
            }
        }

        System.out.println("Next Greater Elements:");

        for (int i = 0; i < size; i++) {
            System.out.print(arr2[i] + " ");
        }

        sc.close();
    }
}