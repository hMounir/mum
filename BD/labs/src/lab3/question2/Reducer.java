package lab3.question2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Reducer {

    private final int id;
    private List<ReducerPair> ReducerPairs;
    private List<Pair<String, Pair<Integer, Integer>>> mappedData;
    private List<Pair<String, Double>> reducedList;

    public Reducer(int index) {
        id = index;
        reducedList = new ArrayList<>();
        mappedData = new ArrayList<>();
        ReducerPairs = new ArrayList<>();
    }

    public void groupingByPairs(Pair<String, Pair<Integer, Integer>> item) {
        Optional<ReducerPair> el = ReducerPairs.stream().filter(x -> x.getKey().equals(item.getKey())).findFirst();
        if (!el.isPresent()) {
            ReducerPairs.add(new ReducerPair(item.getKey(), item.getValue()));
        } else {
            el.get().addValue(item.getValue());
        }
        mappedData.add(item);
    }

    public void reduce(ReducerPair pair) {
        double sumK = pair.getValue().stream().mapToInt(i -> i.getKey()).sum();
        double sumV = pair.getValue().stream().mapToInt(i -> i.getValue()).sum();
        double value = sumV == 0 ? 0 : sumK / sumV;
        reducedList.add(new Pair<>(pair.getKey(), value));
    }

    public List<ReducerPair> getReducerPairs() {
        return ReducerPairs;
    }

    public void reduceGroups() {
        ReducerPairs.forEach(this::reduce);
    }

    public List<Pair<String, Double>> getReducedList() {
        return reducedList;
    }

    public List<Pair<String, Pair<Integer, Integer>>> getMappedData() {
        return mappedData;
    }

    public int getId() {
        return id;
    }

    public void sortGroupedPairs() {
        ReducerPairs.sort(Comparator.comparing(x -> x.getKey().toLowerCase()));
    }

    public void sortMappedData() {
        mappedData.sort(Comparator.comparing(x -> x.getKey().toLowerCase()));
    }
}
