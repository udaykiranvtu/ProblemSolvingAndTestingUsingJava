import java.io.*;
import java.util.*;

interface PerformOperation {
    boolean check(int a);
}

public class Solution {

    public static PerformOperation isOdd() {
        return (int a) -> a % 2 != 0;
    }

    public static PerformOperation isPrime() {
        return (int a) -> {
            if (a < 2) {
                return false;
            }

            for (int i = 2; i * i <= a; i++) {
                if (a % i == 0) {
                    return false;
                }
            }

            return true;
        };
    }

    public static PerformOperation isPalindrome() {
        return (int a) -> {
            int original = a;
            int reversed = 0;

            while (a != 0) {
                int digit = a % 10;
                reversed = reversed * 10 + digit;
                a /= 10;
            }

            return original == reversed;
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int condition = sc.nextInt();
            int number = sc.nextInt();

            PerformOperation op;

            if (condition == 1) {
                op = isOdd();

                if (op.check(number)) {
                    System.out.println("ODD");
                } else {
                    System.out.println("EVEN");
                }

            } else if (condition == 2) {
                op = isPrime();

                if (op.check(number)) {
                    System.out.println("PRIME");
                } else {
                    System.out.println("COMPOSITE");
                }

            } else if (condition == 3) {
                op = isPalindrome();

                if (op.check(number)) {
                    System.out.println("PALINDROME");
                } else {
                    System.out.println("NOT PALINDROME");
                }
            }
        }

        sc.close();
    }
}
