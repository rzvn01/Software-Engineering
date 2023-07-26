package lab7;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * Cacu Razvan GR-2023
 *Build an application which contains a generic class SetterGetter which allows the user to set() and get() the attribute
 * values for different types of objects. For example, given the classes Kid, Adult and Retired, enable the class to set and get
 * the names and ages of the associated objects. Create collections with unique entries of type Kid, Adult and Retired, and
 * which are populated with data read from the console. Print the read data using different methods.
 */
class SetterGetter<T> {
        public void set(String fieldName, T value, Object fieldValue) {
            try {
                Field field = value.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(value, fieldValue);
            } catch (Exception e) {
                System.out.println("Failed to set attribute: " + e.getMessage());
            }
        }

        public Object get(String fieldName, T value) {
            try {
                Field field = value.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                return field.get(value);
            } catch (Exception e) {
                System.out.println("Failed to get attribute: " + e.getMessage());
                return null;
            }
        }
    }

class Kid {
    private String name;
    private int age;

    public Kid(String name, int age) {
        this.name = name;
        this.age = age;
    }

}

class Adult {
    private String name;
    private int age;

    public Adult(String name, int age) {
        this.name = name;
        this.age = age;
    }

}

class Retired {
    private String name;
    private int age;

    public Retired(String name, int age) {
        this.name = name;
        this.age = age;
    }

}

public class Lab7Prb3 {
    private static final String NAME = "name";
    private static final String AGE = "age";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Collection<Kid> kidCollection = new HashSet<>();
        Collection<Adult> adultCollection = new HashSet<>();
        Collection<Retired> retiredCollection = new HashSet<>();

        SetterGetter<Kid> kidSetterGetter = new SetterGetter<>();
        SetterGetter<Adult> adultSetterGetter = new SetterGetter<>();
        SetterGetter<Retired> retiredSetterGetter = new SetterGetter<>();

        populateCollection(kidCollection, kidSetterGetter, scanner,Kid.class);
        populateCollection(adultCollection, adultSetterGetter, scanner,Adult.class);
        populateCollection(retiredCollection, retiredSetterGetter, scanner,Retired.class);

        System.out.println("Printing lab7.Kid Collection:");
        printCollection(kidCollection,kidSetterGetter);

        System.out.println("Printing lab7.Adult Collection:");
        printCollection(adultCollection,adultSetterGetter);

        System.out.println("Printing lab7.Retired Collection:");
        printCollection(retiredCollection,retiredSetterGetter);

    }

    public static <T> void populateCollection(Collection<T> collection, SetterGetter<T> setterGetter, Scanner scanner,Class<T> cls) {
        System.out.print("Enter number of objects to add to the collection: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume the new line character

        for (int i = 1; i <= count; i++) {
            try {
                System.out.printf("Enter details for object %d:%n", i);

                System.out.print("Enter name: ");
                String name = scanner.nextLine();

                System.out.print("Enter age: ");
                int age = scanner.nextInt();
                scanner.nextLine();

                T obj = cls.getConstructor(String.class, int.class).newInstance(null, -1);
                setterGetter.set(NAME,obj,name);
                setterGetter.set(AGE,obj,age);
                collection.add(obj);
            } catch (Exception e) {
                System.out.println("Failed to add object to collection: " + e.getMessage());
            }
        }
    }

        public static <T> void printCollection(Collection<T> collection, SetterGetter<T> setterGetter) {
            for (T obj : collection) {
                try {
                    System.out.println(setterGetter.get(NAME, obj) + ", " + setterGetter.get(AGE, obj));
                } catch (Exception e) {
                    System.out.println("Failed to print object: " + e.getMessage());
                }
            }
        }
    }

