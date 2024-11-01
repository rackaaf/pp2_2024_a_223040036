package Tugas3;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Output extends JFrame {
    public Output(List<String[]> dataDaftar) {
        this.setTitle("Data Pendaftar");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columnNames = { "Nama", "No Telpon", "Jenis Kelamin", "Notif", "Klub Favorit", "Alasan",
                "Tanggal Lahir" };
        String[][] data = dataDaftar.toArray(new String[0][0]);

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        this.add(scrollPane, BorderLayout.CENTER);
    }
}
