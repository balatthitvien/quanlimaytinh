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
import model.Sanpham;

public class SanphamDAO implements DAOInterface<Sanpham> {

    public static SanphamDAO getInstance() {
        return new SanphamDAO();
    }

    @Override
    public int insert(Sanpham t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Sanpham t) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE sanpham SET Tensp = ?,Donvitinh=?,Soluong=?,Gianhap=?,Giaban=?,Loaisp=?,Mancc=?,Ghichu=?,Trangthai=?,Ngaysanxuat=?,Hansudung=? WHERE Masp=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getTensp());
            pst.setString(2, t.getDonvitinh());
            pst.setInt(3, t.getSoluong());
            pst.setDouble(4, t.getGianhap());
            pst.setDouble(5, t.getGiaban());
            pst.setString(6, t.getLoaisp());
            pst.setString(7, t.getMancc());
            pst.setString(8, t.getGhichu());
            pst.setInt(9, t.getTrangthai());
            pst.setDate(10, (Date) t.getNgaysanxuat());
            pst.setDate(11, (Date) t.getHansudung());
            pst.setString(12, t.getMasp());
            ketqua = pst.executeUpdate(sql);
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(SanphamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketqua;
    }

    @Override
    public int delete(Sanpham t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM sanpham WHERE Masp=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMasp());
            ketQua = pst.executeUpdate();

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<Sanpham> selectAll() {
    ArrayList<Sanpham> ketQua = new ArrayList<>();
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT Masp, Tensp, Soluong, Gianhap, Giaban, Loaisp, Mancc, Ngaysanxuat, Hansudung, Trangthai FROM sanpham";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            String Masp = rs.getString("Masp");
            String Tensp = rs.getString("Tensp");
            int Soluong = rs.getInt("Soluong");
            double Gianhap = rs.getDouble("Gianhap");
            double Giaban = rs.getDouble("Giaban");
            String Loaisp = rs.getString("Loaisp");
            String Mancc = rs.getString("Mancc");
            Date Ngaysanxuat = rs.getDate("Ngaysanxuat");
            Date Hansudung = rs.getDate("Hansudung");
            int Trangthai =rs.getInt("Trangthai");
 
           Sanpham sp = new Sanpham(Masp, Tensp, Soluong, Gianhap, Giaban, Loaisp, Mancc, Ngaysanxuat, Hansudung, Trangthai);
            ketQua.add(sp);
        }
        JDBCUtil.closeConnection(con);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return ketQua;
}


    @Override
    public Sanpham selectById(String t) {
        Sanpham ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT Masp,Tensp,Donvitinh,Soluong,Gianhap,Giaban,Ngaysanxuat,Hansudung,Loaisp,TrangThai,Ghichu FROM sanpham WHERE Masp = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Masp = rs.getString("Masp");
                String Tensp = rs.getString("Tensp");
                String Donvitinh =rs.getString("Donvitinh");
                int Soluong = rs.getInt("soLuong");
                double Gianhap = rs.getDouble("Gianhap");
                double Giaban = rs.getDouble("Giaban");
                Date Ngaysanxuat=rs.getDate("Ngaysanxuat");
                Date Hansudung=rs.getDate("Hansudung");
                String Loaisp = rs.getString("Loaisp");
                int Trangthai = rs.getInt("Trangthai");
                String Ghichu = rs.getString("Ghichu");
                ketQua = new Sanpham(Masp, Tensp, Donvitinh, Soluong, Gianhap, Giaban, Ngaysanxuat, Hansudung, Loaisp, Trangthai, Ghichu);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    public int updateSoLuong(String Masp, int Soluong) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE sanpham SET Soluong=? WHERE Masp=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Soluong);
            pst.setString(2, Masp);
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    
    public int deleteTrangthai(String Masp){
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE sanpham SET Trangthai=0 WHERE Masp=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, Masp);
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public ArrayList<Sanpham> selectAllE() {
        ArrayList<Sanpham> ketQua = new ArrayList<Sanpham>();
        ArrayList<Sanpham> ketQuaTonKho = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT Masp,Tensp,Donvitinh,Soluong,Gianhap,Giaban,Ngaysanxuat,Hansudung,Loaisp,TrangThai,Ghichu  FROM sanpham";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Masp = rs.getString("Masp");
                String Tensp = rs.getString("Tensp");
                String Donvitinh = rs.getString("Donvitinh");
                int Soluong = rs.getInt("Soluong");
                double Gianhap = rs.getDouble("Gianhap");
                double Giaban = rs.getDouble("Giaban");
                Date Ngaysanxuat=rs.getDate("Ngaysanxuat");
                Date Hansudung=rs.getDate("Hansudung");
                String Loaisp = rs.getString("Loaisp");
                int Trangthai = rs.getInt("Trangthai");
                String Ghichu = rs.getString("Ghichu");
                Sanpham sp = new Sanpham(Masp, Tensp, Donvitinh, Soluong, Gianhap,Giaban, Ngaysanxuat, Hansudung, Loaisp, Trangthai,Ghichu);
                ketQua.add(sp);
            }
            for (Sanpham Sanpham : ketQua) {
                if (Sanpham.getSoluong() > 0) {
                    ketQuaTonKho.add(Sanpham);
                }
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQuaTonKho;
    }
    
        public ArrayList<Sanpham> selectAllExist() {
        ArrayList<Sanpham> ketQua = new ArrayList<Sanpham>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT Masp,Tensp,Donvitinh,Soluong,Gianhap,Giaban,Ngaysanxuat,Hansudung,Loaisp,TrangThai,Ghichu  FROM sanpham WHERE Trangthai = 1";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
              String Masp = rs.getString("Masp");
                String Tensp = rs.getString("Tensp");
                String Donvitinh = rs.getString("Donvitinh");
                int Soluong = rs.getInt("Soluong");
                double Gianhap = rs.getDouble("Gianhap");
                double Giaban = rs.getDouble("Giaban");
                Date Ngaysanxuat=rs.getDate("Ngaysanxuat");
                Date Hansudung=rs.getDate("Hansudung");
                String Loaisp = rs.getString("Loaisp");
                int Trangthai = rs.getInt("Trangthai");
                String Ghichu = rs.getString("Ghichu");
                Sanpham sp = new Sanpham(Masp, Tensp, Donvitinh, Soluong, Gianhap,Giaban, Ngaysanxuat, Hansudung, Loaisp, Trangthai,Ghichu);
                ketQua.add(sp);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
        
    public int getSl() {
        int soluong = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM sanpham WHERE Trangthai = 1";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                soluong++;
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return soluong;
    }
}
