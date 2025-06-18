package model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Objects;

public class Phieu<T> {
    private String Maphieu;
    private Timestamp Thoigiantao;
    String Nguoitao;
    private ArrayList<T> CTPhieu;
    private double Tongtien;

    public Phieu() {
    }

    public Phieu(String Maphieu, Timestamp Thoigiantao, String Nguoitao, ArrayList<T> CTPhieu, double Tongtien) {
        this.Maphieu = Maphieu;
        this.Thoigiantao = Thoigiantao;
        this.Nguoitao = Nguoitao;
        this.CTPhieu = CTPhieu;
        this.Tongtien = Tongtien;
    }

    public Phieu(String Maphieu, Timestamp Thoigiantao, String Nguoitao, double Tongtien) {
        this.Maphieu = Maphieu;
        this.Thoigiantao = Thoigiantao;
        this.Nguoitao = Nguoitao;
        this.Tongtien = Tongtien;
    }

    public String getMaphieu() {
        return Maphieu;
    }

    public void setMaphieu(String Maphieu) {
        this.Maphieu = Maphieu;
    }

    public Timestamp getThoigiantao() {
        return Thoigiantao;
    }

    public void setThoigiantao(Timestamp Thoigiantao) {
        this.Thoigiantao = Thoigiantao;
    }

    public String getNguoitao() {
        return Nguoitao;
    }

    public void setNguoitao(String Nguoitao) {
        this.Nguoitao = Nguoitao;
    }

    public ArrayList<T> getCTPhieu() {
        return CTPhieu;
    }

    public void setCTPhieu(ArrayList<T> CTPhieu) {
        this.CTPhieu = CTPhieu;
    }

    public double getTongtien() {
        return Tongtien;
    }

    public void setTongtien(double Tongtien) {
        this.Tongtien = Tongtien;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Maphieu, Thoigiantao, Nguoitao, CTPhieu, Tongtien);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Phieu)) return false;
        Phieu<?> other = (Phieu<?>) obj;
        return Double.compare(other.Tongtien, Tongtien) == 0 &&
                Objects.equals(Maphieu, other.Maphieu) &&
                Objects.equals(Thoigiantao, other.Thoigiantao) &&
                Objects.equals(Nguoitao, other.Nguoitao) &&
                Objects.equals(CTPhieu, other.CTPhieu);
    }

    @Override
    public String toString() {
        return "Phieu{" +
                "Maphieu='" + Maphieu + '\'' +
                ", Thoigiantao=" + Thoigiantao +
                ", Nguoitao='" + Nguoitao + '\'' +
                ", CTPhieu=" + CTPhieu +
                ", Tongtien=" + Tongtien +
                '}';
    }
}
