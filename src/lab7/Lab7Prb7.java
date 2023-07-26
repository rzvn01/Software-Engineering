package lab7;

import java.util.Collection;
import java.util.Comparator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Cacu Razvan GR-2023
 * Create a generic class called VirtualLibrary that manages a SortedSet of entries. The types of entries are Book, Article,
 * MediaResource, Magazine and Manual. Implement the specific classes for each type of entry, each of them being a
 * subclass of Publication.
 * The VirtualLibrary has methods to add, add multiple, return a specific entry and check if an entry exists in the library.
 * In the main() method, create an instance of VirtualLibrary and use the offered facilities.
 */
abstract class Publication {
    private final String title;
    private final String author;
    private final String year;

    public Publication(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }
}

class Book extends Publication {
    public Book(String title, String author, String year) {
        super(title, author, year);
    }
}

class Article extends Publication {
    public Article(String title, String author, String year) {
        super(title, author, year);
    }
}

class MediaResource extends Publication {
    public MediaResource(String title, String author, String year) {
        super(title, author, year);
    }
}

class Magazine extends Publication {
    public Magazine(String title, String author, String year) {
        super(title, author, year);
    }
}

class Manual extends Publication {
    public Manual(String title, String author, String year) {
        super(title, author, year);
    }
}

class VirtualLibrary<T extends Publication> {
    private final SortedSet<T> library;

    public VirtualLibrary() {
        library = new TreeSet<>(Comparator.comparing(Publication::getTitle));
    }

    public void add(T entry) {
        library.add(entry);
    }

    public void addMultiple(Collection<T> entries) {
        library.addAll(entries);
    }

    public T getEntry(String title) {
        return library.stream().filter(entry -> entry.getTitle().equals(title)).findFirst().orElse(null);
    }

    public boolean entryExists(String title) {
        return library.stream().anyMatch(entry -> entry.getTitle().equals(title));
    }
}

public class Lab7Prb7 {
    public static void main(String[] args) {
        VirtualLibrary<Publication> library = new VirtualLibrary<>();
        Scanner scanner = new Scanner(System.in);
        String userInput;

        do {
            System.out.println("\n1. Add Entry");
            System.out.println("2. Check if entry exists");
            System.out.println("3. Get entry details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            userInput = scanner.nextLine();

            switch (userInput) {
                case "1" -> {
                    System.out.print("Enter entry type (book, article, mediaResource, magazine, manual): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter year: ");
                    String year = scanner.nextLine();
                    Publication entry;
                    switch (type.toLowerCase()) {
                        case "book" -> entry = new Book(title, author, year);
                        case "article" -> entry = new Article(title, author, year);
                        case "mediaresource" -> entry = new MediaResource(title, author, year);
                        case "magazine" -> entry = new Magazine(title, author, year);
                        case "manual" -> entry = new Manual(title, author, year);
                        default -> {
                            System.out.println("Invalid entry type");
                            continue;
                        }
                    }
                    library.add(entry);
                    System.out.println("Entry added successfully");
                }
                case "2" -> {
                    System.out.print("Enter entry title to check if it exists: ");
                    String entryTitle = scanner.nextLine();
                    System.out.println(entryTitle + " exists: " + library.entryExists(entryTitle));
                }
                case "3" -> {
                    System.out.print("Enter entry title to get details: ");
                    String searchTitle = scanner.nextLine();
                    Publication foundEntry = library.getEntry(searchTitle);
                    if (foundEntry != null) {
                        System.out.println("Entry found: " + foundEntry.getTitle() + ", " + foundEntry.getAuthor() + ", " + foundEntry.getYear());
                    } else {
                        System.out.println("Entry not found");
                    }
                }
                case "4" -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (!userInput.equals("4"));

        scanner.close();
    }
}
