package homework_4.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CollectionsDemo {

    private final static int LIMIT = 100_000;

    public static void main(String[] args) {
        ArrayList<Integer> numbers = createNumbersRange();
        Collections.shuffle(numbers); // перемешиваем
        checkNotExistsDuplicates(numbers); // проверяем отсутствие дубликатов

        ArrayList<Integer> numbers_2 = createNumbersRange(0, LIMIT, 2);
        ArrayList<Integer> numbers_3 = createNumbersRange(0, LIMIT, 3);
        ArrayList<Integer> numbers_5 = createNumbersRange(0, LIMIT, 5);
        ArrayList<Integer> numbers_7 = createNumbersRange(0, LIMIT, 7);
        printPartNumbers(numbers_2);
        printPartNumbers(numbers_3);
        printPartNumbers(numbers_5);
        printPartNumbers(numbers_7);

    }

    private static void printPartNumbers(ArrayList<Integer> numbers) {
        for (int i = 0; i < 25; i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();
    }

    private static ArrayList<Integer> createNumbersRange(int start, int end, int step) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = start; i <= end; i = i + step) {
            result.add(i);
        }
        return result;
    }

    private static ArrayList<Integer> createNumbersRange() {
        return createNumbersRange(0, LIMIT, 1);
    }

    private static void checkNotExistsDuplicates(ArrayList<Integer> numbers) {
        Set<Integer> checkSet = new HashSet<>(numbers);
        if (checkSet.size() != numbers.size()) System.out.println("WARNING: Имеются дубликаты!!!");
    }
}
