/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import controller.SearchMagiamgia;
import dao.GiamgiaDAO;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.Account;
import model.Giamgia;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class MagiamgiaForm extends javax.swing.JInternalFrame {
    private DefaultTableModel tblModel;
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    
    public MagiamgiaForm() {
    initComponents();
    BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
    ui.setNorthPane(null);
    tblGiamgia.setDefaultEditor(Object.class, null);
    initTable();
    SwingUtilities.invokeLater(() -> {
        loadDataToTable();
    });
    changeTextFind();
     initSearchComboBoxListener();
}
    public void checkRole(Account t) {
        if(t.getRole().equals("Nhân viên nhập") || t.getRole().equals("Nhân viên xuất")) {
            btnAdd.setEnabled(false);
            btnDelete.setEnabled(false);
            btnEdit.setEnabled(false);
            jButton6.setEnabled(false);
        } else {
            System.out.println("abcdjad");
        }
    }
    public final void initTable() {
    tblModel = (DefaultTableModel) tblGiamgia.getModel();
    tblModel.setRowCount(0);
}
    public void loadDataToTable() {
    try {
        GiamgiaDAO mtdao = new GiamgiaDAO();
        ArrayList<Giamgia> armt = mtdao.selectAll();
        tblModel.setRowCount(0); 

        for (Giamgia gg : armt) {
            if (gg.getTrangthai() == 1) {
                tblModel.addRow(new Object[]{
                    gg.getMagiamgia(),
                    gg.getLoaisp(),
                    gg.getPhantramgiam(),
                    gg.getNgaybatdau(),
                    gg.getNgayketthuc(),
                    gg.getMota(),
                    gg.getTrangthai() == 1 ? "Khả dụng " : "Không khả dụng"
                });
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    @SuppressWarnings("unchecked")
                         
    public ArrayList<Giamgia> searchFn(String luaChon, String content) {
    ArrayList<Giamgia> result = new ArrayList<>();
    SearchMagiamgia searchPr = new SearchMagiamgia();
    content = content == null ? "" : content.trim();
    if (luaChon.equals("Đã xóa")) {
        result = searchPr.searchDaXoa(content);
        return result;
    }
    if (content.isEmpty()) {
        result = GiamgiaDAO.getInstance().selectAllExist();
        return result;
    }
    switch (luaChon) {
        case "Tất cả":
            result = searchPr.searchTatCa(content);
            break;
        case "Mã giảm giá":
            result = searchPr.searchMagiamgia(content);
            break;
        case "Loại sản phẩm":
            result = searchPr.searchLoaisp(content);
            break;
        case "Phần trăm giảm":
            result = searchPr.searchPhantramgiam(content);
            break;
        case "Ngày bắt đầu":
            result = searchPr.searchNgaybatdau(content);
            break;
        case "Ngày kết thúc":
            result = searchPr.searchNgayketthuc(content);
            break;
        case "Mô tả":
            result = searchPr.searchMota(content);
            break;
        default:
            result = GiamgiaDAO.getInstance().selectAllExist();
    }
    System.out.println("Lựa chọn: " + luaChon + ", từ khóa: " + content);
    return result;
}

   public void xoaMagiamgiaSelect() {
    int i_row = tblGiamgia.getSelectedRow();
    if (i_row == -1) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn mã giảm giá cần xoá");
        return;
    }
    int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá mã giảm giá này?", "Xoá mã giảm giá",
            JOptionPane.YES_NO_OPTION);
    System.out.println("Lựa chọn: " + luaChon); // Debug
    if (luaChon == JOptionPane.YES_OPTION) {
        Giamgia remove = getMagiamgiaSelect();
        if (remove == null) {
            JOptionPane.showMessageDialog(this, "Không lấy được mã giảm giá đang chọn!");
            return;
        }
        System.out.println("Mã giảm giá cần xóa: " + remove.getMagiamgia());

        int result = GiamgiaDAO.getInstance().deleteTrangthai(remove.getMagiamgia());
        if (result > 0) {
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            loadDataToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }
}
    public Giamgia getMagiamgiaSelect() {
    int selectedRow = tblGiamgia.getSelectedRow();
    if (selectedRow == -1) return null;
    String Magiamgia = tblGiamgia.getValueAt(selectedRow, 0).toString(); 
    return GiamgiaDAO.getInstance().selectById(Magiamgia);
}
    public void loadDataToTableSearch(ArrayList<Giamgia> result) {
        try {
            tblModel.setRowCount(0);
            System.out.println("Số kết quả tìm kiếm: " + result.size());
            for (Giamgia i : result) {         
                tblModel.addRow(new Object[]{
    i.getMagiamgia(), i.getLoaisp(),i.getPhantramgiam(), i.getNgaybatdau(),
    i.getNgayketthuc(),i.getMota(),i.getTrangthai() == 1 ? "Khả dụng" : "Không khả dụng"
});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void changeTextFind() {
    jTextFieldSearch.getDocument().addDocumentListener(new DocumentListener() {
        private void updateSearch() {
            String luaChon = jComboBoxLuaChon.getSelectedItem().toString();
            String content = jTextFieldSearch.getText().trim();
            ArrayList<Giamgia> result = searchFn(luaChon, content);
            loadDataToTableSearch(result);
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            updateSearch();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            updateSearch();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            updateSearch();
        }
    });
}

private void initSearchComboBoxListener() {
    jComboBoxLuaChon.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            String luaChon = jComboBoxLuaChon.getSelectedItem().toString();
            String content = jTextFieldSearch.getText().trim();

            if (luaChon.equals("Đã xóa") && content.isEmpty()) {
                ArrayList<Giamgia> result = SearchMagiamgia.getInstance().searchDaXoa("");
                loadDataToTableSearch(result);
            } else {
                ArrayList<Giamgia> result = searchFn(luaChon, content);
                loadDataToTableSearch(result);
            }
        }
    });
}                     
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDetail = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jComboBoxLuaChon = new javax.swing.JComboBox<>();
        jTextFieldSearch = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGiamgia = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        jToolBar1.setRollover(true);

        btnAdd.setFont(new java.awt.Font("#9Slide03 Saira SemiCondensed SemiBold", 0, 14)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/fast-food.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.setFocusable(false);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAdd);

        btnDelete.setFont(new java.awt.Font("#9Slide03 Saira SemiCondensed SemiBold", 0, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/delete.png"))); // NOI18N
        btnDelete.setText("Xoá");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDelete);

        btnEdit.setFont(new java.awt.Font("#9Slide03 Saira SemiCondensed SemiBold", 0, 14)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/edit (1).png"))); // NOI18N
        btnEdit.setText("Sửa");
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdit.setFocusable(false);
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEdit);

        btnDetail.setFont(new java.awt.Font("#9Slide03 Saira SemiCondensed SemiBold", 0, 14)); // NOI18N
        btnDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/list (2).png"))); // NOI18N
        btnDetail.setText("Xem chi tiết");
        btnDetail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetail.setFocusable(false);
        btnDetail.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDetail.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDetail);
        jToolBar1.add(jSeparator1);

        jButton6.setFont(new java.awt.Font("#9Slide03 Saira SemiCondensed SemiBold", 0, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/spreadsheet.png"))); // NOI18N
        jButton6.setText("Xuất Excel");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        jPanel1.add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 8, 428, 84));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxLuaChon.setFont(new java.awt.Font("#9Slide03 Saira SemiCondensed SemiBold", 0, 14)); // NOI18N
        jComboBoxLuaChon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã giảm giá", "Loại sản phẩm", "Khuyến mãi", "Ngày bắt đầu", "Ngày kết thúc", "Đã xóa" }));
        jComboBoxLuaChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLuaChonActionPerformed(evt);
            }
        });
        jComboBoxLuaChon.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBoxLuaChonPropertyChange(evt);
            }
        });
        jPanel3.add(jComboBoxLuaChon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 150, 40));

        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyReleased(evt);
            }
        });
        jPanel3.add(jTextFieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 360, 40));

        jButton7.setFont(new java.awt.Font("#9Slide03 Saira SemiCondensed SemiBold", 0, 18)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/reload (1).png"))); // NOI18N
        jButton7.setText("Làm mới");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 140, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 8, 722, 84));

        tblGiamgia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã giảm giá", "Loại sản phẩm", "Khuyến mãi", "Ngày bắt đầu", "Ngày kết thúc", "Mô tả", "Trạng thái"
            }
        ));
        jScrollPane1.setViewportView(tblGiamgia);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 118, 1170, 610));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, -1, 1180, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        AddMagiamgia a = new AddMagiamgia(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this), rootPaneCheckingEnabled);
        a.setVisible(true);
        loadDataToTable();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
      if (tblGiamgia.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn mã giảm giá cần xoá");
        } else {
            xoaMagiamgiaSelect();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
      if (tblGiamgia.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn mã giảm giá cần sửa");
        } else {
            UpdateMagiamgia a = new UpdateMagiamgia(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this), rootPaneCheckingEnabled);
            a.setVisible(true);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        // TODO add your handling code here:
        if (tblGiamgia.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn mã giảm giá !");
        } else {
            DetailMagiamgia a = new DetailMagiamgia(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this), rootPaneCheckingEnabled);
            a.setVisible(true);
        }
    }//GEN-LAST:event_btnDetailActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();
            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("Product");
                Row rowCol = sheet.createRow(0);
                for (int i = 0; i < tblGiamgia.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(tblGiamgia.getColumnName(i));
                }
                for (int j = 0; j < tblGiamgia.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 0; k < tblGiamgia.getColumnCount(); k++) {
                        Cell cell = row.createCell(k);
                        if (tblGiamgia.getValueAt(j, k) != null) {
                            cell.setCellValue(tblGiamgia.getValueAt(j, k).toString());
                        }
                    }
                }
                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                wb.close();
                out.close();
                openFile(saveFile.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jComboBoxLuaChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLuaChonActionPerformed

    }//GEN-LAST:event_jComboBoxLuaChonActionPerformed

    private void jComboBoxLuaChonPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBoxLuaChonPropertyChange
        // TODO add your handling code here:
           String luaChon = jComboBoxLuaChon.getSelectedItem().toString();
        String content = jTextFieldSearch.getText();
        ArrayList<Giamgia> result = searchFn(luaChon, content);
        loadDataToTableSearch(result);
    }//GEN-LAST:event_jComboBoxLuaChonPropertyChange

    private void jTextFieldSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchKeyPressed

    private void jTextFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyReleased
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jTextFieldSearchKeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        jComboBoxLuaChon.setSelectedIndex(0);
        jTextFieldSearch.setText("");
        loadDataToTable();

    }//GEN-LAST:event_jButton7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDetail;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBoxLuaChon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblGiamgia;
    // End of variables declaration//GEN-END:variables

private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
