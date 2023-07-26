package lab4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**Cacu Razvan GR-2023
 * Define a class named Student that has as private attributes the name, tel. number and average mark
 * (constructors, setters, getters).
 * In the main method create a uni-dimensional array of Student objects with the dimension specified by the user.
 * The data corresponding to each object is read from the keyboard, respecting the format name^^^tel.
 * number^^^average mark. If the data specific to the telephone number is not valid (10 numeric characters, with
 * or without special characters like blank, - or .), the user is asked to re-enter the entire array of characters.
 * Display the students ordered by name and by average mark
 */
class Student {
    private String name;
    private String phoneNumber;
    private double averageMark;

    public Student(String name, String phoneNumber, double averageMark) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.averageMark = averageMark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }


}

public class Lab4Prb9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            System.out.print("Enter number of students: ");
            n = scanner.nextInt();
        }
        while (n <= 0);

        Student[] students = readStudents(n);

        sortByName(students);
        sortByAverageMark(students);
    }

    public static void sortByName(Student[] students) {
        Arrays.sort(students, Comparator.comparing(Student::getName).thenComparingDouble(Student::getAverageMark));
        System.out.println("\n Students sorted by name:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void sortByAverageMark(Student[] students) {
        Arrays.sort(students, Comparator.comparingDouble((Student s) -> s.getAverageMark()).reversed());
        System.out.println("\n Students sorted by average mark:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static Student[] readStudents(int n) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter data for student " + (i + 1) + " (name^^^tel.number^^^average mark): ");
            String input = scanner.next();
            String[] parts = input.split("\\^\\^\\^");


            String telNumber = parts[1].replaceAll("\\D", "");
            if (telNumber.length() != 10) {
                System.out.println("Invalid telephone number, please try again.");
                i--;
                continue;
            }

            students[i] = new Student(parts[0], telNumber, Double.parseDouble(parts[2]));
        }
        return students;
    }

}