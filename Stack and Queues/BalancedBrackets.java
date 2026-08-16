import java.util.Scanner;
import java.util.Stack;

/*
Problem:
Check whether an input string has balanced brackets of types (), [], and {}.

Example:
Input:
(a+[b*c]-{d/e})

Output:
true

Input:
(a+[b*c)-{d/e})

Output:
false

Approach:
Use a stack to store opening brackets.

When a closing bracket is found:
- Call the checkMatchingBracket() method with the expected matching opening bracket
  and the other two bracket types.
- The method ensures that the top of the stack matches the correct opening bracket.
  If mismatched or empty, return false.
- Otherwise, pop the matching opening bracket and continue.

At the end:
- If all brackets are matched correctly, isBalanced is true.
- If any mismatch or leftover brackets remain, isBalanced is false.

Time Complexity: O(n)
Space Complexity: O(n)

Note:
This program assumes the input string contains only bracket characters
and other symbols. It validates only bracket balance, not expression correctness.
*/

public class BalancedBrackets {

    /**
     * Checks whether the stack contains the correct matching opening bracket
     * for the given closing bracket.
     *
     * @param expectedOpen The expected matching opening bracket
     * @param invalidOpen1 The first invalid bracket type
     * @param invalidOpen2 The second invalid bracket type
     * @param bracketStack The stack of characters
     * @return true if the matching bracket is found and popped, false otherwise
     */
    public static boolean checkMatchingBracket(char expectedOpen, char invalidOpen1, char invalidOpen2, Stack<Character> bracketStack) {
        boolean isValid = true;

        // Pop until we find the expected opening bracket or stack becomes empty
        while (!bracketStack.isEmpty() && bracketStack.peek() != expectedOpen) {
            if (bracketStack.peek() == invalidOpen1 || bracketStack.peek() == invalidOpen2) {
                isValid = false;
                break;
            }
            bracketStack.pop();
        }

        // Final validation: stack must not be empty and top must match
        if (bracketStack.isEmpty()) {
            isValid = false;
        } else {
            bracketStack.pop();
            isValid = true;
        }

        return isValid;
    }

    public static void main(String[] args) {
        boolean isBalanced = true; // assume true until proven false
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the input string:");
        String input = scanner.nextLine();

        Stack<Character> bracketStack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == ')') {
                isBalanced = checkMatchingBracket('(', '[', '{', bracketStack);
            } else if (ch == ']') {
                isBalanced = checkMatchingBracket('[', '(', '{', bracketStack);
            } else if (ch == '}') {
                isBalanced = checkMatchingBracket('{', '(', '[', bracketStack);
            } else {
                bracketStack.push(ch);
            }

            // Early exit if mismatch found
            if (!isBalanced) break;
        }

        // Final check: stack should be empty if balanced
        if (!bracketStack.isEmpty()) {
            isBalanced = false;
        }

        System.out.println(isBalanced);

        scanner.close();
    }
}
