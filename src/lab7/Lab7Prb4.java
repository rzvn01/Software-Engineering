package lab7;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

/**Cacu Razvan GR-2023
 *  Implement a class called UserFile (name, extension, type, size in bytes, constructors, mutators, accesors). The types of
 * files are predefined and stored in a Hashtable object (for example "image"->0, "text"->1, "application"->2, etc.) Create a
 * list of objects from this class and read from the keyboard the associated info. Print all the specific extensions of the
 * predefined file types. Order the file list based on size and print the result.
 */

class UserFile {
    private String name;
    private String extension;
    private int type;
    private long size;

    public UserFile(String name, String extension, int type, long size) {
        this.name = name;
        this.extension = extension;
        this.type = type;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}

public class Lab7Prb4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Hashtable<String, Integer> fileTypes = new Hashtable<>();
        fileTypes.put("image", 0);
        fileTypes.put("text", 1);
        fileTypes.put("application", 2);
        fileTypes.put("audio", 3);
        fileTypes.put("video", 4);
        fileTypes.put("archive", 5);
        fileTypes.put("spreadsheet", 6);
        fileTypes.put("presentation", 7);

        List<UserFile> files = new ArrayList<>();
        String response;

        do {
            System.out.println("Enter file name:");
            String name = scanner.nextLine();
            System.out.println("Enter file  extension:");
            String extension = scanner.nextLine();
            printFileTypes(fileTypes);
            System.out.println("Enter file type:");
            int type = fileTypes.get(scanner.nextLine());
            System.out.println("Enter file size (in bytes):");
            long size = scanner.nextLong();
            scanner.nextLine();
            files.add(new UserFile(name, extension, type, size));
            System.out.println("Do you want to add another file ? (yes/no)");
            response = scanner.nextLine();
        } while (!response.equalsIgnoreCase("no") && !response.equalsIgnoreCase("n"));

        System.out.println("File extensions of predefined file types:");
        for (String fileType : fileTypes.keySet()) {
            System.out.println(fileType + ": " + fileType);
        }

        files.sort(Comparator.comparingLong(UserFile::getSize));

        System.out.println("Sorted file list based on size:");
        for (UserFile file : files) {
            System.out.println(file.getName() + "." + file.getExtension() + ", Type: " + file.getType() + ", Size: " + file.getSize() + " bytes");
        }
    }
    private static void printFileTypes( Hashtable<String, Integer> fileTypes){
        System.out.print("File extensions of predefined file types:");
        for (String fileType : fileTypes.keySet()) {
            System.out.print(fileType+", ");
        }
    }
}

