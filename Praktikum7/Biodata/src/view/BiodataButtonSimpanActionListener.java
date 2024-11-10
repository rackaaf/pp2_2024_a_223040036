package view;

import model.Biodata;
import dao.BiodataDao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;
import javax.swing.*;

public class BiodataButtonSimpanActionListener implements ActionListener {
    private BiodataFrame biodataFrame;
    private BiodataDao biodataDao;

    public BiodataButtonSimpanActionListener(BiodataFrame biodataFrame, BiodataDao biodataDao) {
        this.biodataFrame = biodataFrame;
        this.biodataDao = biodataDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Mengambil data dari BiodataFrame
        String nama = this.biodataFrame.getNama();
        String alamat = this.biodataFrame.getAlamat();

        // Membuat objek Biodata baru dan mengatur ID serta data lainnya
        Biodata biodata = new Biodata();
        biodata.setId(UUID.randomUUID().toString()); // Menggunakan UUID sebagai ID unik
        biodata.setNama(nama);
        biodata.setAlamat(alamat);

        // Menyimpan Biodata ke database menggunakan BiodataDao
        int result = this.biodataDao.insert(biodata);

        // Menampilkan pesan konfirmasi atau error
        if (result > 0) {
            JOptionPane.showMessageDialog(biodataFrame, "Data berhasil disimpan!");
            this.biodataFrame.clearForm(); // Membersihkan form setelah penyimpanan
        }
    }
}
