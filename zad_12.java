import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class zad_12 extends MyFiles {
    public static void zad_12() throws IOException {
        String file ="laba_10_zad_12.txt";
        String[] messages = ReadFile(file);
        PrintWriter pw = new PrintWriter(file);
        pw.println("Исходный текст: ");
        for (String message : messages) {
            pw.println(message);
        }
        pw.println();
        for (String message : replaces(messages, file)){
            pw.println(message);
        }
        pw.close();
    }

    public static ArrayList<String> replaces(String[] messages, String FileName) throws IOException {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Исправленный текст: ");
        String[] patterns = {"[бБ]удем говорить", "[нН]у", "[тТ]уто", "[Кк]ороче", "[Тт]ипа"};
        String[] sleng = {"[кК]ат[ак][а-я]+", "[кК]ек[а-я]+", "[кК]раш[а-я]*", "[лЛ]ол[а-я]*",
                "[нН]уб[а-я]*", "ОМГ", "[Сс]трим[а-я]*", "[фФ]лекс[а-я]*",
                "[чЧ]ил[а-я]*", "[пП]адр[а-я]+", "[дД]нокл[а-я]*"};
        String[] trans = {"(играть)", "(смеяться)", "(пример подражания)", "(очень смешно)",
                "(новичек)", "(крайнее удивление)", "(трансляция)", "(быть увлеченным)",
                "(отдых)", "(подруга)", "(одноклассник)"};
        for (String message : messages) {
            message = message.replaceAll("\\s{2,}", " ");
            for (String pattern : patterns) {
                message = message.replaceAll(pattern + "[.,!?]?\\s*", "");
            }
            String[] words = message.split("\\s+");
            for (String word : words) {
                String clearWord = word.replaceAll("[^А-Яа-я]", "");
                message = message.replaceAll(clearWord + ",?\\s+,?" + clearWord, clearWord);
                message = message.replaceAll(clearWord.substring(0, 1).toUpperCase()
                        + clearWord.substring(1) + ",?\\s+,?" + clearWord, clearWord);
                message = message.replaceAll(clearWord + ",?\\s+,?" + clearWord.substring(0, 1).toUpperCase()
                        + clearWord.substring(1), clearWord.substring(0, 1).toUpperCase()
                        + clearWord.substring(1));
            }
            words = message.split("\\s+");
            String NEWmessage = "";
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (word.equals(words[0])) {
                    word = word.substring(0, 1).toUpperCase() + word.substring(1);
                } else if (words[i - 1].charAt(words[i - 1].length() - 1) == '.' ||
                        words[i - 1].charAt(words[i - 1].length() - 1) == '?' ||
                        words[i - 1].charAt(words[i - 1].length() - 1) == '!') {
                    word = word.substring(0, 1).toUpperCase() + word.substring(1);
                }
                String clearWord = word.replaceAll("[^А-Яа-я]", "");
                for (int k = 0; k < trans.length; k++) {
                    word = word.replaceAll(sleng[k], clearWord + trans[k]);
                }
                NEWmessage += word + " ";
            }
            arr.add(NEWmessage);
        }
        return arr;
    }
}
