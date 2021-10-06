package baseball;

import nextstep.utils.Console;

public class PlayGame {

	public int strike;
	public int ball;

	public static String isPlay;

	public PlayGame() {
		init();
		getInput();
	}

	private void init() {
		strike = 0;
		ball = 0;
	}

	private void getInput() {
		System.out.print("숫자를 입력해주세요 : ");
		String inputNum = Console.readLine();

		if (!checkInput(inputNum)) {
			getInput();
		}
	}

	private boolean checkInput(String inputNum) {
		CheckInputValue checkVal = new CheckInputValue(inputNum);

		if (!checkVal.checkValidation() || checkVal.checkDuplication()) {
			return false;
		}

		for (int i = 0; i < RandomNumber.answerLength; i++) {
			checkAnswer(i, String.valueOf(inputNum.charAt(i)));
		}

		System.out.println(printAnswer());

		init();
		getInput();

		return true;
	}

	private void checkAnswer(int i, String checkNum) {
		if (RandomNumber.answer.get(i).equals(checkNum)) {
			strike++;
			return;
		}

		if (RandomNumber.answer.contains(checkNum)) {
			ball++;
		}
	}

	private String printAnswer() {
		if (strike > 0 && ball > 0) {
			return strike + "스트라이크 " + ball + "볼";
		}

		if (strike > 0) {
			return strike + "스트라이크";
		}

		if (ball > 0) {
			return ball + "볼";
		}

		return "낫싱";
	}
}
