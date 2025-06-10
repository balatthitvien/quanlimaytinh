package controller;

import dao.SanphamDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.Sanpham;
/**
 *
 * @author sinh
 */
public class SearchProduct {

    public static SearchProduct getInstance() {
        return new SearchProduct();
    }

    public ArrayList<Sanpham> searchTatCa(String text) {
    ArrayList<Sanpham> result = new ArrayList<>();
    ArrayList<Sanpham> armt = SanphamDAO.getInstance().selectAllExist();
    String keyword = text.toLowerCase().trim();

    for (Sanpham sp : armt) {
        if (sp.getTrangthai() == 1) {
            if ((sp.getMasp() != null && sp.getMasp().toLowerCase().contains(keyword)) ||
                (sp.getTensp() != null && sp.getTensp().toLowerCase().contains(keyword)) ||
                (String.valueOf(sp.getSoluong()).contains(keyword)) ||
                (String.valueOf(sp.getGianhap()).contains(keyword)) ||
                (String.valueOf(sp.getGiaban()).contains(keyword)) ||
                (sp.getLoaisp() != null && sp.getLoaisp().toLowerCase().contains(keyword)) ||
                (sp.getMancc() != null && sp.getMancc().toLowerCase().contains(keyword)) ||
                (sp.getNgaysanxuat() != null && sp.getNgaysanxuat().toString().toLowerCase().contains(keyword)) ||
                (sp.getHansudung() != null && sp.getHansudung().toString().toLowerCase().contains(keyword))) {
                result.add(sp);
            }
        }
    }
    return result;
}



    public ArrayList<Sanpham> searchMasp(String text) {
        ArrayList<Sanpham> result = new ArrayList<>();
        ArrayList<Sanpham> armt = SanphamDAO.getInstance().selectAllExist();
        for (var mt : armt) {
            if (mt.getTrangthai() == 1) {
                if (mt.getMasp().toLowerCase().contains(text.toLowerCase())) {
                    result.add(mt);
                }
            }
        }
        return result;
    }

    public ArrayList<Sanpham> searchTensp(String text) {
        ArrayList<Sanpham> result = new ArrayList<>();
        ArrayList<Sanpham> armt = SanphamDAO.getInstance().selectAllExist();
        for (var mt : armt) {
            if (mt.getTrangThai() == 1) {
                if (mt.getTensp().toLowerCase().contains(text.toLowerCase())) {
                    result.add(mt);
                }
            }
        }
        return result;
    }

    public ArrayList<Sanpham> searchSoluong(String text) {
        ArrayList<Sanpham> result = new ArrayList<>();
        ArrayList<Sanpham> armt = SanphamDAO.getInstance().selectAllExist();
        for (var mt : armt) {
            if (mt.getTrangthai() == 1) {
                if (text.length() != 0) {
                    if (mt.getSoluong() > Integer.parseInt(text)) {
                        result.add(mt);
                    }
                } else {
                    result.add(mt);
                }
            }
        }
        return result;
    }

    public ArrayList<Sanpham> searchGianhap(String text) {
        ArrayList<Sanpham> result = new ArrayList<>();
        ArrayList<Sanpham> armt = SanphamDAO.getInstance().selectAllExist();
        for (var mt : armt) {
            if (mt.getTrangThai() == 1) {

                if (text.length() != 0) {
                    if (mt.getGianhap() > Integer.parseInt(text)) {
                        result.add(mt);
                    }
                }
                else {
                    result.add(mt);
                }
            } 
        }
        return result;
    }
 public ArrayList<Sanpham> searchGiaban(String text) {
        ArrayList<Sanpham> result = new ArrayList<>();
        ArrayList<Sanpham> armt = SanphamDAO.getInstance().selectAllExist();
        for (var mt : armt) {
            if (mt.getTrangThai() == 1) {

                if (text.length() != 0) {
                    if (mt.getGiaban() > Integer.parseInt(text)) {
                        result.add(mt);
                    }
                }
                else {
                    result.add(mt);
                }
            } 
        }
        return result;
    }
    public ArrayList<Sanpham> searchLoaisp(String text) {
        ArrayList<Sanpham> result = new ArrayList<>();
        ArrayList<Sanpham> armt = SanphamDAO.getInstance().selectAllExist();
        for (var mt : armt) {
            if (mt.getLoaisp().toLowerCase().contains(text.toLowerCase())) {
                result.add(mt);
            }
        }
        return result;
    }

    public ArrayList<Sanpham> searchMancc(String text) {
        ArrayList<Sanpham> result = new ArrayList<>();
        ArrayList<Sanpham> armt = SanphamDAO.getInstance().selectAllExist();
        for (var mt : armt) {
            if (mt.getMancc().toLowerCase().contains(text.toLowerCase())) {
                result.add(mt);
            }
        }
        return result;
    }

    public ArrayList<Sanpham> searchNgaysanxuat(String text) {
    ArrayList<Sanpham> result = new ArrayList<>();
    ArrayList<Sanpham> armt = SanphamDAO.getInstance().selectAllExist();

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // hoặc yyyy-MM-dd tùy định dạng bạn muốn

    for (Sanpham sp : armt) {
        String ngaysanxuatStr = sdf.format(sp.getNgaysanxuat());
        if (ngaysanxuatStr.toLowerCase().contains(text.toLowerCase())) {
            result.add(sp);
        }
    }

    return result;
}


    public ArrayList<Sanpham> searchHansudung(String text) {
    ArrayList<Sanpham> result = new ArrayList<>();
    ArrayList<Sanpham> armt = SanphamDAO.getInstance().selectAllExist();

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // hoặc yyyy-MM-dd tùy định dạng bạn muốn

    for (Sanpham sp : armt) {
        String hansudungStr = sdf.format(sp.getHansudung());
        if (hansudungStr.toLowerCase().contains(text.toLowerCase())) {
            result.add(sp);
        }
    }

    return result;
}

    public ArrayList<Sanpham> searchDaXoa(String text) {
        ArrayList<Sanpham> result = new ArrayList<>();
        ArrayList<Sanpham> armt = SanphamDAO.getInstance().selectAll();
        for (var mt : armt) {
            if (mt.getTrangThai() == 0) {
                if (mt.getMasp().toLowerCase().contains(text.toLowerCase())) {
                    result.add(mt);
                }
            }
        }
        return result;
    }

    public Sanpham searchId(String text) {
        Sanpham result = new Sanpham();
        ArrayList<Sanpham> armt = SanphamDAO.getInstance().selectAllExist();
        for (var mt : armt) {
            if (mt.getMasp().toLowerCase().contains(text.toLowerCase())) {
                return mt;
            }
        }
        return null;
    }
}
