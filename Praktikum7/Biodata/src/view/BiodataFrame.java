package view;

import javax.swing.*;
import java.awt.*;
import dao.BiodataDao;

public class BiodataFrame extends JFrame {
    private JTextField namaField;
    private JTextArea alamatField;
    private JButton saveButton;

    public BiodataFrame() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Nama:"));
        namaField = new JTextField();
        inputPanel.add(namaField);

        inputPanel.add(new JLabel("Alamat:"));
        alamatField = new JTextArea();
        inputPanel.add(new JScrollPane(alamatField));

        saveButton = new JButton("Simpan");
        add(inputPanel, BorderLayout.CENTER);
        add(saveButton, BorderLayout.SOUTH);

        saveButton.addActionListener(new BiodataButtonSimpanActionListener(this, new BiodataDao()));

        setTitle("Biodata Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getNama() {
        return namaField.getText();
    }

    public String getAlamat() {
        return alamatField.getText();
    }

    public void clearForm() {
        namaField.setText("");
        alamatField.setText("");
    }
}
