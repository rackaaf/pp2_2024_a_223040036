package Latihan3;

import javax.swing.*;
import java.awt.event.*;

public class KeyListenerExample {
    public static void main(String[] args) {
        // membuat frame
        JFrame frame = new JFrame("KeyListener Example");

        // membuat label untuk menampilkan pesan
        JLabel label = new JLabel("Tekan tombol pada keyboard");
        label.setBounds(50, 50, 300, 30);

        // memmbuat text field untuk fokus keyboard
        JTextField textField = new JTextField();
        textField.setBounds(50, 100, 200, 30);

        // menambahkan keyListener ke textField
        textField.addKeyListener(new KeyListener() {
            // dijalankan ketika tombol ditekan
            public void keyPressed(KeyEvent e) {
                label.setText("Key Pressed : " + KeyEvent.getKeyText(e.getKeyCode()));

            }

            // dijalankan ketika tombol dilepaskan
            public void keyReleased(KeyEvent e) {
                label.setText("Key Released : " + KeyEvent.getKeyText(e.getKeyCode()));

            }

            // dijalankan ketika tombol ditekan dan dilepaskan
            public void keyTyped(KeyEvent e) {
                label.setText("Key Typed : " + e.getKeyChar());

            }

        });

        // menambahkan komponen ke frame
        frame.add(label);
        frame.add(textField);

        // setting Frame
        frame.setSize(400, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
