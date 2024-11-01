package Tugas3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp extends JFrame {
    private Pendaftaran daftar;

    public MainApp() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Pendaftaran");
        setSize(600, 400);
        setLocationRelativeTo(null);

        daftar = new Pendaftaran();

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem menuItemPendaftaran = new JMenuItem("Pendaftaran");
        JMenuItem menuItemLihatData = new JMenuItem("Lihat Data Pendaftar");
        JMenuItem menuExit = new JMenuItem("Exit");

        menu.add(menuItemPendaftaran);
        menu.add(menuItemLihatData);
        menu.add(menuExit);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        menuItemPendaftaran.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                daftar.setVisible(true);
            }
        });

        menuItemLihatData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Output(daftar.getDataDaftar()).setVisible(true);
            }
        });

        menuExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainApp m = new MainApp();
                m.setVisible(true);
            }
        });
    }
}
