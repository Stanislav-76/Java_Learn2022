package DZ_Java;
// Шахматную доску размером NxN обойти конём так, чтобы фигура в каждой клетке была строго один раз.

public class DZ3 {

    static int N = 5;
    static int version = 1;

    public static void printout(int[] arr) {
        System.out.print(version++ + "   ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void horse(int[] array, int count, int pos) {
        int[] dx = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int[] dy = { -1, -2, -2, 1, -1, 2, 2, 1 };
        int x = pos / N;
        int y = pos % N;
        for (int i = 0; i < 8; i++) {            
            if (0 <= x + dx[i] && x + dx[i] < N &&
                    0 <= y + dy[i] && y + dy[i] < N &&
                    array[(x + dx[i]) * N + y + dy[i]] == 0) {
                array[(x + dx[i]) * N + y + dy[i]] = count + 1;                
                horse(array, count + 1, (x + dx[i]) * N + y + dy[i]);
            }            
        }
        if (count == array.length) {
            printout(array);
            array[pos] = 0;
        } else {
            array[pos] = 0;            
        }
    }

    public static void main(String[] args) {
        int[] horse = new int[N * N];
        horse[0] = 1;
        horse(horse, 1, 0);
    }
}
