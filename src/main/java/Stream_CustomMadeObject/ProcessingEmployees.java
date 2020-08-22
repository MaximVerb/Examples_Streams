package Stream_CustomMadeObject;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ProcessingEmployees {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Ashley", "Green", 7600, "IT"),
                new Employee("Jason", "Red", 5000, "IT"),
                new Employee("Matthew", "Indigo", 3587.5, "Sales"),
                new Employee("James", "Indigo", 4700.77, "Marketing"),
                new Employee("Luke", "Lucky", 6200, "IT"),
                new Employee("Jason", "Born", 10_000, "Marketing")};

        //get List view of the employees
        List<Employee> list = Arrays.asList(employees);

        //display all employees
        System.out.println("Complete employee list: ");
        list.stream().forEach(System.out::println);

        Predicate<Employee> fourToSixthousand = e -> (e.getSalary() >= 4000 && e.getSalary() <= 6000);
        //we hebben hiermee een variabele aangemaakt via een lambda

        //geef alle werknemers weer die tussen de 4000 en 6000 verdienen en in oplopende volgorde
        System.out.printf("%nWerknemers die tussen de 4000-6000 verdienen per maand:%n");
        list.stream()
                .filter(fourToSixthousand)
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .forEach(System.out::println);

        //geef de eerste werknemer weer met een salaris tussen de 4000 en 6000
        System.out.printf("%nDe eerste werknemer die tussen de 4000 en 6000 euro heeft verdient:%n%s%n",
                list.stream()
                    .filter(fourToSixthousand)
                    .findFirst() //geeft één object terug, zie onderstaande code (zelfde voor findAny)
                    .get());

        Employee employee = list.stream()
                                .findFirst()
                                .get();

        System.out.printf("%nIf we take one employee from the stream: %n%s%n",employee);


    }
}
