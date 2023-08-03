package task2;

import java.util.*;

public class Task2 {
    /**
     * Посчитайте для каждой валюты разницу между самым большим и самым маленьким заказом типа DELIVERY.
     * Верните результат вычисления для каждой валюты.
     * Валюты в результате должны находиться в порядке возрастания этой разницы.
     *
     * Возвращает map вида [валюта (в порядке возрастания разницы) – разница между самым большим и маленьким заказом типа DELIVERY для валюты].
     Если по какой-то валюте только один заказ, то он является и самым большим и самым маленьким и разница равна 0.
     * Пример входных данных:
     * [
     * Order(DELIVERY, "EUR", 2000),
     * Order (DELIVERY, "USD", 15),
     * Order (DELIVERY, "RUB", 200),
     * Order (PICKUP, "RUB", 1250),
     * Order (DELIVERY, "USD", 35),
     * Order (PICKUP, "USD", 55),
     * Order (DELIVERY, "RUB", 100)
     * ]
     *
     * Ожидаемый результат:
     * ["EUR" -> 0.0, "USD" -> 20.0, "RUB" -> 100.0]
     */

    public static void main(String[] args) {
        List<OrderService.OrderData> list = new ArrayList<>();
        list.add(new OrderService.OrderData(OrderService.Type.DELIVERY, "EUR", 2000L));
        list.add(new OrderService.OrderData(OrderService.Type.DELIVERY, "USD", 15L));
        list.add(new OrderService.OrderData(OrderService.Type.DELIVERY, "RUB", 200L));
        list.add(new OrderService.OrderData(OrderService.Type.PICKUP, "RUB", 1250L));
        list.add(new OrderService.OrderData(OrderService.Type.DELIVERY, "USD", 35L));
        list.add(new OrderService.OrderData(OrderService.Type.PICKUP, "USD", 55L));
        list.add(new OrderService.OrderData(OrderService.Type.DELIVERY, "RUB", 100L));
        System.out.println(getMaxMinusMinDeliveryMapByCurrency(list));
    }
    public static Map<String, Double> getMaxMinusMinDeliveryMapByCurrency(List<OrderService.OrderData> orderDataList) {
        HashMap<String, SortedSet<OrderService.OrderData>> map = new HashMap<>();
        for (OrderService.OrderData data:orderDataList) {
            if (data.getType().equals(OrderService.Type.DELIVERY)) { // Отбираем подходящие по типу объекты
                String currCurrency = data.getCurrency(); // Берем текущую валюту
                if (map.containsKey(currCurrency)) {
                    // Если уже встречалась то в TreeSet добавляем новый заказ
                    SortedSet<OrderService.OrderData> currSet = map.get(currCurrency);
                    currSet.add(data);
                    map.replace(currCurrency, currSet);
                } else {
                    // Если еще не встречалась то создаем SortedSet с сортировкой по возрастанию по полю Amount у заказа и кладем туда первый заказ
                    SortedSet<OrderService.OrderData> currSet = new TreeSet<>(Comparator.comparing(OrderService.OrderData::getAmount));
                    currSet.add(data);
                    map.put(currCurrency, currSet);
                }
            }
        }
        HashMap<String, Double> result = new HashMap<>(); // Создаем результирующую мапу
        Set<String> currencySet = map.keySet(); // Получаем список ключей-валют
        for (String currency: currencySet) { // В цикле проходим все TreeSet в мапе, считая разницу между наибольшим и наименьшим заказом
            result.put(currency, (double)(map.get(currency).last().getAmount() - map.get(currency).first().getAmount()));
        }
        // И того имеем два невложенных цикла, что гарантирует сложность O(2N) что в принципе равносильно O(N)
        return  result;
    }
}
