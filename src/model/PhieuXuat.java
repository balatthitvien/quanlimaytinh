package model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class PhieuXuat extends Phieu {

    public PhieuXuat() {
    }

    public PhieuXuat(String Maphieu, Timestamp Thoigiantao, String Nguoitao, ArrayList<ChiTietPhieuXuat> CTPhieu, double Tongtien) {
        super(Maphieu, Thoigiantao, Nguoitao, CTPhieu, Tongtien);
    }
}
