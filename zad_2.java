import java.io.*;

public class zad_2 extends MyFiles{
    public static void zad_2() throws IOException {
        CreateNewFile("D:\\Java\\laba-10","laba_10_zad_2.txt");
        FileWriter fw = new FileWriter("laba_10_zad_2.txt");
        for (int i = 1; i <= 9; i++){
            for (int j = 1; j <= 9; j++){
                fw.write(j+" / "+i+" = "+(j/i)+"\t");
            }
            fw.write("\n");
        }
        fw.close();
    }
}