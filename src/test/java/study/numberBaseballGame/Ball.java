package study.numberBaseballGame;


public class Ball {
    private final int position;
    private final BallNumber ballNo;

    public Ball(int position, int ballNO) {
        this.position = position;
        this.ballNo = new BallNumber(ballNO);
    }

    public BallStatus play(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }

        if (ball.matchBallNo(ballNo.getNo())) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    private boolean matchBallNo(int ballNo) {
        return this.ballNo.getNo() == ballNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && ballNo == ball.ballNo;
    }

}