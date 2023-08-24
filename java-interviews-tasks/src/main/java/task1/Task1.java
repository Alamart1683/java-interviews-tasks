package task1;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Task1 {
    /**
     * @param a – массив чисел, длина массива может быть больше 10млн.
     * @return массив чисел, в которых нeту дубликатов. Порядок чисел в оригинальном массиве должен быть сохранён. Из дубликатов нужно оставлять последний элемент, например, для {2,1,4,2,3} правильное решение - {1,4,2,3}, а не {2,1,4,3}

    В случае, если во входном массиве есть элемент меньше 0, то нужно выдавать ошибку.
    Например, для {2,3,-1,5} обработка должна закончиться ошибкой.
     */

    public static void main(String... args) {
        double[] a = new double[] {2, 1, 4, 2, 3};
        System.out.println(Arrays.toString(task(a)));
        a = new double[] {2,3,-1,5};
        System.out.println(Arrays.toString(task(a)));
    }

    public static double[] task(double[] a) {
        Set<Double> linkedHashSet = new LinkedHashSet<>();
        for (double v : a) { // Перебираем элементы массива
            if (v > 0) { // Если число не отрицательное то обрабатываем
                linkedHashSet.remove(v); // Если раньше такое число встречалось, то удаляем из множества
                linkedHashSet.add(v); // Добавляем элемент в множество
            } else { // Иначе выдаем ошибку
                throw new RuntimeException("Incorrect number in array: " + v + "!");
            }
        }
        // Итого сложность алгоритма будет O(N)
        return Arrays.stream(linkedHashSet.toArray(new Double[0])).mapToDouble(Double::doubleValue).toArray();
    }
}