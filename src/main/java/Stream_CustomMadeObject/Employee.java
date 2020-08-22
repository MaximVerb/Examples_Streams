package Stream_CustomMadeObject;

public class Employee {
    private String firstname;
    private String lastName;
    private double salary;
    private String department;

    public Employee(String firstname, String lastName, double salary, String department) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return String.format("%s %s", getFirstname(), getLastName());
    }

    @Override
    public String toString() {
        return String.format("%-8s %-8s %8.2f   %s",getFirstname(),getLastName(),getSalary(),getDepartment());
    }
}
