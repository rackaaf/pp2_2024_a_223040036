package Tugas3;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Pendaftaran extends JFrame {
    private JTextField textFieldNama;
    private JTextField textFieldNoTelp;
    private JRadioButton radioButton1, radioButton2;
    private JCheckBox checkBox;
    private JList<String> listKlubFavorit;
    private JSpinner spinnerTanggalLahir;
    private JTextArea textAreaAlasan;
    private List<String[]> dataDaftar;

    public Pendaftaran() {
        this.setSize(600, 800);
        this.setLayout(null);
        this.dataDaftar = new ArrayList<>();

        JLabel labelInputNama = new JLabel("Nama : ");
        labelInputNama.setBounds(20, 20, 100, 20);
        textFieldNama = new JTextField();
        textFieldNama.setBounds(130, 20, 150, 30);

        JLabel labelInputNoTelp = new JLabel("No Telepon : ");
        labelInputNoTelp.setBounds(20, 60, 100, 20);
        textFieldNoTelp = new JTextField();
        textFieldNoTelp.setBounds(130, 60, 150, 30);

        JLabel labelRadio = new JLabel("Jenis kelamin:");
        labelRadio.setBounds(20, 100, 100, 20);
        radioButton1 = new JRadioButton("Laki - Laki");
        radioButton1.setBounds(20, 125, 100, 20);
        radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(20, 150, 100, 20);
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        checkBox = new JCheckBox("Ingin Menerima Notifikasi Jadwal Pertandingan?");
        checkBox.setBounds(20, 180, 300, 20);

        JLabel labelKlubFavorit = new JLabel("Klub Favorit:");
        labelKlubFavorit.setBounds(20, 210, 120, 20);
        String[] klubFavorit = { "Manchester United", "Manchester City", "Real Madrid",
                "Barcelona FC", "Persib" };
        listKlubFavorit = new JList<>(klubFavorit);
        listKlubFavorit.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(listKlubFavorit);
        listScrollPane.setBounds(130, 210, 150, 80);

        // Alasan (JTextArea)
        JLabel labelAlasan = new JLabel("Alasan Memilih:");
        labelAlasan.setBounds(20, 310, 120, 20);
        textAreaAlasan = new JTextArea();
        JScrollPane scrollAlasan = new JScrollPane(textAreaAlasan);
        scrollAlasan.setBounds(130, 310, 200, 80);

        JLabel labelTanggalLahir = new JLabel("Tanggal Lahir:");
        labelTanggalLahir.setBounds(20, 420, 100, 20);
        spinnerTanggalLahir = new JSpinner(new SpinnerDateModel());
        spinnerTanggalLahir.setBounds(130, 420, 150, 30);
        spinnerTanggalLahir.setEditor(new JSpinner.DateEditor(spinnerTanggalLahir, "dd/MM/yyyy"));

        JButton button = new JButton("Simpan");
        button.setBounds(130, 460, 100, 30);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String noTelp = textFieldNoTelp.getText();
                String jenisKelamin = radioButton1.isSelected() ? "Laki - Laki"
                        : radioButton2.isSelected() ? "Perempuan" : "";
                String notif = checkBox.isSelected() ? "Ya" : "Tidak";
                String klubFavorit = listKlubFavorit.getSelectedValue() != null
                        ? listKlubFavorit.getSelectedValue()
                        : "Belum dipilih";
                String alasan = textAreaAlasan.getText();
                String tanggalLahir = ((JSpinner.DateEditor) spinnerTanggalLahir.getEditor()).getFormat()
                        .format(spinnerTanggalLahir.getValue());

                dataDaftar
                        .add(new String[] { nama, noTelp, jenisKelamin, notif, klubFavorit, alasan, tanggalLahir });
                textFieldNama.setText("");
                textFieldNoTelp.setText("");
                bg.clearSelection();
                checkBox.setSelected(false);
                listKlubFavorit.clearSelection();
                textAreaAlasan.setText("");
                spinnerTanggalLahir.setValue(new java.util.Date());
            }
        });

        this.add(button);
        this.add(textFieldNama);
        this.add(labelInputNama);
        this.add(textFieldNoTelp);
        this.add(labelInputNoTelp);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(checkBox);
        this.add(labelKlubFavorit);
        this.add(listScrollPane);
        this.add(labelAlasan);
        this.add(scrollAlasan);
        this.add(labelTanggalLahir);
        this.add(spinnerTanggalLahir);
    }

    public List<String[]> getDataDaftar() {
        return dataDaftar;
    }
}
