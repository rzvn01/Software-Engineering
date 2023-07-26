package lab8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Cacu Razvan GR-2023
 * You are given a *.csv file which contains the following fields separated by the "/" symbol: name, surname, phone
 * number, date of birth, link to Facebook profile. Read the information in the file and generate individual files containing
 * the following information: people born in December, people whose phone numbers are international (not Romanian) or
 * are landline numbers, people named Andrei and Nicolae and people whose Facebook profile link is not customised (have
 * a random sequence of digits at the end of the link).
 */
public class Lab8Prb6 {

    public static void main(String[] args) {

        String folderPath = "C:\\Users\\razvan.cacu\\Desktop\\labs SE\\src\\lab8\\";
        String csvFile = folderPath+"facebook";
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("/", 5);

                String name = data[0];
                String surname = data[1];
                String phone = data[2];
                String dob = data[3];
                String facebookLink = data[4];

                if (!phone.matches("^[\\\\+]407\\d{8}$")) {
                    writeToFile(name, surname, phone, dob, facebookLink, folderPath + "international_or_landline.txt");
                }

                if (name.equals("Andrei") || name.equals("Nicolae")) {
                    writeToFile(name, surname, phone, dob, facebookLink, folderPath + "andrei_nicolae.txt");
                }
                if (dob.split("\\.")[1].equals("12")) {
                    writeToFile(name, surname, phone, dob, facebookLink, folderPath + "december_birthday.txt");
                }
                if (facebookLink.matches("https:\\/\\/www\\.facebook\\.com\\/profile\\.php\\?id=\\d+")) {
                    writeToFile(name, surname, phone, dob, facebookLink, folderPath + "non_custom_link.txt");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void writeToFile(String name, String surname, String phone, String dob, String facebookLink, String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
        writer.write(name + "," + surname + "," + phone + "," + dob + "," + facebookLink);
        writer.newLine();
        writer.close();
    }
}
