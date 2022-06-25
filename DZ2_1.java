package DZ_Java;
// Реализовать алгоритм сортировки слиянием

public class DZ2_1 {
    static int[] sortArray(int[] arrayA) { // сортировка Массива который передается в функцию
        // проверяем не нулевой ли он?
        if (arrayA == null) {
            return null;
        }
        // проверяем не 1 ли элемент в массиве?
        if (arrayA.length < 2) {
            return arrayA; // возврат в рекурсию в строки ниже см комменты.
        }
        // копируем левую часть от начала до середины
        int[] arrayB = new int[arrayA.length / 2];
        System.arraycopy(arrayA, 0, arrayB, 0, arrayA.length / 2);

        // копируем правую часть от середины до конца массива, вычитаем из длины первую
        // часть
        int[] arrayC = new int[arrayA.length - arrayA.length / 2];
        System.arraycopy(arrayA, arrayA.length / 2, arrayC, 0, arrayA.length - arrayA.length / 2);

        // рекурсией закидываем поделенные обе части обратно в наш метод, он будет
        // крутится до тех пор,
        // пока не дойдет до 1 элемента в массиве, после чего вернется в строку и будет
        // искать второй такой же,
        // точнее правую часть от него и опять вернет его назад
        arrayB = sortArray(arrayB); // левая часть возврат из рекурсии строкой return arrayA;
        arrayC = sortArray(arrayC); // правая часть возврат из рекурсии строкой return arrayA;

        // System.out.println(arrayB.length);
        // System.out.println(arrayC.length);

        // printer(arrayB);
        // printer(arrayC);

        // далее опять рекурсия возврата слияния двух отсортированных массивов
        return mergeArray(arrayB, arrayC);
    }

    static int[] mergeArray(int[] arrayA, int[] arrayB) {

        int[] arrayC = new int[arrayA.length + arrayB.length];
        int positionA = 0, positionB = 0;
        for (int i = 0; i < arrayC.length; i++) {                                                                                                                      
            if (positionA == arrayA.length) {
                arrayC[i] = arrayB[positionB];
                positionB++;
            } else if (positionB == arrayB.length) {
                arrayC[i] = arrayA[positionA];
                positionA++;
            } else if (arrayA[positionA] < arrayB[positionB]) {
                arrayC[i] = arrayA[positionA];
                positionA++;
            } else {
                arrayC[i] = arrayB[positionB];
                positionB++;
            }        
        }
        return arrayC;
    }

    static void printer(int[] arrayX) {
        for (int i = 0; i < arrayX.length; i++) {
            System.out.print(arrayX[i] + " ");
        }
        System.out.print('\n');
    }

    public static void main(String[] args) {        
        int[] result = sortArray(new int[] { 7, 3, 1, 4, 9, 8, 11, 12 });

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        // sortArray(array); // кладем массив который нужно отсортировать
        // mergeArray(arrayA, arrayB); // кладем 2 массива которые нужно слить в один
    }
}