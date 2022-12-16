package baseball.view;

import baseball.model.Judgements;
import baseball.model.Numbers;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class View {

    private final JudgementsToTextConverter converter = new JudgementsToTextConverter();
    private final Scanner scanner;
    private final PrintStream printStream;

    public View(PrintStream printStream, InputStream inputStream) {
        this.printStream = printStream;
        this.scanner = new Scanner(inputStream);
    }

    public Numbers inputNumbers() {
        printStream.println("숫자를 입력하세요 : ");
        String inputNumbersText = scanner.next();
        return Numbers.from(inputNumbersText);
    }

    public Command inputCommand() {
        printStream.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int command = scanner.nextInt();
        return Command.valueOf(command);
    }

    public void printJudgements(Judgements judgements) {
        String text = converter.convert(judgements);
        printStream.println(text);
    }
}
