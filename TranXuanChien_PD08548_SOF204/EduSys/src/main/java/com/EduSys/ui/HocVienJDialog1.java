package com.EduSys.ui;

import com.EduSys.Dao.ChuyenDeDAO;
import com.EduSys.Dao.HocVienDAO;
import com.EduSys.Dao.KhoaHocDAO;
import com.EduSys.Dao.NguoiHocDAO;
import com.EduSys.Entity.ChuyenDe;
import com.EduSys.Entity.HocVien;
import com.EduSys.Entity.KhoaHoc;
import com.EduSys.Entity.NguoiHoc;
import com.EduSys.Utils.Auth;
import com.EduSys.Utils.MsgBox;
import com.EduSys.Utils.XDate;
import com.EduSys.Utils.XImage;
import com.EduSys.Utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.management.StringValueExp;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class HocVienJDialog1 extends javax.swing.JDialog {

    public String MaKH;
    ChuyenDeDAO cdDAO = new ChuyenDeDAO();
    KhoaHocDAO khDAO = new KhoaHocDAO();
    NguoiHocDAO nhDAO = new NguoiHocDAO();
    HocVienDAO hvDAO = new HocVienDAO();
    int row = 0;
    DefaultTableModel model;

    void init() {
        setIconImage(XImage.getAppIcon());
        setLocationRelativeTo(null);
        setTitle("HỆ THỐNG HỌC VIÊN");
        this.MaKH = MaKH;
        fillComboBoxChuyenDe();
    }

    public HocVienJDialog1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    void fillComboBoxChuyenDe() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboChuyenDe.getModel();
        model.removeAllElements();
        List<ChuyenDe> list = cdDAO.selectAll();
        for (ChuyenDe cd : list) {
            //add name of the subject to cbo
            model.addElement(cd);
        }
        this.fillComboBoxKhoaHoc();
    }

    void fillComboBoxKhoaHoc() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboKhoaHoc.getModel();
        model.removeAllElements();
        ChuyenDe cd = (ChuyenDe) cboChuyenDe.getSelectedItem();
        if (cd != null) {
            List<KhoaHoc> list = khDAO.selectByChuyenDe(cd.getMaCD());
            for (KhoaHoc kh : list) {
                model.addElement(kh);
            }
            this.fillTableHocVien();
        }
    }

    void fillTableHocVien() {
        DefaultTableModel model = (DefaultTableModel) tblHocVien.getModel();
        model.setRowCount(0);
        KhoaHoc kh = (KhoaHoc) cboKhoaHoc.getSelectedItem();
        if (kh != null) {
            List<HocVien> list = hvDAO.selectByKhoaHoc(kh.getMaKH());
            for (int i = 0; i < list.size(); i++) {
                HocVien hv = list.get(i);
                String hoten = nhDAO.selectById(hv.getMaNH()).getHoTen();
                model.addRow(new Object[]{i + 1, hv.getMaHV(), hv.getMaNH(), hoten, hv.getDiem()});
            }
            this.fillTableNguoiHoc();
        }
    }

    void fillTableNguoiHoc() {
        DefaultTableModel model = (DefaultTableModel) tblNguoiHoc.getModel();
        model.setRowCount(0);
        KhoaHoc kh = (KhoaHoc) cboKhoaHoc.getSelectedItem();
        String keyword = txtSearch.getText();
        List<NguoiHoc> list = nhDAO.selectNotInCourse(kh.getMaKH(), keyword);
        for (NguoiHoc nh : list) {
            model.addRow(new Object[]{nh.getMaNH(), nh.getHoTen(), nh.isGioiTinh() ? "Nam" : "Nữ",
                XDate.toString(nh.getNgaySinh(), "dd-MM-yyyy"), nh.getDienThoai(), nh.getEmail()});
        }
    }

    void addHocVien() {
        KhoaHoc kh = (KhoaHoc) cboKhoaHoc.getSelectedItem();
        int[] rows = tblNguoiHoc.getSelectedRows();
        for (int row : rows) {
            String manh = (String) tblNguoiHoc.getValueAt(row, 0);
            HocVien hv = new HocVien();
            hv.setMaKH(kh.getMaKH());
            hv.setDiem(0);
            hv.setMaNH(manh);
            hvDAO.insert(hv);
        }
        this.fillTableHocVien();
        this.fillTableNguoiHoc();
    }

    void removeHocVien() {
        if (!Auth.isManager()) {
            MsgBox.alert(this, "Bạn không có quyền xóa");
        } else {
            int[] rows = tblHocVien.getSelectedRows();
            if (rows.length > 0 && MsgBox.confirm(this, "bạn có muốn xóa nó")) {
                for (int row : rows) {
                    int mahv = (Integer) tblHocVien.getValueAt(row, 1);
                    hvDAO.delete(mahv);
                }
                this.fillTableHocVien();
                this.fillTableNguoiHoc();
            }
        }
    }

    void updateDiem() {
        int n = tblHocVien.getRowCount();
        for (int i = 0; i < n; i++) {
            int mahv = (Integer) tblHocVien.getValueAt(i, 1);
            double diem = (Double) tblHocVien.getValueAt(i, 4);
            HocVien hv = hvDAO.selectById(mahv);
            hv.setDiem(diem);
            hvDAO.update(hv);
        }
        this.fillTableHocVien();
        MsgBox.alert(this, "Sửa thành công");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        pnlSubjects = new javax.swing.JPanel();
        cboChuyenDe = new javax.swing.JComboBox<>();
        pnlCourses = new javax.swing.JPanel();
        cboKhoaHoc = new javax.swing.JComboBox<>();
        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHocVien = new javax.swing.JTable();
        btnRemove = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        rdoDiemCao = new javax.swing.JRadioButton();
        rdoThapDiem = new javax.swing.JRadioButton();
        rdoTatCa = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNguoiHoc = new javax.swing.JTable();
        pnlSearch = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlSubjects.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chuyên đề", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        cboChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboChuyenDeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSubjectsLayout = new javax.swing.GroupLayout(pnlSubjects);
        pnlSubjects.setLayout(pnlSubjectsLayout);
        pnlSubjectsLayout.setHorizontalGroup(
            pnlSubjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubjectsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboChuyenDe, 0, 295, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSubjectsLayout.setVerticalGroup(
            pnlSubjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubjectsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboChuyenDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pnlCourses.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Khóa học", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        cboKhoaHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboKhoaHocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCoursesLayout = new javax.swing.GroupLayout(pnlCourses);
        pnlCourses.setLayout(pnlCoursesLayout);
        pnlCoursesLayout.setHorizontalGroup(
            pnlCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCoursesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboKhoaHoc, 0, 317, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCoursesLayout.setVerticalGroup(
            pnlCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCoursesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblHocVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "MaHV", "MaNH", "Tên", "Điểm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblHocVien);

        btnRemove.setText("Xóa khỏi khóa học");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnUpdate.setText("Sửa điểm");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoDiemCao);
        rdoDiemCao.setText("Đã nhập");
        rdoDiemCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDiemCaoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoThapDiem);
        rdoThapDiem.setText("Chưa Nhập");
        rdoThapDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoThapDiemActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoTatCa);
        rdoTatCa.setText("Tất cả");
        rdoTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTatCaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(rdoDiemCao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoThapDiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoTatCa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRemove)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(16, 16, 16))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnRemove)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdoDiemCao)
                        .addComponent(rdoThapDiem)
                        .addComponent(rdoTatCa)))
                .addGap(9, 9, 9))
        );

        tabs.addTab("Học viên", jPanel1);

        tblNguoiHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MaNH", "HoTen", "GioiTinh", "NgaySinh", "SoDT", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblNguoiHoc);

        pnlSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pnlSearchLayout = new javax.swing.GroupLayout(pnlSearch);
        pnlSearch.setLayout(pnlSearchLayout);
        pnlSearchLayout.setHorizontalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch)
                .addContainerGap())
        );
        pnlSearchLayout.setVerticalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAdd.setText("Thêm vào khóa học");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(pnlSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdd)
                .addGap(14, 14, 14))
        );

        tabs.addTab("Người học", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tabs)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlCourses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlSubjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCourses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboChuyenDeActionPerformed
        fillComboBoxKhoaHoc();
    }//GEN-LAST:event_cboChuyenDeActionPerformed

    private void cboKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboKhoaHocActionPerformed
        fillTableHocVien();
    }//GEN-LAST:event_cboKhoaHocActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        removeHocVien();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        updateDiem();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        fillTableNguoiHoc();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        addHocVien();
    }//GEN-LAST:event_btnAddActionPerformed

    private void filterAndDisplayData(boolean isDiemCao) {
        DefaultTableModel model = (DefaultTableModel) tblHocVien.getModel();
        int rowCount = model.getRowCount();
        KhoaHoc kh = (KhoaHoc) cboKhoaHoc.getSelectedItem();

        if (kh != null) {
            List<HocVien> list = hvDAO.selectByKhoaHoc(kh.getMaKH());
            model.setRowCount(0);

            for (int i = 0; i < list.size(); i++) {
                HocVien hv = list.get(i);
                String hoten = nhDAO.selectById(hv.getMaNH()).getHoTen();
                double diem = hv.getDiem();

                // Lọc theo điểm
                if ((isDiemCao && diem >= 1) || (!isDiemCao && diem < 1)) {
                    model.addRow(new Object[]{i + 1, hv.getMaHV(), hv.getMaNH(), hoten, diem});
                }
            }
            this.fillTableNguoiHoc();
        }
    }
    private void rdoDiemCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDiemCaoActionPerformed

        filterAndDisplayData(true);
    }//GEN-LAST:event_rdoDiemCaoActionPerformed

    private void rdoThapDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoThapDiemActionPerformed

        filterAndDisplayData(false);
    }//GEN-LAST:event_rdoThapDiemActionPerformed

    private void rdoTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTatCaActionPerformed
        // TODO add your handling code here:
        fillTableHocVien();
    }//GEN-LAST:event_rdoTatCaActionPerformed

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
            java.util.logging.Logger.getLogger(HocVienJDialog1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HocVienJDialog1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HocVienJDialog1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HocVienJDialog1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HocVienJDialog1 dialog = new HocVienJDialog1(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cboChuyenDe;
    private javax.swing.JComboBox<String> cboKhoaHoc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlCourses;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JPanel pnlSubjects;
    private javax.swing.JRadioButton rdoDiemCao;
    private javax.swing.JRadioButton rdoTatCa;
    private javax.swing.JRadioButton rdoThapDiem;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblHocVien;
    private javax.swing.JTable tblNguoiHoc;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
