import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class zad_8 extends MyFiles{
    public static void zad_8() throws IOException {
        CreateNewFile("D:\\Java\\laba-10","laba_10_zad_8.txt");
        File("laba_10_zad_8.txt");
    }
    public static void File(String FileName) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(FileName);
        pw.println("Постановка:");
        pw.println("Коэфициенты находятся следующим образом:\n");
        pw.println("k(x1,y1,x2,y2) = (y1 - y2)/(x1 - x2); b(x1,y1,x2,y2) = y1 - x1*k(x1,y1,x2,y2)\n");
        pw.println("Левая фигура!\nФигура 1:");
        pw.println("№1 y = x * k(-4, 0, 1, 4) + b(-4, 0, 1, 4) D: -4 <= x <= 1");
        pw.println("№2 y = x * k(1, 4, -7, 5) + b(1, 4, -7, 5) D: -7 <= x <= 1");
        pw.println("№3 y = x * k(-4, 0, -7, 5) + b(-4, 0, -7, 5) D: -7 <= x <= -4");
        pw.println("Фигура 2:");
        pw.println("№1 y = x * k(-4, 0, -7, 5) + b(-4, 0, -7, 5) D: -7 <= x <= -4");
        pw.println("№2 y = x * k(-6, -4, -7, 5) + b(-6, -4, -7, 5) D: -7 <= x <= -6");
        pw.println("№3 y = x * k(-6, -4, -4, 0) + b(-6, -4, -4, 0) D: -6 <= x <= -4");
        pw.println("Фигура 2:");
        pw.println("№1 y = x * k(-6, -4, -4, 0) + b(-6, -4, -4, 0) D: -6 <= x <= -4");
        pw.println("№2 y = x * k(-2, -6, -6, -4) + b(-2, -6, -6, -4) D: -6 <= x <= -2");
        pw.println("№3 y = x * k(-2, -6, -4, 0) + b(-2, -6, -4, 0) D: -4 <= x <= -2\n");
        pw.println("Правая фигура!\nФигура 4:");
        pw.println("№1 y = x * k(1, -7, 3, -4) + b(1, -7, 3, -4) D: 1 <= x <= 3");
        pw.println("№2 y = x * k(1, -2, 3, -1) + b(1, -2, 3, -1) D: 1 <= x <= 3");
        pw.println("№3 y = x * k(-6, -4, -4, 0) + b(-6, -4, -4, 0) D: -6 <= x <= -4");
        pw.println("№4 x = 1 D: x > 1");
        pw.println("№5 x = 3 D: x < 3");
        pw.println("Фигура 5:");
        pw.println("№1 y = x * k(3, -1, 5,2) + b(3, -1, 5,2) D: 3 <= x <= 5");
        pw.println("№2 y = x * k(3, -4, 6, -3) + b(3, -4, 6, -3) D: 3 <= x <= 6");
        pw.println("№3 y = x * k(6, -3, 5,2) + b(6, -3, 5,2) D: 5 <= x <= 6");
        pw.println("№4 x = 3 D: x > 3\n");
        Scanner scn = new Scanner(System.in);
        pw.println("---------------------------------------------------------------------\n");
        pw.println("Матрица данных:");
        System.out.printf("Введите размерность матрици NxN значений x и y:\nN = ");
        int N = scn.nextInt();
        int[][] X = new int[N][N];
        int[][] Y = new int[N][N];
        int count = 0;
        for(int i = 0; i < N;i++){
            for(int j = 0; j < N;j++){
                System.out.println("Точка №" + ++count);
                System.out.printf("Задайте Х: ");
                int x = scn.nextInt();
                X[i][j] = x;
                System.out.printf("Задайте Y: ");
                int y = scn.nextInt();
                Y[i][j] = y;
                pw.write("№" + count + " ("+x+","+y+")\t");
            }
            pw.write("\n");
        }
        pw.write("\n");
        pw.println("---------------------------------------------------------------------\n");
        pw.println("Стилизованный вывод:");
        count = 0;
        for(int i = 0; i < N;i++){
            for(int j = 0; j < N;j++){
                int x,y;
                x = X[i][j];
                y = Y[i][j];
                pw.printf("Точка №" + ++count + " ("+x+","+y+") ");
                if (figOne(x,y) || figTwo(x,y) || figThree(x,y)) {
                    pw.printf("попала в левую фигуру");
                } else if(figFour(x,y) || figFive(x,y)){
                    pw.printf("попала во правую фигуру");
                } else {
                    pw.println("не попала");
                }
            }
        }
        pw.close();
    }
    public static double k(double x1,double y1,double x2,double y2){
        return (y1 - y2)/(x1 - x2);
    }
    public static double b(double x1,double y1,double x2,double y2){
        return y1 - x1*k(x1,y1,x2,y2);
    }
    public static boolean figOne(double x, double y) {
        if (y >= x * k(-4, 0, 1, 4) + b(-4, 0, 1, 4) &&
                y <= x * k(1, 4, -7, 5) + b(1, 4, -7, 5) &&
                y >= x * k(-4, 0, -7, 5) + b(-4, 0, -7, 5)) {
            return true;
        }
        return false;
    }
    public static boolean figTwo(double x, double y) {
        if (y <= x * k(-4, 0, -7, 5) + b(-4, 0, -7, 5) &&
                y >= x * k(-6, -4, -7, 5) + b(-6, -4, -7, 5)  &&
                y >= x * k(-6, -4, -4, 0) + b(-6, -4, -4, 0)) {
            return true;
        }
        return false;
    }
    public static boolean figThree(double x, double y) {
        if (y <= x * k(-6, -4, -4, 0) + b(-6, -4, -4, 0) &&
                y >= x * k(-2, -6, -6, -4) + b(-2, -6, -6, -4) &&
                y <= x * k(-2, -6, -4, 0) + b(-2, -6, -4, 0)) {
            return true;
        }
        return false;
    }
    public static boolean figFour(double x, double y) {
        if (y >= x * k(1, -7, 3, -4) + b(1, -7, 3, -4) &&
                y <= x * k(1, -2, 3, -1) + b(1, -2, 3, -1) &&
                x >= 1 && x <= 3) {
            return true;
        }
        return false;
    }
    public static boolean figFive(double x, double y) {
        if (y <= x * k(3, -1, 5,2) + b(3, -1, 5,2) &&
                y >= x * k(3, -4, 6, -3) + b(3, -4, 6, -3) &&
                y <= x * k(6, -3, 5,2) + b(6, -3, 5,2) && x >= 3) {
            return true;
        }
        return false;
    }
}
