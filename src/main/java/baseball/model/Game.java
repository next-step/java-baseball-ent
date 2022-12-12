package baseball.model;

import baseball.controller.request.BaseballNumberRequest;
import baseball.controller.request.RestartRequest;
import baseball.controller.response.GameResponse;
import baseball.model.domain.BaseballNumber;
import baseball.model.domain.RandomBaseballNumberGenerator;
import baseball.model.domain.StrikeBallResult;

public class Game {

    private BaseballNumber targetBaseballNumber;
    private boolean isPlaying;

    public Game(BaseballNumber baseballNumber) {
        targetBaseballNumber = baseballNumber;
        isPlaying = true;
    }

    public GameResponse compare(BaseballNumberRequest baseballNumberRequest) {
        validateIsPlaying();
        int firstDigit = baseballNumberRequest.getFirstDigit();
        int secondDigit = baseballNumberRequest.getSecondDigit();
        int thirdDigit = baseballNumberRequest.getThirdDigit();
        BaseballNumber input = new BaseballNumber(firstDigit, secondDigit, thirdDigit);

        StrikeBallResult strikeBallResult = targetBaseballNumber.compare(input);
        if (strikeBallResult.isThreeStrike()) {
            isPlaying = false;
        }
        return GameResponse.of(strikeBallResult, isPlaying);
    }

    private void validateIsPlaying() {
        if (!isPlaying) {
            throw new IllegalStateException("Playing 상태가 아닙니다.");
        }
    }

    public void restart(RestartRequest restartRequest) {
        if (!restartRequest.isRestart()) {
            return;
        }
        if (isPlaying) {
            throw new IllegalArgumentException("Playing 중인 상태엔 재시작할 수 없습니다.");
        }
        targetBaseballNumber = RandomBaseballNumberGenerator.create();
        isPlaying = true;
    }

    public boolean isPlaying() {
        return isPlaying;
    }
}
