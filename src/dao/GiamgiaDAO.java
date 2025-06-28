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
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Giamgia;

public class GiamgiaDAO implements DAOInterface<Giamgia> {

    public static GiamgiaDAO getInstance() {
        return new GiamgiaDAO();
    }

    @Override
    public int insert(Giamgia t) {
        
         int ketqua = 0;
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "INSERT INTO giamgia (Magiamgia, Loaisp, Phantramgiam,Ngaybatdau, Ngayketthuc, Mota, Trangthai) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, t.getMagiamgia());
        pst.setString(2, t.getLoaisp());
        pst.setInt(3, t.getPhantramgiam());
        pst.setDate(4, new java.sql.Date(t.getNgaybatdau().getTime()));
        pst.setDate(5, new java.sql.Date(t.getNgayketthuc().getTime()));
        pst.setString(6, t.getMota());
        pst.setInt(7, t.getTrangthai());
        ketqua = pst.executeUpdate();
        JDBCUtil.closeConnection(con);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return ketqua;
    }

    @Override
    public int update(Giamgia t) {
    int ketqua = 0;
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "UPDATE giamgia SET Magiamgia = ?, Loaisp = ?, Phantramgiam = ?, Ngaybatdau = ?, Ngayketthuc = ?, "
           + "Mota = ?, Trangthai = ? "  
           + "WHERE Magiamgia = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, t.getMagiamgia());
        pst.setString(2, t.getLoaisp());
        pst.setInt(3, t.getPhantramgiam());
        java.sql.Date sqlNgaybatdau = new java.sql.Date(t.getNgaybatdau().getTime());
        java.sql.Date sqlNgayketthuc = new java.sql.Date(t.getNgayketthuc().getTime());
        pst.setDate(4, sqlNgaybatdau);
        pst.setDate(5, sqlNgayketthuc);
        pst.setString(6, t.getMota());
        pst.setInt(7, t.getTrangthai());
        pst.setString(8, t.getMagiamgia());

        ketqua = pst.executeUpdate();
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(GiamgiaDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return ketqua;
}

    @Override
    public int delete(Giamgia t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM giamgia WHERE Magiamgia=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMagiamgia());
            ketQua = pst.executeUpdate();

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<Giamgia> selectAll() {
    ArrayList<Giamgia> ketQua = new ArrayList<>();
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT Magiamgia, Loaisp,Phantramgiam, Ngaybatdau, Ngayketthuc, Mota, Trangthai FROM giamgia";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            String Magiamgia = rs.getString("Magiamgia");
            String Loaisp = rs.getString("Loaisp");
            int Phantramgiam = rs.getInt("Phantramgiam");
            Date Ngaybatdau = rs.getDate("Ngaybatdau");
            Date Ngayketthuc = rs.getDate("Ngayketthuc");
            String Mota = rs.getString("Mota");
            int Trangthai =rs.getInt("Trangthai");
 
           Giamgia gg = new Giamgia(Magiamgia, Loaisp, Phantramgiam, Ngaybatdau,Ngayketthuc, Mota,Trangthai);

            ketQua.add(gg);
        }
        JDBCUtil.closeConnection(con);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return ketQua;
}


    @Override
    public Giamgia selectById(String t) {
        Giamgia ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT Magiamgia,Loaisp,Phantramgiam,Ngaybatdau,Ngayketthuc,Mota,TrangThai FROM giamgia WHERE Magiamgia = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Magiamgia = rs.getString("Magiamgia");
                String Loaisp = rs.getString("Loaisp");
                int Phantramgiam =rs.getInt("Phantramgiam");
                Date Ngaybatdau=rs.getDate("Ngaybatdau");
                Date Ngayketthuc=rs.getDate("Ngayketthuc");
                String Mota = rs.getString("Mota");
                int Trangthai = rs.getInt("Trangthai");
                ketQua = new Giamgia(Magiamgia, Loaisp, Phantramgiam, Ngaybatdau, Ngayketthuc, Mota,Trangthai);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }  
    public int deleteTrangthai(String Masp){
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE giamgia SET Trangthai=0 WHERE Magiamgia=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, Masp);
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }  
        public ArrayList<Giamgia> selectAllExist() {
        ArrayList<Giamgia> ketQua = new ArrayList<Giamgia>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT Magiamgia,Loaisp,Phantramgiam,Ngaybatdau,Ngayketthuc,Mota,TrangThai FROM giamgia WHERE Trangthai = 1";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
             String Magiamgia = rs.getString("Magiamgia");
                String Loaisp = rs.getString("Loaisp");
                int Phantramgiam =rs.getInt("Phantramgiam");
                Date Ngaybatdau=rs.getDate("Ngaybatdau");
                Date Ngayketthuc=rs.getDate("Ngayketthuc");
                String Mota = rs.getString("Mota");
                int Trangthai = rs.getInt("Trangthai");
                Giamgia sp = new Giamgia(Magiamgia, Loaisp, Phantramgiam, Ngaybatdau, Ngayketthuc,Mota, Trangthai);
                ketQua.add(sp);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
  



}
