/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author kali
 */
public class NhaCungCap {
    private String Mancc;
    private String Tenncc;
    private String Sdt;
    private String Diachi;

    public NhaCungCap() {
    }

    public NhaCungCap(String Mancc, String Tenncc, String Sdt, String Diachi) {
        this.Mancc = Mancc;
        this.Tenncc = Tenncc;
        this.Sdt = Sdt;
        this.Diachi = Diachi;
    }

    public String getMancc() {
        return Mancc;
    }

    public void setMancc(String Mancc) {
        this.Mancc = Mancc;
    }

    public String getTenncc() {
        return Tenncc;
    }

    public void setTenncc(String Tenncc) {
        this.Tenncc = Tenncc;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.Mancc);
        hash = 29 * hash + Objects.hashCode(this.Tenncc);
        hash = 29 * hash + Objects.hashCode(this.Sdt);
        hash = 29 * hash + Objects.hashCode(this.Diachi);
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
        final NhaCungCap other = (NhaCungCap) obj;
        if (!Objects.equals(this.Mancc, other.Mancc)) {
            return false;
        }
        if (!Objects.equals(this.Tenncc, other.Tenncc)) {
            return false;
        }
        if (!Objects.equals(this.Sdt, other.Sdt)) {
            return false;
        }
        return Objects.equals(this.Diachi, other.Diachi);
    }

    @Override
    public String toString() {
        return "NhaCungCap{" + "Mancc=" + Mancc + ", Tenncc=" + Tenncc + ", Sdt=" + Sdt + ", Diachi=" + Diachi + '}';
    }
    
    
}
