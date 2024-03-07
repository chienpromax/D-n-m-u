package com.EduSys.ui;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
import com.EduSys.Dao.*;
import com.EduSys.Entity.NhanVien;
import com.EduSys.Utils.Auth;
import com.EduSys.Utils.MsgBox;
import com.EduSys.ui.*;
import com.EduSys.Utils.XImage;
import java.awt.*;
import javax.swing.JTextField;

public class DangNhapJDialog extends javax.swing.JDialog {

    NhanVienDAO dao = new NhanVienDAO();
    
    void init() {
        setIconImage(XImage.getAppIcon());
        setLocationRelativeTo(null);
        setTitle("ĐĂNG NHẬP HỆ THỐNG");
    }

    public DangNhapJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();

        addPlace(txtTaiKhoan);
        addPlace(txtMatKhau);
    }

    //tạo dòng gạch chân
    public void addPlace(JTextField textField) {
        Font font = textField.getFont();
        font = font.deriveFont(Font.ITALIC);
        textField.setFont(font);
        textField.setForeground(Color.gray);
    }

    public void deletePlace(JTextField textField) {
        Font font = textField.getFont();
        font = font.deriveFont(Font.PLAIN | Font.BOLD);
        textField.setFont(font);
        textField.setForeground(Color.black);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTaiKhoan = new javax.swing.JTextField();
        btnThoat = new javax.swing.JButton();
        btnDangNhap = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        chkHienMatKhau = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 255));
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 51, 153));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("    EduSys");
        jLabel1.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Đăng Nhập EduSys");
        jLabel4.setOpaque(true);

        txtTaiKhoan.setBackground(new java.awt.Color(255, 255, 255));
        txtTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTaiKhoan.setForeground(new java.awt.Color(0, 0, 0));
        txtTaiKhoan.setText("Tài khoản");
        txtTaiKhoan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTaiKhoanFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTaiKhoanFocusLost(evt);
            }
        });

        btnThoat.setBackground(new java.awt.Color(0, 0, 153));
        btnThoat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThoat.setForeground(new java.awt.Color(255, 255, 255));
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        btnDangNhap.setBackground(new java.awt.Color(0, 0, 153));
        btnDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnDangNhap.setText("Đăng Nhập");
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/logos/nonhoctap.png"))); // NOI18N

        txtMatKhau.setBackground(new java.awt.Color(255, 255, 255));
        txtMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMatKhau.setForeground(new java.awt.Color(0, 0, 0));
        txtMatKhau.setText("Mật khẩu");
        txtMatKhau.setEchoChar('\u0000');
        txtMatKhau.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMatKhauFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMatKhauFocusLost(evt);
            }
        });

        chkHienMatKhau.setText("Hiển thị mật khẩu");
        chkHienMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkHienMatKhauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(chkHienMatKhau))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkHienMatKhau)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTaiKhoanFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTaiKhoanFocusGained
        // TODO add your handling code here:
        if (txtTaiKhoan.getText().equals("Tài khoản")) {
            txtTaiKhoan.setText(null);
            txtTaiKhoan.requestFocus();
            deletePlace(txtTaiKhoan);
        }
    }//GEN-LAST:event_txtTaiKhoanFocusGained

    private void txtMatKhauFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMatKhauFocusGained
        // TODO add your handling code here:
        if (txtMatKhau.getText().equals("Mật khẩu")) {
            txtMatKhau.setText(null);
            txtMatKhau.requestFocus();
            txtMatKhau.setEchoChar('*');
            deletePlace(txtMatKhau);
        }
    }//GEN-LAST:event_txtMatKhauFocusGained

    private void txtTaiKhoanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTaiKhoanFocusLost
        // TODO add your handling code here:
        if (txtTaiKhoan.getText().length() == 0) {
            addPlace(txtTaiKhoan);
            txtTaiKhoan.setText("Tài khoản");
        }
    }//GEN-LAST:event_txtTaiKhoanFocusLost

    private void txtMatKhauFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMatKhauFocusLost
        // TODO add your handling code here:
        if (txtMatKhau.getText().length() == 0) {
            addPlace(txtMatKhau);
            txtMatKhau.setText("Mật khẩu");
        }
    }//GEN-LAST:event_txtMatKhauFocusLost

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        this.requestFocusInWindow();
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        ketThuc();
    }//GEN-LAST:event_btnThoatActionPerformed
    void ketThuc(){
        if (MsgBox.confirm(this, "ban muon ket thuc")) {
            System.exit(0);
        }
    }
    void dangNhap(){
        String strMaNV = txtTaiKhoan.getText();
        String strMatKhau = new String(txtMatKhau.getPassword());
        NhanVien nv = dao.selectById(strMaNV);
        if (nv==null) {
            MsgBox.alert(this, "sai tên đăng nhập");
        }else{
            if (!nv.getMatKhau().equals(strMatKhau)) {
                MsgBox.alert(this, "sai mật khẩu");
            }else{
                Auth.user = nv;
                this.dispose();
            }
        }
    }
    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        // TODO add your handling code here:
        dangNhap();
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void chkHienMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkHienMatKhauActionPerformed
        // TODO add your handling code here:
        try {
            if (chkHienMatKhau.isSelected()) {
            txtMatKhau.setEchoChar((char) 0); // Hiển thị mật khẩu thực sự
        } else {
            txtMatKhau.setEchoChar('*'); // Ẩn mật khẩu
        }
        } catch (Exception e) {
            System.out.println(e);
        }     
    }//GEN-LAST:event_chkHienMatKhauActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DangNhapJDialog dialog = new DangNhapJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton btnThoat;
    private javax.swing.JCheckBox chkHienMatKhau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
