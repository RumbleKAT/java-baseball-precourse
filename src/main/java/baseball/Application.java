package baseball;

import static baseball.GameManager.*;

public class Application {

    public static boolean play() throws IllegalArgumentException {
        generateNumber();
        while (true) {
            int[] userInput = getInput();
            calcResult(userInput);
            if (is3Out(userInput)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return checkNextGame();
            }
        }
    }

    public static void main(String[] args) throws IllegalArgumentException {
        while (play()) {}
    }
}
