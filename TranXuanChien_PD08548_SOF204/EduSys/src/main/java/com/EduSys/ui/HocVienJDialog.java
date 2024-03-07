package com.EduSys.ui;

import com.EduSys.Dao.HocVienDAO;
import com.EduSys.Dao.KhoaHocDAO;
import com.EduSys.Dao.NguoiHocDAO;
import com.EduSys.Entity.ChuyenDe;
import com.EduSys.Entity.HocVien;
import com.EduSys.Entity.KhoaHoc;
import com.EduSys.Entity.NguoiHoc;
import com.EduSys.Utils.MsgBox;
import com.EduSys.Utils.XDate;
import com.EduSys.Utils.XImage;
import com.EduSys.Utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.management.StringValueExp;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class HocVienJDialog extends javax.swing.JDialog {

    public String MaKH;
    NguoiHocDAO nhDAO = new NguoiHocDAO();
    HocVienDAO hvDAO = new HocVienDAO();
    KhoaHocDAO khDAO = new KhoaHocDAO();
    int row = 0;
    DefaultTableModel model;

    void init() {
        setIconImage(XImage.getAppIcon());
        setLocationRelativeTo(null);
        setTitle("HỆ THỐNG HỌC VIÊN");
        this.MaKH = MaKH;
        fillTable();
        fillComboBox();
    }

    public HocVienJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    void clearForm() {
        HocVien hv = new HocVien();
        this.setForm(hv);
        this.row = -1;
    }

    void setForm(HocVien model) {
        txtDiem.setText(String.valueOf(model.getDiem()));
    }

    HocVien getForm() {
        HocVien hv = new HocVien();
        hv.setDiem(Double.valueOf(txtDiem.getText()));
        return hv;
    }

    void updateDiem() {
        int n = tblHocVienKH.getRowCount();
        for (int i = 0; i < n; i++) {
            int mahv = (Integer) tblHocVienKH.getValueAt(i, 1);
            double diem = (Double) tblHocVienKH.getValueAt(i, 4);
            HocVien hv = hvDAO.selectById(mahv);
            hv.setDiem(diem);
            hvDAO.update(hv);
        }
        this.fillTable();
        MsgBox.alert(this, "update thành công!");
    }

    void insert() {
        Object selectedObject = cboNguoiHoc.getSelectedItem();
        if (selectedObject instanceof NguoiHoc) {
            NguoiHoc nguoiHoc = (NguoiHoc) selectedObject;
            KhoaHoc kh = (KhoaHoc) cboNguoiHoc.getSelectedItem();
            int[] rows = tblHocVienKH.getSelectedRows();
            for (int row : rows) {
                String manh = (String) tblHocVienKH.getValueAt(row, 0);
                HocVien hv = new HocVien();
                hv.setMaKH(kh.getMaKH());
                hv.setDiem(0);
                hv.setMaNH(manh);
                hvDAO.insert(hv);
            }
            this.fillTable();

        } else {
        }
    }

    void fillComboBox() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboNguoiHoc.getModel();
        model.removeAllElements();
        NguoiHoc cd = (NguoiHoc) cboNguoiHoc.getSelectedItem();
        try {
            List<NguoiHoc> list = (List<NguoiHoc>) nhDAO.selectAll();
            for (NguoiHoc nh : list) {
                model.addElement(nh);
            }
            fillTable();
        } catch (Exception e) {
            // Xử lý lỗi truy vấn (ví dụ: hiển thị thông báo lỗi)
            System.out.println(e);
        }
    }

    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblHocVienKH.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ trong bảng

        try {
            List<NguoiHoc> nguoiHocList = nhDAO.selectAll();
            List<HocVien> hocVienList = hvDAO.selectAll();
            for (NguoiHoc nh : nguoiHocList) {
                for (HocVien hv : hocVienList) {
                    if (nh.getMaNH().equals(hv.getMaNH())) {
                        Object[] row = {
                            nh.getMaNH(),
                            hv.getMaHV(),
                            nh.getHoTen(),
                            hv.getDiem()
                        };
                        model.addRow(row);
                    }
                }
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        cboNguoiHoc = new javax.swing.JComboBox<>();
        txtDiem = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHocVienKH = new javax.swing.JTable();
        rdoTatCa = new javax.swing.JRadioButton();
        rdoDaNhap = new javax.swing.JRadioButton();
        rdoChuaNhap = new javax.swing.JRadioButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(760, 540));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cboNguoiHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cboNguoiHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNguoiHocActionPerformed(evt);
            }
        });

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboNguoiHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboNguoiHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd))
                .addContainerGap())
        );

        jLabel2.setText("HỌC VIÊN KHÁC");

        jLabel3.setText("HỌC VIÊN CỦA KHÓA");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblHocVienKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã HV", "Mã NH", "Họ Và Tên", "Điểm", "Xóa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblHocVienKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHocVienKHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHocVienKH);

        buttonGroup1.add(rdoTatCa);
        rdoTatCa.setText("Tất cả");

        buttonGroup1.add(rdoDaNhap);
        rdoDaNhap.setText("Đã nhập điểm");

        buttonGroup1.add(rdoChuaNhap);
        rdoChuaNhap.setText("Chưa nhập điểm");

        btnUpdate.setText("Cập nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdoTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoDaNhap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoChuaNhap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoTatCa)
                    .addComponent(rdoDaNhap)
                    .addComponent(rdoChuaNhap)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboNguoiHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNguoiHocActionPerformed
        fillTable();
    }//GEN-LAST:event_cboNguoiHocActionPerformed

    private void tblHocVienKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHocVienKHMouseClicked
        int row = tblHocVienKH.getSelectedRow();
        if (row == -1) {
            return;
        }
        txtDiem.setText(tblHocVienKH.getValueAt(row, 3).toString());
        cboNguoiHoc.setSelectedItem(tblHocVienKH.getValueAt(row, 2));
    }//GEN-LAST:event_tblHocVienKHMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        updateDiem();
    }//GEN-LAST:event_btnUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(HocVienJDialog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HocVienJDialog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HocVienJDialog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HocVienJDialog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HocVienJDialog dialog = new HocVienJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboNguoiHoc;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoChuaNhap;
    private javax.swing.JRadioButton rdoDaNhap;
    private javax.swing.JRadioButton rdoTatCa;
    private javax.swing.JTable tblHocVienKH;
    private javax.swing.JTextField txtDiem;
    // End of variables declaration//GEN-END:variables
}
