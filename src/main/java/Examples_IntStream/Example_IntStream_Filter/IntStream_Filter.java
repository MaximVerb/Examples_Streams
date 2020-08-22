package Examples_IntStream.Example_IntStream_Filter;

import java.util.stream.IntStream;

public class IntStream_Filter {
    public static void main(String[] args) {
        System.out.printf("De som van enkel de getallen deelbaar door 2: %d",
                IntStream.rangeClosed(1,10)
                        .filter(x -> x % 2 == 0)
                        .sum());
    }
}
