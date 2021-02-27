package homework_4.exceptions.masterChef.storage;

import homework_4.exceptions.masterChef.IProduct;
import homework_4.exceptions.masterChef.exceptions.InvalidIngredientException;

public class Ingredient {
    private IProduct product;
    private double weight;

    public Ingredient(IProduct product, double weight) throws InvalidIngredientException {
        if (weight <= 0) {
            throw new InvalidIngredientException("Некорректный вес ингредиента");
        }
        this.product = product;
        this.weight = weight;
    }

    public IProduct getProduct() {
        return product;
    }

    public double getWeight() {
        return this.weight;
    }

    public void add(double n) {
        if (n < 0) {
            throw new IllegalArgumentException(String.format("Must have a number of ingredients to added > 0, but not %f", n));
        }
        this.weight += n;
    }

    public void take(double n) {
        if (n < 0) {
            throw new IllegalArgumentException(String.format("Must have a number of ingredients for take > 0, but not %f", n));
        }
        if (this.weight < n) {
            throw new ArithmeticException(String.format("Cannot take %.2f ingredients, as the current weight %.2f", n, this.weight));
        }
        this.weight -= n;
    }

    @Override
    public String toString() {
        return "\nproduct=" + product.getName() +
                " " + weight + "gr";
    }
}
