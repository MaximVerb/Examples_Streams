package Examples_IntStream.Example_Intstream_Map;

import java.util.stream.IntStream;

public class Example_Map {
    public static void main(String[] args) {
        System.out.printf("This is an example summing all the products of 1 through 10 times 2: %d",
                IntStream.rangeClosed(1,10)
                        .map( x -> x * 2)
                        .sum());
        /*
        lees als volgt:
        1 * 2 = 2
        2 * 2 = 4
        3 * 2 = 6
        4 * 2 = 8
        5 * 2 = 10
        enz.
        en dan de som er van
         */
    }
}
