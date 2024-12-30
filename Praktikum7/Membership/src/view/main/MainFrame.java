package view.main;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import dao.JenisMemberDao;
import dao.MemberDao;
import view.jenismember.JenisMemberFrame;
import view.member.MemberFrame;

public class MainFrame extends JFrame {
    private JenisMemberFrame jenisMemberFrame;
    private MemberFrame memberFrame;
    private JButton buttonJenisMember;
    private JButton buttonMember;
    private JenisMemberDao jenisMemberDao;
    private MemberDao memberDao;

    public MainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 500);

        // Inisialisasi DAO
        this.jenisMemberDao = new JenisMemberDao();
        this.memberDao = new MemberDao();

        // Inisialisasi Frame untuk JenisMember dan Member
        this.jenisMemberFrame = new JenisMemberFrame(jenisMemberDao);
        this.memberFrame = new MemberFrame(memberDao, jenisMemberDao);

        // Mengatur layout
        this.setLayout(new FlowLayout());
        MainButtonActionListener actionListener = new MainButtonActionListener(this);

        // Inisialisasi tombol
        this.buttonJenisMember = new JButton("Jenis Member");
        this.buttonMember = new JButton("Member");

        // Menambahkan ActionListener ke tombol
        this.buttonJenisMember.addActionListener(actionListener);
        this.buttonMember.addActionListener(actionListener);

        // Menambahkan tombol ke JFrame
        this.add(buttonJenisMember);
        this.add(buttonMember);
    }

    public JButton getButtonJenisMember() {
        return buttonJenisMember;
    }

    public JButton getButtonMember() {
        return buttonMember;
    }

    public void showJenisMemberFrame() {
        if (jenisMemberFrame == null) {
            jenisMemberFrame = new JenisMemberFrame(jenisMemberDao);
        }
        jenisMemberFrame.setVisible(true);
    }

    public void showMemberFrame() {
        if (memberFrame == null) {
            memberFrame = new MemberFrame(memberDao, jenisMemberDao);
        }
        memberFrame.populateComboJenis();
        memberFrame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame f = new MainFrame();
                f.setVisible(true);
            }
        });
    }
}
