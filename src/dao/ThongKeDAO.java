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
        System.out.println(timeStart);
        System.out.println(timeEnd);

        ArrayList<ThongKeProduct> ketQua = new ArrayList<ThongKeProduct>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT t1.Masp,Tensp,slNhap,slXuat FROM (\n"
                    + "	SELECT Masp, SUM(Soluong) AS slNhap FROM chitietphieunhap \n"
                    + "	JOIN phieunhap ON phieunhap.Maphieu = chitietphieunhap.Maphieu\n"
                    + "	WHERE Thoigiantao BETWEEN ? AND ?"
                    + "	GROUP BY Masp\n"
                    + ") t1 \n"
                    + "JOIN(\n"
                    + "	SELECT Masp, SUM(Soluong) AS slXuat FROM chitietphieuxuat \n"
                    + "	JOIN phieuxuat ON phieuxuat.Maphieu = chitietphieuxuat.Maphieu \n"
                    + "	WHERE Thoigiantao BETWEEN ? AND ?"
                    + "	GROUP BY Masp\n"
                    + ") t2\n"
                    + "ON t1.Masp = t2.Masp\n"
                    + "JOIN Sanpham ON t1.Masp= Sanpham.Masp";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setTimestamp(1, new Timestamp(timeStart.getTime()));
            pst.setTimestamp(2, new Timestamp(timeEnd.getTime()));
            pst.setTimestamp(3, new Timestamp(timeStart.getTime()));
            pst.setTimestamp(4, new Timestamp(timeEnd.getTime()));

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Masp = rs.getString("Masp");
                String Tensp = rs.getString("Tensp");
                int slNhap = rs.getInt("slNhap");
                int slXuat = rs.getInt("slXuat");
                ThongKeProduct p = new ThongKeProduct(Masp, Tensp, slNhap, slXuat);
                ketQua.add(p);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    public ArrayList<ThongKeProduct> getThongKe() {
        ArrayList<ThongKeProduct> ketQua = new ArrayList<ThongKeProduct>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT t1.Masp,Tensp,slNhap,slXuat FROM (\n"
                    + "	SELECT Masp, SUM(Soluong) AS slNhap FROM chitietphieunhap \n"
                    + "	JOIN phieunhap ON phieunhap.Maphieu = chitietphieunhap.Maphieu\n"
                    + "	GROUP BY Masp\n"
                    + ") t1 \n"
                    + "JOIN(\n"
                    + "	SELECT Masp, SUM(Soluong) AS slXuat FROM chitietphieuxuat \n"
                    + "	JOIN phieuxuat ON phieuxuat.Maphieu = chitietphieuxuat.Maphieu \n"
                    + "	GROUP BY Masp\n"
                    + ") t2\n"
                    + "ON t1.Masp = t2.Masp\n"
                    + "JOIN Sanpham ON t1.Masp = Sanpham.Masp";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Masp= rs.getString("Masp");
                String Tensp = rs.getString("Tensp");
                int slNhap = rs.getInt("slNhap");
                int slXuat = rs.getInt("slXuat");
                ThongKeProduct p = new ThongKeProduct(Masp, Tensp, slNhap, slXuat);
                ketQua.add(p);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
}
