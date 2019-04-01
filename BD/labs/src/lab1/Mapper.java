package lab1;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Mapper {

    public static void main(String[] args){
        try {

            URL path = Mapper.class.getResource("testDataForW1D1.txt");

            String content = new String(Files.readAllBytes(Paths.get(new File(path.getFile()).getPath())));
            List<String> words = Arrays.asList(content.split(" "));
            List<Pair> pairList = new ArrayList<>();

            for (String word : words) {
                if(word.matches("([a-zA-Z])+") && !word.equals("")  && !word.contains(".")){
                    if(word.contains("-") || word.contains("_")){
                        String[] multiWord =
                                word.contains("-") ? word.split("-") : word.split("_");
                        for (String w:multiWord) {
                            pairList.add(new Pair(w.trim().toLowerCase()
                                    .replace("\"", "")
                                    .replace(".", ""), 1));
                        }
                    }else {
                        pairList.add(new Pair(word.trim().toLowerCase()
                                .replace("\"","")
                                .replace(".",""),1));
                    }
                }
            }

            pairList.stream()
                    .sorted(Comparator.comparing(pair -> pair.getKey().trim()))
                    .forEach(System.out::println);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
