package Stream_CustomMadeObject;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        //we hebben hiermee een variabele aangemaakt via een (één-paramater) lambda
        Lines();

        //geef alle werknemers weer die tussen de 4000 en 6000 verdienen en in oplopende volgorde
        System.out.printf("%nWerknemers die tussen de 4000-6000 verdienen per maand:%n");
        list.stream()
                .filter(fourToSixthousand)
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .forEach(System.out::println);
        Lines();

        //geef de eerste werknemer weer met een salaris tussen de 4000 en 6000
        System.out.printf("%nDe eerste werknemer die tussen de 4000 en 6000 euro heeft verdient:%n%s%n",
                list.stream()
                        .filter(fourToSixthousand)
                        .findFirst() //geeft één object terug, zie onderstaande code (zelfde voor findAny)
                        .get());
        Lines();

        Employee employee1 = list.stream()
                .findFirst()
                .get();

        System.out.printf("%nIf we take one employee from the stream: %n%s%n", employee1);
        Lines();

        Function<Employee, String> byFirstName = Employee::getFirstname;
        Function<Employee, String> byLastName = Employee::getLastName;

        //Het aanmaken van de comparator, eerst zal er vergeleken worden op de achternaam en daarna de voornaam
        Comparator<Employee> firstThenLast = Comparator.comparing(byLastName).thenComparing(byFirstName);

        System.out.printf("%nEmployees in ascending order by last name and then by first: %n");
        list.stream()
                .sorted(firstThenLast)
                .forEach(System.out::println);
        Lines();

        //display unique employee last names
        System.out.printf("%nUnique employee last names %n%n");
        list.stream()
                .map(Employee::getLastName)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        Lines();

        //display only first and last names
        System.out.printf("%nEmployee names in order of last name and then first name%n");
        list.stream()
                .sorted(firstThenLast)
                .map(Employee::getName)
                .forEach(System.out::println);
        Lines();

        //how to group employees
        System.out.printf("%nEmployees grouped by department: %n");
        Map<String, List<Employee>> groupedByDep =
                list.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment));
        groupedByDep.forEach(
                (department, employeesInDepartment) -> {
                    System.out.printf("%n%s%n", department);
                    employeesInDepartment.forEach(
                            employee -> System.out.printf(" %s%n", employee));
                }
        );

        Lines();

        //counting numbers of employees in each department
        System.out.printf("%nCount of employees by department: %n");
        Map<String, Long> countByDep =
                list.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        countByDep.forEach(
                (dep, count) -> System.out.printf("%s has %d employee(s)%n", dep, count));

        Lines();

        //sum of Employee salaries with DoubleStream method
        System.out.printf("%nSum of Employees' salaries (via sum method): %.2f%n",
                list.stream()
                        .mapToDouble(Employee::getSalary)
                        .sum());

        //calculate sum of Employee salaries with Stream reduce method
        System.out.printf("Sum of employees' salaties (via reduce method): %.2f%n",
                list.stream()
                        .mapToDouble(Employee::getSalary)
                        .reduce(0, (x, y) -> x + y));

        //average of Employee salaries with DoubleStream average method
        System.out.printf("Average of employee salaries: %.2f%n",
                list.stream()
                        .mapToDouble(Employee::getSalary)
                        .average()
                        .getAsDouble());


    }

    public static void Lines() {
        for (int i = 1; i <= 2; i++) {
            System.out.print("------------------------------------------");
        }
    }
}
