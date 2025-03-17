package coffeeshop;

public class Cappuccino extends Coffee {
    @Override
    public String getDescription() {
        return "Cappuccino";
    }

    @Override
    public double getCost() {
        return 2.50;
    }
}
