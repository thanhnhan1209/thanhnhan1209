/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.Account;

/**
 *
 * @author Tran Nhat Sinh
 */
public class XuatKho extends javax.swing.JFrame {

    /**
     * Creates new form Navbar
     */
    Color DefaultColor, ClickedColor;
    private Account currentAcc;

    private XuatKho() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Account getCurrentAcc() {
        return currentAcc;
    }

    public XuatKho(Account t) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new FlatLightLaf());
        UIManager.put("Table.showVerticalLines", true);
        UIManager.put("Table.showHorizontalLines", true);
        initComponents();
        setLocationRelativeTo(null);
        this.currentAcc = t;
        XuatHangForm xh = new XuatHangForm();
        xh.setNguoiTao((String) t.getUser());
        MainContent.add(xh).setVisible(true);
        DefaultColor = new Color(51, 102, 255);
        ClickedColor = new Color(51, 102, 255);
        NavbarMenu.setBackground(DefaultColor);
        XuatHang.setBackground(ClickedColor);
        PhieuXuat.setBackground(DefaultColor);
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

        NavbarMenu = new javax.swing.JPanel();
        XuatHang = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        DangXuat = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        NameUser = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        PhieuXuat = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        Account = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        MainContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý kho hàng máy tính");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NavbarMenu.setBackground(new java.awt.Color(51, 102, 255));
        NavbarMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        XuatHang.setBackground(new java.awt.Color(51, 102, 255));
        XuatHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XuatHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XuatHangMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                XuatHangMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_export_25px.png"))); // NOI18N
        jLabel4.setText("XUẤT HÀNG");

        javax.swing.GroupLayout XuatHangLayout = new javax.swing.GroupLayout(XuatHang);
        XuatHang.setLayout(XuatHangLayout);
        XuatHangLayout.setHorizontalGroup(
            XuatHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(XuatHangLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        XuatHangLayout.setVerticalGroup(
            XuatHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, XuatHangLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        NavbarMenu.add(XuatHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 240, 40));

        DangXuat.setBackground(new java.awt.Color(51, 102, 255));
        DangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DangXuatMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DangXuatMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_shutdown_25px.png"))); // NOI18N
        jLabel5.setText("ĐĂNG XUẤT");

        javax.swing.GroupLayout DangXuatLayout = new javax.swing.GroupLayout(DangXuat);
        DangXuat.setLayout(DangXuatLayout);
        DangXuatLayout.setHorizontalGroup(
            DangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DangXuatLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        DangXuatLayout.setVerticalGroup(
            DangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DangXuatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        NavbarMenu.add(DangXuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 690, 240, -1));

        NameUser.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        NameUser.setForeground(new java.awt.Color(255, 255, 255));
        NameUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameUser.setText("ADMIN");
        NameUser.setToolTipText("");
        NavbarMenu.add(NameUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 160, -1));

        jLabel8.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("HI !");
        NavbarMenu.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 40, -1));

        PhieuXuat.setBackground(new java.awt.Color(51, 102, 255));
        PhieuXuat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PhieuXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PhieuXuatMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PhieuXuatMousePressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_database_daily_export_25px.png"))); // NOI18N
        jLabel9.setText("PHIẾU XUẤT");

        javax.swing.GroupLayout PhieuXuatLayout = new javax.swing.GroupLayout(PhieuXuat);
        PhieuXuat.setLayout(PhieuXuatLayout);
        PhieuXuatLayout.setHorizontalGroup(
            PhieuXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PhieuXuatLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel9)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        PhieuXuatLayout.setVerticalGroup(
            PhieuXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PhieuXuatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        NavbarMenu.add(PhieuXuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 240, 40));

        Account.setBackground(new java.awt.Color(51, 102, 255));
        Account.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Account.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AccountMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AccountMousePressed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-information-25.png"))); // NOI18N
        jLabel14.setText("THÔNG TIN");

        javax.swing.GroupLayout AccountLayout = new javax.swing.GroupLayout(Account);
        Account.setLayout(AccountLayout);
        AccountLayout.setHorizontalGroup(
            AccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AccountLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        AccountLayout.setVerticalGroup(
            AccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AccountLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        NavbarMenu.add(Account, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 240, -1));

        getContentPane().add(NavbarMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 750));

        MainContent.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout MainContentLayout = new javax.swing.GroupLayout(MainContent);
        MainContent.setLayout(MainContentLayout);
        MainContentLayout.setHorizontalGroup(
            MainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1180, Short.MAX_VALUE)
        );
        MainContentLayout.setVerticalGroup(
            MainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );

        getContentPane().add(MainContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1180, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void XuatHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XuatHangMousePressed
        // TODO add your handling code here:

        XuatHang.setBackground(ClickedColor);
        PhieuXuat.setBackground(DefaultColor);

    }//GEN-LAST:event_XuatHangMousePressed

    private void PhieuXuatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PhieuXuatMousePressed
        // TODO add your handling code here:

        XuatHang.setBackground(DefaultColor);
        PhieuXuat.setBackground(ClickedColor);

    }//GEN-LAST:event_PhieuXuatMousePressed

    private void DangXuatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DangXuatMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_DangXuatMousePressed

    private void XuatHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XuatHangMouseClicked
        // TODO add your handling code here:
        XuatHangForm xh = new XuatHangForm();
        xh.setNguoiTao((String) this.currentAcc.getUser());
        MainContent.removeAll();
        MainContent.add(xh).setVisible(true);
    }//GEN-LAST:event_XuatHangMouseClicked

    private void PhieuXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PhieuXuatMouseClicked
        // TODO add your handling code here:
        PhieuXuatForm px = new PhieuXuatForm(this.getCurrentAcc());
        MainContent.removeAll();
        MainContent.add(px).setVisible(true);
    }//GEN-LAST:event_PhieuXuatMouseClicked

    private void DangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DangXuatMouseClicked
        // TODO add your handling code here:
        int relly = JOptionPane.showConfirmDialog(
                null,
                "Bạn muốn thoát khỏi chương trình ?",
                "Xác nhận",
                JOptionPane.YES_NO_OPTION);
        if (relly == JOptionPane.YES_OPTION) {
            this.dispose();
            Login a = new Login();
            a.setVisible(true);
        } else {
            DangXuat.setBackground(DefaultColor);
        }
    }//GEN-LAST:event_DangXuatMouseClicked

    private void AccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AccountMouseClicked
        // TODO add your handling code here:
        ChangePassword cp = new ChangePassword(this, rootPaneCheckingEnabled, getCurrentAcc());
        cp.setVisible(true);
    }//GEN-LAST:event_AccountMouseClicked

    private void AccountMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AccountMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_AccountMousePressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int resp = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát ?", "Exit?", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new XuatKho().setVisible(true);
            }
        });
    }

    public void setName(String name) {
        this.NameUser.setText(name);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Account;
    private javax.swing.JPanel DangXuat;
    private javax.swing.JPanel MainContent;
    private javax.swing.JLabel NameUser;
    private javax.swing.JPanel NavbarMenu;
    private javax.swing.JPanel PhieuXuat;
    private javax.swing.JPanel XuatHang;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
