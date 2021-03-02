package homework_4.exceptions.masterChef.salads;

import homework_4.exceptions.masterChef.IProduct;
import homework_4.exceptions.masterChef.storage.Ingredient;

import java.util.ArrayList;

public abstract class SaladBase {

    protected ArrayList<Ingredient> ingredients = new ArrayList<>();

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredient i) {
        System.out.printf("К салату %s добавляем: %.2f %s\n", this, i.getWeight(), i.getProduct());
        if (ingredients.contains(i)) {
            ingredients.get(ingredients.indexOf(i)).add(i.getWeight());
        } else {
            this.ingredients.add(i);
        }
    }

    public void make() {
        System.out.printf("%s готов!!!\n", this);
    }

    public boolean isIncludeProduct(IProduct product) {
        for (Ingredient ingredient : this.ingredients) {
            if (ingredient.getProduct() == product) {
                return true;
            }
        }
        return false;
    }

    public double getCalories() {
        double calories = 0;
        for (Ingredient ingredient : ingredients) {
            calories += ingredient.getProduct().getCalories();
        }
        return calories;
    }
}
