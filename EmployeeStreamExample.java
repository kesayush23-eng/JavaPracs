import java.util.*;
        import java.util.stream.*;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }
}

public class EmployeeStreamExample {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", 40000),
                new Employee(2, "Bob", 60000),
                new Employee(3, "Charlie", 80000),
                new Employee(4, "David", 30000),
                new Employee(5, "Eve", 100000),
                new Employee( 6,"John",50000)
        );



        List<Employee> filtered = employees.stream()
                .filter(e -> e.getSalary() > 50000)
                .collect(Collectors.toList());

        System.out.println("Employees with salary > 500000:");
        filtered.forEach(System.out::println);

        List<Employee> sorted = filtered.stream()
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .collect(Collectors.toList());

        System.out.println("\nEmployees sorted by salary:");
        sorted.forEach(System.out::println);

        Employee highestPaid = sorted.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);

        System.out.println("\nHighest paid employee:");
        System.out.println(highestPaid);
    }
}
