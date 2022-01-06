package study.numberBaseballGame;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BaseballGame {

    Set<Integer> answer = new HashSet<>();

    public BaseballGame() {
        Random random = new Random();

        while (answer.size() != 3) {
            int randomNumber = random.nextInt(9);
            answer.add(randomNumber);
        }
    }

    public Set<Integer> getAnswer() {
        return answer;
    }

    public void inputNumber(int number) {
        checkValidNumber(number);
    }

    private void checkValidNumber(int number) {
        if (number > 9 || number > 1) {
            throw new IllegalArgumentException("올바른 번호가 아닙니다");
        }
    }
}
