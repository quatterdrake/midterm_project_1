package payment;

import java.util.Scanner;

public class CryptoPayment implements PaymentMethod {

    @Override
    public void processPayment(double amount) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your crypto wallet address: ");
        String walletAddress = scanner.nextLine();

        if (isValidCryptoAddress(walletAddress)) {
            System.out.printf("✅ Payment of $%.2f with Crypto was successful!%n", amount);
        } else {
            System.out.println("❌ Invalid crypto wallet address. Payment failed.");
        }
    }

    private boolean isValidCryptoAddress(String address) {
        // Проверка длины от 26 до 35 символов и допустимых символов (буквы и цифры)
        String regex = "^[13][a-km-zA-HJ-NP-Z1-9]{25,34}$";
        return address.matches(regex);
    }
}
