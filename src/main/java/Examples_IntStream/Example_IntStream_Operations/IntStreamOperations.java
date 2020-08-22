package Examples_IntStream.Example_IntStream_Operations;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamOperations {
    public static void main(String[] args) {
        int[] values = {1, 5, 8, 9, 16, 15};

        //display original values
        System.out.println("original values: ");
        System.out.println(
                IntStream.of(values)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "))
        );

        //count, min, max, sum and average
        System.out.printf("%nCount: %d%n", IntStream.of(values).count());
        System.out.printf("Min: %d%n",
                IntStream.of(values)
                        .min()
                        .getAsInt());
        System.out.printf("Max: %d%n",
                IntStream.of(values)
                        .max()
                        .getAsInt()     //moest de stream leeg zijn, dan throwt dit een noSuchElementException
                                        //daarom best afronden met .orElse
        );
        System.out.printf("Sum: %d%n",
                IntStream.of(values)
                        .sum());
        System.out.printf("Average: %.2f%n",
                IntStream.of(values)
                        .average()
                        .getAsDouble()
        );

        System.out.println();
        //sum of values with reduce method
        System.out.printf("Sum via reduce method: %d%n",
                IntStream.of(values)
                        .reduce(0, (x,y) -> x + y));
        //hier gebruik je de reduce methode met 2 parameters, een identifier en de elementen

        //product of values with reduce method
        System.out.printf("Product via reduce method: %d%n",
                IntStream.of(values)
                        .reduce((x,y) -> x * y).getAsInt());
        //hetzelfde als reduce(1,(x,y) -> x * y).getAsInt()

        //de som van het kwadraat van alle elementen
        System.out.printf("Sum of squares via sum and map: %d%n%n",
                IntStream.of(values)
                        .map(x -> x * x)
                        .sum());

        //alle elementen van de stream in gesorteerde volgorde tonen
        System.out.printf("Values displayed in sorted order: %s%n",
                IntStream.of(values)
                        .sorted()  //want integer heeft een natuurlijke vergelijker (id est comparable)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")));
    }
}
