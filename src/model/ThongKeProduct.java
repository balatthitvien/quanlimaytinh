/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author sinh
 */
public class ThongKeProduct {
    private String Masp;
    private String Tensp;
    private int Slnhap;
    private int Slxuat;

    public ThongKeProduct() {
    }

    public ThongKeProduct(String Masp, String Tensp, int Slnhap, int Slxuat) {
        this.Masp = Masp;
        this.Tensp = Tensp;
        this.Slnhap = Slnhap;
        this.Slxuat = Slxuat;
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
        this.Tensp = Tensp;
    }

    public int getSlnhap() {
        return Slnhap;
    }

    public void setSlNhap(int Slnhap) {
        this.Slnhap= Slnhap;
    }

    public int getSlxuat() {
        return Slxuat;
    }

    public void setSlxuat(int Slxuat) {
        this.Slxuat = Slxuat;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.Masp);
        hash = 53 * hash + Objects.hashCode(this.Tensp);
        hash = 53 * hash + this.Slnhap;
        hash = 53 * hash + this.Slxuat;
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
        final ThongKeProduct other = (ThongKeProduct) obj;
        if (this.Slnhap != other.Slnhap) {
            return false;
        }
        if (this.Slxuat != other.Slxuat) {
            return false;
        }
        if (!Objects.equals(this.Masp, other.Masp)) {
            return false;
        }
        return Objects.equals(this.Tensp, other.Tensp);
    }

    @Override
    public String toString() {
        return "ThongKeProduct{" + "Masp=" + Masp + ",Tensp=" + Tensp + ", Slnhap=" + Slnhap + ", Slxuat=" + Slxuat + '}';
    }
    
    
}
