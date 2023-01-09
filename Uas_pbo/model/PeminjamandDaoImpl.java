/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Uas_pbo.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class PeminjamandDaoImpl implements PeminjamanDao {
    List<Peminjaman> data = new ArrayList<>();

    public PeminjamandDaoImpl() {
        data.add(new Peminjaman("1111", "B001", "2023-01-01", "2023-01-03"));
    }
    
    public void save(Peminjaman peminjaman){
        data.add(peminjaman);
    }
    public void update(int index, Peminjaman peminjaman){
        data.set(index, peminjaman);
    }
    public void delete (int index){
        data.remove(index);
    }
    public Peminjaman getPeminjaman(int index){
        return data.get(index);
    }
    
    public List<Peminjaman> getAllPeminjaman(){
        return data;
    }
}
