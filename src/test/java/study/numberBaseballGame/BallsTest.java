package study.numberBaseballGame;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class BallsTest {

    @Test
    void play_nothing() throws Exception{
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = answer.play(Arrays.asList(4,5,6));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void play_1strike_1ball() throws Exception{
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = answer.play(Arrays.asList(4,5,6));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void play_3strike() throws Exception{
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = answer.play(Arrays.asList(1, 2, 3));

        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isGameEnd()).isTrue();
    }


    @Test
    void ball() throws Exception{
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = answer.play(new Ball(1, 2));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() throws Exception{
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = answer.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
