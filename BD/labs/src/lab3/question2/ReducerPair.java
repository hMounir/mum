package lab3.question2;

import java.util.ArrayList;
import java.util.List;

public class ReducerPair extends Pair<String, List<Pair<Integer, Integer>>> {

    public ReducerPair(String key) {
        super(key, new ArrayList<>());
    }

    public ReducerPair(String key, Pair<Integer, Integer> value) {
        super(key, new ArrayList<>());
        addValue(value);
    }

    public void addValue(Pair<Integer, Integer> p) {
        this.getValue().add(p);
    }

    @Override
    public String toString() {
        return new StringBuilder().append(getKey()).append(" , ").append(getValue()).toString();
    }
}
