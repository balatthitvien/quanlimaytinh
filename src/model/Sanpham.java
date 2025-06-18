/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.util.Objects;

public class Sanpham {
    private String Masp;
    private String Tensp;
    private String Donvitinh;
    private int Soluong;
    private double Gianhap;
    private double Giaban;
    private String Loaisp;
    private String Mancc;
    private String Ghichu;
    private int Trangthai;
    private Date Ngaysanxuat;
    private Date Hansudung;
    
public Sanpham(){}
    public Sanpham(String Masp, String Tensp, String Donvitinh, int Soluong, Double Gianhap, Double Giaban,
               Date Ngaysanxuat, Date Hansudung ,String Loaisp, String Mancc, int Trangthai,  String Ghichu) {
    this.Masp = Masp;
    this.Tensp = Tensp;
    this.Donvitinh = Donvitinh;
    this.Soluong = Soluong;
    this.Gianhap = Gianhap;
    this.Giaban = Giaban;
    this.Loaisp = Loaisp;
    this.Mancc = Mancc;
    this.Ghichu = Ghichu;
    this.Trangthai = Trangthai;
    this.Ngaysanxuat = Ngaysanxuat;
    this.Hansudung = Hansudung;
}

    public Sanpham(String Masp, String Tensp, int Soluong, double Gianhap,double Giaban, String Loaisp, String Mancc, Date Ngaysanxuat, Date Hansudung, int Trangthai) {
        this.Masp = Masp;
        this.Tensp = Tensp;
        this.Soluong = Soluong;
        this.Gianhap = Gianhap;
        this.Giaban = Giaban;
        this.Loaisp= Loaisp;
        this.Mancc = Mancc;
        this.Ngaysanxuat=Ngaysanxuat;
        this.Hansudung=Hansudung;
        this.Trangthai=Trangthai;
    }

    public Sanpham(String Masp, String Tensp, String Donvitinh, int Soluong, double Gianhap, double Giaban, java.sql.Date Ngaysanxuat, java.sql.Date Hansudung, String Loaisp, int Trangthai, String Ghichu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public String getMasp() {
        return Masp;
    }

    public void setMasp(String Masp) {
        this.Masp = Masp;
    }

    public String getTensp() {
        return Tensp;
    }

    public void setTensp(String Tensp) {
        this.Tensp= Tensp;
    }
public String getDonvitinh() {
        return Donvitinh;
    }

    public void setDonvitinh(String Donvitinh) {
        this.Donvitinh = Donvitinh;
    }
    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public double getGianhap() {
        return Gianhap;
    }

    public void setGianhap(double Gianhap) {
        this.Gianhap = Gianhap;
    }
 public double getGiaban() {
        return Giaban;
    }

    public void setGiaban(double Giaban) {
        this.Giaban = Giaban;
    }
    public String getLoaisp() {
        return Loaisp;
    }

    public void setLoaisp(String Loaisp) {
        this.Loaisp= Loaisp;
    }

    public String getMancc() {
        return Mancc;
    }

    public void setMancc(String Mancc) {
        this.Mancc = Mancc;
    }

    public String getGhichu() {
        return Ghichu;
    }

    public void setGhichu(String Ghichu) {
        this.Ghichu = Ghichu;
    }

    public int getTrangthai() {
        return Trangthai;
    }

    public void setTrangthai(int Trangthai) {
        this.Trangthai = Trangthai;
    }

    public Date getNgaysanxuat() {
        return Ngaysanxuat;
    }

    public void setNgaysanxuat(Date Ngaysanxuat) {
        this.Ngaysanxuat = Ngaysanxuat;
    }
    public Date getHansudung() {
        return Hansudung;
    }

    public void setHansudung(Date Hansudung) {
        this.Hansudung = Hansudung;
    }
     public void xuatHang(int sl) {
        if (sl > 0 && sl <= this.Soluong) {
            this.Soluong -= sl;
        }
    }
    @Override
    public String toString() {
        return "Sanpham{" + "Masp=" + Masp + ", Tensp=" + Tensp + ", Donvitinh=" + Donvitinh + ",Soluong=" + Soluong + ",Gianhap=" + Gianhap + ",Giaban=" + Giaban + ", Loaisp=" + Loaisp + ", Mancc=" + Mancc + ", Ngaysanxuat=" + Ngaysanxuat + ", Hansudung=" + Hansudung +  '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Sanpham other = (Sanpham) obj;
        return Soluong == other.Soluong &&
               Double.compare(other.Gianhap, Gianhap) == 0 &&
               Double.compare(other.Giaban, Giaban) == 0 &&
               Trangthai == other.Trangthai &&
               Objects.equals(Masp, other.Masp) &&
               Objects.equals(Tensp, other.Tensp) &&
               Objects.equals(Donvitinh, other.Donvitinh) &&
               Objects.equals(Loaisp, other.Loaisp) &&
               Objects.equals(Mancc, other.Mancc) &&
               Objects.equals(Ghichu, other.Ghichu) &&
               Objects.equals(Ngaysanxuat, other.Ngaysanxuat) &&
               Objects.equals(Hansudung, other.Hansudung);
    }
}
