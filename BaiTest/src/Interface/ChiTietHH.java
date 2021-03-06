/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Process.ChucNang;
import Process.DatabaseManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class ChiTietHH extends javax.swing.JFrame {

    /**
     * Creates new form ChiTietHH
     */
    DefaultTableModel dfTableModel;
    int chucNangDaChon = ChucNang.NONE;
    int hdso;
    public ChiTietHH(int hdso) throws SQLException {
        initComponents();
        this.hdso = hdso;
        dfTableModel = (DefaultTableModel) tblDSCTHD.getModel();
        retrieve();
        showData();
    }
    
    private void showData(){
        String mahh = cbMahh.getSelectedItem().toString();
        try {
            lblDongia.setText(DatabaseManager.LayGTHH("dongia", mahh));
            lblDv.setText(DatabaseManager.LayGTHH("dvtinh", mahh));
            lblQuycach.setText(DatabaseManager.LayGTHH("quicach", mahh));
            lblTenhh.setText(DatabaseManager.LayGTHH("tenhh", mahh));
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void retrieve() throws SQLException
    {
       DefaultComboBoxModel dm = new DatabaseManager().LayMHH();
       cbMahh.setModel(dm);
       txtHDS.setText(""+hdso);
    }
    
    void TblDSCTHD_SelectionChanged() {
        int row = tblDSCTHD.getSelectedRow();
        if (row >= 0) {
            String maHH = (String) dfTableModel.getValueAt(row, 0);
            String sLuong = (String) dfTableModel.getValueAt(row, 1);
            cbMahh.setSelectedItem(maHH.trim());
            txtSL.setText(sLuong.trim());
        } else {
            lblDongia.setText("");
            lblDv.setText("");
            lblQuycach.setText("");
            lblTenhh.setText("");
            txtSL.setText("");
        }
        ReloadLblIndexTblDSCTHH();
    }
    //L???y d??? li???u cho b???ng l???p h???c

    void ReloadTaleCTHD() {
        if (DatabaseManager.CTHDToTable(tblDSCTHD,""+hdso) == false) {
            JOptionPane.showMessageDialog(null, "L???y d??? li???u chi ti???t c?? l???i", "C?? l???i x???y ra", JOptionPane.ERROR_MESSAGE);
            ReloadLblIndexTblDSCTHH();
        }
    }

    void ReloadLblIndexTblDSCTHH() {
        int rowSelected = tblDSCTHD.getSelectedRow();
        int totalRow = tblDSCTHD.getRowCount();
        lblIndexTblKH.setText((rowSelected + 1) + "/" + totalRow);
    }

    void SwitchMode(int chucNang){
        chucNangDaChon = chucNang;
        switch (chucNang) {
            case ChucNang.ADD: {
                boolean trangThai = true;
                cbMahh.setEnabled(trangThai);
                txtSL.setEnabled(trangThai);
                cbMahh.setEnabled(trangThai);
                txtHDS.requestFocus();
                btnSave.setEnabled(trangThai);
                btnUpdate.setEnabled(!trangThai);
                btnDelete.setEnabled(!trangThai);
                txtSL.setText("");
                btnAdd.setText("H???y");
                break;
            }
            case ChucNang.UPDATE: {
                boolean trangThai = true;
                cbMahh.setEnabled(trangThai);
                txtSL.setEnabled(trangThai);
                cbMahh.setEnabled(trangThai);
                cbMahh.requestFocus();
                btnSave.setEnabled(trangThai);
                btnAdd.setEnabled(!trangThai);
                btnDelete.setEnabled(!trangThai);
                btnUpdate.setText("H???y");
                break;
            }
            case ChucNang.NONE: {
                boolean trangThai = false;
                cbMahh.setEnabled(trangThai);
                txtSL.setEnabled(trangThai);
                btnSave.setEnabled(trangThai);
                cbMahh.setEnabled(trangThai);
                btnAdd.setEnabled(true);
                btnUpdate.setEnabled(true);
                btnDelete.setEnabled(true);
                btnAdd.setText("Th??m");
                btnUpdate.setText("S???a");
            }
        }
    }

    boolean CheckInput() {
        String maHH = cbMahh.getSelectedItem().toString();
        String sLuong = txtSL.getText().trim();
        if (maHH.length() == 0) {
            JOptionPane.showMessageDialog(null, "Vui l??ng ch???n m?? h??ng h??a", "Ch??a ch???n m?? h??ng h??a", JOptionPane.WARNING_MESSAGE);
            cbMahh.requestFocus();
            return false;
        }
        if (sLuong.length() == 0) {
            JOptionPane.showMessageDialog(null, "Vui l??ng nh???p s??? l?????ng", "Ch??a nh???p s??? l?????ng", JOptionPane.WARNING_MESSAGE);
            txtSL.requestFocus();
            return false;
        }
        return true;
    }

    void exit() {
        int result = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n tho??t kh??ng?", "Tho??t ?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.CANCEL_OPTION) {
            return;
        }
        this.dispose();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdd = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblIndexTblKH = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDSCTHD = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtHDS = new javax.swing.JTextField();
        txtSL = new javax.swing.JTextField();
        btnFirst = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        cbMahh = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblTenhh = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblQuycach = new javax.swing.JLabel();
        lblDv = new javax.swing.JLabel();
        lblDongia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chi ti???t h??a ????n");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdd.setText("Th??m");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnLast.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSave.setText("L??u");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUpdate.setText("S???a");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDelete.setText("X??a");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblIndexTblKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblIndexTblKH.setText("0/0");

        tblDSCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "M?? h??ng h??a", "S??? l?????ng"
            }
        ));
        jScrollPane2.setViewportView(tblDSCTHD);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("H??a ????n s???");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("M?? h??ng h??a");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Tr??? l???i");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Chi ti???t h??a ????n");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("S??? l?????ng");

        txtHDS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtHDS.setEnabled(false);

        txtSL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSL.setEnabled(false);

        btnFirst.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFirst.setText("|<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBack.setText("<");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNext.setText(">");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        cbMahh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbMahh.setEnabled(false);
        cbMahh.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMahhItemStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("T??n h??ng h??a");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Qui c??ch");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("????n v??? t??nh");

        lblTenhh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("????n gi??");

        lblQuycach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblDv.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblDongia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFirst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBack)
                        .addGap(20, 20, 20)
                        .addComponent(lblIndexTblKH)
                        .addGap(18, 18, 18)
                        .addComponent(btnNext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLast))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtHDS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cbMahh, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTenhh)
                                    .addComponent(lblQuycach))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDv)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(105, 105, 105)
                                        .addComponent(jLabel10)))
                                .addGap(18, 18, 18)
                                .addComponent(lblDongia)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18))
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel4))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(3, 3, 3)
                        .addComponent(btnSave))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtHDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbMahh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(jLabel6)
                    .addComponent(lblTenhh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(lblQuycach)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(lblDv)
                    .addComponent(lblDongia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst)
                    .addComponent(btnNext)
                    .addComponent(btnBack)
                    .addComponent(btnLast)
                    .addComponent(lblIndexTblKH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if (chucNangDaChon == ChucNang.NONE) {
            SwitchMode(ChucNang.ADD);
        } else {
            SwitchMode(ChucNang.NONE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        if (tblDSCTHD.getRowCount() > 0) {
            int lastRowIndex = tblDSCTHD.getRowCount() - 1;
            tblDSCTHD.getSelectionModel().setSelectionInterval(lastRowIndex,
                lastRowIndex);
        }
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String hdSo = txtHDS.getText().trim();
        String maHH = cbMahh.getSelectedItem().toString();
        String sLuong = txtSL.getText().trim();
        if (chucNangDaChon == ChucNang.ADD) {
            if (CheckInput() == false) {
                return;
            }
            if (DatabaseManager.CountCTHD("chitiethoadon", "mahh", maHH, "hdso", hdSo) > 0) {
                txtSL.requestFocus();
                JOptionPane.showMessageDialog(null, "M?? h??ng h??a b???n nh???p ???? t???n t???i", "Tr??ng m??", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (DatabaseManager.ThemCTHD(hdSo, maHH, sLuong)) {
                btnAdd.requestFocus();
                SwitchMode(ChucNang.NONE);
                ReloadTaleCTHD();
                JOptionPane.showMessageDialog(null, "Th??m th??nh c??ng", "Th??nh c??ng", JOptionPane.INFORMATION_MESSAGE);
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Th??m th???t b???i", "C?? l???i x???y ra", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        if (chucNangDaChon == ChucNang.UPDATE) {
            if (CheckInput() == false) {
                return;
            }
            if (DatabaseManager.SuaCTHD(maHH, sLuong)) {
                btnUpdate.requestFocus();
                SwitchMode(ChucNang.NONE);
                ReloadTaleCTHD();
                JOptionPane.showMessageDialog(null, "S???a th??nh c??ng",
                    "Th??nh c??ng", JOptionPane.INFORMATION_MESSAGE);
                return;
            } else {
                JOptionPane.showMessageDialog(null, "S???a th???t b???i", "C?? l???i ", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (tblDSCTHD.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Ch??a ch???n kh??ch h??ng ????? s???a",
                "Ch??a ch???n kh??ch h??ng", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (chucNangDaChon == ChucNang.NONE) {
            SwitchMode(ChucNang.UPDATE);
        } else {
            SwitchMode(ChucNang.NONE);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblDSCTHD.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "B???n ch??a ch???n m???t h??ng n??o ????? x??a", "Ch??a ch???n m???t h??ng", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int result = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n x??a m???t h??ng n??y kh??ng", "X??a m???t h??ng?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.CANCEL_OPTION) {
            return;
        }
        String mahh = (String) tblDSCTHD.getValueAt(selectedRow, 0);
        String hdSo = txtHDS.getText().trim();
        if (DatabaseManager.XoaCTHD(mahh,hdSo)) {
            btnAdd.requestFocus();
            SwitchMode(ChucNang.NONE);
            ReloadTaleCTHD();
            JOptionPane.showMessageDialog(null, "X??a th??nh c??ng","Th??nh c??ng", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else {
            JOptionPane.showMessageDialog(null, "X??a th???t b???i", "C?? l???i x???y ra", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        exit();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        if (tblDSCTHD.getRowCount() > 0) {
            tblDSCTHD.getSelectionModel().setSelectionInterval(0, 0);
        }
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        int rowSelected = tblDSCTHD.getSelectedRow();
        if (rowSelected > 0) {
            rowSelected--;
            tblDSCTHD.getSelectionModel().setSelectionInterval(rowSelected,
                rowSelected);
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        int rowSelected = tblDSCTHD.getSelectedRow();
        if (rowSelected < tblDSCTHD.getRowCount() - 1) {
            rowSelected++;
            tblDSCTHD.getSelectionModel().setSelectionInterval(rowSelected,
                rowSelected);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void cbMahhItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMahhItemStateChanged
        showData();
    }//GEN-LAST:event_cbMahhItemStateChanged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tblDSCTHD.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                TblDSCTHD_SelectionChanged();
            }
        });
        ReloadTaleCTHD();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(ChiTietHH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietHH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietHH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietHH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new ChiTietHH(hdso).setVisible(true);
//                } catch (SQLException ex) {
//                    Logger.getLogger(ChiTietHH.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbMahh;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDongia;
    private javax.swing.JLabel lblDv;
    private javax.swing.JLabel lblIndexTblKH;
    private javax.swing.JLabel lblQuycach;
    private javax.swing.JLabel lblTenhh;
    private javax.swing.JTable tblDSCTHD;
    private javax.swing.JTextField txtHDS;
    private javax.swing.JTextField txtSL;
    // End of variables declaration//GEN-END:variables
}
