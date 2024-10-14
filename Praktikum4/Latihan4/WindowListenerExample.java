package Latihan4;

import javax.swing.*;
import java.awt.event.*;

public class WindowListenerExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("WindowListener Example");

        // membuat label untuk menampilkan pesan
        JLabel label = new JLabel("lakukan operasi pada jendela");
        label.setBounds(50, 50, 300, 30);

        // menambahkan windowlistener ke frame
        frame.addWindowListener(new WindowListener() {
            // dijalankan ketika jendela dibuka
            public void windowOpened(WindowEvent e) {
                label.setText("Window Opened.");

            }

            // dijalankan ketika jendela sedang dalam proses penutupan
            public void windowClosing(WindowEvent e) {
                label.setText("Window Closing.");
                // bisa menambahkan System.exit(0); jika ingin menghentikan program

            }

            // dijalankan ketika jendela benar benar ditutup
            public void windowClosed(WindowEvent e) {
                System.out.println("Window Closed.");
            }

            // dijalankan ketika jendela diminimalkan
            public void windowIconified(WindowEvent e) {
                label.setText("Window Minimazed.");

            }

            // dijalankan ketika jendela dipulihkan dari minimalkan
            public void windowDeiconified(WindowEvent e) {
                label.setText("Window Restored.");

            }

            // dijalankan ketika jendela menjadi aktif(berfokus)
            public void windowActivated(WindowEvent e) {
                label.setText("Window Activated.");

            }

            // dijalankan ketika jendela kehilangan fokus
            public void windowDeactivated(WindowEvent e) {
                label.setText("Window Deactivated.");

            }

        });

        // menambahkan label ke frame
        frame.add(label);

        // setting frame
        frame.setSize(400, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
