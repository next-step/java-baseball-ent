package baseball;

import baseball.game.GameService;

public class Main {
    public static void main(String[] args) {
        GameService gameService = new GameService();
        gameService.start();
    }
}
