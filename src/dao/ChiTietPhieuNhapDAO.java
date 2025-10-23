/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.ChiTietPhieuNhap;
import model.ChiTietPhieuNhap;
import model.Phieu;

public class ChiTietPhieuNhapDAO implements DAOInterface<ChiTietPhieuNhap> {

    public static ChiTietPhieuNhapDAO getInstance() {
        return new ChiTietPhieuNhapDAO();
    }

    @Override
    public int insert(ChiTietPhieuNhap t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO chitietphieunhap (Maphieu, Masp, Soluong, Gianhap) VALUES (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaphieu());
            pst.setString(2, t.getMasp());
            pst.setInt(3, t.getSoluong());
            pst.setDouble(4, t.getGianhap());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(ChiTietPhieuNhap t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE chitietphieunhap SET Maphieu=?, Masp=?, Soluong=?, Gianhap = ?  WHERE Maphieu=? AND Masp=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaphieu());
            pst.setString(2, t.getMasp());
            pst.setInt(3, t.getSoluong());
            pst.setDouble(4, t.getGianhap());
            pst.setString(5, t.getMaphieu());
            pst.setString(6, t.getMasp());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(ChiTietPhieuNhap t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM chitietphieunhap WHERE Maphieu=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaphieu());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    public ArrayList<ChiTietPhieuNhap> selectAll(String t) {
        ArrayList<ChiTietPhieuNhap> ketQua = new ArrayList<ChiTietPhieuNhap>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM chitietphieunhap WHERE Maphieu=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Maphieu = rs.getString("Maphieu");
                String Masp = rs.getString("Masp");
                int Soluong = rs.getInt("Soluong");
                double Gianhap = rs.getDouble("Gianhap");
                ChiTietPhieuNhap ctp = new ChiTietPhieuNhap(Maphieu, Masp, Soluong, Gianhap);
                ketQua.add(ctp);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<ChiTietPhieuNhap> selectAll() {
        ArrayList<ChiTietPhieuNhap> ketQua = new ArrayList<ChiTietPhieuNhap>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM chitietphieunhap";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Maphieu = rs.getString("Maphieu");
                String Masp = rs.getString("Masp");
                int Soluong = rs.getInt("Soluong");
                double Gianhap = rs.getDouble("Gianhap");
                ChiTietPhieuNhap ctp = new ChiTietPhieuNhap(Maphieu, Masp, Soluong, Gianhap);
                ketQua.add(ctp);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ChiTietPhieuNhap selectById(String t) {
        ChiTietPhieuNhap ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM chitietphieunhap WHERE Maphieu=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Maphieu = rs.getString("Maphieu");
                String Masp = rs.getString("Masp");
                int Soluong = rs.getInt("Soluong");
                double Gianhap = rs.getDouble("Gianhap");
                ketQua = new ChiTietPhieuNhap(Maphieu, Masp, Soluong, Gianhap);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
}
