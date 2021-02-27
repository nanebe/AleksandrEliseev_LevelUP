package homework_4.exceptions.masterChef.products;

import homework_4.exceptions.masterChef.IProduct;

public enum Vegetable implements IProduct {
    CUCUMBER(16, 0.7),
    POTATO(77, 2),
    CARROT(41, 1.3),
    TOMATO(24, 0.9),
    CABBAGE(25, 1.3),
    BROCCOLI(25, 1.9),
    BEET(43, 1.6),
    ONION(40, 1.1),
    RADISH(20, 1.2),
    CHEESE(60, 1.4),
    OLIVES(41, 1),
    PEA(20, 0.6);

    private final double calories;
    private final double proteins;

    Vegetable(double calories, double proteins) {
        this.calories = calories;
        this.proteins = proteins;
    }

    @Override
    public double getProteins() {
        return this.proteins;
    }

    @Override
    public String getName() {
        return this.name();
    }

    @Override
    public double getCalories() {
        return this.calories;
    }
}
