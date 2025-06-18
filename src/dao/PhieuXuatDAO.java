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
import model.PhieuXuat;

public class PhieuXuatDAO implements DAOInterface<PhieuXuat> {

    public static PhieuXuatDAO getInstance() {
        return new PhieuXuatDAO();
    }
@Override
public int insert(PhieuXuat t) {
    int ketQua = 0;
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "INSERT INTO phieuxuat (Maphieu, Thoigiantao, Nguoitao, Tongtien) VALUES (?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);

        // ⚠ Thêm dòng này để kiểm tra giá trị Nguoitao
        System.out.println("Nguoitao: " + t.getNguoitao());

        pst.setString(1, t.getMaphieu());
        pst.setTimestamp(2, t.getThoigiantao());
        pst.setString(3, t.getNguoitao());
        pst.setDouble(4, t.getTongtien());

        ketQua = pst.executeUpdate();
        JDBCUtil.closeConnection(con);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return ketQua;
}


    @Override
    public int update(PhieuXuat t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE phieuxuat SET Maphieu=?, Thoigiantao=?, Nguoitao=?, Tongtien = ? WHERE Maphieu=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaphieu());
            pst.setTimestamp(2, t.getThoigiantao());
            pst.setString(3, t.getNguoitao());
            pst.setDouble(4, t.getTongtien());
            pst.setString(5, t.getMaphieu());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
               System.err.println("Lỗi khi thêm phiếu xuất: " + e.getMessage());
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(PhieuXuat t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM phieuxuat WHERE Maphieu=?";
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
    public ArrayList<PhieuXuat> selectAll() {
        ArrayList<PhieuXuat> ketQua = new ArrayList<PhieuXuat>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM phieuxuat ORDER BY Thoigiantao DESC";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Maphieu = rs.getString("Maphieu");
                Timestamp Thoigiantao = rs.getTimestamp("Thoigiantao");
                String Nguoitao = rs.getString("Nguoitao");
                double Tongtien = rs.getDouble("Tongtien");
                PhieuXuat p = new PhieuXuat(Maphieu, Thoigiantao, Nguoitao, ChiTietPhieuXuatDAO.getInstance().selectAll(Maphieu), Tongtien);
                ketQua.add(p);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public PhieuXuat selectById(String t) {
        PhieuXuat ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM phieuxuat WHERE Maphieu=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Maphieu = rs.getString("Maphieu");
                Timestamp Thoigiantao = rs.getTimestamp("Thoigiantao");
                String Nguoitao = rs.getString("Nguoitao");
                double Tongtien = rs.getDouble("Tongtien");
                ketQua = new PhieuXuat(Maphieu, Thoigiantao, Nguoitao, ChiTietPhieuXuatDAO.getInstance().selectAll(Maphieu), Tongtien);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
}
