package DZ_Java;
// расставить 8 ферзей на шахматной доске

public class PZ3 {
    static int version = 1;

    public static void printout(int[] arr) {
        System.out.print(version++ + "  ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printout2(int[] arr) {
        System.out.print(version++);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(" %c%d", (char) (65 + arr[i]/8), arr[i]%8+1);
        }
        System.out.println();
    }

    public static boolean battle(int[] array) {
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 8; j++) {
                int x_a = array[i] / 8;
                int y_a = array[i] % 8;
                int x_b = array[j] / 8;
                int y_b = array[j] % 8;
                if (x_a == x_b || y_a == y_b || Math.abs(x_a - x_b) == Math.abs(y_a - y_b))
                    return true;
            }
        }
        return false;
    }

    public static void ferzi(int[] array, int count) {
        if (count == 8)
            if (!battle(array)) {
                printout2(array);
                return;
            } else
                return;
        for (int i = count * 8; i < (count + 1) * 8; i++) {
            array[count] = i;
            ferzi(array, count + 1);
        }
    }

    public static void main(String[] args) {        
        int[] ferz = new int[8];
        ferzi(ferz, 0);
    }
}
