package Sprint3.Uppgift5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockPaperScissors extends JFrame implements ActionListener {
    int userPoints;
    int computerPoints;

    JButton rock1 = new JButton("Sten");
    JButton scissors1 = new JButton("Sax");
    JButton paper1 = new JButton("Påse");
    JButton rock2 = new JButton("Sten");
    JButton scissors2 = new JButton("Sax");
    JButton paper2 = new JButton("Påse");
    JLabel messageNorth = new JLabel("Välj ditt alternativ till vänster.");
    JLabel messageSouth = new JLabel("Poäng användare-dator: " + userPoints + "-" + computerPoints);

    JPanel jp = new JPanel();
    JPanel northPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JPanel westPanel = new JPanel();
    JPanel eastPanel = new JPanel();

    RockPaperScissors() {
        //NORTH
        northPanel.setLayout(new FlowLayout());
        northPanel.add(messageNorth);

        //SOUTH
        southPanel.setLayout(new GridLayout(1, 2));
        southPanel.add(messageSouth);

        //WEST
        westPanel.setLayout(new GridLayout(3, 1));
        westPanel.add(rock1); westPanel.add(scissors1); westPanel.add(paper1);

        //EAST
        eastPanel.setLayout(new GridLayout(3, 1));
        eastPanel.add(rock2); eastPanel.add(scissors2); eastPanel.add(paper2);

        //JPanel setup
        add(jp);
        jp.setLayout(new BorderLayout());
        jp.add(northPanel, BorderLayout.NORTH);
        jp.add(westPanel, BorderLayout.WEST);
        jp.add(eastPanel, BorderLayout.EAST);
        jp.add(southPanel, BorderLayout.SOUTH);
        setTitle("Sten, sax, påse");
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //initiera ActionListener
        rock1.addActionListener(this);
        scissors1.addActionListener(this);
        paper1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //1. Användarens inmatning
        int choice1 = 0;

        if (ae.getSource() == rock1) {
            choice1 = 1;
            rock1.setBackground(Color.cyan);
            scissors1.setBackground(Color.lightGray);
            paper1.setBackground(Color.lightGray);

        } else if (ae.getSource() == scissors1) {
            choice1 = 3;
            rock1.setBackground(Color.lightGray);
            scissors1.setBackground(Color.cyan);
            paper1.setBackground(Color.lightGray);

        } else if (ae.getSource() == paper1) {
            choice1 = 2;
            rock1.setBackground(Color.lightGray);
            scissors1.setBackground(Color.lightGray);
            paper1.setBackground(Color.cyan);
        }
        //2. Datorns svar
        int choice2 = (int) (Math.random() * 3 + 1); //ger 1, 2 eller 3
        if (choice2 == 1) { //om sten
            rock2.setBackground(Color.cyan);
            scissors2.setBackground(Color.lightGray);
            paper2.setBackground(Color.lightGray);
        } else if (choice2 == 3) { //om sax
            rock2.setBackground(Color.lightGray);
            scissors2.setBackground(Color.cyan);
            paper2.setBackground(Color.lightGray);
        } else if (choice2 == 2) { //om påse
            rock2.setBackground(Color.lightGray);
            scissors2.setBackground(Color.lightGray);
            paper2.setBackground(Color.cyan);
        }
        //3. Om väljer samma, vinner, förlorar
        if (choice1 == choice2) {
            messageNorth.setText("Ni valde samma. Gör ett val.");
        } else if (choice1 == 1 && choice2 == 3 || choice1 == 3 && choice2 == 2 || choice1 == 2 && choice2 == 1) {
            messageNorth.setText("Du vann! Gör ett val.");
            userPoints++;
            messageSouth.setText("Poäng användare-dator: " + userPoints + " - " + computerPoints);
        } else {
            messageNorth.setText(("Du förlorade! Gör ett val."));
            computerPoints++;
            messageSouth.setText("Poäng användare-dator: " + userPoints + " - " + computerPoints);
        }
    }

    public static void main(String[] args) {
        //sätter manuell look and feel som tillåter ändring av färg trots min mac
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new RockPaperScissors();
    }
}