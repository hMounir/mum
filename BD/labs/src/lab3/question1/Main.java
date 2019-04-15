package lab3.question1;

public class Main {

    public static void main(String[] args) {
        InMapperWordCount wordCount = new InMapperWordCount(3, 4,
                new String[]{"lab3/question1/input/input0.txt", "lab3/question1/input/input1.txt", "lab3/question1/input/input2.txt"});

        wordCount.shuffleAndSort();

        wordCount.reduce();

        wordCount.print();
    }
}