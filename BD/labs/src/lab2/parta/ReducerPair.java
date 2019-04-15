package lab2.parta;

import java.util.Arrays;
import java.util.Objects;

public class ReducerPair {

    private String key;
    private Integer[] value;

    public ReducerPair(String key, Integer[] value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer[] getValue() {
        return value;
    }

    public void setValue(Integer[] value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "< " +
                "" + key +
                " , " + Arrays.toString(value) +
                " >";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReducerPair that = (ReducerPair) o;
        return Objects.equals(key, that.key) &&
                Arrays.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(key);
        result = 31 * result + Arrays.hashCode(value);
        return result;
    }
}
