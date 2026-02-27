import java.util.Scanner;

public class PalindroneCheckerApp {
    public static void main(String[] args){
                Scanner sc = new Scanner(System.in);

                System.out.print("INPUT TEXT: ");
                String text = sc.nextLine();

                String reversed = new StringBuilder(text).reverse().toString();
                boolean isPalindrome = text.equalsIgnoreCase(reversed);

                System.out.println("is it palindron ?: " + isPalindrome);

                sc.close();
            }
        }







