/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Uas_pbo.model;
import java.util.List;
/**
 *
 * @author ASUS7
 */
public interface NasabahDao {
    void save(Nasabah Nasabah);
    void update(int index, Nasabah Nasabah);
    void delete (int index);
    Nasabah getNasabah(int index);
    List<Nasabah> getAll();
}
