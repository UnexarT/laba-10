import java.io.*;

public class zad_3 {
    public static void zad_3() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("laba_10_zad_3.txt"));
        System.out.println("Слова содержащие аббревиатуру ABBA или АББА:");
        String line;
        while((line = br.readLine()) != null){
            if (line.matches(".*(ABBA|АББА).*")){
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.matches(".*(ABBA|АББА).*")) {
                        System.out.println(word);
                    }
                }
            }
        }
        br.close();
    }
}
