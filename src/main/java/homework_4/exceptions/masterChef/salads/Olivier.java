package homework_4.exceptions.masterChef.salads;

import homework_4.exceptions.masterChef.exceptions.InvalidIngredientException;
import homework_4.exceptions.masterChef.products.Vegetable;
import homework_4.exceptions.masterChef.storage.Ingredient;

public class Olivier extends SaladBase {

    private final String NAME = "Оливье";

    public Olivier() throws InvalidIngredientException {
        super.ingredients.add(new Ingredient(Vegetable.PEA, 18));
        super.ingredients.add(new Ingredient(Vegetable.BROCCOLI, 15));
        super.ingredients.add(new Ingredient(Vegetable.ONION, 7));
        super.ingredients.add(new Ingredient(Vegetable.POTATO, 35));
        super.ingredients.add(new Ingredient(Vegetable.CARROT, 25));
    }

    @Override
    public String toString() {
        return this.NAME;
    }
}
