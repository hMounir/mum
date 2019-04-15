package lab2.partb;

import java.util.Arrays;
import java.util.stream.IntStream;

public class WordCount {

    private final String[] filesPath;
    private final Mapper[] mappers;
    private final Reducer[] reducers;

    public WordCount(int m, int r, String[] filesPath) {
        mappers = new Mapper[m];
        reducers = new Reducer[r];
        this.filesPath = filesPath;
        initMappers();
        initReducers();
    }

    private void initMappers() {
        IntStream.range(0, mappers.length).forEach(x -> {
            System.out.println("Mapper Input " + x);
            mappers[x] = new Mapper(filesPath[x], x);
            mappers[x].mapAndSort();
        });

        IntStream.range(0, mappers.length).forEach(i -> {
            System.out.println("Mapper " + i + " Output");
            mappers[i].getMappedList().forEach(x -> {
                System.out.println("< " + x.getKey() + " , " + x.getValue() + " >");
            });
        });
    }

    private void initReducers() {
        for (int i = 0; i < reducers.length; i++) {
            reducers[i] = new Reducer(i);
        }
    }

    public Mapper[] getMappers() {
        return mappers;
    }

    public Reducer[] getReducers() {
        return reducers;
    }

    public int getPartition(String key) {
        return (int) key.hashCode() % reducers.length;
    }

    public void shuffleAndSort() {
        Arrays.stream(mappers).forEach(x -> {
            x.getMappedList().forEach(z -> {
                int p = getPartition(z.getKey().toLowerCase());
                reducers[p].groupingByPairs(z);
            });
        });

        Arrays.stream(mappers).forEach(x -> {
            Integer lastIndexX = x.getId();
            Arrays.stream(reducers).forEach(y -> {
                y.sortMappedData();
                System.out.println("Pairs send from Mapper " + lastIndexX + " Reducer " + y.getId());
                y.getMappedData().stream()
                        .filter(z -> x.getMappedList().contains(z))
                        .forEach(z -> System.out.println("< " + z.getKey() + " , " + z.getValue() + " >"));
            });
        });

        Arrays.stream(reducers).forEach(x -> {
            x.sortGroupedPairs();
            System.out.println("Reducer " + x.getId() + " input");
            x.getReducerPairs().forEach(y -> System.out.println("< " + y.getKey() + " , " + y.getValue() + " >"));
        });
    }

    public void reduce() {
        Arrays.stream(reducers).forEach(x -> x.reduceGroups());
    }

    public void print() {
        Arrays.stream(reducers)
                .peek(x -> System.out.println("Reducer " + x.getId() + " Output"))
                .flatMap(x -> x.getReducedList().stream())
                .forEach(x -> System.out.println("< " + x.getKey() + " , " + x.getValue() + " >"));
    }
}
