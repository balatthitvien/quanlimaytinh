/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Phieu;
import model.PhieuNhap;

public class PhieuNhapDAO implements DAOInterface<PhieuNhap> {

    public static PhieuNhapDAO getInstance() {
        return new PhieuNhapDAO();
    }

    @Override
    public int insert(PhieuNhap t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO phieunhap (Maphieu, Thoigiantao, Nguoitao,Mancc, Tongtien) VALUES (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaphieu());
            pst.setTimestamp(2, t.getThoigiantao());
            pst.setString(3, t.getNguoitao());
            pst.setString(4, t.getNhacc());
            pst.setDouble(5, t.getTongtien());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(PhieuNhap t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE phieunhap SET Maphieu=?, Thoigiantao=?, Nguoitao=?, Mancc=?, Tongitne = ? WHERE Maphieu=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaphieu());
            pst.setTimestamp(2, t.getThoigiantao());
            pst.setString(3, t.getNguoitao());
            pst.setString(4, t.getNhacc());
            pst.setDouble(5, t.getTongtien());
            pst.setString(6, t.getMaphieu());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(PhieuNhap t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM phieunhap WHERE Maphieu=?";
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

    @Override
    public ArrayList<PhieuNhap> selectAll() {
        ArrayList<PhieuNhap> ketQua = new ArrayList<PhieuNhap>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM phieunhap ORDER BY Thoigiantao DESC";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Maphieu = rs.getString("Maphieu");
                Timestamp Thoigiantao = rs.getTimestamp("Thoigiantao");
                String Nguoitao = rs.getString("Nguoitao");
                String Mancc = rs.getString("Mancc");
                double Tongtien = rs.getDouble("Tongtien");
                PhieuNhap p = new PhieuNhap(Mancc, Maphieu, Thoigiantao, Nguoitao, ChiTietPhieuNhapDAO.getInstance().selectAll(Maphieu), Tongtien);
                ketQua.add(p);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public PhieuNhap selectById(String t) {
        PhieuNhap ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM phieunhap WHERE Maphieu=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Maphieu = rs.getString("Maphieu");
                Timestamp Thoigiantao = rs.getTimestamp("Thoigiantao");
                String Nguoitao = rs.getString("Nguoitao");
                String Mancc = rs.getString("Mancc");
                double Tongtien = rs.getDouble("Tongtien");
                ketQua = new PhieuNhap(Mancc, Maphieu, Thoigiantao, Nguoitao, ChiTietPhieuNhapDAO.getInstance().selectAll(Maphieu), Tongtien);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    public ArrayList<Phieu> selectAllAccount(String acc) {
        ArrayList<Phieu> ketQua = new ArrayList<Phieu>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT Maphieu,Thoigiantao,Nguoitao,Tongtien FROM phieunhap UNION SELECT * FROM phieuxuat WHERE Nguoitao = ? ORDER BY Thoigiantao DESC";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, acc);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Maphieu = rs.getString("Maphieu");
                Timestamp Thoigiantao = rs.getTimestamp("Thoigiantao");
                String Nguoitao = rs.getString("Nguoitao");
                double Tongtien = rs.getDouble("Tongtien");
                Phieu p = new Phieu(Maphieu, Thoigiantao, Nguoitao, ChiTietPhieuNhapDAO.getInstance().selectAll(Maphieu), Tongtien);
                ketQua.add(p);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    public ArrayList<Phieu> selectAllP() {
        ArrayList<Phieu> ketQua = new ArrayList<Phieu>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT Maphieu,Thoigiantao,Nguoitao,Tongtien FROM phieunhap UNION SELECT * FROM phieuxuat ORDER BY Thoigiantao DESC";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Maphieu = rs.getString("Maphieu");
                Timestamp Thoigiantao = rs.getTimestamp("Thoigiantao");
                String Nguoitao = rs.getString("Nguoitao");
                double Tongtien = rs.getDouble("Tongtien");
                Phieu p = new Phieu(Maphieu, Thoigiantao, Nguoitao, ChiTietPhieuNhapDAO.getInstance().selectAll(Maphieu), Tongtien);
                ketQua.add(p);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

}
