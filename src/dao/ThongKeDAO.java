/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import controller.ConvertDate;
import database.JDBCUtil;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import model.ThongKeProduct;
import java.sql.*;

public class ThongKeDAO {

    public static ThongKeDAO getInstance() {
        return new ThongKeDAO();
    }

    public ArrayList<ThongKeProduct> getThongKe(Date timeStart, Date timeEnd) {

        ArrayList<ThongKeProduct> ketQua = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT sp.Masp, sp.Tensp, "
                    + "IFNULL(tn.slNhap, 0) AS slNhap, "
                    + "IFNULL(tx.slXuat, 0) AS slXuat "
                    + "FROM Sanpham sp "
                    + "LEFT JOIN ("
                    + "    SELECT ctpn.Masp, SUM(ctpn.Soluong) AS slNhap "
                    + "    FROM chitietphieunhap ctpn "
                    + "    JOIN phieunhap pn ON pn.Maphieu = ctpn.Maphieu "
                    + "    GROUP BY ctpn.Masp "
                    + ") tn ON sp.Masp = tn.Masp "
                    + "LEFT JOIN ("
                    + "    SELECT ctpx.Masp, SUM(ctpx.Soluong) AS slXuat "
                    + "    FROM chitietphieuxuat ctpx "
                    + "    JOIN phieuxuat px ON px.Maphieu = ctpx.Maphieu "
                    + "    GROUP BY ctpx.Masp "
                    + ") tx ON sp.Masp = tx.Masp "
                    + "WHERE sp.Hansudung BETWEEN ? AND ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setTimestamp(1, new Timestamp(timeStart.getTime()));
            pst.setTimestamp(2, new Timestamp(timeEnd.getTime()));
       
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Masp = rs.getString("Masp");
                String Tensp = rs.getString("Tensp");
                int slNhap = rs.getInt("slNhap");
                int slXuat = rs.getInt("slXuat");
                ThongKeProduct p = new ThongKeProduct(Masp, Tensp, slNhap, slXuat);
                ketQua.add(p);
                System.out.println(" -> " + Masp + " | " + Tensp + " | Nhập: " + slNhap + " | Xuất: " + slXuat);
            }
            System.out.println("Tổng số dòng: " + ketQua.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public ArrayList<ThongKeProduct> getThongKe() {
        ArrayList<ThongKeProduct> ketQua = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT sp.Masp, sp.Tensp, "
                    + "IFNULL(tn.slNhap, 0) AS slNhap, "
                    + "IFNULL(tx.slXuat, 0) AS slXuat "
                    + "FROM Sanpham sp "
                    + "LEFT JOIN ("
                    + "    SELECT ctpn.Masp, SUM(ctpn.Soluong) AS slNhap "
                    + "    FROM chitietphieunhap ctpn "
                    + "    JOIN phieunhap pn ON pn.Maphieu = ctpn.Maphieu "
                    + "    GROUP BY ctpn.Masp "
                    + ") tn ON sp.Masp = tn.Masp "
                    + "LEFT JOIN ("
                    + "    SELECT ctpx.Masp, SUM(ctpx.Soluong) AS slXuat "
                    + "    FROM chitietphieuxuat ctpx "
                    + "    JOIN phieuxuat px ON px.Maphieu = ctpx.Maphieu "
                    + "    GROUP BY ctpx.Masp "
                    + ") tx ON sp.Masp = tx.Masp";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Masp = rs.getString("Masp");
                String Tensp = rs.getString("Tensp");
                int slNhap = rs.getInt("slNhap");
                int slXuat = rs.getInt("slXuat");
                ThongKeProduct p = new ThongKeProduct(Masp, Tensp, slNhap, slXuat);
                ketQua.add(p);
                System.out.println(" -> " + Masp + " | " + Tensp + " | Nhập: " + slNhap + " | Xuất: " + slXuat);
            }
            System.out.println("Tổng số dòng: " + ketQua.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
