package homework_3.masterChef.products;

import homework_3.masterChef.IProduct;

public enum Fruit implements IProduct {
    APPLE(59, 0.3),
    ORANGE(36, 0.9),
    LEMON(29, 1.1);

    private final double calories;
    private final double proteins;

    Fruit(double calories, double proteins) {
        this.calories = calories;
        this.proteins = proteins;
    }

    @Override
    public double getCalories() {
        return this.calories;
    }

    @Override
    public double getProteins() {
        return this.proteins;
    }

    @Override
    public String getName() {
        return this.name();
    }

}
