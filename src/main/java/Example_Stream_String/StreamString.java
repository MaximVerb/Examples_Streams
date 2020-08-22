package Example_Stream_String;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StreamString {
    public static void main(String[] args) {
        String[] colors = {"rood","oranje","geel","groen","Blauw","Indigo","Violet"};

        //display original strings
        System.out.printf("Original Strings: %s%n", Arrays.asList(colors));

        //Strings in uppercase
        System.out.printf("Strings in uppercase: %s%n",
                Arrays.stream(colors)
                    .map(String::toUpperCase)
                    .collect(Collectors.toList()));

        //Strings less than "n" (case insensitive) sorted ascending
        System.out.printf("Strings less than n sorted ascending: %s%n",
                Arrays.stream(colors)
                    .filter(x -> x.compareToIgnoreCase("n") < 0)
                    .sorted(String.CASE_INSENSITIVE_ORDER)
                    .collect(Collectors.toList()));

        //Strings less than "n" (case insensitive) sorted descending
        System.out.printf("Strings less than n sorted ascending: %s%n",
                Arrays.stream(colors)
                        .filter(x -> x.compareToIgnoreCase("n") < 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                        .collect(Collectors.toList()));
    }
}
