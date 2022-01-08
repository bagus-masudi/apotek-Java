/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek.component;

import apotek.ApotekKaryawan;
import apotek.ApotekSupplier;
import apotek.RestockObat;
import apotek.swing.connectionmysql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ahmad Bagus Mas'udi
 */
public class FormSupplier extends javax.swing.JPanel {

    /**
     * Creates new form FormPembelian
     */
    
    public static String Kode;
    
    public FormSupplier() {
        initComponents();
        tampilkanSupplier();
    }

    public void tampilkanSupplier() {
        DefaultTableModel table = new DefaultTableModel();

        table.addColumn("Id_Supplier");
        table.addColumn("Nama");
        table.addColumn("Alamat");
        table.addColumn("Kota");
        table.addColumn("No_Telepon");

        try {
            Connection con = connectionmysql.koneksiDB();
            String sql = "select * from supplier";
            Statement S = con.createStatement();
            ResultSet R = S.executeQuery(sql);

            while (R.next()) {
                table.addRow(new Object[]{
                    R.getString(1), R.getString(2), R.getString(3), R.getString(4), R.getString(5)
                });
            }
            tabelSupplier.setModel(table);

        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    private void hapuslayar(){
    ID.setText("");
    NAMA.setText("");
    alamat.setText("");
    txtKota.setText("");
    txtTelp.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new apotek.swing.PanelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelSupplier = new apotek.swing.Table();
        txtTelp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        NAMA = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        alamat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtKota = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        save3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(242, 242, 242));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        tabelSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelSupplierMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelSupplier);

        txtTelp.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel3.setText("ID Supplier");

        ID.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel2.setText("Nama");

        NAMA.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel5.setText("Alamat");

        alamat.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel4.setText("Kota");

        txtKota.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel1.setText("No Telepon");

        save.setBackground(new java.awt.Color(255, 255, 255));
        save.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        save.setForeground(new java.awt.Color(51, 51, 51));
        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apotek/image/che2ck.png"))); // NOI18N
        save.setText("Simpan");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        hapus.setBackground(new java.awt.Color(255, 255, 255));
        hapus.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        hapus.setForeground(new java.awt.Color(51, 51, 51));
        hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apotek/image/trash-can (1).png"))); // NOI18N
        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        save3.setBackground(new java.awt.Color(255, 255, 255));
        save3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        save3.setForeground(new java.awt.Color(51, 51, 51));
        save3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apotek/image/edit.png"))); // NOI18N
        save3.setText("Edit");
        save3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NAMA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(alamat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(68, 68, 68)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtKota, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(save)
                        .addGap(27, 27, 27)
                        .addComponent(hapus)
                        .addGap(27, 27, 27)
                        .addComponent(save3)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save3)
                    .addComponent(save)
                    .addComponent(hapus))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        try{
            if(NAMA.getText().equals("")|| ID.getText().equals("")||
                NAMA.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Data Tidak Boleh Kosong","Pesan", JOptionPane.ERROR_MESSAGE);
                hapuslayar();
            }else{
                try {
                    Connection con = connectionmysql.koneksiDB();
                    String sql = "insert into supplier values ('"+ID.getText()+"','" +NAMA.getText()+"','"+alamat.getText()+"','"+txtKota.getText()+"','"+ txtTelp.getText() +"')" ;
                    Statement S = con.createStatement();
                    S.execute(sql);
                    JOptionPane.showMessageDialog(null, "Simpan Berhasil");
                    new ApotekSupplier().setVisible(true);
                    new ApotekSupplier().setVisible(false);
                } catch (Exception e) {
                    System.out.println(e);
        }

            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Akun Ini Sudah Ada","Pesan", JOptionPane.WARNING_MESSAGE);
            //hapuslayar();
        }
    }//GEN-LAST:event_saveActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        try {
            Connection con = connectionmysql.koneksiDB();
            String sql = "delete from supplier where ID_SUPPLIER = '" + ID.getText() + "'";
            Statement S = con.createStatement();
            S.execute(sql);
            JOptionPane.showMessageDialog(null, "Hapus berhasil");
            new ApotekSupplier().setVisible(true);
            new ApotekSupplier().setVisible(false); 
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Hapus gagal");
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void save3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save3ActionPerformed
        try {
            Connection con = connectionmysql.koneksiDB();
            String sql = "update supplier set ID_SUPPLIER = '"+ ID.getText() +"', NAMA = '"+ NAMA.getText() +"', ALAMAT = '"+ alamat.getText() +"', KOTA = '"+ txtKota.getText() +"', NO_TELEPON = '"+ txtTelp.getText() +"' where ID_SUPPLIER = '"+ ID.getText() +"'";
            Statement S = con.createStatement();
            S.execute(sql);
            JOptionPane.showMessageDialog(null, "Edit berhasil");
            new ApotekSupplier().setVisible(true);
            new ApotekSupplier().setVisible(false); 
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Edit gagal");
        }
    }//GEN-LAST:event_save3ActionPerformed

    private void tabelSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelSupplierMouseClicked
        int baris = tabelSupplier.rowAtPoint(evt.getPoint());
        
        String is = tabelSupplier.getValueAt(baris, 0).toString();
        ID.setText(is);
        
        String nama = tabelSupplier.getValueAt(baris, 1).toString();
        NAMA.setText(nama);
        
        String almt = tabelSupplier.getValueAt(baris, 2).toString();
        alamat.setText(almt);
        
        String kt = tabelSupplier.getValueAt(baris, 3).toString();
        txtKota.setText(kt);
        
        String telp = tabelSupplier.getValueAt(baris, 4).toString();
        txtTelp.setText(telp);
        
        
    }//GEN-LAST:event_tabelSupplierMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JTextField NAMA;
    private javax.swing.JTextField alamat;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private apotek.swing.PanelBorder panelBorder1;
    private javax.swing.JButton save;
    private javax.swing.JButton save3;
    private apotek.swing.Table tabelSupplier;
    private javax.swing.JTextField txtKota;
    private javax.swing.JTextField txtTelp;
    // End of variables declaration//GEN-END:variables
}
