package homework_4.exceptions.masterChef.salads;

import homework_4.exceptions.masterChef.exceptions.InvalidIngredientException;
import homework_4.exceptions.masterChef.products.Vegetable;
import homework_4.exceptions.masterChef.storage.Ingredient;

public class GreekSalad extends SaladBase {

    private final String NAME = "Греческий салат";

    public GreekSalad() throws InvalidIngredientException {
        super.ingredients.add(new Ingredient(Vegetable.TOMATO, 40));
        super.ingredients.add(new Ingredient(Vegetable.CHEESE, 10));
        super.ingredients.add(new Ingredient(Vegetable.OLIVES, 15));
        super.ingredients.add(new Ingredient(Vegetable.CUCUMBER, 20));
        super.ingredients.add(new Ingredient(Vegetable.CABBAGE, 15));
    }

    @Override
    public String toString() {
        return this.NAME;
    }
}
