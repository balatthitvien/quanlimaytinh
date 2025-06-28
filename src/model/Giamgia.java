/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.util.Objects;

public class Giamgia {
    private String Magiamgia;
    private String Loaisp;
    private int Phantramgiam;
    private Date Ngaybatdau;
    private Date Ngayketthuc;
    private String Mota;
    private int Trangthai;

    
public Giamgia(){}
    public Giamgia(String Magiamgia, String Loaisp,int Phantramgiam, Date Ngaybatdau, Date Ngayketthuc, String Mota, int Trangthai) {
    this.Magiamgia = Magiamgia;
    this.Loaisp = Loaisp;
    this.Phantramgiam = Phantramgiam;
    this.Ngaybatdau = Ngaybatdau;
    this.Ngayketthuc = Ngayketthuc;
    this.Mota = Mota;
    this.Trangthai = Trangthai;
}
    public String getMagiamgia() {
        return Magiamgia;
    }

    public void setMagiamgia(String Magiamgia) {
        this.Magiamgia = Magiamgia;
    }

    public String getLoaisp() {
        return Loaisp;
    }

    public void setLoaisp(String Loaisp) {
        this.Loaisp= Loaisp;
    }
    public int getPhantramgiam() {
        return Phantramgiam;
    }
    public void setPhantramgiam(int Phantramgiam) {
        this.Phantramgiam= Phantramgiam;
    }
    public Date getNgaybatdau() {
        return Ngaybatdau;
    }

    public void setNgaybatdau(Date Ngaybatdau) {
        this.Ngaybatdau = Ngaybatdau;
    }
    public Date getNgayketthuc() {
        return Ngayketthuc;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota= Mota;
    }
    public int getTrangthai() {
        return Trangthai;
    }

    public void setTrangthai(int Trangthai) {
        this.Trangthai= Trangthai;
    }



    @Override
    public String toString() {
        return "Giamgia{" + "Magiamgia=" + Magiamgia + ",Loaisp=" + Loaisp + ", Phantramgiam=" + Phantramgiam + ",Ngaybatdau=" + Ngaybatdau + ",Ngayketthuc=" + Ngayketthuc + ",Mota=" + Mota + ", Loaisp=" + Loaisp + ", Trangthai=" + Trangthai + '}';
    }

}

