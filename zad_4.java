import java.io.*;

public class zad_4 {
    public static void zad_4() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("laba_10_zad_4_1.txt"));
        PrintWriter pw = new PrintWriter("laba_10_zad_4_2.txt");
        String line;
        String last = "";
        int cnt1 = 0;
        while((line = bf.readLine()) != null){
            String[] words = line.split("\\s+");
            int cnt2 = 0;
            for(int i = 0;i < words.length;i++){
                if (i != words.length-1 && words[i].matches(".+[_.,;:\\t!?]")){
                    pw.println(words[i]+" "+words[i+1]);
                }
                if (!last.equals("") && cnt2++ < 1 && cnt1++ > 0) {
                    pw.println(last + " " + words[0]);
                }
                last = words[words.length-1];
                int cnt3 = 0;
                int cnt4 = 0;
                for (int j = 0;j < words[i].length();j++){
                    if ((words[i].charAt(j) >= 'A' && words[i].charAt(j) <= 'Z')
                            || (words[i].charAt(j) >= 'a' && words[i].charAt(j) <= 'z')){
                        cnt3++;
                    }else if(Character.isDigit(words[i].charAt(j))){
                        cnt4++;
                    }
                }
                if (cnt3 + cnt4 == words[i].length() && cnt3 > 0 && cnt4 > 0) {
                    pw.println(words[i]);
                }
            }
        }
        pw.close();
        bf.close();
    }
}
