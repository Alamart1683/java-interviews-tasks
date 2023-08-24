package Task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Task4 {
    /**
     * Отберите четные числа и просуммируйте их
     */
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        System.out.println("Вариант 1: " + variant1(list));
        System.out.println("Вариант 2: " + variant2(list));
    }

    public static int variant1(ArrayList<Integer> list) {
        return (int) list.stream().filter(i -> i % 2 == 0).collect(Collectors.summarizingInt(Integer::intValue)).getSum();
    }

    public static int variant2(ArrayList<Integer> list) {
        return list.stream().filter(i -> i % 2 == 0).mapToInt(Integer::intValue).sum();
    }
}
