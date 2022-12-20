import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {
    List<Integer> numbers;

    Computer() {
        this.numbers = generateNumberList();
    }

    private void calculate(List<Integer> input) {
        Result result = new Result();
        calculateStrike(input, result);
        calculateBall(input, result);
    }

    private void calculateBall(List<Integer> input, Result result) {
        input.retainAll(numbers);
        result.addBall(input.size());
    }

    private void calculateStrike(List<Integer> input, Result result) {
        for(int i = 0 ; i < numbers.size() ; i++) {
            addValueIfIsStrike(input, result, i);
        }
    }

    private void addValueIfIsStrike(List<Integer> input, Result result, int i) {
        if(numbers.get(i).equals(input.get(i))) {
            result.addStrike();
        }
    }

    private List<Integer> generateNumberList() {
        List<Integer> numberList = new ArrayList<>();
        for(int i = 1 ; i <= 9 ; i++) {
            numberList.add(i);
        }
        Collections.shuffle(numberList);
        return numberList.subList(0, 3);
    }
}
