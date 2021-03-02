package homework_3.masterChef.storage;

import homework_3.masterChef.IProduct;
import homework_3.masterChef.exceptions.InvalidIngredientException;

import java.util.ArrayList;

public class FoodStorage {

    private ArrayList<Ingredient> foodStorage;

    public FoodStorage() {
        this.foodStorage = new ArrayList<>();
    }

    public boolean isProductExist(IProduct product, double count) {
        for (Ingredient item : foodStorage) {
            if (item.getProduct() == product) {
                return item.getWeight() >= count;
            }
        }
        return false;
    }

    public void take(IProduct product, double count) {
        for (Ingredient item : foodStorage) {
            if (item.getProduct() == product) {
                if (item.getWeight() >= count) {
                    System.out.printf("Со склада взято %.2f %s\n", count, product.getName());
                    item.take(count);
                } else {
                    System.out.printf("Невозможно взять со склада продукт %s в количестве %.2f, т.к. сейчас его количество = %.2f\n", product.getName(), count, item.getWeight());
                }
                return;
            }
        }
        System.out.printf("Невозможно взять со склада продукт %s в количестве %.2f, т.к. сейчас он отсутствует на складе\n", product, count);
    }

    public void add(IProduct product, double count) throws InvalidIngredientException {
        for (Ingredient item : foodStorage) {
            if (item.getProduct() == product) {
                item.add(count);
                System.out.printf("На склад было добавлено %.2f %s, стало %.2f\n", count, product.getName(), item.getWeight());
                return;
            }
        }
        foodStorage.add(new Ingredient(product, count));
        System.out.printf("На склад было добавлено %.2f %s\n", count, product.getName());
    }

    @Override
    public String toString() {
        return "FoodStorage{" + foodStorage + '}';
    }
}
