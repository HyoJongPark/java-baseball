package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class NumberGenerator {

    private List<Integer> generatedNumbers = new ArrayList<>();

    public NumberGenerator() {
        List<Integer> numbers = new ArrayList<>();
        IntStream.rangeClosed(1, 9).forEach(numbers::add);
        Collections.shuffle(numbers);

        IntStream.range(0, 3).forEach(i -> generatedNumbers.add(numbers.get(i)));
    }
}
