package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class GameManager {
    public static int [] ans = new int [3];

    public static void generateNumber(){
        StringBuilder sb = new StringBuilder();
        int num1 = Randoms.pickNumberInRange(1,9);
        sb.append(num1);
        while(sb.length() != 3) sb.append(getUniqueNumber(sb.toString()));
        String answerNum = sb.toString();
        ans[0] = answerNum.charAt(0) - '0';
        ans[1] = answerNum.charAt(1) - '0';
        ans[2] = answerNum.charAt(2) - '0';
    }

    private static int getUniqueNumber(String param) {
        int num;
        for(num = Randoms.pickNumberInRange(1,9); !param.contains(String.valueOf(num));){
            return num;
        }
        return 0;
    }

    public static int[] getInput() {
        String intputNum = Console.readLine();
        if (intputNum.length() != 3) {
            throw new IllegalArgumentException();
        }

        try {
            Integer.parseInt(intputNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return new int[]{
                intputNum.charAt(0) - '0',
                intputNum.charAt(1) - '0',
                intputNum.charAt(2) - '0'
        };
    }

    public static boolean checkNextGame() {
        String inputString = Console.readLine();
        if (inputString.contentEquals("1")) {
            return true;
        } else if (inputString.contentEquals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    public static boolean is3Out(int[] inputNumber) {
        return calcStrike(inputNumber) == 3;
    }

    public static int calcStrike(int [] inputNumber){
        int strikeCount = 0;
        if (ans[0] == inputNumber[0]) strikeCount++;
        if (ans[1] == inputNumber[1]) strikeCount++;
        if (ans[2] == inputNumber[2]) strikeCount++;
        return strikeCount;
    }

    public static int calcBallet(int [] inputNumber) {
        int ballCount = 0;
        if (ans[1] == inputNumber[0] || ans[2] == inputNumber[0]) ballCount++;
        if (ans[0] == inputNumber[1] || ans[2] == inputNumber[1]) ballCount++;
        if (ans[0] == inputNumber[2] || ans[1] == inputNumber[2]) ballCount++;
        return ballCount;
    }


    public static void calcResult(int[] inputNumber) {
        int strikeCount = calcStrike(inputNumber);
        int ballCount = calcBallet(inputNumber);
        StringBuilder printString = new StringBuilder();

        if (ballCount > 0) printString.append(ballCount + "볼 ");
        if (strikeCount > 0) printString.append(strikeCount + "스트라이크");
        if (ballCount == 0 && strikeCount == 0) printString.append("낫싱");
        System.out.println(printString);
    }
}
