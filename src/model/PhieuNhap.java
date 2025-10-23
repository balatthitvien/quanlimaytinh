/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Tran Nhat Sinh
 */
public class PhieuNhap extends Phieu<ChiTietPhieuNhap> {

    private String Nhacc;

    public PhieuNhap() {
    }

    public PhieuNhap(String Nhacc) {
        this.Nhacc = Nhacc;
    }

    public PhieuNhap(String Nhacc, String Maphieu, Timestamp Thoigiantao, String Nguoitao, ArrayList<ChiTietPhieuNhap> CTPhieu, double Tongtien) {
        super(Maphieu, Thoigiantao, Nguoitao, CTPhieu, Tongtien);
        this.Nhacc = Nhacc;
    }

    public String getNhacc() {
        return Nhacc;
    }

    public void setNhacc(String Nhacc) {
        this.Nhacc = Nhacc;
    }

    @Override
    public String toString() {
        return "PhieuNhap{" + "Nhacc=" + Nhacc + ", Maphieu=" + getMaphieu() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.Nhacc);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final PhieuNhap other = (PhieuNhap) obj;
        return Objects.equals(this.Nhacc, other.Nhacc) &&
               Objects.equals(this.getMaphieu(), other.getMaphieu()) &&
               Double.compare(this.getTongtien(), other.getTongtien()) == 0;
    }
}
