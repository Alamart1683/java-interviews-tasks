package task3;

public class Task3 {
    /**
     * Написать код, который выводит числа от 0 до 1000, которые делятся на 3, но не делятся на 5, и сумма цифр в которых меньше десяти.
     */
    public static void main(String[] args) {
        var begin = System.currentTimeMillis();
        myVariant(1000);
        var end = System.currentTimeMillis() - begin;
        System.out.println("Время выполнения: " + end);
    }

    public static void myVariant(int n) {
        int ascii_num_shift = 48; // Числа в кодировке ASCII начинаются с этой позиции
        for (int i = 0; i <= n; i+= 3) { // Числа не кратные трем нет смысла рассматривать и их можно пропустить
            if (i % 5 != 0) {
                String stringI = Integer.toString(i);
                if (stringI.chars().sum() - ascii_num_shift * stringI.length() < 10) { // Учтем смещение кодировки и количество цифр
                    System.out.println(i);
                }
            }
        }
    }
}

