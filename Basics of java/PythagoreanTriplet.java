/*
Question: Given three integers, check whether they form a Pythagorean triplet.
A Pythagorean triplet satisfies: a² + b² = c², where c is the largest number.
*/

import java.util.Scanner;

class PythagoreanTriplet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input three numbers
        int first = sc.nextInt();
        int second = sc.nextInt();
        int third = sc.nextInt();

        int largest, smaller1, smaller2;

        // Find the largest number and assign the other two as smaller ones
        if (first > second && first > third) {
            largest = first;
            smaller1 = second;
            smaller2 = third;
        } else if (second > first && second > third) {
            largest = second;
            smaller1 = first;
            smaller2 = third;
        } else {
            largest = third;
            smaller1 = first;
            smaller2 = second;
        }

        // Calculate squares using multiplication instead of Math.pow
        int sumOfSquares = smaller1 * smaller1 + smaller2 * smaller2;
        int squareOfLargest = largest * largest;

        // Check Pythagorean condition
        if (sumOfSquares == squareOfLargest) {
            System.out.println("Given numbers are a Pythagorean triplet");
        } else {
            System.out.println("Not a Pythagorean triplet");
        }

        sc.close();
    }
}
