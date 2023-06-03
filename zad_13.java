import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class zad_13 extends MyFiles {
    public static void zad_13() throws IOException {
        String[] file1 = ReadFile("laba_10_zad_13_1.txt");
        String[] file2 = ReadFile("laba_10_zad_13_2.txt");
        String[][][] masses = FileMas_x3(file1);
        String[][][] argums = FileMas_x3(file2);
        CreateNewFile("D:\\Java\\laba-10","laba_10_zad_13_3.txt");
        PrintWriter pw = new PrintWriter("laba_10_zad_13_3.txt");
        String[] trueArgs;
        for(int i = 0; i < masses.length; i++){
            trueArgs = Check(masses[i],argums[i][0]);
            for(int j = 0; j < trueArgs.length; j++){
                pw.print(trueArgs[j]+"\t");
            }
            pw.println("\n");
        }
        pw.close();
    }



    public static String[][][] FileMas_x3(String[] lines){
        int i = 0;
        ArrayList<ArrayList<String>> Arr = new ArrayList<>();
        while(i < lines.length)  {
            ArrayList<String> arr = new ArrayList<>();
            while (!lines[i].equals("")) {
                arr.add(lines[i]);
                i++;
                if(i == lines.length){
                    break;
                }
            }
            Arr.add(arr);
            i++;
        }
        String[][][] Mas = new String[Arr.size()][Arr.get(0).size()][Arr.get(0).get(0).split("\\s+").length];
        for(int k = 0; k < Mas.length;k++){
            for(int j = 0; j < Mas[0].length;j++){
                Mas[k][j] = Arr.get(k).get(j).split("\\s+");
            }
        }
        return Mas;
    }

    public static String[] Gauss(String[][] mas){
        int len = mas[0].length - 1;
        double[][] copy = new double[len][len + 1];
        for(int i = 0; i < len; i++) {
            for (int j = 0; j < len + 1; j++){
                copy[i][j] = Double.parseDouble(mas[i][j]);
            }
        }
        for(int n = 0; n < len; n++) {
            for (int i = n; i < len; i++) {
                double num = copy[i][n];
                for (int j = n; j < len + 1; j++) {
                    copy[i][j] = copy[i][j]/num;
                    if(Double.isInfinite(copy[i][j]) || Double.isNaN(copy[i][j]) ){
                        copy[i][j] = 0;
                    }
                }
            }
            for (int i = n + 1; i < len; i++) {
                for (int j = n; j < len + 1; j++) {
                    copy[i][j] -= copy[n][j];
                }
            }
        }
        double[] args = new double[len];
        for(int i = 0; i < len; i++){
            args[i] = 1;
        }
        args[len-1] = copy[len-1][len];
        for (int i = len - 2; i >= 0; i--) {
            double sum = 0;
            for (int j = len - 1; j > i; j--) {
                sum += copy[i][j] * args[j];
            }
            args[i] = copy[i][len] - sum;
            if(Double.isInfinite(args[i]) || Double.isNaN(args[i]) ){
                args[i] = 0;
            }
        }
        String[] strArgs = new String[len];
        for(int i = 0; i < args.length;i++){
            strArgs[i] = Double.toString(args[i]);
        }
        return strArgs;
    }

    public static String[] Check(String[][] mas, String[] args){
        int len = mas[0].length - 1;

        int count = 0;
        for (int i = 0; i < len; i++) {
            double sum = 0;
            for (int j = 0; j < len; j++) {
                sum += Double.parseDouble(mas[i][j]) * Double.parseDouble(args[j]);
            }
            if ((sum > Double.parseDouble(mas[i][len]) - 0.001) &&
                    (sum < Double.parseDouble(mas[i][len]) + 0.001)){
                count++;
            }
        }
        if (count != len){
            args = Gauss(mas);
        }
        return args;
    }
}
