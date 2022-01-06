package numberBaseballGame;

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
}
