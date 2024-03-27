import Appliction.Application;

public class Main {
    public static void main(String[] args) {
        new Application().run();

}}


//
//import javax.swing.*;
//import java.awt.*;
//
//public class Main {
//    public static void main(String[] args) {
//        // Create JFrame
//        JFrame frame = new JFrame("Scrollable Table Example");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Sample data for the table
//        Object[][] data = new Object[50][3];
//        for (int i = 0; i < 50; i++) {
//            for (int j = 0; j < 3; j++) {
//                data[i][j] = "";
//            }
//        }
//
//        // Column names
//        String[] columns = {"ID", "First Name", "Last Name"};
//
//        // Create JTable with sample data and column names
//        JTable table = new JTable(data, columns);
//
//        // Create JScrollPane and add JTable to it
//        JScrollPane scrollPane = new JScrollPane(table);
//
//        // Set preferred size of JScrollPane (optional)
//        scrollPane.setPreferredSize(new Dimension(400, 200));
//        frame.setLayout(null);
//        scrollPane.setSize(new Dimension(600,400));
//        // Add JScrollPane to JFrame
//        frame.add(scrollPane);
//        // Set JFrame size and make it visible
//        frame.setSize(600, 400);
//        frame.setVisible(true);
//    }
//}