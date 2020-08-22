package Examples_IntStream.Example_Collector_ToList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysAndStreams {
    public static void main(String[] args) {
        Integer[] values = { 5,10,15,20,25,30, 1, 2, 3, 4 };

        //display original values
        System.out.printf("Original values: %s%n", Arrays.asList(values));

        //sort values in ascending order
        System.out.printf("Values in ascending order: %s%n",
                Arrays.stream(values)
                    .sorted()
                    .collect(Collectors.toList()));

        //values greater than 4
        List<Integer> greater4 =
                Arrays.stream(values)
                    .filter(x -> x > 4)
                    .collect(Collectors.toList());
        System.out.printf("Values greater than 4: %s%n", greater4);

        //filter values greater than 4 and then sort results
        System.out.printf("Sorted values greater than 4: %s%n",
                Arrays.stream(values)
                    .filter(x -> x > 4)
                    .sorted()
                    .collect(Collectors.toList()));
    }
}
