package Example_Stream_Integer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysAndStreams {
    public static void main(String[] args) {
        Integer[] values = {2, 9, 5, 0, 3, 7, 1, 4, 8, 6};

        //display original values
        System.out.printf("Original values: %s%n", Arrays.asList(values));

        //sort values in ascending order with streams
        System.out.printf("Sorted values: %s%n",
                Arrays.stream(values)
                        .sorted()
                        .collect(Collectors.toList()));

        //values greater than 4
        List<Integer> list4 =
                Arrays.stream(values)
                        .filter(x -> x > 4)
                        .collect(Collectors.toList());
        System.out.printf("Values greater than 4: %s%n", list4);

        //filter values greater than 4 and then sort them
        System.out.printf("Values greater than 4 and sorted : %s%n",
                Arrays.stream(values)
                        .filter(x -> x > 4)
                        .sorted()
                        .collect(Collectors.toList()));

        //list4 sorted
        System.out.printf("Values greater than 4 and sorted but from a list: %s%n",
                list4.stream()
                        .sorted()
                        .collect(Collectors.toList()));

    }
}
