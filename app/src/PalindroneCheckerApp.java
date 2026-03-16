import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

// Strategy interface
interface PalindromeStrategy {
    boolean check(String str);
}

    // Stack-based palindrome
    public static boolean stackPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) stack.push(c);
        for (char c : str.toCharArray()) if (c != stack.pop()) return false;
        return true;
    }

    // Deque-based palindrome
    public static boolean dequePalindrome(String str) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : str.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) if (deque.removeFirst() != deque.removeLast()) return false;
        return true;
    }

    // Recursive palindrome
    public static boolean recursivePalindrome(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return recursivePalindrome(str, start + 1, end - 1);
    }
}

public class PalindroneCheckerApp {

    public boolean executeStrategy(String str) {
        return strategy.check(str);
    }
}

public class PalindroneCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PalindromeContext context = new PalindromeContext();

        System.out.println("=== Palindrome Performance Comparison ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Stack
        long startStack = System.nanoTime();
        boolean stackResult = stackPalindrome(input);
        long endStack = System.nanoTime();

        // Deque
        long startDeque = System.nanoTime();
        boolean dequeResult = dequePalindrome(input);
        long endDeque = System.nanoTime();

        // Recursive
        long startRec = System.nanoTime();
        boolean recResult = recursivePalindrome(input, 0, input.length() - 1);
        long endRec = System.nanoTime();

        System.out.println("\nResults:");
        System.out.println("Stack-based: " + stackResult + " | Time: " + (endStack - startStack) + " ns");
        System.out.println("Deque-based: " + dequeResult + " | Time: " + (endDeque - startDeque) + " ns");
        System.out.println("Recursive:   " + recResult + " | Time: " + (endRec - startRec) + " ns");

        scanner.close();
    }
}