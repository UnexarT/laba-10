import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.Math.sin;
import static java.lang.Math.tan;

public class zad_7 extends MyFiles{
    public static void zad_7() throws IOException {
        CreateNewFile("D:\\Java\\laba-10","laba_10_zad_7.txt");
        Calc("laba_10_zad_7.txt");

    }

    public static void Calc(String FileName) throws IOException {
        PrintWriter pw = new PrintWriter(FileName);
        pw.println("Постановка: f(x) = tan(x)+sin(x), где -3 <= x <= 3\n");
        pw.println("Вычисления начинаются с шагом x += 0.5:");
        for (double x = -3; x <= 3; x += 0.5){
            if (x >= 1){
                pw.println(x + "\t\t\t" + (tan(x)+sin(x)));
            } else if(x >= 0 && x < 1) {
                pw.println(x + "\t\t\t" + (tan(x) + sin(x)));
            }else{
                pw.println(x + "\t\t" + (5*x*x - 3));
            }
        }
        pw.close();
    }
}
