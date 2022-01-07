package numberBaseballGame;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static numberBaseballGame.GameUI.flag;

public class BaseballGame {

    private int[] answer;
    private int strikeCount;
    private int ballCount;

    public int[] getAnswer() {
        return answer;
    }

    public BaseballGame() {
        Random random = new Random();
        Set<Integer> tempSet = new HashSet<>();

        while (tempSet.size() != 3) {
            int randomNumber = random.nextInt(9);
            randomNumber++;
            tempSet.add(randomNumber);
        }
        answer = tempSet.stream().mapToInt(Integer::intValue).toArray();
    }


    public void inputNumber(String number) {
        checkValidNumber(number);
        checkAnswer(number);
    }

    private void checkAnswer(String number) {
        checkBall(number);
        checkStrike(number);
    }

    private void checkBall(String number) {
        String threeStrike = Arrays.toString(answer).replaceAll("[^0-9]", "");

        if (checkFirstDigitPlaceOfBall(number, threeStrike)) {
            ballCount++;
        }
        if (checkSecondDigitPlaceOfBall(number, threeStrike)) {
            ballCount++;
        }
        if (checkThreeDigitPlaceOfBall(number, threeStrike)) {
            ballCount++;
        }
        if (ballCount != 0) {
            System.out.printf("%d 볼 \n", ballCount);
        }

        ballCount = 0;
    }

    private boolean checkFirstDigitPlaceOfBall(String number, String threeStrike) {
        return answer[0] != Character.getNumericValue(number.charAt(0)) && threeStrike.contains(String.valueOf(number.charAt(0)));
    }

    private boolean checkSecondDigitPlaceOfBall(String number, String threeStrike) {
        return answer[1] != Character.getNumericValue(number.charAt(1)) && threeStrike.contains(String.valueOf(number.charAt(1)));
    }

    private boolean checkThreeDigitPlaceOfBall(String number, String threeStrike) {
        return answer[2] != Character.getNumericValue(number.charAt(2)) && threeStrike.contains(String.valueOf(number.charAt(2)));
    }

    private void checkStrike(String number) {
        if (answer[0] == Character.getNumericValue(number.charAt(0))) {
            strikeCount++;
        }
        if (answer[1] == Character.getNumericValue(number.charAt(1))) {
            strikeCount++;
        }
        if (answer[2] == Character.getNumericValue(number.charAt(2))) {
            strikeCount++;
        }

        if (strikeCount != 0) {
            System.out.printf("%d 스트라이크 \n", strikeCount);
        }

        if (strikeCount == 3) {
            System.out.println(" 3개의 숫자를 모두 맞히셨습니다! 게임 종료\n ");
            flag = false;
        }

        strikeCount = 0;
    }

    private void checkValidNumber(String input) {
        for (char c : input.toCharArray()) {
            checkValidNumberAsInteger(Character.getNumericValue(c));
        }
    }

    private void checkValidNumberAsInteger(int number) {
        if (number > 9 || number < 1) {
            throw new IllegalArgumentException("올바른 번호가 아닙니다");
        }
    }

}