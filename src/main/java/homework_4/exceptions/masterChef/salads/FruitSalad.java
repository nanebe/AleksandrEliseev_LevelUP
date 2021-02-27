package homework_4.exceptions.masterChef.salads;

import homework_4.exceptions.masterChef.exceptions.InvalidIngredientException;
import homework_4.exceptions.masterChef.products.Fruit;
import homework_4.exceptions.masterChef.storage.Ingredient;

public class FruitSalad extends SaladBase {

    private final String NAME = "Фруктовый салат";

    public FruitSalad() throws InvalidIngredientException {
        super.ingredients.add(new Ingredient(Fruit.APPLE, 40));
        super.ingredients.add(new Ingredient(Fruit.ORANGE, 40));
    }

    @Override
    public String toString() {
        return this.NAME;
    }
}
