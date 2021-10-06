package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CheckInputValueTest {

	RandomNumber randomNum;

	@BeforeEach
	void setUp() {
		randomNum = new RandomNumber();
	}

	@DisplayName("입력값 타입 및 길이검사")
	@ParameterizedTest
	@CsvSource(value = {"123:true", "369:true", "1234:false", "abc:false", "12ab:false", "가나다:false"}, delimiter = ':')
	void validate(String inputValue, boolean expected) {
		CheckInputValue checkInput = new CheckInputValue(inputValue);

		assertEquals(expected, checkInput.checkValidation());
	}
	
	@DisplayName("입력값 중복검사")
	@ParameterizedTest
	@CsvSource(value = {"123:false", "369:false", "111:true", "393:true", "667:true"}, delimiter = ':')
	void duplicate(String inputValue, boolean expected) {
		CheckInputValue checkInput = new CheckInputValue(inputValue);

		assertEquals(expected, checkInput.checkDuplication());
	}
}
