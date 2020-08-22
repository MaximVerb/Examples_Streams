package Examples_IntStream.Example_Element_By_Element;

import java.util.stream.IntStream;

public class ElementPerElement {
    public static void main(String[] args) {
        IntStream.rangeClosed(1,10)
                .filter(
                        x -> {
                    System.out.printf("%nfilter: %d%n", x);
                    return x % 2 == 0;
                })
                .map(
                        x -> {
                            System.out.println("map " + x);
                            return x * 3;
                        })
                .sum();
    }
}
