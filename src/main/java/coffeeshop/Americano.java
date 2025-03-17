package coffeeshop;

public class Americano extends Coffee {
    @Override
    public String getDescription() {
        return "Americano";
    }

    @Override
    public double getCost() {
        return 2.20;
    }
}
