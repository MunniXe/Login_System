import java.util.HashMap;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        HashMap<String, String> users = new HashMap<>();

        while (true) {
            System.out.println("\nDo you have an account?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Choose option: ");

            int choice = input.nextInt();
            input.nextLine(); // clear buffer

            if (choice == 2) {
                // REGISTER
                System.out.print("Enter email: ");
                String email = input.nextLine();

                String password;
                while (true) {
                    System.out.print("Enter password (min 8 characters): ");
                    password = input.nextLine();

                    if (password.length() >= 8) {
                        break;
                    } else {
                        System.out.println("Password must be at least 8 characters.");
                    }
                }

                users.put(email, password);
                System.out.println("Account created successfully!");

                // loop continues back automatically

            } else if (choice == 1) {
                // LOGIN
                System.out.print("Enter email: ");
                String email = input.nextLine();

                System.out.print("Enter password: ");
                String password = input.nextLine();

                if (users.containsKey(email) && users.get(email).equals(password)) {
                    System.out.println("Welcome, login successful!");
                    break; // exit after successful login
                } else {
                    System.out.println("Invalid email or password.");
                }

            } else {
                System.out.println("Invalid option.");
            }
        }

        input.close();
    }
}