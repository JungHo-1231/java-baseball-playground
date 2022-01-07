package study.numberBaseballGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class BaseballGameTest {

    public static final int INVALID_NUMBER = 10;
    private BaseballGame baseballGame;

    @BeforeEach
    void setUp() {
        baseballGame = new BaseballGame();
    }

    @Test
    @DisplayName("객체를 생성시 3자리의 임의의 숫자를 생성한다.")
    void gameStartTest() throws Exception {

        int[] answer = baseballGame.getAnswer();

        assertEquals(answer.length, 3);
    }

    @Test
    @DisplayName("올바르지 않은 숫자를 입력하면 예외가 발생한다.")
    void checkValidNumberIfNotThrowException() throws Exception {
        //given
        StringBuilder invalidNumber = new StringBuilder();
        invalidNumber.append(INVALID_NUMBER);
        invalidNumber.append(INVALID_NUMBER);
        invalidNumber.append(INVALID_NUMBER);

        //when
        //then
        assertThatThrownBy(() -> baseballGame.inputNumber(String.valueOf(invalidNumber)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("플레이어가 입력한 숫자가 자리와 값이 1개 일치할 경우 1스트라이크를 출력한다")
    void oneStrikeTest() throws Exception {
        //given
        String oneStrikeSetting = oneStrikeSetting();
        //when
        int[] answer = baseballGame.getAnswer();
        //then
        baseballGame.inputNumber(oneStrikeSetting);
        assertEquals(answer[0], Character.getNumericValue(oneStrikeSetting.charAt(0)));
    }

    @Test
    @DisplayName("플레이어가 입력한 숫자가 자리와 값이 2개 일치할 경우 2스트라이크를 출력한다")
    void twoStrikeTest() throws Exception {
        //given
        String twoStrikeSetting = twoStrikeSetting();
        //when
        int[] answer = baseballGame.getAnswer();
        //then
        baseballGame.inputNumber(twoStrikeSetting);

        assertEquals(answer[0], Character.getNumericValue(twoStrikeSetting.charAt(0)));
        assertEquals(answer[1], Character.getNumericValue(twoStrikeSetting.charAt(1)));
    }

    @Test
    @DisplayName("플레이어가 입력한 숫자가 자리와 값이 3개 일치할 경우 3 스트라이크를 출력한다")
    void threeStrikeTest() throws Exception {
        //given
        int[] answer = baseballGame.getAnswer();
        String threeStrike = Arrays.toString(answer).replaceAll("[^0-9]", "");

        //when
        baseballGame.inputNumber(threeStrike);

        //then
        assertEquals(answer[0], Character.getNumericValue(threeStrike.charAt(0)));
        assertEquals(answer[1], Character.getNumericValue(threeStrike.charAt(1)));
        assertEquals(answer[2], Character.getNumericValue(threeStrike.charAt(2)));
    }

    @Test
    @DisplayName("플레이어가 입력한 숫자만  1개 일치할 경우 1볼을 출력한다")
    void oneBallTest() throws Exception {
        //given
        String oneStrikeSetting = oneBallSetting();
        //when
        int[] answer = baseballGame.getAnswer();
        //then
        baseballGame.inputNumber(oneStrikeSetting);
    }

    private String oneBallSetting() {

        int[] answer = baseballGame.getAnswer();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(answer[1]);

        if (answer[0] != 9) {
            stringBuilder.append(answer[0] + 1);
        }

        if (answer[0] == 9) {
            stringBuilder.append(1);
        }

        if (answer[2] != 9) {
            stringBuilder.append(answer[2] + 1);
        }

        if (answer[2] == 9) {
            stringBuilder.append(2);
        }

        return new String(stringBuilder);
    }

    private String oneStrikeSetting() {
        int[] answer = baseballGame.getAnswer();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(answer[0]);

        if (answer[1] != 9) {
            stringBuilder.append(answer[1] + 1);
        }

        if (answer[1] == 9) {
            stringBuilder.append(1);
        }

        if (answer[2] != 9) {
            stringBuilder.append(answer[2] + 1);
        }

        if (answer[2] == 9) {
            stringBuilder.append(2);
        }

        return new String(stringBuilder);
    }

    private String twoStrikeSetting() {
        int[] answer = baseballGame.getAnswer();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(answer[0]);
        stringBuilder.append(answer[1]);


        if (answer[2] != 9) {
            stringBuilder.append(answer[2] + 1);
        }

        if (answer[2] == 9) {
            stringBuilder.append(2);
        }

        return new String(stringBuilder);
    }
}

