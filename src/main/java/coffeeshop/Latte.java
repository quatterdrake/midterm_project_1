package coffeeshop;

public class Latte extends Coffee {
    @Override
    public String getDescription() {
        return "Latte";
    }

    @Override
    public double getCost() {
        return 3.00;
    }
}
