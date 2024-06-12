package uas_app;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Beli extends javax.swing.JFrame {

    public Beli() {
        initComponents();
        set_table();
    }
    Connection con = null;
    PreparedStatement pst = null;

    //ngatur table
    private void set_table() {
        int CC;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/dbmaterial", "root", "");
            pst = con.prepareStatement("SELECT * from tbmaterial");
            ResultSet Rs = pst.executeQuery();
            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) tbmaterial.getModel();

            DFT.setRowCount(0);
            while (Rs.next()) {
                Vector v2 = new Vector();

                for (int i = 1; i <= CC; i++) {
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
    private void nuke() {
        txtNama.setText("");
        txtDeskripsi.setText("");
        txtBeli.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        formLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbmaterial = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDeskripsi = new javax.swing.JTextArea();
        txtNama = new javax.swing.JTextField();
        labelNama = new javax.swing.JLabel();
        labelDeskprisi = new javax.swing.JLabel();
        labelJumlah = new javax.swing.JLabel();
        txtBeli = new javax.swing.JTextField();
        btnBeli = new javax.swing.JButton();
        labelBeli = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 800));

        headerPanel.setBackground(new java.awt.Color(51, 153, 255));
        headerPanel.setToolTipText("");

        formLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        formLabel.setText("Form Pembelian");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(formLabel))
        );

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

        txtDeskripsi.setColumns(20);
        txtDeskripsi.setRows(5);
        jScrollPane2.setViewportView(txtDeskripsi);

        labelNama.setText("Nama :");

        labelDeskprisi.setText("Deskirpsi :");

        labelJumlah.setText("Jumlah Beli :");

        txtBeli.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtBeliInputMethodTextChanged(evt);
            }
        });
        txtBeli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBeliKeyTyped(evt);
            }
        });

        btnBeli.setText("Beli");
        btnBeli.setMaximumSize(new java.awt.Dimension(73, 23));
        btnBeli.setMinimumSize(new java.awt.Dimension(73, 23));
        btnBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBeliActionPerformed(evt);
            }
        });

        labelBeli.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelBeli.setText("PEMBELIAN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNama, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNama))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelDeskprisi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelJumlah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(labelBeli))
                                    .addComponent(txtBeli))
                                .addGap(18, 18, 18)
                                .addComponent(btnBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNama)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDeskprisi)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(labelBeli)
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelJumlah)
                            .addComponent(btnBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbmaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbmaterialMouseClicked
        DefaultTableModel model = (DefaultTableModel) tbmaterial.getModel();
        int selectedIndex = tbmaterial.getSelectedRow();

        int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        txtNama.setText(model.getValueAt(selectedIndex, 1).toString());
        txtDeskripsi.setText(model.getValueAt(selectedIndex, 2).toString());
    }//GEN-LAST:event_tbmaterialMouseClicked

    private void txtBeliInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtBeliInputMethodTextChanged

    }//GEN-LAST:event_txtBeliInputMethodTextChanged

    private void txtBeliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBeliKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBeliKeyTyped

    private void btnBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBeliActionPerformed
        int jumlahBeli = Integer.parseInt(txtBeli.getText());

        if (jumlahBeli <= 0) {
            JOptionPane.showMessageDialog(null, "Masukkan Jumlah Barang yang Ingin Dibeli!");
        }
        else{
            try {
                DefaultTableModel model = (DefaultTableModel)tbmaterial.getModel();
                int selectedIndex = tbmaterial.getSelectedRow();
                int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
                
                con = DriverManager.getConnection("jdbc:mysql://localhost/dbmaterial","root","");            
                pst = con.prepareStatement("SELECT * FROM tbmaterial WHERE id=?");
                pst.setInt(1, id);
                
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    int stok = rs.getInt("stok");
                    int harga = rs.getInt("harga");
                    int stokBaru = stok - jumlahBeli;
                    
                    if(stokBaru < 0){
                        JOptionPane.showMessageDialog(null, "Stok Tidak Mencukupi!");
                    }
                    else{
                        int total = harga * jumlahBeli;
                        pst = con.prepareStatement("UPDATE tbmaterial SET stok=? WHERE id=?");
                        pst.setInt(1, stokBaru);
                        pst.setInt(2, id);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Pembelian Berhasil! Total Pembayaran : Rp." + total);
                        set_table();
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Beli.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnBeliActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Beli().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBeli;
    private javax.swing.JLabel formLabel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelBeli;
    private javax.swing.JLabel labelDeskprisi;
    private javax.swing.JLabel labelJumlah;
    private javax.swing.JLabel labelNama;
    private javax.swing.JTable tbmaterial;
    private javax.swing.JTextField txtBeli;
    private javax.swing.JTextArea txtDeskripsi;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables
}
