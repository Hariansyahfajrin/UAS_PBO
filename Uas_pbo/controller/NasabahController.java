/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Uas_pbo.controller;
import Uas_pbo.view.FormNasabah;
import Uas_pbo.model.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ASUS
 */
public class NasabahController {
    private FormNasabah formNasabah;
    private NasabahDao NasabahDao;
    private Nasabah Nasabah;
    
    public NasabahController(FormNasabah formNasabah){
        this.formNasabah = formNasabah;
        NasabahDao = new NasabahDaoImpl();
    }
    
    public void bersihForm(){
        formNasabah.getTxtkode().setText("");
        formNasabah.getTxtNama().setText("");
    }
    
    public void saveNasabah(){
        Nasabah = new Nasabah();
        Nasabah.setkode(formNasabah.getTxtkode().getText());
        Nasabah.setNama(formNasabah.getTxtNama().getText());
        NasabahDao.save(Nasabah);
        javax.swing.JOptionPane.showMessageDialog(formNasabah, "Entri Ok");
    }
    
    public void getNasabah(){
        int index = formNasabah.getTblNasabah().getSelectedRow();
        Nasabah = NasabahDao.getNasabah(index);
        if(Nasabah != null){
            formNasabah.getTxtkode().setText(Nasabah.getkode());
            formNasabah.getTxtNama().setText(Nasabah.getNama());

        }
    }
    
    public void updateNasabah(){
        int index = formNasabah.getTblNasabah().getSelectedRow();
        Nasabah.setkode(formNasabah.getTxtkode().getText());
        Nasabah.setNama(formNasabah.getTxtNama().getText());
        NasabahDao.update(index, Nasabah);
        javax.swing.JOptionPane.showMessageDialog(formNasabah, "Update Ok");
    }
    
    public void deleteNasabah(){
        int index = formNasabah.getTblNasabah().getSelectedRow();
        NasabahDao.delete(index);
        javax.swing.JOptionPane.showMessageDialog(formNasabah, "Delete Ok");
    }
    
    public void tampilData(){
        DefaultTableModel tabelModel = 
               (DefaultTableModel) formNasabah.getTblNasabah().getModel();
        tabelModel.setRowCount(0);
        java.util.List<Nasabah> list = NasabahDao.getAll();
        for(Nasabah Nasabah : list){
            Object[] data = {
                Nasabah.getkode(),
                Nasabah.getNama() 
            };
            tabelModel.addRow(data); 
        }
    }
}
