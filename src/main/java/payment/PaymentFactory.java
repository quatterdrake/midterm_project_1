package payment;

public class PaymentFactory {

    public PaymentMethod createPaymentMethod(String type) {
        return switch (type.toLowerCase()) {
            case "creditcard" -> new CreditCardPayment();
            case "paypal" -> new PayPalPayment(); // Тут должна быть безошибочная обработка
            case "crypto" -> new CryptoPayment();
            default -> throw new IllegalArgumentException("Invalid payment method");
        };
    }
}
