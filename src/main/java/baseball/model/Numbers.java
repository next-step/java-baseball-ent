package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Numbers implements Iterable<Number> {

    private static final int SIZE = 3;

    private final List<Number> value;

    private Numbers(List<Number> numbers) {
        this.value = numbers;
    }

    public static Numbers from(String numbers) {
        if (!consistByNumbersOfSpecificSize(numbers) || hasDuplicatedNumber(numbers)) {
            String message = "[입력값 : %s] 중복이 없는 %d자리 숫자만 가능합니다.";
            throw new IllegalArgumentException(String.format(message, numbers, SIZE));
        }
        return new Numbers(collectToList(numbers));
    }

    private static boolean consistByNumbersOfSpecificSize(String numbers) {
        String regex = "[1-9]{%d}";
        return numbers.matches(String.format(regex, SIZE));
    }

    private static boolean hasDuplicatedNumber(String numbers) {
        Set<Character> set = new HashSet<>();
        for (char ch : numbers.toCharArray()) {
            set.add(ch);
        }
        return set.size() != SIZE;
    }

    private static List<Number> collectToList(String numbers) {
        List<Number> value = new ArrayList<>();
        for (int i = 0; i < numbers.length(); i++) {
            value.add(new Number(numbers.charAt(i), i));
        }
        return value;
    }

    @Override
    public Iterator<Number> iterator() {
        return value.iterator();
    }
}
