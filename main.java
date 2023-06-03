import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        int fl = 1;
        while (fl == 1) {
            System.out.println("Введите номер задания(1-12) для получения ответа: ");
            int N = 0;
            while(N == 0) {
                System.out.printf("%s = ", "№");
                N = scn.nextInt();
                if (N <= 0) {
                    System.out.println("Ошибка в веденных данных!");
                    N = 0;
                }
            }
            System.out.println();
            int x = N;
            switch (x) {
                case 1:
                    zad_1 z1 = new zad_1();
                    z1.zad_1();
                    break;
                case 2:
                    zad_2 z2 = new zad_2();
                    z2.zad_2();
                    break;
                case 3:
                    zad_3 z3 = new zad_3();
                    z3.zad_3();
                    break;
                case 4:
                    zad_4 z4 = new zad_4();
                    z4.zad_4();
                    break;
                case 5:
                    zad_5 z5 = new zad_5();
                    z5.zad_5();
                    break;
                case 6:
                    zad_6 z6 = new zad_6();
                    z6.zad_6();
                    break;
                case 7:
                    zad_7 z7 = new zad_7();
                    z7.zad_7();
                    break;
                case 8:
                    zad_8 z8 = new zad_8();
                    z8.zad_8();
                    break;
                case 9:
                    zad_9 z9 = new zad_9();
                    z9.zad_9();
                    break;
                case 11:
                    zad_11 z11 = new zad_11();
                    z11.zad_11();
                    break;
                case 12:
                    zad_12 z12 = new zad_12();
                    z12.zad_12();
                    break;
                case 13:
                    zad_13 z13 = new zad_13();
                    z13.zad_13();
                    break;
                case 14:
                    zad_14 z14 = new zad_14();
                    z14.zad_14();
                    break;
            }
            System.out.println("\nХотите проверить другие задания? Да - 1, нет - 2");
            N = 0;
            while(N == 0) {
                System.out.printf("%s = ", "Ответ");
                N = scn.nextInt();
                if (N <= 0) {
                    System.out.println("Ошибка в веденных данных!");
                    N = 0;
                }
            }
            System.out.println();
            fl = N;
        }
    }
}
