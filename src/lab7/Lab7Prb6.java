package lab7;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Cacu Razvan GR-2023
 * Write an Employee class with the private fields name, age, salary and getter / setter methods for the fields. In the
 * main () method, placed in another class, create a list of Employee type objects, initialized with values read from the
 * keyboard. Sort the list in:
 * - ascending order by name, using the Comparable interface
 * - descending order by age, using the Comparable interface and a lambda expression
 * - ascending order by name and descending order by salary, using the Comparator interface
 */

class Employee implements Comparable<Employee> {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee other) {
        return this.name.compareTo(other.name);
    }
}

public class Lab7Prb6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        String response;

        do {
            System.out.println("Enter employee name:");
            String name = scanner.nextLine();
            System.out.println("Enter employee age:");
            int age = scanner.nextInt();
            System.out.println("Enter employee salary:");
            double salary = scanner.nextDouble();
            scanner.nextLine();

            employees.add(new Employee(name, age, salary));
            System.out.println("Do you want to add another employee ? (yes/no)");
            response = scanner.nextLine();

        } while (!response.equalsIgnoreCase("no") && !response.equalsIgnoreCase("n"));


        Collections.sort(employees);
        System.out.println("Sorted ascending by name:");
        employees.forEach(emp -> System.out.println(emp.getName()));

        employees.sort((e1, e2) -> e2.getAge() - e1.getAge());
        System.out.println("Sorted descending by age:");
        employees.forEach(emp -> System.out.println(emp.getName() + "\t" + emp.getAge()));

        Comparator<Employee> nameSalaryComparator = Comparator
                .comparing(Employee::getName)
                .thenComparing(Employee::getSalary, Comparator.reverseOrder());

        employees.sort(nameSalaryComparator);
        System.out.println("\nSorted ascending by name and descending by salary :");
        employees.forEach(emp -> System.out.println(emp.getName() + "\t" + emp.getSalary()));
    }
}