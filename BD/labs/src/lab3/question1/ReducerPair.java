package lab3.question1;

import java.util.ArrayList;
import java.util.List;

public class ReducerPair {

    private String key;
    private List<Integer> value;

    public ReducerPair(String key) {
        this.key = key;
        this.value = new ArrayList<>();
    }

    public ReducerPair(String key, int value) {
        this.key = key;
        addValue(value);
    }

    public void addValue(Integer p) {
        if(this.getValue() == null){
            this.value = new ArrayList<>();
        }
        this.getValue().add(p);
    }

    public List<Integer> getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }
}
