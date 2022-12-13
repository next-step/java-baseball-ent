package baseball;

import baseball.model.NumbersGenerator;
import baseball.model.RandomNumbersGenerator;
import baseball.view.View;

public class Application {

    public static void main(String[] args) {
        View view = new View(System.out, System.in);
        NumbersGenerator numbersGenerator = new RandomNumbersGenerator();
        BaseBallGame game = new BaseBallGame(view, numbersGenerator);
        game.run();
    }
}
