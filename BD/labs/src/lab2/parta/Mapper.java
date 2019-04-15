package lab2.parta;


import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mapper {

    private String fileName;
    private List<String > stringLines;
    private String scapeRegex = "[\\W+,-.]|(\\w+[\\._]\\w+)|\\\"|([A-Za-z]+[\\d]+[\\w]*)|\\d";

    public Mapper(String fileName) {
        this.fileName = fileName;
        readFile();
    }

    private void readFile() {
        try {
            URI uri = ClassLoader.getSystemResource(fileName).toURI();
            String mainPath = Paths.get(uri).toString();
            Path path = Paths.get(mainPath);

            try (Stream<String> stream = Files.lines(path)) {
                stringLines = stream.collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public List<Pair> mapAndSort(){
        try {
            return stringLines.stream().map(x -> x.split(scapeRegex))
                    .flatMap(Arrays::stream)
                    .filter(x -> !x.isEmpty())
                    .map(x -> new Pair(x, 1))
                    .sorted(Comparator.comparing(pair -> pair.getKey().trim()))
                    .collect(Collectors.toList());
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
