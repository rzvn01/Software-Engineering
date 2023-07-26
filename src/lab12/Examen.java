package lab12;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class ShapeException extends Exception {
    public ShapeException(String message) {
        super(message);
    }
}

class NumberException extends Exception {
    public NumberException(String message) {
        super(message);
    }
}

class ShapeDrawer extends JPanel {

    Map<String, Integer> shapes = new HashMap<>();
    Map<String, Integer> shapesDrawn = new HashMap<>();
    JLabel errorLabel;
    Point lastClick;

    public ShapeDrawer() {
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lastClick = evt.getPoint();
                repaint();
            }
        });
        this.setBackground(new Color(122, 123, 211));
        errorLabel = new JLabel();
        add(errorLabel);

        try {
            readFile();
        } catch (IOException | ShapeException | NumberException e) {
            errorLabel.setText(e.getMessage());
        }

        for (String shape : shapes.keySet()) {
            shapesDrawn.put(shape, 0);
        }
    }

    public void readFile() throws IOException, ShapeException, NumberException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\razvan.cacu\\Desktop\\labs SE\\fisier.txt"));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length != 2) throw new ShapeException("Invalid shape data");

            String shape = parts[0];
            if (!shape.equals("circle") && !shape.equals("square") && !shape.equals("triangle"))
                throw new ShapeException("Invalid shape: " + shape);

            try {
                int number = Integer.parseInt(parts[1]);
                shapes.put(shape, number);
            } catch (NumberFormatException e) {
                throw new NumberException("Invalid number for shape " + shape);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (lastClick != null) {
            for (String shape : shapes.keySet()) {
                if (shapes.get(shape) > shapesDrawn.get(shape)) {
                    switch (shape) {
                        case "circle":
                            g.drawOval(lastClick.x, lastClick.y, 50, 50);

                            break;
                        case "square":
                            g.drawRect(lastClick.x, lastClick.y, 50, 50);
                            break;
                        case "triangle":
                            g.drawPolygon(new int[]{lastClick.x, lastClick.x + 25, lastClick.x + 50}, new int[]{lastClick.y + 50, lastClick.y, lastClick.y + 50}, 3);
                            break;
                    }

                    shapesDrawn.put(shape, shapesDrawn.get(shape) + 1);
                    break;
                }
            }
        }
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Shape Drawer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ShapeDrawer drawer = new ShapeDrawer();
        frame.add(drawer);

        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ShapeDrawer::createAndShowGUI);
    }
}