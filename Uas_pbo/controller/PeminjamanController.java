/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Uas_pbo.controller;

import Uas_pbo.model.*;
import Uas_pbo.view.FormPeminjaman;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS 
 */
public class PeminjamanController {
    private FormPeminjaman formPeminjaman;
    private NasabahDao NasabahDao;
    private PeminjamanDao peminjamanDao;
    private Peminjaman peminjaman;

    public PeminjamanController(FormPeminjaman formPeminjaman) {
        this.formPeminjaman = formPeminjaman;
        NasabahDao = new NasabahDaoImpl();
        NasabahDao = new NasabahDaoImpl();
        peminjamanDao = new PeminjamandDaoImpl();
    }   
    
    public void bersihForm(){
        formPeminjaman.getTxtTglPinjam().setText("");
        formPeminjaman.getTxtTglKembali().setText("");
    }
    
    public void setCbokode(){
        formPeminjaman.getCbokode().removeAllItems();
        List<Nasabah> list = NasabahDao.getAll();
        for (Nasabah Nasabah : list) {
            formPeminjaman.getCbokode().
                    addItem(Nasabah.getkode()+"-"+Nasabah.getNama());
        }
    }
    public void setCboNasabah(){
        formPeminjaman.getCboNasabah().removeAllItems();
        List<Nasabah> list = NasabahDao.getAll();
        for (Nasabah Nasabah : list) {
            formPeminjaman.getCboNasabah().
                    addItem(Nasabah.getkode()+"-"+Nasabah.getNama());
        }
    }
    
    public void save(){
        peminjaman = new Peminjaman();
        peminjaman.setkode(formPeminjaman.getCbokode()
                .getSelectedItem().toString().split("-")[0]);
        peminjaman.setKodeNasabah(formPeminjaman.getCboNasabah()
                .getSelectedItem().toString());
        peminjaman.setTglpinjam(formPeminjaman.getTxtTglPinjam().getText());
        peminjaman.setTglkembali(formPeminjaman.getTxtTglKembali().getText());
        peminjamanDao.save(peminjaman);
        JOptionPane.showMessageDialog(formPeminjaman, "Entri Data Ok");
    }
    
    public void getPeminjaman(){
        int index = formPeminjaman.getTblPeminjaman().getSelectedRow();
        peminjaman = peminjamanDao.getPeminjaman(index);
        if(peminjaman != null){
            List<Nasabah> listNasabah = NasabahDao.getAll();
            for(Nasabah Nasabah:listNasabah){
                if(peminjaman.getNasabah()==Nasabah.getNasabah()){
                    formPeminjaman.getCbokode()
                    .setSelectedItem(Nasabah.getkode()+"-"+Nasabah.getNama());
                    break;
                }
            }
            formPeminjaman.getCbokode().setSelectedItem(peminjaman.getkode());
            formPeminjaman.getCboNasabah().setSelectedItem(peminjaman.getNasabah());
            formPeminjaman.getTxtTglPinjam().setText(peminjaman.getTglpinjam());
            formPeminjaman.getTxtjumlahpinjam().setText(peminjaman.getjumlahpinjam());
            formPeminjaman.getTxtTglKembali().setText(peminjaman.getTglkembali());
        }
    }
    
    public void tampilData(){
        DefaultTableModel tabelModel = 
            (DefaultTableModel) formPeminjaman.getTblPeminjaman().getModel();
        tabelModel.setRowCount(0);
        java.util.List<Peminjaman> list = peminjamanDao.getAllPeminjaman();
        for(Peminjaman peminjaman : list){
            Object[] data = {
                peminjaman.getkode(),
                peminjaman.getKodeNasabah(),
                peminjaman.getTglpinjam(),
                peminjaman.getjumlahpinjam(),
                peminjaman.getTglkembali()
            };
            tabelModel.addRow(data); 
        }
    }
}
