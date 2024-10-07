package Latihan5;

import java.awt.*;
import javax.swing.*;

public class FormBiodata extends JFrame {

    public FormBiodata() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel headerLabel = new JLabel("Form Biodata", JLabel.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setSize(300, 300);
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel labelinputnama = new JLabel("Nama : ");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(labelinputnama, gbc);

        JTextField textFieldnama = new JTextField();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(textFieldnama, gbc);

        JLabel labelinputnotelp = new JLabel("No Telepon : ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(labelinputnotelp, gbc);

        JTextField textFieldnotelp = new JTextField();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(textFieldnotelp, gbc);

        JLabel jenisKelaminLabel = new JLabel("Jenis Kelamin:");
        gbc.ipady = 30;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(jenisKelaminLabel, gbc);

        JLabel labelRadio = new JLabel("Jenis kelamin:");
        labelRadio.setLayout(new BoxLayout(labelRadio, BoxLayout.Y_AXIS));
        ButtonGroup bg = new ButtonGroup();
        JRadioButton radioButton1 = new JRadioButton("Laki - Laki");
        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        bg.add(radioButton1);
        bg.add(radioButton2);
        labelRadio.add(radioButton1);
        labelRadio.add(radioButton2);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(labelRadio, gbc);

        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(checkBox, gbc);

        JButton button = new JButton("Simpan");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        panel.add(button, gbc);

        controlPanel.add(panel);

        this.setLayout(new GridLayout(3, 1));
        this.add(headerLabel);
        this.add(controlPanel);
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FormBiodata f = new FormBiodata();
                f.setVisible(true);
            }
        });
    }

}