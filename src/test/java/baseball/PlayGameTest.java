package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PlayGameTest {

	RandomNumber randomNumber;
	ArrayList<String> answer;

	int strike;
	int ball;

	@BeforeEach
	void setUp() {
		randomNumber = new RandomNumber();
		answer = new ArrayList<>(Arrays.asList(new String[] {"9", "5", "8"}));
	}

	@DisplayName("게임 결과 계산")
	@ParameterizedTest
	@CsvSource(value = {"123:0:0", "369:0:1", "789:0:2", "985:1:2", "958:3:0"}, delimiter = ':')
	void validate(String inputValue, int expectedStrike, int expectedBall) {
		for (int i = 0; i < randomNumber.answerLength; i++) {
			checkAnswer(i, String.valueOf(inputValue.charAt(i)));
		}

		assertEquals(expectedStrike, strike);
		assertEquals(expectedBall, ball);

		init();
	}
	
	@DisplayName("정답시 게임 종료")
	@ParameterizedTest
	@CsvSource(value = {"0:false", "1:false", "2:false", "3:true"}, delimiter = ':')
	void duplicate(int strike, boolean expected) {
		assertEquals(expected, strike == randomNumber.answerLength);
	}

	private void init() {
		strike = 0;
		ball = 0;
	}

	private void checkAnswer(int i, String checkNum) {
		if (answer.get(i).equals(checkNum)) {
			strike++;
			return;
		}

		if (answer.contains(checkNum)) {
			ball++;
		}
	}
}
