import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import static java.lang.Math.*;

public class MyFiles {
    public static String[] ReadFile(String FileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FileName));
        ArrayList<String> list = new ArrayList<>();
        String line;
        while((line = br.readLine()) != null){
            list.add(line);
        }
        String[] arr = new String[list.size()];
        list.toArray(arr);
        return arr;
    }
    public static ArrayList<String> FileReadInArr(String FileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FileName));
        String line;
        ArrayList<String> arr = new ArrayList<>();
        int i = 0;
        while((line = br.readLine()) != null){
            if (line.matches(".+\\..*")){
                String[] predl = line.split("\\.");
                for(int j = 0; j < predl.length;j++){
                    if (arr.isEmpty() ) {
                        arr.add(predl[j] + ".");
                    } else if (arr.get(arr.size()-1).matches(".+\\..*")){
                        arr.add(predl[j] + ".");
                    } else {
                        arr.set((arr.size()-1), arr.get(arr.size()-1) + predl[j]+".");
                    }
                }
            }else{
                arr.add(line);
            }
        }
        return arr;
    }

    public static void CreateNewFile(String path,String FileName) throws IOException {
        File file = new File(path,FileName);
        if (!file.exists()){
            file.createNewFile();
        }
    }


}
