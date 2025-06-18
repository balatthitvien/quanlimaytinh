/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

public class ChiTietPhieuXuat {

    private String Maphieu;
    private String Masp;
    private int Soluong;
    private double Giaban;

    public ChiTietPhieuXuat() {
    }

    public ChiTietPhieuXuat(String Maphieu, String Masp, int Soluong, double Giaban) {
        this.Maphieu = Maphieu;
        this.Masp = Masp;
        this.Soluong = Soluong;
        this.Giaban = Giaban;
    }

    public String getMaphieu() {
        return Maphieu;
    }

    public void setMaphieu(String Maphieu) {
        this.Maphieu = Maphieu;
    }

    public String getMasp() {
        return Masp;
    }

    public void setMasp(String Masp) {
        this.Masp = Masp;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public double getGiaban() {
        return Giaban;
    }

    public void setGiaban(double Giaban) {
        this.Giaban = Giaban;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ChiTietPhieuXuat other = (ChiTietPhieuXuat) obj;
        if (this.Soluong != other.Soluong) {
            return false;
        }
        if (Double.doubleToLongBits(this.Giaban) != Double.doubleToLongBits(other.Giaban)) {
            return false;
        }
        if (!Objects.equals(this.Maphieu, other.Maphieu)) {
            return false;
        }
        return Objects.equals(this.Masp, other.Masp);
    }

    @Override
    public String toString() {
        return "ChiTietPhieu{" + "Maphieu=" + Maphieu + ", Masp=" + Masp + ", Soluong=" + Soluong + ", Giaban=" + Giaban + '}';
    }

    
}
