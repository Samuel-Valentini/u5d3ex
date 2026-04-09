package samuelvalentini.u5d2ex.model;

public enum PizzaSize {
    STANDARD(1.0, 1.0),
    XL(1.4, 1.95);

    private final double priceMultiplier;
    private final double caloriesMultiplier;

    PizzaSize(double priceMultiplier, double caloriesMultiplier) {
        this.priceMultiplier = priceMultiplier;
        this.caloriesMultiplier = caloriesMultiplier;
    }

    public double getPriceMultiplier() {
        return priceMultiplier;
    }

    public double getCaloriesMultiplier() {
        return caloriesMultiplier;
    }
}
