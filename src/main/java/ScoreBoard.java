import java.util.HashMap;

public class ScoreBoard {
    private Answer answer;
    private HashMap<Integer, Integer> input; // 전역 변수 선언보다 좋은 방법이 있는지 고민해보자.
    private int strike = 0;
    private int ball = 0;
    private int nothing = 0;
    
    public ScoreBoard() {
        this.answer = new Answer();
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public int getNothing() {
        return nothing;
    }

    public Answer getAnswer() {
        return this.answer;
    }

    /*
     * 정답 숫자 재설정, 카운트 초기화. 게임 재시작시 사용.
     */
    public void reset() {
        answer.resetAnswer();
        clearCount();
    }

    /*
     * 유저 입력값에 대해 채점 진행
     */
    public void checkScore(HashMap<Integer, Integer> userInput) {
        clearCount();
        input = userInput;
        for (Integer i : userInput.keySet()) {
            checkNumber(i);
        }
    }

    /*
     * 채점 결과 터미널에 출력
     */
    public void printScore() {
        String scoreStr = "";
        if (nothing == 3) {
            System.out.println("일치하는 숫자가 없습니다.");
            return;
        }
        if (strike != 0) {
            scoreStr += strike + " 스트라이크 ";
        }
        if (ball != 0) {
            scoreStr += ball + " 볼 ";
        }
        System.out.println(scoreStr);
    }

    /*
     * 하나의 숫자에 대해 채점
     */
    private void checkNumber(int num) {
        if (answer.contains(num)) {
            checkStrikeOrBall(num);
            return;
        }
        nothing++;
    }

    /*
     * 정답에 포함된 숫자에 대해 스트라이크인지 볼인지 확인 후 결과 기록
     */
    private void checkStrikeOrBall(int num) {
        if (answer.getIndex(num) == input.get(num)) {
            strike++;
            return;
        }
        ball++;
    }

    /*
     * 카운트를 초기화함. 유저의 다음 입력값을 새로 받기 위함임.
     */
    public void clearCount() {
        strike = 0;
        ball = 0;
        nothing = 0;
    }
}
