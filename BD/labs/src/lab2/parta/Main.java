package lab2.parta;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args){
        try {
            List<Pair> pairList = new Mapper("lab2/parta/testDataForW1D1.txt").mapAndSort();

            System.out.println("Mapper Output\n");
            pairList.forEach(System.out::println);

            System.out.println("\nReducer Input\n");
            Reducer reducer = new Reducer();
            List<ReducerPair> reducerPairList = reducer.reduceGroup(pairList);
            reducerPairList.forEach(System.out::println);

            System.out.println("\nReducer Output\n");
            reducer.reduceOutput(reducerPairList);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
