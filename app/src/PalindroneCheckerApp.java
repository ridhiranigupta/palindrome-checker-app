import java.util.Scanner;
import java.util.Stack;

// Palindrome service class
class PalindromeChecker {

    public boolean checkPalindrome(String str) {

        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        // Compare with popped characters
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

public class PalindroneCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Object-Oriented Palindrome Checker ===");
        System.out.print("Enter a string: ");

        String input = scanner.nextLine();

        PalindromeChecker checker = new PalindromeChecker();

        if (checker.checkPalindrome(input)) {
            System.out.println("Result: The string is a Palindrome.");
        } else {
            System.out.println("Result: The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}