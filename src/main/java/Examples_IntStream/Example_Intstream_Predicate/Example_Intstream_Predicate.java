package Examples_IntStream.Example_Intstream_Predicate;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Example_Intstream_Predicate {
    public static void main(String[] args) {
        IntPredicate even = value -> value % 2 == 0;
        IntPredicate greaterThen5 = value -> value > 5;

        IntStream.rangeClosed(1,20)
                .filter(even.and(greaterThen5))
                .forEach(System.out::println);
    }
}
