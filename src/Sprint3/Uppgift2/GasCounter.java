package Sprint3.Uppgift2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class GasCounter extends JFrame implements ActionListener {
    //först samtliga JPanels
    JPanel jp = new JPanel();
    JPanel northPanel = new JPanel();
    JPanel westPanel = new JPanel();
    JPanel eastPanel = new JPanel();
    JPanel southPanel = new JPanel();

    //sen alla fields
    JTextField field1 = new JTextField();
    JTextField field2 = new JTextField();
    JTextField field3 = new JTextField();

    //sen JLabels för south, åtkomst för utskrift
    JLabel south1 = new JLabel();
    JLabel south2 = new JLabel();
    JLabel south3 = new JLabel();

    public GasCounter() {
        //NORTH
        northPanel.setLayout(new FlowLayout());
        northPanel.add(new JLabel("Fyll i en siffra och tryck sedan enter i respektive textruta.")); //kompakt

        //WEST
        westPanel.setLayout(new GridLayout(3, 1));
        westPanel.add(new JLabel("Ange mätarställning nu:")); //kompakt
        westPanel.add(new JLabel("Ange mätarställning för ett år sedan:"));
        westPanel.add(new JLabel("Ange antal liter förbrukad bensin:"));

        //EAST
        eastPanel.setLayout(new GridLayout(3, 1));

        field1.setPreferredSize(new Dimension(275, 30)); //minimumdimensioner
        field2.setPreferredSize(new Dimension(275, 30));
        field3.setPreferredSize(new Dimension(275, 30));

        eastPanel.add(field1);
        eastPanel.add(field2);
        eastPanel.add(field3);

        //SOUTH
        southPanel.setLayout(new GridLayout(1, 3));
        southPanel.add(south1);
        south1.setText("Antal körda mil:");
        southPanel.add(south2);
        south2.setText("Antal liter bensin:");
        southPanel.add(south3);
        south3.setText("Förbrukning per mil:");

        //JFrame setup
        add(jp);
        jp.setLayout(new BorderLayout());
        jp.add(northPanel, BorderLayout.NORTH);
        jp.add(westPanel, BorderLayout.WEST);
        jp.add(eastPanel, BorderLayout.EAST);
        jp.add(southPanel, BorderLayout.SOUTH);
        setTitle("Drivmedelsberäknare");
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //ActionListener setup
        field1.addActionListener(this);
        field2.addActionListener(this);
        field3.addActionListener(this);
    }

    //hjälpmetod som räknar ut antal körda mil
    public double numberOfMil(double nowDouble, double yearAgoDouble) {
        return nowDouble - yearAgoDouble;
    }

    //hjälpmetod som räknar ut antal liter per mil
    public double literPerMilCalc(double totalLiterDouble, double totalMil) {
        return totalLiterDouble / totalMil;
    }

    //ActionListener med scanners som parsas till doubles
    @Override
    public void actionPerformed(ActionEvent ae) {
        Scanner nowScan = new Scanner(field1.getText());
        Scanner yearAgoScan = new Scanner(field2.getText());
        Scanner totalLiterScan = new Scanner(field3.getText());

        if (nowScan.hasNextDouble() && yearAgoScan.hasNextDouble() && totalLiterScan.hasNextDouble()) {
            double nowDouble = nowScan.nextDouble();
            double yearAgoDouble = yearAgoScan.nextDouble();
            double totalLiterDouble = totalLiterScan.nextDouble();

            double totalMil = numberOfMil(nowDouble, yearAgoDouble);
            double literPerMil = literPerMilCalc(totalLiterDouble, totalMil);

            south1.setText("Antal körda mil:" + totalMil);
            south2.setText("Antal liter bensin:" + totalLiterDouble);
            south3.setText("Förbrukning per mil:" + literPerMil);
        }
    }

    public static void main(String[] args) {
        new GasCounter();
    }
}