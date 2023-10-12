package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GameManger {
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int NUMBER_OF_DIGITS = 3;
    private List<Integer> uniqueNumbers;

    public List<Integer> getUniqueNumbers() {
        return this.uniqueNumbers;
    }

    private void generateUniqueNumbers() {
        // 서로 다른 숫자 NUMBER_OF_DIGITS 개 생성 (3개)
        while (uniqueNumbers.size() < NUMBER_OF_DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            if (!uniqueNumbers.contains(randomNumber)) {
                uniqueNumbers.add(randomNumber);
            }
        }
    }

}
