package Examples_IntStream.Example_IntStream_Sum;

import java.util.stream.IntStream;

public class IntStream_Sum {
    public static void main(String[] args) {
        int total = 0;

        for (int i = 1; i <= 10; i++) {
            total += i;
        }
        System.out.println("Using the normal iteration: " + total);

        //bovenstaande is basis-Java en is vatbaarder voor fouten, bijvoorbeeld, is je controlevariabele (i) wel in orde,
        //wanneer houdt de lus op, ..... vandaar zijn streams beter

        System.out.printf("Sum of 1 through 10 is: %d%n",
                IntStream.rangeClosed(1,10)
                .sum());

        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        System.out.printf("Sum of 1 through 10 using reduce: %d%n",
                IntStream.of(arr)
                .reduce(0,(x,y) -> x + y));

        //Eigenlijk is sum() een gespecialiseerde vorm van reduce. De 0 is de identifier value, lang verhaal kort,
        //eerst gaat men 0 + 1 doen, vervolgens 1 + 2, vervolgens 3 + 3, enz. uiteindelijk komt dit dan neer op
        //de som van 1 tot 10
    }
}
