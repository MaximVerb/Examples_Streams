package Examples_IntStream.Example_Methode_Reference;

import java.security.SecureRandom;
import java.util.stream.Collectors;

public class Methode_Reference {
    public static void main(String[] args) {
        SecureRandom randomNumbers = new SecureRandom();


        //display ten random integers on separate lines
        System.out.println("Random numbers on separate lines:");
        randomNumbers.ints(10,1,7)//maakt een stream van willekeurige getallen
                .forEach(System.out::println);

        //random numbers on one line
        String numbers =
                randomNumbers.ints(10,1,7)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.printf("Printing out 10 random numbers on one line: %s", numbers);
    }
}
