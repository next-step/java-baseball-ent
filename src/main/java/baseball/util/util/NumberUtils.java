package baseball.util.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NumberUtils {
    public static List<Integer> generateRandomUniqueIntegerList(int size, int min, int max) {
        List<Integer> numberList = new ArrayList<>();
        for(int i = min ; i <= max ; i++) {
            numberList.add(i);
        }
        Collections.shuffle(numberList, new Random(System.nanoTime()));
        return numberList.subList(0, size);
    }
}
