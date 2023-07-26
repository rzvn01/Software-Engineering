package lab7;

import java.util.Comparator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Cacu Razvan GR-2023
 * Write a class named Student that has the private fields name, group, average_mark, and getter / setter methods for
 * all the attributes. In the main() method, placed in another class, create a sortedSet collection, with Student type objects,
 * initialized with values read from the keyboard, that will keep the elements in descending order by average_mark and in
 * ascending order by name (the students that have the same average will appear in alphabetic order). Browse the
 * collection using for-loop and display all the items. Then browse the collection with an iterator and display all students
 * with average_mark> = 8. Browse the collection with forEach () and display all student data in a particular group.
 */

class Student {
    private String name;
    private String group;
    private double average_mark;

    public Student(String name, String group, double average_mark) {
        this.name = name;
        this.group = group;
        this.average_mark = average_mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getAverageMark() {
        return average_mark;
    }

    public void setAverageMark(double average_mark) {
        this.average_mark = average_mark;
    }
}

public class Lab7Prb5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Comparator<Student> studentComparator = Comparator
                .comparingDouble(Student::getAverageMark).reversed()
                .thenComparing(Student::getName);

        SortedSet<Student> students = new TreeSet<>(studentComparator);
        String response;

        do {
            System.out.println("Enter student name:");
            String name = scanner.nextLine();
            System.out.println("Enter student group:");
            String group = scanner.nextLine();
            System.out.println("Enter student average mark:");
            double averageMark = scanner.nextDouble();
            scanner.nextLine();

            students.add(new Student(name, group, averageMark));
            System.out.println("Do you want to add another student ? (yes/no)");
            response = scanner.nextLine();
        } while (!response.equalsIgnoreCase("no") && !response.equalsIgnoreCase("n"));


        System.out.println("All students:");
        for (Student student : students) {
            System.out.println(student.getName() + " " + student.getGroup() + " " + student.getAverageMark());
        }

        System.out.println("Students with average_mark >= 8:");
        for (Student student : students) {
            if (student.getAverageMark() >= 8) {
                System.out.println(student.getName() + " " + student.getGroup() + " " + student.getAverageMark());
            }
        }

        System.out.println("Enter the group to display its students:");
        String group = scanner.nextLine();
        System.out.println("Students in group " + group + ":");

        students.forEach(student -> {
            if (student.getGroup().equals(group)) {
                System.out.println(student.getName() + " " + student.getGroup() + " " + student.getAverageMark());
            }
        });
    }
}
