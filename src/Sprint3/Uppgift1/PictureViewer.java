package Sprint3.Uppgift1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PictureViewer extends JFrame implements ActionListener {
    final String imagePath1 = "src/Sprint3/Uppgift1/images/1.jpg";
    final String imagePath2 = "src/Sprint3/Uppgift1/images/2.jpg";
    final String imagePath3 = "src/Sprint3/Uppgift1/images/3.jpg";
    int swap = 0;
    JLabel imageViewer;

    public PictureViewer() {
        JButton changeImageButton = new JButton("Byt bild");
        imageViewer = new JLabel(new ImageIcon(imagePath1));
        imageViewer.setPreferredSize(new Dimension(800, 500));
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.BLACK);
        panel.add(imageViewer);
        panel.add(changeImageButton);

        changeImageButton.addActionListener(this); //lägger till lyssnare till knappen

        //JFrame
        add(panel); //lägger till panelen utan this
        setLayout(new FlowLayout());
        setTitle("Bildvisare");
        pack(); //anpassar storleken efter komponenternas storlek
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent a) {
        if (swap == 0) {
            imageViewer.setIcon(new ImageIcon(imagePath2));
            swap = 1;
        } else if (swap == 1) {
            imageViewer.setIcon(new ImageIcon(imagePath3));
            swap = 2;
        } else if (swap == 2) {
            imageViewer.setIcon(new ImageIcon(imagePath1));
            swap = 0;
        }
    }

    public static void main(String[] args) {
        new PictureViewer();
    }
}