package lab11;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Cacu Razvan GR-2023
 *  Implement a Java application that concatenates in a TextArea component the content of the text files selected by the
 * user, as the user chooses the files. Each file’s content is preceded by the file’s name.
 */
 class FileConcatenationApp {
     public static void createAndShowGUI() {
         JFrame frame = new JFrame("File Concatenation App");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         JPanel panel = new JPanel(new BorderLayout());

         JTextArea textArea = new JTextArea();
         textArea.setEditable(false);

         JButton chooseFilesButton = new JButton("Choose Files");

         chooseFilesButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 JFileChooser fileChooser = new JFileChooser();
                 fileChooser.setMultiSelectionEnabled(true);
                 fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));

                 int result = fileChooser.showOpenDialog(frame);

                 if (result == JFileChooser.APPROVE_OPTION) {
                     File[] files = fileChooser.getSelectedFiles();
                     concatenateFiles(files, textArea);
                 }
             }
         });

         panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
         panel.add(chooseFilesButton, BorderLayout.SOUTH);

         frame.getContentPane().add(panel);
         frame.setSize(400, 300);
         frame.setVisible(true);
     }

     private static void concatenateFiles(File[] files, JTextArea textArea) {
         textArea.setText(""); // Clear existing text

         for (File file : files) {
             String fileName = file.getName();
             textArea.append("File: " + fileName + "\n");

             try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                 String line;
                 while ((line = reader.readLine()) != null) {
                     textArea.append(line + "\n");
                 }
             } catch (IOException e) {
                 e.printStackTrace();
             }

             textArea.append("\n");
         }
     }

 }
 public class Lab11Prb7 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FileConcatenationApp::createAndShowGUI);
    }
}
