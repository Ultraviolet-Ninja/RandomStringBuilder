package random;

import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;

public class Main {
    private static final Supplier<RandomStringBuilder> GENERATE_SERIAL_CODE = () ->
            new RandomStringBuilder().appendRandomLetter("ABCDEFGHIJKLMNOPQRSTUVWXYZ0987654312", 2)
                    .appendRandomNumbers(0, 9, 1)
                    .appendRandomChars('A', 'Z', 2)
                    .appendRandomNumbers(0, 9, 1);

    public static void main(String[] args) {
        Set<RandomStringBuilder> collect = IntStream.range(0, 1500000)
                .parallel()
                .mapToObj(num -> GENERATE_SERIAL_CODE.get())
                .collect(toSet());
        System.out.println(collect);
        System.out.println(collect.size());
    }
}
