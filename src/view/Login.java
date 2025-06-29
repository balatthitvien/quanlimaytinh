/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.formdev.flatlaf.FlatLightLaf;
import com.mysql.cj.protocol.Resultset;
import com.sun.jdi.connect.spi.Connection;
import controller.BCrypt;
import dao.AccountDAO;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.Account;

public class Login extends javax.swing.JFrame {

    /**
     * Creates new form JFrame
     */
    Connection con = null;
    Resultset rs = null;
    Color panDefualt, panEnter, panClick;

    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        UIManager.put("Button.focus", Color.white);
        panDefualt = new Color(128, 0, 128); 
        panClick = new Color(89, 168, 120);
        panEnter = new Color(89, 168, 120);
        JPaneLogin.setBackground(panDefualt);
        ImageIcon logo = new ImageIcon(getClass().getResource("/icon/logo.png"));
        setIconImage(logo.getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        loginUser = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        passwordUser = new javax.swing.JPasswordField();
        JPaneLogin = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập vào phần mềm");
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(254, 211, 243));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/970224824336a32e5c75cb80eb37bcf6.jpg"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("#9Slide03 Saira SemiCondensed SemiBold", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 96, 255));
        jLabel8.setText("Mật khẩu");

        loginUser.setBackground(new java.awt.Color(204, 102, 255));
        loginUser.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        loginUser.setForeground(new java.awt.Color(255, 255, 255));
        loginUser.setBorder(null);
        loginUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginUserMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginUserMousePressed(evt);
            }
        });
        loginUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginUserActionPerformed(evt);
            }
        });
        loginUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginUserKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("#9Slide03 Saira SemiCondensed SemiBold", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 96, 255));
        jLabel4.setText("Tên tài khoản");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("#9Slide03 Saira SemiCondensed SemiBold", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 96, 252));
        jLabel3.setText("Đăng nhập");

        jLabel1.setFont(new java.awt.Font("#9Slide03 Saira SemiCondensed SemiBold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 153));
        jLabel1.setText("Hệ thống quản lí siêu thị");

        passwordUser.setBackground(new java.awt.Color(204, 102, 255));
        passwordUser.setForeground(new java.awt.Color(255, 255, 255));
        passwordUser.setBorder(null);
        passwordUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordUserKeyPressed(evt);
            }
        });

        JPaneLogin.setBackground(new java.awt.Color(153, 0, 153));
        JPaneLogin.setBorder(new javax.swing.border.MatteBorder(null));
        JPaneLogin.setForeground(new java.awt.Color(204, 0, 255));
        JPaneLogin.setToolTipText("");
        JPaneLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JPaneLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JPaneLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPaneLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPaneLoginMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPaneLoginMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                JPaneLoginMouseReleased(evt);
            }
        });
        JPaneLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JPaneLoginKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("#9Slide03 Saira SemiCondensed SemiBold", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Đăng nhập");

        javax.swing.GroupLayout JPaneLoginLayout = new javax.swing.GroupLayout(JPaneLogin);
        JPaneLogin.setLayout(JPaneLoginLayout);
        JPaneLoginLayout.setHorizontalGroup(
            JPaneLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPaneLoginLayout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        JPaneLoginLayout.setVerticalGroup(
            JPaneLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPaneLoginLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel7.setFont(new java.awt.Font("#9Slide03 Saira SemiCondensed SemiBold", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 96, 255));
        jLabel7.setText("Quên mật khẩu ?");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jCheckBox1.setBackground(new java.awt.Color(254, 211, 243));
        jCheckBox1.setFont(new java.awt.Font("#9Slide03 Saira SemiCondensed SemiBold", 1, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 96, 255));
        jCheckBox1.setText("Hiện mật khẩu");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordUser, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JPaneLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginUser, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel7)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel6)
                .addGap(24, 24, 24)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(15, 15, 15)
                .addComponent(jCheckBox1)
                .addGap(18, 18, 18)
                .addComponent(JPaneLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(72, 72, 72))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        System.out.println(evt.getKeyCode());

    }//GEN-LAST:event_formKeyPressed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        RecoverPassword rcv = new RecoverPassword(this, rootPaneCheckingEnabled);
        rcv.setVisible(true);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void JPaneLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JPaneLoginKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPaneLoginKeyPressed

    private void JPaneLoginMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPaneLoginMouseReleased
        // TODO add your handling code here:
        JPaneLogin.setBackground(panClick);
    }//GEN-LAST:event_JPaneLoginMouseReleased

    private void JPaneLoginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPaneLoginMousePressed
        // TODO add your handling code here:

        JPaneLogin.setBackground(panEnter);
    }//GEN-LAST:event_JPaneLoginMousePressed

    private void JPaneLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPaneLoginMouseExited
        // TODO add your handling code here:
        JPaneLogin.setBackground(panClick);
    }//GEN-LAST:event_JPaneLoginMouseExited

    private void JPaneLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPaneLoginMouseEntered
        // TODO add your handling code here:
        JPaneLogin.setBackground(panEnter);
    }//GEN-LAST:event_JPaneLoginMouseEntered

    private void JPaneLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPaneLoginMouseClicked
        checkLogin();

    }//GEN-LAST:event_JPaneLoginMouseClicked

    private void passwordUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordUserKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // Enter was pressed. Your code goes here.
            checkLogin();
        }
    }//GEN-LAST:event_passwordUserKeyPressed

    private void loginUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginUserKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // Enter was pressed. Your code goes here.
            checkLogin();
        }
    }//GEN-LAST:event_loginUserKeyPressed

    private void loginUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginUserActionPerformed

    private void loginUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginUserMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginUserMousePressed

    private void loginUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginUserMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_loginUserMouseEntered

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox1.isSelected()) {
        passwordUser.setEchoChar((char) 0); // Hiện mật khẩu
    } else {
        passwordUser.setEchoChar('*'); // Ẩn mật khẩu
    }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new FlatLightLaf());

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    public void checkLogin() {
        String usercheck = loginUser.getText();
        String passwordcheck = passwordUser.getText();
        if (usercheck.equals("") || passwordcheck.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ !", "Cảnh báo !", JOptionPane.WARNING_MESSAGE);
        } else {
            try {                
                Account acc = AccountDAO.getInstance().selectById(usercheck);                
                if (acc == null) {
                    JOptionPane.showMessageDialog(this, "Tài khoản không tồn tại trên hệ thống !", "Cảnh báo !", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (BCrypt.checkpw(passwordcheck, acc.getPassword())) {
                        if (acc.getStatus() == 1) {
                            try {
                                JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
                                this.dispose();
                                String role = acc.getRole();
                                if (role.equals("Admin")) {
                                    Admin ad = new Admin(acc);
                                    ad.setVisible(true);
//                                    ad.setCurrentAcc(acc);
                                    ad.setName(acc.getFullName());
                                } else if (role.equals("Quản lý kho")) {
                                    QuanLiKho ql = new QuanLiKho();
                                    ql.setVisible(true);
                                    ql.setCurrentAcc(acc);
                                    ql.setName(acc.getFullName());
                                } else if (role.equals("Nhân viên nhập")) {
                                    NhapKho ql = new NhapKho(acc);
                                    ql.setVisible(true);
                                    ql.setName(acc.getFullName());
                                } else if (role.equals("Nhân viên xuất")) {
                                    XuatKho ql = new XuatKho(acc);
                                    ql.setVisible(true);
                                    ql.setName(acc.getFullName());
                                }
                            } catch (UnsupportedLookAndFeelException ex) {
                                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Tài khoản của bạn đã bị khóa !", "Cảnh báo !", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Sai mật khẩu !", "Cảnh báo !", JOptionPane.WARNING_MESSAGE);
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPaneLogin;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField loginUser;
    private javax.swing.JPasswordField passwordUser;
    // End of variables declaration//GEN-END:variables
}
