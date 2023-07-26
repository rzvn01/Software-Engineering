package lab4;

import java.util.Scanner;

/**
 * Cacu Razvan GR-2023
 * Develop a Java program which defines a class named Person that contains as private attributes: name
 * (String), latitude and longitude (float). The class contains an explicit constructor without parameters that
 * will initialize the latitude and longitude with 0 and the string with null. A finalize() method will be used
 * as a destructor from C++ and will display a message. The mutator methods, setName(), setLongitude() and
 * setLatitude() will be defined to modify the attributes of the class. Define appropriate accessor methods.
 * Instantiate n objects, read the corresponding data from the keyboard and display the information related to all
 * the objects
 */


class Person {
    private String name;
    private float latitude;
    private float longitude;

    public Person() {
        this.name = null;
        this.latitude = 0;
        this.longitude = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("The method finalize was called ! ");

    }
}

public class Lab4Prb4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        do {
            System.out.println("Please enter the number of people  ");
            n = scanner.nextInt();
        }
        while (n <= 0);

        Person[] people = new Person[n];

        for (int i = 0; i < n; i++) {
            people[i] = new Person();
            System.out.println("Name : ");
            String name = scanner.next();
            people[i].setName(name);
            System.out.println("Latitude : ");
            float latitude = scanner.nextFloat();
            people[i].setLatitude(latitude);
            System.out.println("Longitude : ");
            float longitude = scanner.nextFloat();
            people[i].setLongitude(longitude);
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\nPerson : ");
            System.out.println("Name : " + people[i].getName());
            System.out.println("Latitude : " + people[i].getLatitude());
            System.out.println("Longitude : " + people[i].getLongitude());
            try {
                people[i].finalize();
            } catch (Throwable e) {
                System.out.println("Could not call method finalize");
            }
        }

    }
}
