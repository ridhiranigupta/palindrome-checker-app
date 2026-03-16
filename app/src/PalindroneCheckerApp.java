import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

// Strategy interface
interface PalindromeStrategy {
    boolean check(String str);
}

// Stack-based implementation
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            stack.push(c);
        }
        for (char c : str.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }
}

// Deque-based implementation
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String str) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : str.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}

// Context class
class PalindromeContext {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String str) {
        return strategy.check(str);
    }
}

public class PalindroneCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PalindromeContext context = new PalindromeContext();

        System.out.println("=== Strategy Pattern Palindrome Checker ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("Choose strategy: 1 = Stack, 2 = Deque");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Set strategy dynamically
        switch (choice) {
            case 1 -> context.setStrategy(new StackStrategy());
            case 2 -> context.setStrategy(new DequeStrategy());
            default -> {
                System.out.println("Invalid choice. Defaulting to Stack strategy.");
                context.setStrategy(new StackStrategy());
            }
        }

        // Execute chosen strategy
        boolean result = context.executeStrategy(input);

        if (result) {
            System.out.println("Result: The string is a Palindrome.");
        } else {
            System.out.println("Result: The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}