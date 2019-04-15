package lab2.parta;

import java.util.List;
import java.util.stream.Collectors;

public class Reducer {

    public List<ReducerPair> reduceGroup(List<Pair> wordsList){
        return wordsList.stream()
                .map(word -> {
                        Integer[] wordCount = wordsList.stream().filter(word::equals).map(Pair::getValue).toArray(Integer[]::new);
                        return new ReducerPair(word.getKey(),wordCount); })
                .distinct().collect(Collectors.toList());
    }

    public void reduceOutput(List<ReducerPair> wordsList){
        wordsList.stream().map(word -> {
            Integer wordSum = word.getValue().length;
            return new Pair(word.getKey(),wordSum);
        }).distinct().forEach(System.out::println);
    }
}
