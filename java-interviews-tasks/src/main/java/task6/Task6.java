package task6;

public class Task6 {
    /**
     У нас есть деревянная доска длиной n единиц.
     По доске ходят два муравья, каждый муравей движется со скоростью 1 единица за раунд.
     Один муравей движется влево, другой вправо. В одном раунде каждый муравей делает ход.
     Муравей, идущий влево, движется первым.

     Если муравей собирается переместиться в точку, которая уже занята другим муравьем,
     то каждый из муравьев меняет направление и только после этого движется текущий муравей.
     Предположим, что изменение направления не требует дополнительного раунда.
     Кроме того, муравьи не могут занять одно и то же положение на доске.

     Когда муравей достигает одного конца доски и движется к концу доски,
     он не выпадает из доски сразу, это происходит в следующем раунде.

     Даны целое число n — длина доски и два целых числа:
     left — позиция муравья, который движется влево,
     и right — позиция муравья, который движется вправо.
     Возвращает количество раундов, необходимое для того, чтобы первый муравей выпал из доски.

     Ограничения:
     1 <= n <= 10^4
     0 <= left <= n
     0 <= right <= n
     left != right
     */
    public static void main(String[] args) {
        System.out.println(antMovement(4, 1, 3));
        System.out.println(antMovement(4, 4, 1));
        System.out.println(antMovement(4, 4, 3));
        System.out.println(antMovement(3, 3, 1));
        System.out.println(antMovement(10, 5, 2));
        System.out.println(antMovement(4, 4, 0));
        System.out.println(antMovement(5, 5, 0));
        System.out.println(antMovement(6, 6, 0));
        System.out.println(antMovement(5, 4, 0));
        System.out.println(antMovement(1, 0, 1));
        System.out.println(antMovement(2, 1, 0));
        System.out.println(antMovement(2, 2, 0));
        System.out.println(antMovement(3, 2, 3));
    }

    public static int antMovement(int n, int left, int right) {
        if (n >= 1 && n <= 10000 &&
                left != right &&
                left >= 0 && left <= n &&
                right >= 0 && right <= n) {
            int steps = 0;
            while (right <= n && left >= 0) {
                if (left - right == 1) {
                    int tmp = right;
                    right = left;
                    left = tmp;
                }
                left--;
                if (left - right == 1) {
                    int tmp = right;
                    right = left;
                    left = tmp - 1;
                }
                right++;
                steps++;
            }
            return steps;
        }
        return -1;
    }
}
