package util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static dto.GameStartOption.DELIMITER;

public class RandomIntegerMaker {

    public static final int MIN_HEIGHT_INDEX = 0;

    public static List<Integer> createRandomIntegers(Integer heights) {
        List<Integer> randoms = IntStream.range(MIN_HEIGHT_INDEX, heights)
                .mapToObj(Integer::new)
                .collect(Collectors.toList());
        Collections.shuffle(randoms);

        return randoms.stream()
                .limit(randInt(heights))
                .collect(Collectors.toList());
    }

    public static List<Integer> createRandomIntegersWithRestriction(Integer ladderHeight, List<Integer> restrictions) {
        List<Integer> randoms = createRandomIntegers(ladderHeight);
        return randoms.stream()
                .filter(i -> !restrictions.contains(i))
                .collect(Collectors.toList());
    }

    public static List<String> separateByDelimiter(String inputString) {
        String[] splitString = inputString.split(DELIMITER);
        return Arrays.asList(splitString);
    }

    public static Integer randInt(int bound) {
        return (int) (Math.random() * bound + 1);
    }
}
