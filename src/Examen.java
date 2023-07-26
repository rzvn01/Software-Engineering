
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


class NumberException extends Exception {
    NumberException(String message) {
        super(message);
    }
}

class ButtonGui {
    private JFrame frame;
    private JTextArea textArea;
    private JButton[] buttons = new JButton[20];

    private JButton saveButton;
    private JPanel panel;
    private Map<JButton, Integer> valueaMap = new HashMap<>();
    private Map<JButton, Integer> indexValues = new HashMap<>();
    private String textValues = "";

    ButtonGui() {
        Random random = new Random();
        frame = new JFrame("Random Buttons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        textArea = new JTextArea(20, 1);
        saveButton = new JButton("Save Data!");

        int i = 0;
        panel.add(textArea);

        for (int j = 0; j < 20; j++)
            buttons[j] = new JButton();

        for (JButton button : buttons) {
            int value = random.nextInt(8) + 3;
            button.setText(String.valueOf(value));
            panel.add(button);
            valueaMap.put(button, value);
            indexValues.put(button, i);
            i++;
            textValues = textValues + value + "\n";
        }
        textArea.setText(textValues);

        for (JButton button : buttons) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int value = valueaMap.get(button);
                    if (value == 0)
                        try {
                            throw new NumberException("Value cannot be smaller than 0");
                        } catch (NumberException ex) {
                            String[] lines = textValues.split("\n");
                            int index = indexValues.get(button);
                            String text = "";
                            lines[index] = "Button" + index + "cannot have a value smaller than 0";
                            for (String line : lines) {
                                text = text + line + "\n";
                            }
                            textArea.setText(text);
                            valueaMap.put(button,0);
                        }
                    else {
                        value--;
                        valueaMap.put(button, value);
                        button.setText(String.valueOf(value));
                    }
                }
            });
        }


        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    saveToFile();
                } catch (IOException ex) {
                textArea.setText("Cannot save to file!");
                }

            }
        });


        panel.add(saveButton);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

    }

    public void saveToFile() throws IOException {
        String fileName = "C:\\Users\\razvan.cacu\\Desktop\\labs SE\\fisier.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        String[] lines = textValues.split("\n");
        try {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            textArea.setText("Cannot write into file!");
        }

    }
}


public class Examen {
    public static void main(String[] args) {
        new ButtonGui();
    }
}