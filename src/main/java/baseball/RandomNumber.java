package baseball;

import java.util.ArrayList;

import nextstep.utils.Randoms;

public class RandomNumber {

	public static final int DEFAULT_LENGTH = 3;

	public static ArrayList<String> answer;
	public static int answerLength;

	public RandomNumber() {
		this(DEFAULT_LENGTH);
	}

	public RandomNumber(int numLength) {
		answer = new ArrayList();
		answerLength = numLength;

		for (int i = 0; i < numLength; i++) {
			String num = getRandomNum();
			answer.add(num);
		}
	}

	private String getRandomNum() {
		String num = String.valueOf(Randoms.pickNumberInRange(1, 9));

		if (answer.contains(num)) {
			return getRandomNum();
		}

		return num;
	}
}
