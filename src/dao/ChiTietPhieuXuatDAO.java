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
import model.ChiTietPhieuXuat;
import model.Phieu;

public class ChiTietPhieuXuatDAO implements DAOInterface<ChiTietPhieuXuat> {

    public static ChiTietPhieuXuatDAO getInstance() {
        return new ChiTietPhieuXuatDAO();
    }

    @Override
    public int insert(ChiTietPhieuXuat t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO chitietphieuxuat (Maphieu, Masp, Soluong, Giaban) VALUES (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaphieu());
            pst.setString(2, t.getMasp());
            pst.setInt(3, t.getSoluong());
            pst.setDouble(4, t.getGiaban());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(ChiTietPhieuXuat t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE chitietphieuxuat SET Maphieu=?, Masp=?, Soluong=?, Giaban = ?  WHERE Maphieu=? AND Masp=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaphieu());
            pst.setString(2, t.getMasp());
            pst.setInt(3, t.getSoluong());
            pst.setDouble(4, t.getGiaban());
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
    public int delete(ChiTietPhieuXuat t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM chitietphieuxuat WHERE Maphieu=?";
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

    public ArrayList<ChiTietPhieuXuat> selectAll(String t) {
        ArrayList<ChiTietPhieuXuat> ketQua = new ArrayList<ChiTietPhieuXuat>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM chitietphieuxuat WHERE Maphieu=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Maphieu = rs.getString("Maphieu");
                String Masp = rs.getString("Masp");
                int Soluong = rs.getInt("Soluong");
                double Giaban = rs.getDouble("Giaban");
                ChiTietPhieuXuat ctp = new ChiTietPhieuXuat(Maphieu, Masp, Soluong, Giaban);
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
    public ArrayList<ChiTietPhieuXuat> selectAll() {
        ArrayList<ChiTietPhieuXuat> ketQua = new ArrayList<ChiTietPhieuXuat>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM chitietphieuxuat";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Maphieu = rs.getString("Maphieu");
                String Masp = rs.getString("Masp");
                int Soluong = rs.getInt("Soluong");
                double Giaban = rs.getDouble("Giaban");
                ChiTietPhieuXuat ctp = new ChiTietPhieuXuat(Maphieu, Masp, Soluong, Giaban);
                ketQua.add(ctp);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ChiTietPhieuXuat selectById(String t) {
        ChiTietPhieuXuat ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM chitietphieuxuat WHERE Maphieu=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Maphieu = rs.getString("Maphieu");
                String Masp = rs.getString("Masp");
                int Soluong = rs.getInt("Soluong");
                double Giaban = rs.getDouble("Giaban");
                ketQua = new ChiTietPhieuXuat(Maphieu, Masp, Soluong, Giaban);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
}
