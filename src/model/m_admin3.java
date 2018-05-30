/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connector.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author Brian R
 */
public class m_admin3 {

    Connection connection;
    Statement statement;
    ResultSet resultSet;
    PreparedStatement preparedStatement;
    public int m_id;

    public m_admin3() {
        try {
            connection = config.Connection();
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void chart(int id) {
        try {
            String sql = "select ba.nama_barang, sum(p.jumlah_penjualan) from tb_penjualan p join\n"
                    + "tb_barangtokoo b on p.id_penjualan = b.id_barangtoko\n"
                    + "join barang ba on b.kode_barang = ba.kode_barang where b.id = " + id + ""
                    + "group by ba.nama_barang";
            JDBCCategoryDataset dataset = new JDBCCategoryDataset(config.connection, sql);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            JFreeChart chart = ChartFactory.createLineChart("Chart", "Nama Barang", "Jumlah Penjualan", dataset, PlotOrientation.VERTICAL, false, true, true);
            BarRenderer render = null;
            CategoryPlot plot = null;
            render = new BarRenderer();
            ChartFrame frame = new ChartFrame("Chart", chart);
            frame.setVisible(true);
            frame.setSize(400, 650);
            frame.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public HashMap<String, Integer> comboUsers() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        try {
            String sql = "select id,username from users where status = 3";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            m_combogudang m;

            while (resultSet.next()) {
                m = new m_combogudang(resultSet.getInt(1), resultSet.getString(2));
                map.put(m.getUsername(), m.getId());
            }
        } catch (Exception e) {
            System.out.println("salah");
        }
        return map;
    }

    public HashMap<String, Integer> comboBarangg(int id) {
        m_id = id;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        try {
            String sql = "select b.kode_barang,nama_barang from barang b join tb_barangtokoo tb on b.kode_barang = tb.kode_barang where tb.id = " + m_id;
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            m_combobarang m;

            while (resultSet.next()) {
                m = new m_combobarang(resultSet.getInt(1), resultSet.getString(2));
                map.put(m.getNama_barang(), m.getKode_barang());
            }
        } catch (Exception e) {
            System.out.println("salah");
            System.out.println("hehehe");
        }
        return map;
    }
}
