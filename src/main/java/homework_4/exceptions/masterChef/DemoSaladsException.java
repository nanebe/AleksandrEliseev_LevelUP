package homework_4.exceptions.masterChef;

import homework_4.exceptions.masterChef.exceptions.InvalidIngredientException;
import homework_4.exceptions.masterChef.products.Fruit;
import homework_4.exceptions.masterChef.products.Vegetable;
import homework_4.exceptions.masterChef.salads.CrabSalad;
import homework_4.exceptions.masterChef.salads.FruitSalad;
import homework_4.exceptions.masterChef.salads.GreekSalad;
import homework_4.exceptions.masterChef.salads.Olivier;
import homework_4.exceptions.masterChef.salads.SaladBase;
import homework_4.exceptions.masterChef.storage.FoodStorage;
import homework_4.exceptions.masterChef.storage.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DemoSaladsException {

    static final FoodStorage storage = new FoodStorage();

    public static void main(String[] args) throws InvalidIngredientException {
        try {
            prepareStorage();
        } catch (InvalidIngredientException e) {
            System.out.printf("WARNING: При добавлении продуктов на склад что то пошло ни так: %s", e.getMessage());
        }

        GreekSalad greekSalad = new GreekSalad();
        FruitSalad fruitSalad = new FruitSalad();
        Olivier olivier = new Olivier();
        CrabSalad crabSalad = new CrabSalad();
        ArrayList<SaladBase> salads = new ArrayList<>(Arrays.asList(greekSalad, fruitSalad, olivier, crabSalad));

        System.out.println("\n\n==============  Пробуем приготовить наши блюда  =============");
        for (SaladBase salad : salads) {
            try {
                checkSaladMake(salad);
            } catch (Exception e) {
                System.out.printf("WARNING: При приготовлении салата %s что то пошло ни так: %s", salad, e.getMessage());
            }
        }

        try {
            storage.take(Vegetable.CABBAGE, -5);
        } catch (IllegalArgumentException e) {
            System.out.printf("WARNING: %s", e.getMessage());
        }
    }

    private static void prepareStorage() throws InvalidIngredientException {
        System.out.print("\n=====  Наполняем склад продуктами  =====\n\n");
        storage.add(Fruit.APPLE, 100);
        storage.add(Fruit.ORANGE, 500);
        storage.take(Vegetable.CABBAGE, 5);
        storage.add(Vegetable.CABBAGE, 5);
        storage.add(Vegetable.CABBAGE, 5);
        storage.take(Vegetable.CABBAGE, 5);
        storage.take(Vegetable.CABBAGE, 15);
        storage.add(Vegetable.TOMATO, 35);
        storage.add(Vegetable.RADISH, -35);
        storage.add(Vegetable.BEET, 43);
        storage.add(Vegetable.CHEESE, 55);
        storage.add(Vegetable.OLIVES, 105);
        storage.add(Vegetable.OLIVES, 25);
        storage.add(Vegetable.CUCUMBER, 155);
        storage.add(Vegetable.CABBAGE, 45);
        System.out.printf("\n%s\n\n", storage);
    }

    private static void checkSaladMake(SaladBase salad) {
        System.out.printf("=====  Проверяем наличие продуктов для %s  =====> ", salad);
        for (Ingredient ingredient : salad.getIngredients()) {
            if (!storage.isProductExist(ingredient.getProduct(), ingredient.getWeight())) {
                throw new IllegalArgumentException(String.format("Для приготовления %s на складе недостаточно продуктов\n", salad));
            }
        }
        System.out.println("Достаточно!");
    }

    public static void printSortByCalories(ArrayList<SaladBase> salads) {
        Map<SaladBase, Double> saladsMap = new HashMap<>();
        for (SaladBase salad : salads) {
            saladsMap.put(salad, salad.getCalories());
        }
        saladsMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
    }
}
