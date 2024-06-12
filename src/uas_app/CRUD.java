package uas_app;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class CRUD extends javax.swing.JFrame {

    public CRUD() {
        initComponents();
        set_table();
    }
    
    Connection con = null;
    PreparedStatement pst = null;
    
    //ngatur table
    private void set_table(){
        int CC;
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/dbmaterial","root","");
            pst = con.prepareStatement("SELECT * from tbmaterial");
            ResultSet Rs = pst.executeQuery();
            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel)tbmaterial.getModel();
            
            DFT.setRowCount(0);
            while (Rs.next()) {
                Vector v2 = new Vector();
                
                for(int i=1; i<=CC; i++){
                    v2.add(Rs.getString("id"));
                    v2.add(Rs.getString("nama"));
                    v2.add(Rs.getString("deskripsi"));
                    v2.add(Rs.getString("kondisi"));
                    v2.add(Rs.getString("hazard"));
                    v2.add(Rs.getString("satuan"));
                    v2.add(Rs.getString("stok"));
                    v2.add(Rs.getString("harga"));

                }
                DFT.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    //clear field input
    private void nuke(){
        txtNama.setText("");
        txtDeskripsi.setText("");
        buttonGroupKondisi.clearSelection();
        txtHazard.setSelectedItem("");
        txtSatuan.setText("");
        txtStok.setText("");
        txtHarga.setText("");
    }
    
    //membaca radio button yg di select
    private String rbuttonDipilih(ButtonGroup buttonGroup){
        for(Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();){
            AbstractButton button = buttons.nextElement();
            
            if(button.isSelected()){
                return button.getText();
            }
        }
            return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupKondisi = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbmaterial = new javax.swing.JTable();
        headerPanel = new javax.swing.JPanel();
        formLabel = new javax.swing.JLabel();
        labelNama = new javax.swing.JLabel();
        labelHazard = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDeskripsi = new javax.swing.JTextArea();
        txtNama = new javax.swing.JTextField();
        labelDeskprisi = new javax.swing.JLabel();
        labelSatuan = new javax.swing.JLabel();
        txtSatuan = new javax.swing.JTextField();
        txtStok = new javax.swing.JTextField();
        labelStok = new javax.swing.JLabel();
        txtHazard = new javax.swing.JComboBox<>();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        txtHarga = new javax.swing.JTextField();
        labelHarga = new javax.swing.JLabel();
        btnKeluar = new javax.swing.JButton();
        labelState = new javax.swing.JLabel();
        rbPadat = new javax.swing.JRadioButton();
        rbGas = new javax.swing.JRadioButton();
        rbCair = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 800));
        setMinimumSize(new java.awt.Dimension(1280, 800));
        setPreferredSize(new java.awt.Dimension(1280, 800));

        tbmaterial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "Deskripsi", "Kondisi", "Hazard", "Satuan", "Stok", "Harga/Satuan"
            }
        ));
        tbmaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbmaterialMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbmaterial);

        headerPanel.setBackground(new java.awt.Color(51, 153, 255));

        formLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        formLabel.setText("Form CRUD ");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(formLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(formLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelNama.setText("Nama :");

        labelHazard.setText("Hazard :");

        txtDeskripsi.setColumns(20);
        txtDeskripsi.setRows(5);
        jScrollPane2.setViewportView(txtDeskripsi);

        labelDeskprisi.setText("Deskirpsi :");

        labelSatuan.setText("Satuan :");

        txtStok.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtStokInputMethodTextChanged(evt);
            }
        });
        txtStok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStokKeyTyped(evt);
            }
        });

        labelStok.setText("Stok :");

        txtHazard.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Explosive", "Flammable", "Corrosive", "Toxic", "Irritant" }));
        txtHazard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHazardActionPerformed(evt);
            }
        });

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnUbah.setText("Ubah");
        btnUbah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUbahMouseClicked(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusMouseClicked(evt);
            }
        });

        txtHarga.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtHargaInputMethodTextChanged(evt);
            }
        });
        txtHarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHargaKeyTyped(evt);
            }
        });

        labelHarga.setText("Harga/Satuan :");

        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        labelState.setText("Kondisi :");

        buttonGroupKondisi.add(rbPadat);
        rbPadat.setText("Padat");

        buttonGroupKondisi.add(rbGas);
        rbGas.setText("Gas");

        buttonGroupKondisi.add(rbCair);
        rbCair.setText("Cair");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelHarga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelStok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelDeskprisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelNama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelHazard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(labelSatuan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelState, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSatuan)
                    .addComponent(txtNama)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addComponent(txtStok)
                    .addComponent(txtHazard, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtHarga)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnUbah, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                .addComponent(btnKeluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbPadat)
                                .addGap(18, 18, 18)
                                .addComponent(rbCair)
                                .addGap(18, 18, 18)
                                .addComponent(rbGas)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNama)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDeskprisi)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelState)
                            .addComponent(rbGas)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rbPadat)
                                .addComponent(rbCair)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelHazard)
                            .addComponent(txtHazard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelSatuan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelStok))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelHarga))
                        .addGap(18, 18, 18)
                        .addComponent(btnTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKeluar)
                        .addGap(43, 43, 43))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtHazardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHazardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHazardActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        String nama, deskripsi, kondisi, hazard, satuan, stok, harga;
        
        nama = txtNama.getText();
        deskripsi = txtDeskripsi.getText();
        kondisi = rbuttonDipilih(buttonGroupKondisi);
        hazard = (String) txtHazard.getSelectedItem();
        satuan = txtSatuan.getText();
        stok = txtStok.getText();
        harga = txtHarga.getText();
       
        if(nama.equals("")){
            JOptionPane.showMessageDialog(null, "Masukkan Nama Barang!");
        }
        else if(deskripsi.equals("")){
            JOptionPane.showMessageDialog(null, "Masukkan Deskripsi Barang!");
        }
        else if(kondisi.equals("")){
            JOptionPane.showMessageDialog(null, "Pilih Kondisi Barang!");
        }        
        else if(hazard.equals("")){
            JOptionPane.showMessageDialog(null, "Pilih Kategori Barang!");
        }
        else if(satuan.equals("")){
            JOptionPane.showMessageDialog(null, "Masukkan Satuan Barang!");
        }
        else if(stok.equals("")){
            JOptionPane.showMessageDialog(null, "Masukkan Stok Barang!");
        }
        else if(harga.equals("")){
            JOptionPane.showMessageDialog(null, "Masukkan Harga Barang!");
        }
        else{
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/dbmaterial","root","");
                pst = con.prepareStatement("INSERT into tbmaterial(nama, deskripsi, kondisi, hazard, satuan, stok, harga) values (?,?,?,?,?,?,?)");
                
                pst.setString(1, nama);
                pst.setString(2, deskripsi);
                pst.setString(3, kondisi);
                pst.setString(4, hazard);
                pst.setString(5, satuan);
                pst.setString(6, stok);
                pst.setString(7, harga);
                
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Dimasukkan");
                set_table();
                
                nuke();

            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_btnTambahActionPerformed
    }
    private void tbmaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbmaterialMouseClicked
        DefaultTableModel model = (DefaultTableModel)tbmaterial.getModel();
        int selectedIndex = tbmaterial.getSelectedRow();
        
        int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        txtNama.setText(model.getValueAt(selectedIndex, 1).toString());
        txtDeskripsi.setText(model.getValueAt(selectedIndex, 2).toString());
        
        String kondisi = model.getValueAt(selectedIndex, 3).toString();
        switch(kondisi){
            case "Padat" -> rbPadat.setSelected(true);
            case "Cair" -> rbCair.setSelected(true);
            case "Gas" -> rbGas.setSelected(true);
        }
        
        txtHazard.setSelectedItem(model.getValueAt(selectedIndex, 4).toString());
        txtSatuan.setText(model.getValueAt(selectedIndex, 5).toString());
        txtStok.setText(model.getValueAt(selectedIndex, 6).toString());
        txtHarga.setText(model.getValueAt(selectedIndex, 7).toString());

    }//GEN-LAST:event_tbmaterialMouseClicked

    private void btnUbahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseClicked
        String nama, deskripsi, kondisi, hazard, satuan, stok, harga;
        
        nama = txtNama.getText();
        deskripsi = txtDeskripsi.getText();
        kondisi = rbuttonDipilih(buttonGroupKondisi);
        hazard = (String) txtHazard.getSelectedItem();
        satuan = txtSatuan.getText();
        stok = txtStok.getText();
        harga = txtHarga.getText();
        
        if(nama.equals("")){
            JOptionPane.showMessageDialog(null, "Masukkan Nama Barang!");
        }
        else if(deskripsi.equals("")){
            JOptionPane.showMessageDialog(null, "Masukkan Deskripsi Barang!");
        }
        else if(kondisi.equals("")){
            JOptionPane.showMessageDialog(null, "Pilih Kondisi Barang!");
        }
        else if(hazard.equals("")){
            JOptionPane.showMessageDialog(null, "Pilih Kategori Barang!");
        }
        else if(satuan.equals("")){
            JOptionPane.showMessageDialog(null, "Masukkan Satuan Barang!");
        }
        else if(stok.equals("")){
            JOptionPane.showMessageDialog(null, "Masukkan Stok Barang!");
        }
        else if(harga.equals("")){
            JOptionPane.showMessageDialog(null, "Masukkan Harga Barang!");
        }
        else{
            try {
                DefaultTableModel model = (DefaultTableModel)tbmaterial.getModel();
                int selectedIndex = tbmaterial.getSelectedRow();
                int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
                con = DriverManager.getConnection("jdbc:mysql://localhost/dbmaterial","root","");
                pst = con.prepareStatement("UPDATE tbmaterial set nama =?, deskripsi=?, kondisi=?, hazard=?, satuan=?, stok=?, harga=? where id=?");
                
                pst.setString(1, nama);
                pst.setString(2, deskripsi);
                pst.setString(3, kondisi);
                pst.setString(4, hazard);
                pst.setString(5, satuan);
                pst.setString(6, stok);
                pst.setString(7, harga);
                pst.setInt(8, id);

                
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
                set_table();
                nuke();
                
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnUbahMouseClicked

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        try {
            DefaultTableModel model = (DefaultTableModel)tbmaterial.getModel();
            int selectedIndex = tbmaterial.getSelectedRow();
            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
            con = DriverManager.getConnection("jdbc:mysql://localhost/dbmaterial","root","");
            pst = con.prepareStatement("DELETE from tbmaterial where id=?");
            
            pst.setInt(1, id);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
            set_table();
            nuke();

        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnHapusMouseClicked

    private void txtHargaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtHargaInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaInputMethodTextChanged

    private void txtHargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHargaKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE)) {
        evt.consume();}
    }//GEN-LAST:event_txtHargaKeyTyped

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        Login newLoginFrame = new Login();
        newLoginFrame.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void txtStokKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStokKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtStokKeyTyped

    private void txtStokInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtStokInputMethodTextChanged

    }//GEN-LAST:event_txtStokInputMethodTextChanged

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
            java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.ButtonGroup buttonGroupKondisi;
    private javax.swing.JLabel formLabel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelDeskprisi;
    private javax.swing.JLabel labelHarga;
    private javax.swing.JLabel labelHazard;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel labelSatuan;
    private javax.swing.JLabel labelState;
    private javax.swing.JLabel labelStok;
    private javax.swing.JRadioButton rbCair;
    private javax.swing.JRadioButton rbGas;
    private javax.swing.JRadioButton rbPadat;
    private javax.swing.JTable tbmaterial;
    private javax.swing.JTextArea txtDeskripsi;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JComboBox<String> txtHazard;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtSatuan;
    private javax.swing.JTextField txtStok;
    // End of variables declaration//GEN-END:variables
}
