package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class CheckInputValue {
	String inputValue;

	public CheckInputValue(String inputValue) {
		this.inputValue = inputValue;
	}

	public boolean checkValidation() {
		boolean result = Pattern.matches("^[1-9]{" + RandomNumber.answerLength + "}$", inputValue);

		if (!result) {
			printErrorMessage(RandomNumber.answerLength + "자리 숫자[1-9]를 입력해주세요.");
		}

		return result;
	}

	public boolean checkDuplication() {
		Set<String> numSet = new HashSet<String>();
		ArrayList<String> inputNumList = new ArrayList<>(Arrays.asList(inputValue.split("")));

		for (String s : inputNumList) {
			numSet.add(s);
		}

		if (numSet.size() < RandomNumber.answerLength) {
			printErrorMessage("숫자는 중복될 수 없습니다.");
			return true;
		}

		return false;
	}

	public void printErrorMessage(String msg) {
		System.out.println("[ERROR] " + msg);
	}

}
