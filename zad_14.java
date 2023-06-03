import java.io.IOException;
import java.io.PrintWriter;

public class zad_14 extends MyFiles{
    public static void zad_14() throws IOException {
        String[] file = ReadFile("Variant_7,17.txt");
        String[] nums = new String[file.length - 11];
        LinesSplit(file, nums, 11);
        String[][] mas = MasNumsSplit(nums);
        String[] MaxMinMid = MaxMinMid(mas);
        PrintWriter pw = new PrintWriter("Variant_7,17.txt");
        for(int i = 0; i < file.length; i++){
            pw.println(file[i]);
        }
        pw.printf("\nОтветы на вопросы:\n");
        pw.println("Вопрос №1");
        pw.printf("Максимальное значение по UX: %s\n", MaxMinMid[0]);
        pw.printf("Минимальное значение по UX: %s\n", MaxMinMid[1]);
        pw.printf("Среднее значение по UX: %s\n\n", MaxMinMid[2]);
        pw.println("Вопрос №2");
        for(int i = 0; i < mas.length; i++){
            pw.printf("Отклонение %d: %f\n",i+1,Double.parseDouble(MaxMinMid[2])-Double.parseDouble(mas[i][2]));
        }
        pw.close();
    }
    public static String[] MaxMinMid (String[][] mas){
        String[] arr = new String[3];
        double max, min, mid, sum;
        max = Math.pow(10, -1000000000);
        min = Math.pow(10, 1000000000);
        sum = 0;
        for (int i = 0; i < mas.length; i++){
            if (Double.parseDouble(mas[i][2]) > max){
                max = Double.parseDouble(mas[i][2]);
            } else if (Double.parseDouble(mas[i][2]) < min){
                min = Double.parseDouble(mas[i][2]);
            }
            sum += Double.parseDouble(mas[i][2]);
        }
        mid = sum/ mas.length;
        arr[0] = Double.toString(max);
        arr[1] = Double.toString(min);
        arr[2] = Double.toString(mid);
        return arr;
    }

    public static String[][] MasNumsSplit (String[] nums){
        String[][] mas = new String[nums.length][nums[0].split("\\s+").length];
        String[] line;
        for (int i = 0; i < nums.length; i++){
            line = nums[i].split("\\s+");
            mas[i] = line;
        }
        return mas;
    }


    public static void LinesSplit (String[] file,String[] mas, int num){
        for (int i = 0; i < mas.length; i++){
            String line = file[num + i].replaceAll("-0\\."," -0\\.");
            mas[i] = line;
        }
    }
}
