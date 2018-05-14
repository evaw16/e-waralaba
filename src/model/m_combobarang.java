/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Brian R
 */
public class m_combobarang {
    private int kode_barang;
    private String nama_barang;

    public m_combobarang(int kode_barang, String nama_barang) {
        this.kode_barang = kode_barang;
        this.nama_barang = nama_barang;
    }

    public int getKode_barang() {
        return kode_barang;
    }

    public void setKode_barang(int kode_barang) {
        this.kode_barang = kode_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }
    
    
}
