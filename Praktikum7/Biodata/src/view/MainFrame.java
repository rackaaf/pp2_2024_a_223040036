package view;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        JButton openBiodataForm = new JButton("Open Biodata Form");
        openBiodataForm.addActionListener(e -> new BiodataFrame().setVisible(true));
        add(openBiodataForm);

        setTitle("Main Frame");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }
}
