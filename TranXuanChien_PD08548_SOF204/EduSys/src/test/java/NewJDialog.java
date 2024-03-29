
import com.EduSys.Utils.XImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

/**
 *
 * @author xuanc
 */
public class NewJDialog extends javax.swing.JDialog {

    void init() {
        setIconImage(XImage.getAppIcon());
        setLocationRelativeTo(null);
        setTitle("HE THONG QUAN LY DAO TAO HOC VIEN");
        new Timer(1000, new ActionListener() {
            SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss a");
            @Override
             public void actionPerformed(ActionEvent e) {
                lblDongHo.setText(format.format(new Date()));
            }
        }).start();
//        this.openWelcom();
//        this.openLogin();
    }
    public NewJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnDangxuat = new javax.swing.JButton();
        btnKetThuc = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnChuyenDe = new javax.swing.JButton();
        btnNguoiHoc = new javax.swing.JButton();
        btnKhoaHoc = new javax.swing.JButton();
        btnHocVien = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnHuongDan = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblDongHo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnHeThong = new javax.swing.JMenu();
        mniDangNhap = new javax.swing.JMenuItem();
        mniDangXuat = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mniDoiMatKhau = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mniKetThuc = new javax.swing.JMenuItem();
        mnQuanLy = new javax.swing.JMenu();
        mniChuyenDe = new javax.swing.JMenuItem();
        mniKhoaHoc = new javax.swing.JMenuItem();
        mniNguoihoc = new javax.swing.JMenuItem();
        mniHocVien = new javax.swing.JMenuItem();
        mniNhanVien = new javax.swing.JMenuItem();
        mnThongKe = new javax.swing.JMenu();
        mniNguoiHocTungnam = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mniBangDiemKhoa = new javax.swing.JMenuItem();
        mniDiemTungKhoa = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        mniDoanhThuTungChuyenDe = new javax.swing.JMenuItem();
        mnTroGiup = new javax.swing.JMenu();
        mniHuongDanSuDung = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        mniGioiThieuSanPham = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jToolBar1.setBackground(new java.awt.Color(51, 204, 255));
        jToolBar1.setRollover(true);

        btnDangxuat.setForeground(new java.awt.Color(0, 0, 0));
        btnDangxuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/EduSys/Icon/Exit.png"))); // NOI18N
        btnDangxuat.setText("Đăng nhập");
        btnDangxuat.setFocusable(false);
        btnDangxuat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDangxuat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDangxuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangxuatActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDangxuat);

        btnKetThuc.setForeground(new java.awt.Color(0, 0, 0));
        btnKetThuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/EduSys/Icon/Stop.png"))); // NOI18N
        btnKetThuc.setText("Kết thúc");
        btnKetThuc.setFocusable(false);
        btnKetThuc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKetThuc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetThucActionPerformed(evt);
            }
        });
        jToolBar1.add(btnKetThuc);
        jToolBar1.add(jSeparator1);

        btnChuyenDe.setForeground(new java.awt.Color(0, 0, 0));
        btnChuyenDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/EduSys/Icon/Lists.png"))); // NOI18N
        btnChuyenDe.setText("Chuyên đề");
        btnChuyenDe.setFocusable(false);
        btnChuyenDe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChuyenDe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnChuyenDe);

        btnNguoiHoc.setForeground(new java.awt.Color(0, 0, 0));
        btnNguoiHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/EduSys/Icon/Conference.png"))); // NOI18N
        btnNguoiHoc.setText("Người học");
        btnNguoiHoc.setFocusable(false);
        btnNguoiHoc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNguoiHoc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnNguoiHoc);

        btnKhoaHoc.setForeground(new java.awt.Color(0, 0, 0));
        btnKhoaHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/EduSys/Icon/Certificate.png"))); // NOI18N
        btnKhoaHoc.setText("Khóa học");
        btnKhoaHoc.setFocusable(false);
        btnKhoaHoc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKhoaHoc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnKhoaHoc);

        btnHocVien.setForeground(new java.awt.Color(0, 0, 0));
        btnHocVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/EduSys/Icon/User.png"))); // NOI18N
        btnHocVien.setText("Học viên");
        btnHocVien.setFocusable(false);
        btnHocVien.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHocVien.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnHocVien);
        jToolBar1.add(jSeparator2);

        btnHuongDan.setForeground(new java.awt.Color(0, 0, 0));
        btnHuongDan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/EduSys/Icon/Globe.png"))); // NOI18N
        btnHuongDan.setText("Hưỡng dẫn");
        btnHuongDan.setFocusable(false);
        btnHuongDan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHuongDan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnHuongDan);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/EduSys/Icon/Info.png"))); // NOI18N
        jLabel1.setText("HỆ QUẢN LÝ ĐÀO TẠO");

        lblDongHo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/EduSys/Icon/Alarm.png"))); // NOI18N
        lblDongHo.setText("ĐỒNG HỒ 99:99:99 PM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDongHo)
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblDongHo)))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/EduSys/Icon/background.png"))); // NOI18N

        mnHeThong.setText("Hệ thống");

        mniDangNhap.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/EduSys/Icon/Key.png"))); // NOI18N
        mniDangNhap.setText("Đăng Nhập");
        mnHeThong.add(mniDangNhap);

        mniDangXuat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/EduSys/Icon/Exit.png"))); // NOI18N
        mniDangXuat.setText("Đăng Xuất");
        mniDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDangXuatActionPerformed(evt);
            }
        });
        mnHeThong.add(mniDangXuat);
        mnHeThong.add(jSeparator3);

        mniDoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/EduSys/Icon/Refresh.png"))); // NOI18N
        mniDoiMatKhau.setText("Đổi Mật Khẩu");
        mniDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDoiMatKhauActionPerformed(evt);
            }
        });
        mnHeThong.add(mniDoiMatKhau);
        mnHeThong.add(jSeparator4);

        mniKetThuc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, 0));
        mniKetThuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/EduSys/Icon/Stop.png"))); // NOI18N
        mniKetThuc.setText("Kết Thúc");
        mniKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniKetThucActionPerformed(evt);
            }
        });
        mnHeThong.add(mniKetThuc);

        jMenuBar1.add(mnHeThong);

        mnQuanLy.setText("Quản lý");

        mniChuyenDe.setText("Chuyên đề");
        mnQuanLy.add(mniChuyenDe);

        mniKhoaHoc.setText("Khóa học");
        mnQuanLy.add(mniKhoaHoc);

        mniNguoihoc.setText("Người học");
        mnQuanLy.add(mniNguoihoc);

        mniHocVien.setText("Học viên");
        mnQuanLy.add(mniHocVien);

        mniNhanVien.setText("Nhân viên");
        mnQuanLy.add(mniNhanVien);

        jMenuBar1.add(mnQuanLy);

        mnThongKe.setText("Thống kê");

        mniNguoiHocTungnam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/EduSys/Icon/Clien list.png"))); // NOI18N
        mniNguoiHocTungnam.setText("Người học từng năm");
        mnThongKe.add(mniNguoiHocTungnam);
        mnThongKe.add(jSeparator5);

        mniBangDiemKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/EduSys/Icon/Card file.png"))); // NOI18N
        mniBangDiemKhoa.setText("Bảng điểm khóa");
        mnThongKe.add(mniBangDiemKhoa);

        mniDiemTungKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/EduSys/Icon/Bar chart.png"))); // NOI18N
        mniDiemTungKhoa.setText("Điểm từng khóa học");
        mnThongKe.add(mniDiemTungKhoa);
        mnThongKe.add(jSeparator6);

        mniDoanhThuTungChuyenDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/EduSys/Icon/Dollar.png"))); // NOI18N
        mniDoanhThuTungChuyenDe.setText("Doanh thu từng chuyển đề");
        mnThongKe.add(mniDoanhThuTungChuyenDe);

        jMenuBar1.add(mnThongKe);

        mnTroGiup.setText("Trợ giúp");

        mniHuongDanSuDung.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        mniHuongDanSuDung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/EduSys/Icon/Globe.png"))); // NOI18N
        mniHuongDanSuDung.setText("Hưỡng dẫn sử dụng");
        mnTroGiup.add(mniHuongDanSuDung);
        mnTroGiup.add(jSeparator7);

        mniGioiThieuSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/EduSys/Icon/Brick house.png"))); // NOI18N
        mniGioiThieuSanPham.setText("Giới thiệu sản phẩm");
        mnTroGiup.add(mniGioiThieuSanPham);

        jMenuBar1.add(mnTroGiup);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDangXuatActionPerformed
        // TODO add your handling code here:
