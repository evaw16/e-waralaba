/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Brian R
 */
import connector.config;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class gudang1 extends javax.swing.JPanel {

//    private String namaBarang;
//    private String kodeBarang, harga, jumlahStok;
//    Connection connection = config.Connection();
    Statement statement;
    ResultSet resultSet;

    public gudang1() {
        initComponents();
//        tampilBarang();

//        btnSimpan.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                try {
//                    String sql = "INSERT INTO barang values(NULL,'" + nama_barang.getText() + "'," + jumlah_stok.getText() + "," + harga_barang.getText() + ")";
//                    statement = connection.createStatement();
//                    statement.executeUpdate(sql);
//
//                    clear();
//                    tampilBarang();
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
//            }
//        });
//
//        btnUbah.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                try {
//                    String sql = "update barang set nama_barang='" + nama_barang.getText() + "', jumlah_stok=" + jumlah_stok.getText() + ", harga=" + harga_barang.getText() + " where kode_barang="+kode_barang.getText();
//                    statement = connection.createStatement();
//                    statement.executeUpdate(sql);
//
//                    clear();
//                    tampilBarang();
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
//            }
//        });
//
//        btnReset.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                clear();
//            }
//        });
//        
//        btnHapus.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                try {
//                    String sql = "delete from barang where kode_barang= "+kode_barang.getText();
//                    statement = connection.createStatement();
//                    statement.executeUpdate(sql);
//
//                    clear();
//                    tampilBarang();
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
//            }
//        });

    }

//    private void clear() {
//        nama_barang.setText("");
//        jumlah_stok.setText("");
//        harga_barang.setText("");
//    }

//    private void tampilBarang() {
//        DefaultTableModel model = new DefaultTableModel();
//        model.addColumn("Kode Barang");
//        model.addColumn("Nama Barang");
//        model.addColumn("Jumlah Stok");
//        model.addColumn("Harga");
//        try {
//            String sql = "select * from barang";
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery(sql);
//
//            int no = 0;
//            while (resultSet.next()) {
//                no++;
//                model.addRow(new Object[]{
//                    resultSet.getString("kode_barang"), resultSet.getString("nama_barang"), resultSet.getString("jumlah_stok"), resultSet.getString("harga")
//                });
//            }
//            table_barang.setModel(model);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
    
    public JButton getBtnHapus() {
        return btnHapus;
    }

    public JButton getBtnReset() {
        return btnReset;
    }

    public JButton getBtnSimpan() {
        return btnSimpan;
    }

    public JButton getBtnUbah() {
        return btnUbah;
    }

    public JTextField getCari_barang() {
        return cari_barang;
    }

    public JTextField getHarga_barang() {
        return harga_barang;
    }

    public JTextField getJumlah_stok() {
        return jumlah_stok;
    }

    public JTextField getKode_barang() {
        return kode_barang;
    }

    public JTextField getNama_barang() {
        return nama_barang;
    }

    public JTable getTable_barang() {
        return table_barang;
    }
    public void setTabelGudang1(DefaultTableModel tabel) {
        this.table_barang.setModel(tabel);
    }
    public void setTabel(JTable t, DefaultTableModel tabel) {
        t.setModel(tabel);
    }

    public void setHarga_barang(String harga_barang) {
        this.harga_barang.setText(harga_barang);
    }

    public void setJumlah_stok(String jumlah_stok) {
        this.jumlah_stok.setText(jumlah_stok);
    }

    public void setKode_barang(String kode_barang) {
        this.kode_barang.setText(kode_barang);
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang.setText(nama_barang);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_barang = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nama_barang = new javax.swing.JTextField();
        kode_barang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jumlah_stok = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        harga_barang = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        cari_barang = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(690, 530));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Barang", "Nama Barang", "Jumlah Stok", "Harga"
            }
        ));
        table_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_barangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_barang);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 380, 470));

        jLabel2.setText("Nama Barang");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel3.setText("Kode Barang");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        nama_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_barangActionPerformed(evt);
            }
        });
        add(nama_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 180, -1));

        kode_barang.setEditable(false);
        add(kode_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 180, -1));

        jLabel4.setText("Jumlah Stok");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));
        add(jumlah_stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 180, -1));

        jLabel1.setText("Harga");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));
        add(harga_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 180, -1));

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnSimpan.png"))); // NOI18N
        btnSimpan.setBorderPainted(false);
        btnSimpan.setContentAreaFilled(false);
        add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 130, 50));

        btnUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnUbah.png"))); // NOI18N
        btnUbah.setToolTipText("");
        btnUbah.setBorderPainted(false);
        btnUbah.setContentAreaFilled(false);
        add(btnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, -1, -1));

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnReset.png"))); // NOI18N
        btnReset.setBorderPainted(false);
        btnReset.setContentAreaFilled(false);
        add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, -1, -1));

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnHapus.png"))); // NOI18N
        btnHapus.setBorderPainted(false);
        btnHapus.setContentAreaFilled(false);
        add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        cari_barang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cari_barangKeyPressed(evt);
            }
        });
        add(cari_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 180, -1));

        jLabel5.setText("Pencarian");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void nama_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_barangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_barangActionPerformed

    private void cari_barangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cari_barangKeyPressed
//        DefaultTableModel model = new DefaultTableModel();
//        model.addColumn("Kode Barang");
//        model.addColumn("Nama Barang");
//        model.addColumn("Jumlah Stok");
//        model.addColumn("Harga");
//        try {
//            String sql = "select * from barang where nama_barang like '%" + cari_barang.getText() + "%'";
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery(sql);
//
//            int no = 0;
//            while (resultSet.next()) {
//                no++;
//                model.addRow(new Object[]{
//                    resultSet.getInt("kode_barang"), resultSet.getString("nama_barang"), resultSet.getInt("jumlah_stok"), resultSet.getInt("harga")
//                });
//            }
//            table_barang.setModel(model);
//        } catch (Exception e) {
//            System.out.println("asdkljlasdjlkasdj");
//            System.out.println(e.getMessage());
//        }
    }//GEN-LAST:event_cari_barangKeyPressed

    private void table_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_barangMouseClicked
        int baris = table_barang.getSelectedRow();
        kode_barang.setText(table_barang.getModel().getValueAt(baris, 0).toString());
        nama_barang.setText(table_barang.getModel().getValueAt(baris, 1).toString());
        jumlah_stok.setText(table_barang.getModel().getValueAt(baris, 2).toString());
        harga_barang.setText(table_barang.getModel().getValueAt(baris, 3).toString());
    }//GEN-LAST:event_table_barangMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JTextField cari_barang;
    private javax.swing.JTextField harga_barang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumlah_stok;
    private javax.swing.JTextField kode_barang;
    private javax.swing.JTextField nama_barang;
    private javax.swing.JTable table_barang;
    // End of variables declaration//GEN-END:variables

}
