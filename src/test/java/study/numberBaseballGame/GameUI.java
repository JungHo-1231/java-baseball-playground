package study.numberBaseballGame;

import numberBaseballGame.BaseballGame;

import java.util.Scanner;

public class GameUI {

    static boolean flag = true;
    static Scanner scanner = new Scanner(System.in);

    public void start() {
        numberBaseballGame.BaseballGame baseballGame = new BaseballGame();
        int[] answer = baseballGame.getAnswer();

        for (int i : answer) {
            System.out.println("i = " + i);
        }

        while (flag) {
            System.out.println("숫자를 입력해주세요.");
            String s = scanner.next();
            baseballGame.inputNumber(s);
            checkGameIsEnd(flag);
        }
    }

    private void checkGameIsEnd(boolean flag) {
        if (flag) {
            return;
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        checkGameRestart(scanner.nextInt());
    }

    private void checkGameRestart(int answer) {
        if (answer == 1) {
            flag = true;
            start();
        }

        if (answer == 2) {
            return;
        }
    }
}
