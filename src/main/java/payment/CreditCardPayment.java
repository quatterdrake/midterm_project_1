package payment;

import java.util.Scanner;

public class CreditCardPayment implements PaymentMethod {

    @Override
    public void processPayment(double amount) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your credit card number: ");
        String cardNumber = scanner.nextLine();

        if (CardValidator.validateCard(cardNumber)) {
            System.out.printf("✅ Payment of $%.2f with Credit Card was successful!%n", amount);
        } else {
            System.out.println("❌ Invalid credit card number. Payment failed.");
        }
    }
}
