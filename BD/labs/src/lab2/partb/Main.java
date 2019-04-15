package lab2.partb;

public class Main {

    public static void main(String[] args) {
        WordCount wordCount = new WordCount(3, 4, new String[]{"lab2/partb/input/input0.txt", "lab2/partb/input/input1.txt", "lab2/partb/input/input2.txt"});
        wordCount.shuffleAndSort();
        wordCount.reduce();
        wordCount.print();
    }
}