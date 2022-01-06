package study.numberBaseballGame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class BaseballGameTest {

    public static final int IN_VALID_NUMBER = 10;

    @Test
    @DisplayName("객체를 생성시 3자리의 임의의 숫자를 생성한다.")
    void gameStartTest() throws Exception {
        BaseballGame baseballGame = new BaseballGame();

        Set<Integer> answer = baseballGame.getAnswer();

        assertEquals(answer.size(), 3);
    }

    @Test
    @DisplayName("올바르지 않은 숫자를 입력하면 예외가 발생한다.")
    void checkValidNumberIfNotThrowException() throws Exception {
        //given
        BaseballGame baseballGame = new BaseballGame();

        //when
        //then
        assertThatThrownBy(() -> baseballGame.inputNumber(IN_VALID_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);
    }


}

