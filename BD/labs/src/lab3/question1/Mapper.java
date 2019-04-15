package lab3.question1;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mapper {

    private String fileName;
    private List<String> stringLines;
    private String scapeRegex = "[\\W+,-.]|(\\w+[\\._]\\w+)|\\\"|([A-Za-z]+[\\d]+[\\w]*)|\\d";
    private List<Pair> splits;
    private int id;

    public Mapper(String fileName, int index) {
        id = index;
        this.fileName = fileName;
        readFile();
        stringLines.forEach(x -> System.out.println(x));
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
            splits = stringLines.stream().map(x -> x.split(scapeRegex))
                    .flatMap(Arrays::stream)
                    .filter(x -> !x.isEmpty())
                    .map(x -> new Pair(x, 1))
                    .sorted(Comparator.comparing(pair -> pair.getKey().trim()))
                    .collect(Collectors.toList());
            return splits;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public int getId() {
        return id;
    }

    public List<Pair> getSplits() {
        return splits;
    }
}
