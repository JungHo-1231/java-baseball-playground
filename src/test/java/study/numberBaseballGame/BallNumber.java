package study.numberBaseballGame;

import org.junit.jupiter.api.Test;

public class BallNumber {
    private static final int MIN_NO = 1;
    private static final int MAX_NO = 9;

    private int no;

    public BallNumber(int no) {
        if (no < MIN_NO || no > MAX_NO) {
            throw new IllegalStateException("볼 숫자는 1부터 9의 값이어야 합니다.");
        }
        this.no = no;
    }

    public int getNo() {
        return no;
    }
}
