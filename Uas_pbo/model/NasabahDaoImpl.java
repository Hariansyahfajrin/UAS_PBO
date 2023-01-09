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
public class NasabahDaoImpl implements NasabahDao {
    List<Nasabah> data = new ArrayList<>();

    public NasabahDaoImpl() {
        data.add(new Nasabah("1111", "Rian", "Padang"));
        data.add(new Nasabah("1112", "Budi", "Padang panjang"));
        data.add(new Nasabah("1113", "Ani", "Padang"));
    }
    
    public void save(Nasabah Nasabah){
        data.add(Nasabah);
    }
    public void update(int index, Nasabah Nasabah){
        data.set(index, Nasabah);
    }
    public void delete (int index){
        data.remove(index);
    }
    public Nasabah getNasabah(int index){
        return data.get(index);
    }
    
    public List<Nasabah> getAll(){
        return data;
    }
}
