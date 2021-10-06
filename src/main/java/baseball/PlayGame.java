package baseball;

import nextstep.utils.Console;

public class PlayGame {

	public int strike;
	public int ball;

	public static String isPlay;

	public PlayGame() {
		getInput();
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

		return true;
	}
}
