import java.io.*;
import java.util.ArrayList;

public class zad_6 extends MyFiles {
    public static void zad_6() throws IOException {
        RefreshFile("laba_10_zad_6.txt");
    }

    public static void RefreshFile(String FileName) throws IOException {
        ArrayList<String> persons = FileReadInArr(FileName);
        int[] counts = Check(persons);
        PrintWriter pw = new PrintWriter(FileName);
        for(String person: persons){
            pw.println(person);
        }
        pw.println("Число волейболистов по клубам с ценой контракта не менее 100 000: "+counts[0]);
        pw.println("Число волейболистов по клубам участвующих в играх клуба не менее 5 лет: "+counts[1]);
        pw.close();
    }


    public static int[] Check(ArrayList<String> persons) {
        int[] counts = new int[2];
        String teams = "";
        for (String person : persons) {
            String[] facts = person.split(",");
            if (!teams.matches(".*" + facts[1] + ".*")) {
                teams += facts[1] + ",";
            }
        }
        for (String team : teams.split(",")) {
            for (String person : persons) {
                person = person.replace('.', ',');
                String[] facts = person.split(",");
                if (person.matches(".*" + team + ".*")) {
                    if (Integer.parseInt(facts[3]) >= 100000) {
                        counts[0]++;
                    }
                    if (2023 - Integer.parseInt(facts[2]) >= 5) {
                        counts[1]++;
                    }
                }
            }
        }
        return counts;
    }
}
