import java.util.Scanner;
import java.util.Stack;

/*
Problem:
Check whether an expression contains duplicate brackets.

Example:
Input:
((a+b))

Output:
true

Input:
(a+b)

Output:
false

Approach:
Use a stack to store the characters of the expression.

When a closing bracket ')' is found:
- If the top of the stack is '(', duplicate brackets are present.
- Otherwise, remove all characters until the matching '(' is found,
  then remove the '(' as well.

If no duplicate brackets are found, return false.

Time Complexity: O(n)
Space Complexity: O(n)

Note:
The expression is assumed to contain balanced brackets.
*/

public class DuplicationOfBrackets {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the input string");
        String str = sc.next();

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (ch == ')') {

                if (st.peek() == '(') {
                    System.out.println(true);
                    return;
                } else {
                    while (st.peek() != '(') {
                        st.pop();
                    }
                    st.pop();
                }

            } else {
                st.push(ch);
            }
        }

        System.out.println(false);

        sc.close();
    }
}