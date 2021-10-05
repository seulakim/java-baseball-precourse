package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberTest {

	RandomNumber randomNum;

	@BeforeEach
	void setUp() {
		randomNum = new RandomNumber();
	}

	@DisplayName("랜덤 숫자 길이 유효성검사")
	@Test
	void validate() {
		assertEquals(randomNum.answer.size(), randomNum.answerLength);
	}
	
	@DisplayName("랜덤 숫자 중복 유효성검사")
	@Test
	void duplicate() {
		Set<String> numSet = new HashSet<String>();

		for (String s : randomNum.answer) {
			numSet.add(s);
		}

		assertEquals(numSet.size(), randomNum.answerLength);
	}
}
