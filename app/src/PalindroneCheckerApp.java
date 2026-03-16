import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class PalindroneCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

                Stack<Character> stack = new Stack<>();
                Queue<Character> queue = new LinkedList<>();

                System.out.println("=== Queue + Stack Based Palindrome Checker ===");
                System.out.print("Enter a string: ");

                String input = scanner.nextLine();

                // Insert characters into stack and queue
                for (int i = 0; i < input.length(); i++) {
                    char ch = input.charAt(i);
                    stack.push(ch);     // LIFO
                    queue.add(ch);      // FIFO
                }

                boolean isPalindrome = true;

                // Compare dequeue (queue) with pop (stack)
                while (!queue.isEmpty()) {
                    if (queue.remove() != stack.pop()) {
                        isPalindrome = false;
                        break;
                    }
                }

                // Print result
                if (isPalindrome) {
                    System.out.println("Result: The string is a Palindrome.");
                } else {
                    System.out.println("Result: The string is NOT a Palindrome.");
                }

                scanner.close();
            }
        }