import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.*;


public class zad_11 extends MyFiles{
    public static void zad_11() throws IOException {
        CreateNewFile("D:\\Java\\laba-10","laba_10_zad_11.txt");
        Calc("laba_10_zad_11.txt");

    }

    public static void Calc(String FileName) throws IOException {
        PrintWriter pw = new PrintWriter(FileName);
        pw.println("Постановка: f(x) = cos(x)^2-x*sin(y), где -2 <= x <= 3 и -1 <= y <= 4\n");
        pw.println("Вычисления начинаются с шагом x += 0.1 и y += 0.2:\n");
        pw.println("--------------------------------------------------------------------------\n");
        pw.write("Массив координат X:\n{");
        for (double x = -2; x <= 3; x += 0.1){
            pw.printf("%.1f   ",x);
        }
        pw.write("}\n");
        pw.println("--------------------------------------------------------------------------\n");
        pw.write("Массив координат Y:\n{");
        for (double y = -1; y <= 4; y += 0.2){
            pw.printf("%.1f   ",y);
        }
        pw.write("}\n");
        pw.println("--------------------------------------------------------------------------\n");
        pw.println("Матрица значений Z:");
        for (double x = -2; x <= 3; x += 0.1){
            for (double y = -1; y <= 4; y += 0.2) {
                if (x < 0){
                    pw.printf("%.3f\t\t",x);
                } else {
                    pw.printf("%.3f \t\t",x);
                }
                if ((pow(cos(x),2)-x*sin(y)) < 0){
                    pw.printf("%.3f",(pow(cos(x),2)-x*sin(y)));
                } else {
                    pw.printf("%.3f ",(pow(cos(x),2)-x*sin(y)));
                }
            }
            pw.write("\n");
        }
        pw.close();
    }
}