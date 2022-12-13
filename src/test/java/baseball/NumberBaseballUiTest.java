package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class NumberBaseballUiTest {

    @Test
    void readPlayerBaseballNumber_성공1() throws IOException {
        NumberBaseballUi numberBaseballUi = new NumberBaseballUi(new PlayerInputValidator());
        String input = "123";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(numberBaseballUi.readPlayerBaseballNumber()).containsExactly(1, 2, 3);
    }

    @Test
    void readPlayerBaseballNumber_성공2() throws IOException {
        NumberBaseballUi numberBaseballUi = new NumberBaseballUi(new PlayerInputValidator());
        String input = "468";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(numberBaseballUi.readPlayerBaseballNumber()).containsExactly(4, 6, 8);
    }

    @Test
    void readPlayerBaseballNumber_실패1() throws IOException {
        NumberBaseballUi numberBaseballUi = new NumberBaseballUi(new PlayerInputValidator());
        String input = "111\n123";
        String expectedOutput = "숫자를 입력해주세요: 잘못된 입력입니다. 다시 입력해주세요.\n숫자를 입력해주세요: ";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        assertThat(numberBaseballUi.readPlayerBaseballNumber()).containsExactly(1, 2, 3);
        assertThat(out.toString()).hasToString(expectedOutput);
    }

    @Test
    void readGameRestartInput_성공1() throws IOException {
        NumberBaseballUi numberBaseballUi = new NumberBaseballUi(new PlayerInputValidator());
        String input = "1";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(numberBaseballUi.readGameRestartInput()).isEqualTo(1);
    }

    @Test
    void readGameRestartInput_성공2() throws IOException {
        NumberBaseballUi numberBaseballUi = new NumberBaseballUi(new PlayerInputValidator());
        String input = "2";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(numberBaseballUi.readGameRestartInput()).isEqualTo(2);
    }

    @Test
    void readGameRestartInput_실패1() throws IOException {
        NumberBaseballUi numberBaseballUi = new NumberBaseballUi(new PlayerInputValidator());
        String input = "asd\n1";
        String expectedOutput = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n" +
                "잘못된 입력입니다. 다시 입력해주세요.\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        assertThat(numberBaseballUi.readGameRestartInput()).isEqualTo(1);
        assertThat(out.toString()).hasToString(expectedOutput);
    }
}