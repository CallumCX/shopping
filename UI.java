import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UI {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        JTextField empty = new JTextField("Currently empty!");
        empty.setEditable(false);
        empty.setHorizontalAlignment(JTextField.CENTER);
        empty.setBounds(400,350,200,50);

        String fullValue = (ItemListIO.getFoodList()).toString();
        JTextField full = new JTextField(fullValue);
        full.setHorizontalAlignment(JTextField.CENTER);
        full.setBounds(400,350,200,50);

        JTextField question = new JTextField("What would you like to add?");
        question.setEditable(false);
        question.setHorizontalAlignment(JTextField.CENTER);
        question.setBounds(400,250,200,50);

        JTextField answer = new JTextField();
        question.setEditable(true);
        question.setHorizontalAlignment(JTextField.CENTER);
        question.setBounds(400,300,200,50);

        Food.ReadFile();
        JFrame mainWindow = new JFrame();
        mainWindow.setLayout(null);

        JButton button1 = new JButton("View shopping list");
        button1.setBounds(50,100,200,50);
        mainWindow.add(button1);
        button1.addActionListener(e -> {
            JList<String> outputList = new JList<>();
            if (ItemListIO.allFoodItems.isEmpty()) {
                empty.setVisible(true);
                mainWindow.add(empty);
            }
            else {
                full.setVisible(true);
                mainWindow.add(full);
            }
        });

        JButton button2 = new JButton("Add an item");
        button2.setBounds(50,200,200,50);
        mainWindow.add(button2);
        button2.addActionListener(e -> {
            full.setVisible(false);
            empty.setVisible(false);
            Scanner input1 = new Scanner(System.in);
            question.setVisible(true);
            answer.setVisible(true);
            ItemListIO.addToFoodList(input1);



        });

        JButton button3 = new JButton("Remove an item");
        button3.setBounds(50,300,200,50);
        mainWindow.add(button3);

        JButton button4 = new JButton("List all available foods");
        button4.setBounds(50,400,200,50);
        mainWindow.add(button4);

        JButton button5 = new JButton("Calculate the price");
        button5.setBounds(50,500,200,50);
        mainWindow.add(button5);

        JButton button6 = new JButton("Exit");
        button6.setBounds(50,600,200,50);
        mainWindow.add(button6);











        mainWindow.setSize(750,1000);
        mainWindow.setTitle("Shopping list creator!");
        mainWindow.setResizable(false);
        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



}
