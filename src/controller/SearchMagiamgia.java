package controller;

import dao.GiamgiaDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.Giamgia;

public class SearchMagiamgia {

    public static SearchMagiamgia getInstance() {
        return new SearchMagiamgia();
    }

    public ArrayList<Giamgia> searchTatCa(String text) {
        ArrayList<Giamgia> result = new ArrayList<>();
        ArrayList<Giamgia> armt = GiamgiaDAO.getInstance().selectAllExist();
        String keyword = text.toLowerCase().trim();

        for (Giamgia gg : armt) {
            if ((gg.getMagiamgia() != null && gg.getMagiamgia().toLowerCase().contains(keyword)) ||
                (gg.getLoaisp() != null && gg.getLoaisp().toLowerCase().contains(keyword)) ||
                (String.valueOf(gg.getPhantramgiam()).contains(keyword)) ||
                (gg.getNgaybatdau() != null && gg.getNgaybatdau().toString().toLowerCase().contains(keyword)) ||
                (gg.getNgayketthuc() != null && gg.getNgayketthuc().toString().toLowerCase().contains(keyword)) ||
                (gg.getMota() != null && gg.getMota().toLowerCase().contains(keyword)))
                result.add(gg);
            }
        return result;
    }



    public ArrayList<Giamgia> searchMagiamgia(String text) {
        ArrayList<Giamgia> result = new ArrayList<>();
        ArrayList<Giamgia> armt = GiamgiaDAO.getInstance().selectAllExist();
        for (var gg : armt) {
            if (gg.getTrangthai() == 1) {
                if (gg.getMagiamgia().toLowerCase().contains(text.toLowerCase())) {
                    result.add(gg);
                }
            }
        }
        return result;
    }

    public ArrayList<Giamgia> searchLoaisp(String text) {
    ArrayList<Giamgia> result = new ArrayList<>();
    ArrayList<Giamgia> armt = GiamgiaDAO.getInstance().selectAllExist();
    text = text.trim().toLowerCase();

    for (Giamgia gg : armt) {
        String Loaisp = gg.getLoaisp();
        if (gg.getTrangthai() == 1 && Loaisp != null && Loaisp.toLowerCase().contains(text)) {
            result.add(gg);
        }
    }
    return result;
}
    public ArrayList<Giamgia> searchPhantramgiam(String text) {
    ArrayList<Giamgia> result = new ArrayList<>();
    ArrayList<Giamgia> armt = GiamgiaDAO.getInstance().selectAllExist();
    text = text.trim();

    for (Giamgia gg : armt) {
        if (gg.getTrangthai() == 1) {
            if (String.valueOf(gg.getPhantramgiam()).contains(text)) {
                result.add(gg);
            }
        }
    }
    return result;
}

public ArrayList<Giamgia> searchNgaybatdau(String text) {
    ArrayList<Giamgia> result = new ArrayList<>();
    ArrayList<Giamgia> armt = GiamgiaDAO.getInstance().selectAllExist();

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 

    for (Giamgia gg : armt) {
        String ngaybatdauStr = sdf.format(gg.getNgaybatdau());
        if (ngaybatdauStr.toLowerCase().contains(text.toLowerCase())) {
            result.add(gg);
        }
    }

    return result;
}
    public ArrayList<Giamgia> searchNgayketthuc(String text) {
    ArrayList<Giamgia> result = new ArrayList<>();
    ArrayList<Giamgia> armt = GiamgiaDAO.getInstance().selectAllExist();

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 

    for (Giamgia gg : armt) {
        String ngayketthucStr = sdf.format(gg.getNgayketthuc());
        if (ngayketthucStr.toLowerCase().contains(text.toLowerCase())) {
            result.add(gg);
        }
    }

    return result;
}
    public ArrayList<Giamgia> searchMota(String text) {
    ArrayList<Giamgia> result = new ArrayList<>();
    ArrayList<Giamgia> armt = GiamgiaDAO.getInstance().selectAllExist();
    text = text.trim().toLowerCase();

    for (var gg : armt) {
        if (gg.getMota() != null && gg.getMota().toLowerCase().contains(text)) {
            result.add(gg);
        }
    }
    return result;
}

    public ArrayList<Giamgia> searchDaXoa(String text) {
        ArrayList<Giamgia> result = new ArrayList<>();
        ArrayList<Giamgia> armt = GiamgiaDAO.getInstance().selectAll();
        for (var gg : armt) {
            if (gg.getTrangthai() == 0) {
                if (gg.getMagiamgia().toLowerCase().contains(text.toLowerCase())) {
                    result.add(gg);
                }
            }
        }
        return result;
    }
    

}
