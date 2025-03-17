package payment;

import java.util.Scanner;

public class PayPalPayment implements PaymentMethod {

    @Override
    public void processPayment(double amount) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your PayPal email: ");
        String email = scanner.nextLine();

        if (isValidEmail(email)) {
            System.out.printf("✅ Payment of $%.2f with PayPal was successful!%n", amount);
        } else {
            System.out.println("❌ Invalid email. Payment failed.");
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@[\\w-\\.]+\\.[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }
}
