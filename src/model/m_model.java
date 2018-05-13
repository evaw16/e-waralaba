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
public abstract class m_model extends connector.config {

    public m_model() {
        
    }

    public abstract void simpanData(String a);

    public abstract void ubahData(String a);

    public abstract void hapusData(int a);
}
