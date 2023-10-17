package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberGenerator {

    public List<Integer> getGeneratedNumbers() {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> result;
        IntStream.rangeClosed(1, 9).forEach(numbers::add);
        Collections.shuffle(numbers);
        result = IntStream.range(0, 3).mapToObj(numbers::get).collect(Collectors.toList());

        return result;
    }
}
