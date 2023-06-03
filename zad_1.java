import java.util.Scanner;
import java.io.*;
public class zad_1{
    public static String line = "";
    public static void zad_1() throws IOException {
        String[] mas = FileGetStrMas("laba_10_zad_1.txt");
        Scanner scn = new Scanner(System.in);
        System.out.printf("Задайте проверяемую латинскую букву: ");
        String n = scn.next();
        Check(Stats(mas,n),n,"laba_10_zad_1.txt");
    }


    public static String[] FileGetStrMas(String FileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FileName));
        line = br.readLine();
        br.close();
        line = line.replaceAll("[{}]","");
        String mas[] = line.split(",");
        return mas;
    }

    public static void Check(int[] mas, String n, String FileName)  throws IOException {
        PrintWriter bw = new PrintWriter(new FileWriter(FileName));
        bw.append("{"+line+"}"+"\n");
        bw.append("\nРезультаты:\n");
        bw.append("Прописных латинских букв "+ mas[0] +" штук \n");
        if (mas[1] == 1) { bw.append("Буква <<"+ n +">> встречается в массиве\n");
        } else {  bw.append("Буква <<"+ n +">> не встречается в массиве\n");}
        if (mas[2] >= 2){ bw.append("Запятая встречается в массиве 2-а или более раз\n");
        } else {  bw.append("Запятая встречается в массиве менее 2-х раз\n");}
        if (mas[3] == 1) { bw.append("Среди элементов встречается <<во>> или <<ов>>\n");
        } else {  bw.append("Среди букв не встречается <<во>> или <<ов>>\n");}
        if (mas[4] == 1) { bw.append("Среди элементов встречаются одинаковый цифры стоящие подряд\n");
        } else {  bw.append("Среди элементов не встречаются одинаковый цифры стоящие подряд\n");}
        if (mas[5] == 1) { bw.append("Среди элементов встречаются одинаковые буквы " +
                "разного регистра и нули стоящие подряд\n");
        } else {  bw.append("Среди элементов не встречаются одинаковые буквы " +
                "разного регистра и нули стоящие подряд\n");}
        bw.close();
    }

    public static int[] Stats(String[] mas, String n) {
        int arr[] = new int[6];
        for(int i = 0; i < mas.length; i++){
            if (mas[i].matches("[А-яA-z]+")){
                if (mas[i].matches("[А-Я]+")) {
                    arr[0]++;
                }
                if((mas[i].toUpperCase()).equals(n.toUpperCase())) {
                    arr[1] = 1;
                }
                if((i != mas.length - 1) && ((mas[i].equals("в") && mas[i+1].equals("о"))
                        || (mas[i].equals("о") && mas[i+1].equals("в")))){
                    arr[3] = 1;
                }
                if(i > 1 && i != mas.length-1 && !mas[i].equals(mas[i+1]) && (mas[i].toUpperCase().equals(mas[i+1])
                        || mas[i].toLowerCase().equals(mas[i+1]))) {
                    for (int j = i + 1; j < mas.length - 1; j++) {
                        if (mas[j].equals("0") && mas[j + 1].equals("0")) {
                            arr[5] = 1;
                        }
                    }
                }
            }else if (mas[i].equals(",")){
                arr[2]++;
            }else if (i != mas.length - 1 && mas[i].matches("[0-9]+")
                    && mas[i+1].matches("[0-9]+") && mas[i].equals(mas[i+1])){
                arr[4] = 1;
            }
        }
        return arr;
    }
}

