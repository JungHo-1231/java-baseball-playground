package study.numberBaseballGame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallTest {

    private Ball com;

    @BeforeEach
    void setUp() {
        com = new Ball(1, 4);
    }

    @Test
    void strike() throws Exception {
        BallStatus status = com.play(new Ball(2, 4));
        Assertions.assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() throws Exception {
        BallStatus status = com.play(new Ball(2, 4));
        Assertions.assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() throws Exception {
        BallStatus status = com.play(new Ball(2, 5));
        Assertions.assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}