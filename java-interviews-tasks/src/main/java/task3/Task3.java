package task3;

public class Task3 {
    /**
     * Написать код, который выводит числа от 0 до 1000, которые делятся на 3, но не делятся на 5, и сумма цифр в которых меньше десяти.
     */
    public static void main(String[] args) {
        var begin = System.currentTimeMillis();
        asciiCodesVariant(10000000);
        var end = System.currentTimeMillis() - begin;
        System.out.println("Время выполнения через использование кодировки: " + end);
        begin = System.currentTimeMillis();
        charTransVariant(10000000);
        end = System.currentTimeMillis() - begin;
        System.out.println("Время выполнения через преобразование символов в цифры числа: " + end);
        begin = System.currentTimeMillis();
        sumByDivisionVariant(10000000);
        end = System.currentTimeMillis() - begin;
        System.out.println("Время выполнения через преобразование символов в цифры числа: " + end);
    }

    public static void asciiCodesVariant(int n) {
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

    public static void charTransVariant(int n) {
        for (int i = 0; i <= n; i+=3) {
            if (i % 5 != 0) {
                String stringI = Integer.toString(i);
                int sum = 0;
                for (int j = 0; j < stringI.length(); j++) {
                    sum += Character.getNumericValue(stringI.charAt(j));
                }
                if (sum < 10) {
                    System.out.println(i);
                }
            }
        }
    }

    // Самый быстрый вариант
    public static void sumByDivisionVariant(int n) {
        for (int i = 0; i <= n; i+=3) {
            if (i % 5 != 0) {
                int sum = 0;
                int j = i;
                while (j != 0) {
                    sum += (j % 10);
                    j /= 10;
                }
                if (sum < 10) {
                    System.out.println(i);
                }
            }
        }
    }
}

