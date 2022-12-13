package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RefereeTest {

    @DisplayName("낫싱으로 판결한다.")
    @Test
    void judgeNothing() {
        Numbers rightNumbers = new Numbers("123");
        Numbers inputNumbers = new Numbers("456");
        Referee referee = new Referee(rightNumbers);

        Judgements actual = referee.judge(inputNumbers);

        assertThat(actual).isEqualTo(new Judgements(0, 0));
    }

    @DisplayName("1스트라이크로 판결한다.")
    @ParameterizedTest
    @CsvSource({"123, 145", "123, 425", "123, 453"})
    void judgeOneStrike(String rightNumbersText, String inputNumbersText) {
        Numbers rightNumbers = new Numbers(rightNumbersText);
        Numbers inputNumbers = new Numbers(inputNumbersText);
        Referee referee = new Referee(rightNumbers);

        Judgements actual = referee.judge(inputNumbers);

        assertThat(actual).isEqualTo(new Judgements(1, 0));
    }

    @DisplayName("2스트라이크로 판결한다.")
    @ParameterizedTest
    @CsvSource({"123, 124", "456, 156", "789, 759"})
    void judgeTwoStrike(String rightNumbersText, String inputNumbersText) {
        Numbers rightNumbers = new Numbers(rightNumbersText);
        Numbers inputNumbers = new Numbers(inputNumbersText);
        Referee referee = new Referee(rightNumbers);

        Judgements actual = referee.judge(inputNumbers);

        assertThat(actual).isEqualTo(new Judgements(2, 0));
    }

    @DisplayName("1볼로 판결한다.")
    @ParameterizedTest
    @CsvSource({"123, 415", "123, 451", "123, 245", "123, 452", "123, 345", "123, 435"})
    void judgeOneBall(String rightNumbersText, String inputNumbersText) {
        Numbers rightNumbers = new Numbers(rightNumbersText);
        Numbers inputNumbers = new Numbers(inputNumbersText);
        Referee referee = new Referee(rightNumbers);

        Judgements actual = referee.judge(inputNumbers);

        assertThat(actual).isEqualTo(new Judgements(0, 1));
    }

    @DisplayName("2볼로 판결한다.")
    @ParameterizedTest
    @CsvSource({"123, 215", "123, 251"})
    void judgeTwoBall(String rightNumbersText, String inputNumbersText) {
        Numbers rightNumbers = new Numbers(rightNumbersText);
        Numbers inputNumbers = new Numbers(inputNumbersText);
        Referee referee = new Referee(rightNumbers);

        Judgements actual = referee.judge(inputNumbers);

        assertThat(actual).isEqualTo(new Judgements(0, 2));
    }

    @DisplayName("3볼로 판결한다.")
    @Test
    void judgeThreeBall() {
        Numbers rightNumbers = new Numbers("123");
        Numbers inputNumbers = new Numbers("312");
        Referee referee = new Referee(rightNumbers);

        Judgements actual = referee.judge(inputNumbers);

        assertThat(actual).isEqualTo(new Judgements(0, 3));
    }

    @DisplayName("1스트라이크 2볼로 판결한다.")
    @ParameterizedTest
    @CsvSource({"123, 132", "456, 654", "789, 879"})
    void judgeTwoBallAndOneStrike(String rightNumbersText, String inputNumbersText) {
        Numbers rightNumbers = new Numbers(rightNumbersText);
        Numbers inputNumbers = new Numbers(inputNumbersText);
        Referee referee = new Referee(rightNumbers);

        Judgements actual = referee.judge(inputNumbers);

        assertThat(actual).isEqualTo(new Judgements(1, 2));
    }

    @DisplayName("3스트라이크로 판결한다.")
    @Test
    void judgeThreeStrike() {
        Numbers rightNumbers = new Numbers("123");
        Numbers inputNumbers = new Numbers("123");
        Referee referee = new Referee(rightNumbers);

        Judgements actual = referee.judge(inputNumbers);

        assertThat(actual).isEqualTo(new Judgements(3, 0));
    }
}
