package Latihan7;

import java.awt.event.*;
import javax.swing.*;

public class HelloTextArea extends JFrame {

    public HelloTextArea() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelinputnama = new JLabel("Nama : ");
        labelinputnama.setBounds(20, 20, 100, 20);

        JTextField textFieldnama = new JTextField();
        textFieldnama.setBounds(130, 20, 150, 30);

        JLabel labelinputnotelp = new JLabel("No Telepon : ");
        labelinputnotelp.setBounds(20, 60, 100, 20);

        JTextField textFieldnotelp = new JTextField();
        textFieldnotelp.setBounds(130, 60, 150, 30);

        JLabel labelRadio = new JLabel("Jenis kelamin:");
        labelRadio.setBounds(20, 100, 100, 20);

        JRadioButton radioButton1 = new JRadioButton("Laki - Laki");
        radioButton1.setBounds(20, 125, 100, 20);

        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(20, 150, 100, 20);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        checkBox.setBounds(20, 180, 200, 20);

        JButton button = new JButton("Simpan");
        button.setBounds(130, 220, 100, 30);

        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(20, 260, 300, 300);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldnama.getText();
                String notelp = textFieldnotelp.getText();
                String jenisKelamin = "";
                if (radioButton1.isSelected()) {
                    jenisKelamin = radioButton1.getText();
                }
                if (radioButton2.isSelected()) {
                    jenisKelamin = radioButton2.getText();
                }

                txtOutput.append("Nama : " + nama + "\n");
                txtOutput.append("No Telepon : " + notelp + "\n");
                txtOutput.append("Jenis Kelamin : " + jenisKelamin + "\n");

                if (checkBox.isSelected()) {
                    txtOutput.append("WNA : Ya\n");
                } else {
                    txtOutput.append("WNA : Bukan\n");
                }

                txtOutput.append("____________________________________________________________________\n");

                textFieldnama.setText("");
                textFieldnotelp.setText("");
                bg.clearSelection();
                checkBox.setSelected(false);
            }
        });

        this.add(button);
        this.add(textFieldnama);
        this.add(labelinputnama);
        this.add(textFieldnotelp);
        this.add(labelinputnotelp);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(checkBox);
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