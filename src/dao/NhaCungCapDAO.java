/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.sun.jdi.connect.spi.Connection;
import database.JDBCUtil;
import java.sql.Date;
import java.util.ArrayList;
import model.NhaCungCap;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Phieu;

/**
 *
 * @author kali
 */
public class NhaCungCapDAO implements DAOInterface<NhaCungCap> {

    public static NhaCungCapDAO getInstance() {
        return new NhaCungCapDAO();
    }

    @Override
public int insert(NhaCungCap t) {
    if (isMaNCCExist(t.getMancc())) {
        JOptionPane.showMessageDialog(null, "Mã nhà cung cấp " + t.getMancc() + " đã tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return 0;
    }

    int ketQua = 0;
    try {
        java.sql.Connection con = JDBCUtil.getConnection();
        String sql = "INSERT INTO nhacungcap (Mancc, Tenncc, Sdt, Diachi) VALUES (?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, t.getMancc());
        pst.setString(2, t.getTenncc());
        pst.setString(3, t.getSdt());
        pst.setString(4, t.getDiachi());
        ketQua = pst.executeUpdate();
        JDBCUtil.closeConnection(con);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return ketQua;
}



    @Override
    public int update(NhaCungCap t) {
        int ketQua = 0;
        try {
            java.sql.Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE nhacungcap SET Mancc=?, Tenncc=?, Sdt=?, Diachi=? WHERE Mancc=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMancc());
            pst.setString(2, t.getTenncc());
            pst.setString(3, t.getSdt());
            pst.setString(4, t.getDiachi());
            pst.setString(5, t.getMancc());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;

    }

    @Override
    public int delete(NhaCungCap t) {
        int ketQua = 0;
        try {
            java.sql.Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM nhacungcap WHERE Mancc=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMancc());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<NhaCungCap> selectAll() {
        ArrayList<NhaCungCap> ketQua = new ArrayList<NhaCungCap>();
        try {
            java.sql.Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM NhaCungCap";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Mancc = rs.getString("Mancc");
                String Tenncc = rs.getString("Tenncc");
                String sdt = rs.getString("Sdt");
                String Diachi = rs.getString("Diachi");
                NhaCungCap ncc = new NhaCungCap(Mancc, Tenncc, sdt, Diachi);
                ketQua.add(ncc);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public NhaCungCap selectById(String t) {
        NhaCungCap ketQua = null;
        try {
            java.sql.Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM nhacungcap WHERE Mancc=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Mancc = rs.getString("Mancc");
                String Tenncc = rs.getString("Tenncc");
                String sdt = rs.getString("Sdt");
                String Diachi = rs.getString("Diachi");
                ketQua = new NhaCungCap(Mancc, Tenncc, sdt, Diachi);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
    public boolean isMaNCCExist(String mancc) {
    try {
        java.sql.Connection con = JDBCUtil.getConnection();
        String sql = "SELECT COUNT(*) FROM nhacungcap WHERE Mancc=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, mancc);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}
}
