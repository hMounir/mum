package lab3.question1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Reducer {

    private final int id;
    private List<ReducerPair> reducerPairs;
    private List<Pair> mappedData;
    private List<Pair> reducedList;

    public Reducer(int index) {
        id = index;
        reducedList = new ArrayList<>();
        mappedData = new ArrayList<>();
        reducerPairs = new ArrayList<>();
    }

    public void groupingByPairs(Pair item) {
        Optional<ReducerPair> el = reducerPairs.stream().filter(x -> x.getKey().equals(item.getKey())).findFirst();
        if (!el.isPresent()) {
            reducerPairs.add(new ReducerPair(item.getKey(), item.getValue()));
        } else {
            el.get().addValue(item.getValue());
        }
        mappedData.add(item);
    }

    public void reduce(ReducerPair pair) {
        int sum = pair.getValue().stream().mapToInt(i -> i).sum();
        reducedList.add(new Pair(pair.getKey(), sum));
    }

    public List<ReducerPair> getReducerPairs() {
        return reducerPairs;
    }

    public void reduceGroups() {
        reducerPairs.forEach(this::reduce);
    }

    public List<Pair> getReducedList() {
        return reducedList;
    }

    public List<Pair> getMappedData() {
        return mappedData;
    }

    public int getId() {
        return id;
    }

    public void sortGroupedPairs() {
        reducerPairs.sort(Comparator.comparing(x -> x.getKey().toLowerCase()));
    }

    public void sortMappedData() {
        mappedData.sort(Comparator.comparing(x -> x.getKey().toLowerCase()));
    }
}
