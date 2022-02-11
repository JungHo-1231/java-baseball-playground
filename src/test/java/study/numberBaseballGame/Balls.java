package study.numberBaseballGame;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> answer;

    public Balls(List<Integer> answer) {
        this.answer = mapBall(answer);
    }

    public BallStatus play(Ball userBall) {
        return answer.stream()
                .map(answer -> answer.play(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING)
                ;
    }

    public PlayResult play(List<Integer> balls) {
        Balls userBalls = new Balls(balls);
        PlayResult result = new PlayResult();

        for (Ball answer : answer) {
            BallStatus status = userBalls.play(answer);
            result.report(status);
        }

        return result;

    }

    private List<Ball> mapBall(List<Integer> answer) {
        List<Ball> balls = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, answer.get(i)));
        }

        return balls;
    }
}
