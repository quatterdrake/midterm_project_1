package app;

import coffeeshop.*;
import payment.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeFactory coffeeFactory = new CoffeeFactory();
        PaymentFactory paymentFactory = new PaymentFactory();

        System.out.println("☕ Welcome to the Coffee Shop Simulator! ☕");

        // Выбор кофе
        System.out.println("\nChoose your coffee: Espresso, Cappuccino, Latte, Americano");
        System.out.print("Your choice: ");
        String coffeeChoice = scanner.nextLine();
        Coffee coffee = coffeeFactory.createCoffee(coffeeChoice);

        // Добавление декораторов (по желанию)
        boolean addingExtras = true;
        while (addingExtras) {
            System.out.println("\nWould you like to add any extras?");
            System.out.println("1. Milk");
            System.out.println("2. Chocolate");
            System.out.println("3. Caramel");
            System.out.println("4. No more extras");

            System.out.print("Your choice: ");
            if (scanner.hasNextInt()) { // Проверяем, ввёл ли пользователь число
                int extraChoice = scanner.nextInt();
                scanner.nextLine(); // Очистка буфера после nextInt()

                switch (extraChoice) {
                    case 1 -> coffee = new MilkDecorator(coffee);
                    case 2 -> coffee = new ChocolateDecorator(coffee);
                    case 3 -> coffee = new CaramelDecorator(coffee);
                    case 4 -> addingExtras = false;
                    default -> System.out.println("Invalid choice, please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Очистка буфера после неверного ввода
            }
        }

        System.out.println("\nYour order: " + coffee.getDescription());
        System.out.printf("Total cost: $%.2f%n", coffee.getCost());

        // Выбор способа оплаты
        // Выбор способа оплаты
        scanner.nextLine(); // Очистка буфера
        System.out.println("\nChoose your payment method: CreditCard, PayPal, Crypto");
        System.out.print("Your choice: ");
        String paymentChoice = scanner.nextLine();

        PaymentMethod paymentMethod = paymentFactory.createPaymentMethod(paymentChoice);
        paymentMethod.processPayment(coffee.getCost());

        System.out.println("\n✅ Thank you for your purchase! Enjoy your coffee! ☕");


        scanner.close(); // Закрываем Scanner
    }
}
