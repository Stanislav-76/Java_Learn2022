// Написать программу вычисления n-ого треугольного числа.
import java.util.Scanner;

public class DZ1 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите n треугольного числа: ");
        int x = iScanner.nextInt();
        System.out.printf("Треугольное число %d = %d",x, x*(x+1)/2);
    }
}