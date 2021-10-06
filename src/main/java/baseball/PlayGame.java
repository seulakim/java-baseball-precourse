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
		endGame();

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

	private boolean endGame() {
		if (strike == RandomNumber.answerLength) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
			restartGame();
			return false;
		}

		init();
		getInput();
		return true;
	}

	private void restartGame() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		isPlay = Console.readLine();

		if (!isPlay.equals(Application.PLAY_GAME) && !isPlay.equals(Application.QUIT_GAME)) {
			CheckInputValue checkVal = new CheckInputValue(isPlay);
			checkVal.printErrorMessage("1 또는 2를 입력해주세요.");
			restartGame();
		}
	}
}
