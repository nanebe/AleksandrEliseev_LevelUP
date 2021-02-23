package homework_3.masterChef.salads;

import homework_3.masterChef.exceptions.InvalidIngredientException;
import homework_3.masterChef.products.Fruit;
import homework_3.masterChef.storage.Ingredient;

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
