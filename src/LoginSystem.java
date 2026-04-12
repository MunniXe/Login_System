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
            input.nextLine(); // to start a new line

            if (choice == 1) {
                // to login, we will ask for email and password and check if they match the stored credentials
                System.out.print("Enter email: ");
                String email = input.nextLine();

                System.out.print("Enter password: ");
                String password = input.nextLine();

                if (users.containsKey(email) && users.get(email).equals(password)) {
                    System.out.println("Welcome, login successful!");
                    break;
                } else {
                    System.out.println("Invalid email or password.");
                }

            } else if (choice == 2) {
                // To create an account obviously you need to have an account, so we will ask for email and password
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

                // it loops back to the beginning to ask if the user has an account, so they can login with the newly created account

            } else {
                System.out.println("Invalid option.");
            }
        }

        input.close();
    }
}