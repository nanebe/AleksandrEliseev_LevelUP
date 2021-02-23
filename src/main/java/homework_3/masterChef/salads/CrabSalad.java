package homework_3.masterChef.salads;

import homework_3.masterChef.exceptions.InvalidIngredientException;
import homework_3.masterChef.products.Vegetable;
import homework_3.masterChef.storage.Ingredient;

public class CrabSalad extends SaladBase {

    private final String NAME = "Крабовый салат";

    public CrabSalad() throws InvalidIngredientException {
        super.ingredients.add(new Ingredient(Vegetable.TOMATO, 30));
        super.ingredients.add(new Ingredient(Vegetable.RADISH, 20));
        super.ingredients.add(new Ingredient(Vegetable.CUCUMBER, 35));
        super.ingredients.add(new Ingredient(Vegetable.BEET, 15));
    }

    @Override
    public String toString() {
        return this.NAME;
    }
}