//        dangXuat();
    }//GEN-LAST:event_mniDangXuatActionPerformed

    private void mniDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDoiMatKhauActionPerformed
        // TODO add your handling code here:
        //        openDoiMatKhau();
    }//GEN-LAST:event_mniDoiMatKhauActionPerformed

    private void mniKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniKetThucActionPerformed
        // TODO add your handling code here:
//        ketThuc();
    }//GEN-LAST:event_mniKetThucActionPerformed

    private void btnDangxuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangxuatActionPerformed
        // TODO add your handling code here:
//        dangXuat();
    }//GEN-LAST:event_btnDangxuatActionPerformed

    private void btnKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetThucActionPerformed
        // TODO add your handling code here:
//        ketThuc();
    }//GEN-LAST:event_btnKetThucActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(NewJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewJDialog dialog = new NewJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnChuyenDe;
    private javax.swing.JButton btnDangxuat;
    private javax.swing.JButton btnHocVien;
    private javax.swing.JButton btnHuongDan;
    private javax.swing.JButton btnKetThuc;
    private javax.swing.JButton btnKhoaHoc;
    private javax.swing.JButton btnNguoiHoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblDongHo;
    private javax.swing.JMenu mnHeThong;
    private javax.swing.JMenu mnQuanLy;
    private javax.swing.JMenu mnThongKe;
    private javax.swing.JMenu mnTroGiup;
    private javax.swing.JMenuItem mniBangDiemKhoa;
    private javax.swing.JMenuItem mniChuyenDe;
    private javax.swing.JMenuItem mniDangNhap;
    private javax.swing.JMenuItem mniDangXuat;
    private javax.swing.JMenuItem mniDiemTungKhoa;
    private javax.swing.JMenuItem mniDoanhThuTungChuyenDe;
    private javax.swing.JMenuItem mniDoiMatKhau;
    private javax.swing.JMenuItem mniGioiThieuSanPham;
    private javax.swing.JMenuItem mniHocVien;
    private javax.swing.JMenuItem mniHuongDanSuDung;
    private javax.swing.JMenuItem mniKetThuc;
    private javax.swing.JMenuItem mniKhoaHoc;
    private javax.swing.JMenuItem mniNguoiHocTungnam;
    private javax.swing.JMenuItem mniNguoihoc;
    private javax.swing.JMenuItem mniNhanVien;
    // End of variables declaration//GEN-END:variables
}
