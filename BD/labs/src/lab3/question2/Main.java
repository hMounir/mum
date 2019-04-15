package lab3.question2;

public class Main {

    public static void main(String[] args) {
        InMapperWordCount wordCount = new InMapperWordCount(4, 3,
                new String[]{"lab3/question2/input/input0.txt", "lab3/question2/input/input1.txt", "lab3/question2/input/input2.txt", "lab3/question2/input/input3.txt"});

        wordCount.shuffleAndSort();

        wordCount.reduce();

        wordCount.print();
    }
}