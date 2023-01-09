/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Uas_pbo.model;

/**
 *
 * @author ASUS
 */
public class Nasabah {
    private String kode;
    private String nama;
    
    public Nasabah() {
    }

    public Nasabah(String kode, String nama, String alamat) {
        this.kode = kode;
        this.nama = nama;
    }

    public String getkode() {
        return kode;
    }

    public void setkode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
