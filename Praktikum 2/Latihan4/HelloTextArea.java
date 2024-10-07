package Latihan4;

import java.awt.event.*;
import javax.swing.*;

public class HelloTextArea extends JFrame {

    public HelloTextArea() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelinputnama = new JLabel("Input Nama : ");
        labelinputnama.setBounds(130, 20, 100, 20);

        JTextField textFieldnama = new JTextField();
        textFieldnama.setBounds(130, 40, 150, 30);

        JLabel labelinputnotelp = new JLabel("Input No Telepon : ");
        labelinputnotelp.setBounds(130, 80, 150, 20);

        JTextField textFieldnotelp = new JTextField();
        textFieldnotelp.setBounds(130, 100, 150, 30);

        JButton button = new JButton("klik");
        button.setBounds(130, 140, 100, 40);

        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(130, 200, 200, 200);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldnama.getText();
                String notelp = textFieldnotelp.getText();
                txtOutput.append("Nama :  " + nama + "\nNo Telepon : " + notelp + "\n");
                txtOutput.append("--------------------------------------------------\n");
                textFieldnama.setText("");
                textFieldnotelp.setText("");
            }
        });

        this.add(button);
        this.add(textFieldnama);
        this.add(labelinputnama);
        this.add(textFieldnotelp);
        this.add(labelinputnotelp);
        this.add(txtOutput);

        this.setSize(600, 600);
        this.setLayout(null);

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloTextArea h = new HelloTextArea();
                h.setVisible(true);
            }
        });
    }

}