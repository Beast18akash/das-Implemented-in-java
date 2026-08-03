/*
Question:
Rotate a number by k positions.

Example:
51234, k = 2
Output:
34512

Approach:
Count digits, normalize rotation, split the number, and recombine.

Time Complexity: O(log10 n)
Space Complexity: O(1)
*/

// rotate the number 
// eg : number 51234 with rotate = 2 gives 34512
// also negative numbers are also taken care of
import java.util.Scanner;
public class RotateNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 =sc.nextInt();
        int rotate = sc.nextInt();
        int num2;
        int temp = num1;
       int count =0;
        while (temp >0){
            temp = temp/10;
            count = count+1;
        }rotate = rotate%count; 
        if (rotate < 0){
            rotate =rotate+count;
        }
         for (int i =0;i <rotate;i++){
             num2 = num1%10;
             num1 =num1/10;
             num1 +=(int)Math.pow(10, count-1) * num2;
         }
 System.out.println(num1);

        sc.close();
    }
}
