package lab8;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**Cacu Razvan GR-2023
 * Write a Java application which reads a set of text files that contain students data (CSV files). The files are stored on the
 * local machine under the names Year_Y_Group_XXXX.txt . Agregate the information in these files using a
 * SequenceInputStream and generate a new file which contains all the students ordered alphabetically.
 */
public class Lab8Prb5 {
    public static void main(String[] args) throws IOException {
        Path inputDir = Paths.get("C:\\Users\\razvan.cacu\\Desktop\\se labs\\src\\lab8");
        Path outputFile = Paths.get("C:\\Users\\razvan.cacu\\Desktop\\se labs\\src\\lab8\\merged_student_data.csv");

        BufferedWriter writer = Files.newBufferedWriter(outputFile);

        List<Path> inputFiles = Files.list(inputDir)
                .filter(p -> p.getFileName().toString().matches("Year_\\d+_Group_\\d{4}\\.txt$"))
                .sorted()
                .toList();

        InputStream inputStream = new SequenceInputStream(Collections.enumeration(inputFiles.stream()
                .map(p -> {
                    try {
                        return Files.newInputStream(p);
                    } catch (IOException e) {
                        throw new UncheckedIOException(e);
                    }
                })
                .collect(Collectors.toList())));

        Scanner scanner = new Scanner(inputStream);

        List<String> studentData = new ArrayList<>();

        while (scanner.hasNextLine()) {
            studentData.add(scanner.nextLine());
        }

        Collections.sort(studentData);

        for (String student : studentData) {
            writer.write(student);
            writer.newLine();
        }

        writer.close();
    }
}