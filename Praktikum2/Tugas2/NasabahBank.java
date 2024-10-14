package Tugas2;

import java.awt.event.*;
import javax.swing.*;

public class NasabahBank extends JFrame {

    public NasabahBank() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Nama
        JLabel labelInputNama = new JLabel("Nama : ");
        labelInputNama.setBounds(20, 20, 100, 20);

        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(130, 20, 150, 30);

        // No Telepon
        JLabel labelInputNoTelp = new JLabel("No Telepon : ");
        labelInputNoTelp.setBounds(20, 60, 100, 20);

        JTextField textFieldNoTelp = new JTextField();
        textFieldNoTelp.setBounds(130, 60, 150, 30);

        // Jenis Kelamin
        JLabel labelRadio = new JLabel("Jenis kelamin:");
        labelRadio.setBounds(20, 100, 100, 20);

        JRadioButton radioButton1 = new JRadioButton("Laki - Laki");
        radioButton1.setBounds(20, 125, 100, 20);

        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(20, 150, 100, 20);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        // Warga Negara Asing
        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        checkBox.setBounds(20, 180, 200, 20);

        // Jenis Tabungan (JList)
        JLabel labelJenisTabungan = new JLabel("Jenis Tabungan:");
        labelJenisTabungan.setBounds(20, 210, 120, 20);

        String[] jenisTabungan = { "Tabungan Reguler", "Tabungan Kesehatan", "Tabungan Pendidikan",
                "Tabungan Haji", "Tabungan Pensiun" };
        JList<String> listJenisTabungan = new JList<>(jenisTabungan);
        listJenisTabungan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(listJenisTabungan);
        listScrollPane.setBounds(130, 210, 150, 80);

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem menuReset = new JMenuItem("Reset");
        JMenuItem menuExit = new JMenuItem("Exit");

        // Frekuensi Transaksi per Bulan (JSpinner)
        JLabel labelFrekuensiTransaksi = new JLabel("Frekuensi Transaksi per Bulan:");
        labelFrekuensiTransaksi.setBounds(20, 300, 200, 20);

        SpinnerModel modelFrekuensiTransaksi = new SpinnerNumberModel(1, 1, 100, 1);
        JSpinner spinnerFrekuensiTransaksi = new JSpinner(modelFrekuensiTransaksi);
        spinnerFrekuensiTransaksi.setBounds(230, 300, 50, 30);

        // Password and Confirm Password (JPasswordField)
        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(20, 340, 100, 20);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(130, 340, 150, 30);

        JLabel labelConfirmPassword = new JLabel("Confirm Password:");
        labelConfirmPassword.setBounds(20, 380, 150, 20);

        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(170, 380, 150, 30);

        // Tanggal Lahir (JSpinner)
        JLabel labelTanggalLahir = new JLabel("Tanggal Lahir:");
        labelTanggalLahir.setBounds(20, 420, 100, 20);

        SpinnerDateModel modelTanggalLahir = new SpinnerDateModel();
        JSpinner spinnerTanggalLahir = new JSpinner(modelTanggalLahir);
        spinnerTanggalLahir.setBounds(130, 420, 150, 30);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinnerTanggalLahir, "dd/MM/yyyy");
        spinnerTanggalLahir.setEditor(editor);

        // Simpan Button
        JButton button = new JButton("Simpan");
        button.setBounds(130, 460, 100, 30);

        // Output Area
        JTextArea txtOutput = new JTextArea("");
        JScrollPane scrollPane = new JScrollPane(txtOutput);
        scrollPane.setBounds(20, 500, 300, 150);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String notelp = textFieldNoTelp.getText();
                String jenisKelamin = "";
                if (radioButton1.isSelected()) {
                    jenisKelamin = radioButton1.getText();
                }
                if (radioButton2.isSelected()) {
                    jenisKelamin = radioButton2.getText();
                }

                String pilihanTabungan = listJenisTabungan.getSelectedValue();
                String frekuensiTransaksi = spinnerFrekuensiTransaksi.getValue().toString();
                String tanggalLahir = editor.getFormat().format(spinnerTanggalLahir.getValue());

                txtOutput.append("Nama : " + nama + "\n");
                txtOutput.append("No Telepon : " + notelp + "\n");
                txtOutput.append("Jenis Kelamin : " + jenisKelamin + "\n");
                if (checkBox.isSelected()) {
                    txtOutput.append("WNA : Ya\n");
                } else {
                    txtOutput.append("WNA : Bukan\n");
                }
                txtOutput.append(
                        "Jenis Tabungan : " + (pilihanTabungan != null ? pilihanTabungan : "Belum dipilih") + "\n");
                txtOutput.append("Frekuensi Transaksi : " + frekuensiTransaksi + "\n");

                char[] password = passwordField.getPassword();
                char[] confirmPassword = confirmPasswordField.getPassword();
                if (String.valueOf(password).equals(String.valueOf(confirmPassword))) {
                    txtOutput.append("Password: Cocok\n");
                } else {
                    txtOutput.append("Password: Tidak Cocok\n");
                }

                txtOutput.append("Tanggal Lahir : " + tanggalLahir + "\n");

                txtOutput.append(
                        "----------------------------------------------------------------------\n");
            }
        });

        menuReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldNama.setText("");
                textFieldNoTelp.setText("");
                bg.clearSelection();
                checkBox.setSelected(false);
                listJenisTabungan.clearSelection();
                spinnerFrekuensiTransaksi.setValue(1);
                passwordField.setText("");
                confirmPasswordField.setText("");
                spinnerTanggalLahir.setValue(new java.util.Date());
                txtOutput.setText("");
            }
        });

        menuExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menu.add(menuReset);
        menu.add(menuExit);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        this.add(button);
        this.add(textFieldNama);
        this.add(labelInputNama);
        this.add(textFieldNoTelp);
        this.add(labelInputNoTelp);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(checkBox);
        this.add(labelJenisTabungan);
        this.add(listScrollPane);
        this.add(labelFrekuensiTransaksi);
        this.add(spinnerFrekuensiTransaksi);
        this.add(labelPassword);
        this.add(passwordField);
        this.add(labelConfirmPassword);
        this.add(confirmPasswordField);
        this.add(labelTanggalLahir);
        this.add(spinnerTanggalLahir);
        this.add(scrollPane);

        this.setSize(600, 800);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                NasabahBank n = new NasabahBank();
                n.setVisible(true);
            }
        });
    }
}
