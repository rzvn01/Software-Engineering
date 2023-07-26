package lab6.dbInteraction;
/*
  Cacu Razvan GR-2023
  Consider a package of classes and interfaces called lab6.dbInteraction that simulates a database interaction based on a
  user authentication mechanism. The package includes the following components:
  - a class that defines objects of type Person with the private attributes: name, surname, e-mail address, userID and
  password along with the getter and setter methods
  - an interface with the methods createUser(), deleteUser() and login(). All methods return a boolean value that represent
  the success state of the corresponding operation. The first 2 methods take as input a Person object. The 3-rd method
  receives as parameters a userID and a password.
  - an abstract class VerifyPerson that extends the Person class and implements the methods that check the formats of the
  name, surname and e-mail address with the following specs:
  * the name and surname ca only contain alphabetic characters
  * the length of the name and surname cannot be greater than 50 characters
  * the e-mail address should be formatted as: [a-zA-Z._]@[a-zA-Z.].[a-zA-Z]{2-5}
  - the abstract class declares but does not implement  the methods for checking the userID and the password
  - a class that extends the abstract class Verify and implements the check methods for userID and password according to
  the following specs:
  o The userID can only contain alphanumeric symbols plus the “.” symbol
  o The password should be at least 8 characters long, with at lease one uppercase symbol and a non-alphanumeric
  symbol.
  Write a Test class that manages a list of persons and uses all the functionalities implemented in the package.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

class Person {
    private String name;
    private String surname;
    private String emailAddress;
    private String userID;
    private String password;

    public Person(String name, String surname, String emailAddress, String userID, String password) {
        this.name = name;
        this.surname = surname;
        this.emailAddress = emailAddress;
        this.userID = userID;
        this.password = password;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

interface UserAuth {
    boolean createUser(Person person);

    boolean login(String userID, String password);

    boolean deleteUser(Person person);

}

abstract class VerifyPerson extends Person implements UserAuth {


    public VerifyPerson() {
        super();
    }

    protected boolean isValidName(String name) {
        return Pattern.matches("^[a-zA-Z]{1,50}$", name);
    }

    protected boolean isValidSurname(String surname) {
        return Pattern.matches("^[a-zA-Z]{1,50}$", surname);
    }

    protected boolean isValidEmail(String emailAddress) {
        return Pattern.matches("^[a-zA-Z._]+@[a-zA-Z.]+\\.[a-zA-Z]{2,5}$", emailAddress);
    }

    protected abstract boolean isValidUserID(String userID);

    protected abstract boolean isValidPassword(String password);
}

class UserManager extends VerifyPerson {
    public List<Person> getUsers() {
        return users;
    }

    public void setUsers(List<Person> users) {
        this.users = users;
    }

    private List<Person> users;

    public UserManager() {
        super();
        users = new ArrayList<>();
    }

    @Override
    protected boolean isValidUserID(String userID) {
        return Pattern.matches("^[a-zA-Z0-9.]+$", userID);
    }

    @Override
    protected boolean isValidPassword(String password) {
        return Pattern.matches("^(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).{8,}$", password);
    }

    @Override
    public boolean createUser(Person person) {
        if (isValidName(person.getName()) && isValidSurname(person.getSurname()) && isValidEmail(person.getEmailAddress()) &&
                isValidUserID(person.getUserID()) && isValidPassword(person.getPassword())) {
            users.add(person);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteUser(Person person) {
        return users.remove(person);
    }

    @Override
    public boolean login(String userID, String password) {
        for (Person user : users) {
            if (user.getUserID().equals(userID) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}

public class Lab6Prb10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManager();

        String userInput;
        boolean createUserSuccess;

        do {
            System.out.println("Enter the user's name:");
            String name = scanner.nextLine();

            System.out.println("Enter the user's surname:");
            String surname = scanner.nextLine();

            System.out.println("Enter the user's email address:");
            String emailAddress = scanner.nextLine();

            System.out.println("Enter the user's user ID:");
            String userID = scanner.nextLine();

            System.out.println("Enter the user's password:");
            String password = scanner.nextLine();

            Person person = new Person(name, surname, emailAddress, userID, password);

            createUserSuccess = userManager.createUser(person);

            if (createUserSuccess) {
                System.out.println("User created successfully.");
            } else {
                System.out.println("Failed to create the user. Please check the input and try again.");
            }

            System.out.println("Do you want to create another user? (yes/no)");
            userInput = scanner.nextLine().trim().toLowerCase();

        } while (userInput.equals("yes"));
        scanner.nextLine();
        System.out.println("User creation process finished.");
        System.out.println("\n\nLOGIN\n");
        System.out.println("Enter the user's user ID:");
        String userID = scanner.nextLine();

        System.out.println("Enter the user's password:");
        String password = scanner.nextLine();
        boolean loginStatus = userManager.login(userID, password);
        if (loginStatus)
            System.out.println("Login successful!");
        else
            System.out.println("Login failed");

        boolean deleteUserSuccess = userManager.deleteUser(userManager.getUsers().get(0));
        if (deleteUserSuccess)
            System.out.println("User deleted successful ");
        else
            System.out.println("Failed to delete the user!");
    }
}
