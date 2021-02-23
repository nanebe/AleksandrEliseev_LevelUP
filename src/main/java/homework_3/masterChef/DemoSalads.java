package homework_3.masterChef;

import homework_3.masterChef.exceptions.InvalidIngredientException;
import homework_3.masterChef.products.Fruit;
import homework_3.masterChef.products.Vegetable;
import homework_3.masterChef.salads.CrabSalad;
import homework_3.masterChef.salads.FruitSalad;
import homework_3.masterChef.salads.GreekSalad;
import homework_3.masterChef.salads.Olivier;
import homework_3.masterChef.salads.SaladBase;
import homework_3.masterChef.storage.FoodStorage;
import homework_3.masterChef.storage.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DemoSalads {

    static final FoodStorage storage = new FoodStorage();

    public static void main(String[] args) throws InvalidIngredientException {
        prepareStorage();

        GreekSalad greekSalad = new GreekSalad();
        FruitSalad fruitSalad = new FruitSalad();
        Olivier olivier = new Olivier();
        CrabSalad crabSalad = new CrabSalad();
        ArrayList<SaladBase> salads = new ArrayList<>(Arrays.asList(greekSalad, fruitSalad, olivier, crabSalad));

        System.out.println("\n\n==============  Получаем сведения о калорийности наших блюд и сортируем их  =============\n");
        printSortByCalories(salads);

        System.out.println("\n\n==============  Пробуем приготовить наши блюда  =============\n");
        salads.stream().filter(i -> checkSaladMake(i)).forEach(SaladBase::make);

        System.out.println("\n\n==============  Ищем салаты с определенным продуктом  =============\n");
        System.out.print("Vegetable.CUCUMBER ==>\n");
        salads.stream().filter(i -> i.isIncludeProduct(Vegetable.CUCUMBER)).forEach(System.out::println);
        System.out.print("Vegetable.CABBAGE ==>\n");
        fruitSalad.addIngredient(new Ingredient(Vegetable.CABBAGE, 15));
        salads.stream().filter(i -> i.isIncludeProduct(Vegetable.CABBAGE)).forEach(System.out::println);
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
        storage.add(Vegetable.RADISH, 35);
        storage.add(Vegetable.BEET, 43);
        storage.add(Vegetable.CHEESE, 55);
        storage.add(Vegetable.OLIVES, 105);
        storage.add(Vegetable.OLIVES, 25);
        storage.add(Vegetable.CUCUMBER, 155);
        storage.add(Vegetable.CABBAGE, 45);
        System.out.printf("\n%s\n\n", storage);
    }

    private static boolean checkSaladMake(SaladBase salad) {
        System.out.printf("=====  Проверяем наличие продуктов для %s  =====> ", salad);
        for (Ingredient ingredient : salad.getIngredients()) {
            if (!storage.isProductExist(ingredient.getProduct(), ingredient.getWeight())) {
                System.out.printf("Для приготовления %s на складе недостаточно продуктов\n", salad);
                return false;
            }
        }
        return true;
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
