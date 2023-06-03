import java.io.*;
import java.util.ArrayList;

public class zad_5 extends MyFiles {
    public static void zad_5() throws IOException {
        ArrayList<String> arr1 = FileReadInArr("laba_10_zad_5_2.txt");
        ArrayList<String> arr2 = FileReadInArr("laba_10_zad_5_1.txt");
        RefreshFile_2(arr1,arr2,"laba_10_zad_5_2.txt");
    }

    public static void RefreshFile_2(ArrayList<String> arr1, ArrayList<String> arr2,String FileName) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(FileName);
        for(String unit: arr1){
            pw.println(unit);
        }
        for(String unit: arr2){
            if (unit.matches(".*[IV].*")) {
                pw.println(unit);
            }
        }
        pw.close();
    }
}
