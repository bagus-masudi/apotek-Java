/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek.component;

import apotek.ApotekPenjualan;
import apotek.swing.connectionmysql;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Ahmad Bagus Mas'udi
 */
public class FormPenjualan extends javax.swing.JPanel {

    /**
     * Creates new form FormPenjualan
     */
    
    public static String Kode;
    public static String Kode1;
    public static String Jumlah;
    public static String Jumlah1;
    public static String Total1;
    public static String Stok;
    public static String a;
    public static String Tanggal;
    public static int TotalBayar;
 
    
    public FormPenjualan() {
        initComponents();
        tampilkanKeranjang();
        tampilkanKaryawan();
        tampilkanPelanggan();
        tampilkanPenjualan();
        totalbiaya();
        cbm();
        
        
        int row = tabelKeranjang.getRowCount();
        if (row > 0){
            a = tblTotalBiaya.getValueAt(0, 0).toString();
            int b = Integer.parseInt(a) + 200;
            txtTB.setText(Integer.toString(b));
        }
        
        txtNP.setEditable(false);
        txtTB.setEditable(false);
        txtKembali.setEditable(false);
    }
    
    public void cbm(){
        String kdkaryawan = "";
        int i = 0;
        int kolom = tblKaryawan.getRowCount() - 1;
        while(i <= kolom){
            kdkaryawan = tblKaryawan.getValueAt(i, 0).toString();
            cbmKaryawan.addItem(kdkaryawan);
            i= i + 1;
        }
        
        String kdpelanggan = "";
        int ii = 0;
        int kolomm = tblPelanggan.getRowCount() - 1;
        while(ii <= kolomm){
            kdpelanggan = tblPelanggan.getValueAt(ii, 0).toString();
            cbmPelanggan.addItem(kdpelanggan);
            ii= ii + 1;
        }
       
        String penjualan = "";
        int row = tblPenjualan.getRowCount() - 1;
        if (row > 0){
            penjualan = tblPenjualan.getValueAt(row, 0).toString();
            int pnj = Integer.parseInt(penjualan) + 1;
            txtNP.setText(Integer.toString(pnj));
        } else if (row == 0){
            
        }
        
    }
    
    public void tampilkanKeranjang() {
        DefaultTableModel table = new DefaultTableModel();

        table.addColumn("Id_Obat");
        table.addColumn("Nama");
        table.addColumn("Stok");
        table.addColumn("Jumlah");
        table.addColumn("Total_Harga");

        try {
            Connection con = connectionmysql.koneksiDB();
            String sql = "select * from keranjang";
            Statement S = con.createStatement();
            ResultSet R = S.executeQuery(sql);

            while (R.next()) {
                table.addRow(new Object[]{
                    R.getString(1), R.getString(2), R.getString(3), R.getString(4), R.getString(5)
                });
            }
            tabelKeranjang.setModel(table);

        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void tampilkanPelanggan() {
        DefaultTableModel table = new DefaultTableModel();

        table.addColumn("ID_PELANGGAN");

        try {
            Connection con = connectionmysql.koneksiDB();
            String sql = "select ID_PELANGGAN from pelanggan";
            Statement S = con.createStatement();
            ResultSet R = S.executeQuery(sql);

            while (R.next()) {
                table.addRow(new Object[]{
                    R.getString(1)
                });
            }
            tblPelanggan.setModel(table);

        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void tampilkanPenjualan() {
        DefaultTableModel table = new DefaultTableModel();

        table.addColumn("No Penjualan");
        table.addColumn("Id Obat");
        table.addColumn("Id Karyawan");
        table.addColumn("Id Pelanggan");
        table.addColumn("Tanggal");
        table.addColumn("Jumlah");
        table.addColumn("Total");
        table.addColumn("Pajak");
        table.addColumn("Total Bayar");

        try {
            Connection con = connectionmysql.koneksiDB();
            String sql = "select * from penjualan";
            Statement S = con.createStatement();
            ResultSet R = S.executeQuery(sql);

            while (R.next()) {
                table.addRow(new Object[]{
                    R.getString(1), R.getString(2), R.getString(3), R.getString(4), R.getString(5), R.getString(6), R.getString(7), R.getString(8), R.getString(9)
                });
            }
            tblPenjualan.setModel(table);

        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void tampilkanKaryawan() {
        DefaultTableModel table = new DefaultTableModel();

        table.addColumn("ID_KARYAWAN");

        try {
            Connection con = connectionmysql.koneksiDB();
            String sql = "select ID_KARYAWAN from karyawan";
            Statement S = con.createStatement();
            ResultSet R = S.executeQuery(sql);

            while (R.next()) {
                table.addRow(new Object[]{
                    R.getString(1)
                });
            }
            tblKaryawan.setModel(table);

        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void totalbiaya() {
        DefaultTableModel table = new DefaultTableModel();

        table.addColumn("TotalBiaya");

        try {
            Connection con = connectionmysql.koneksiDB();
            String sql = "select sum(total_harga) from keranjang";
            Statement S = con.createStatement();
            ResultSet R = S.executeQuery(sql);

            while (R.next()) {
                table.addRow(new Object[]{
                    R.getString(1)
                });
            }
            tblTotalBiaya.setModel(table);

        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void totalproduk() {
        DefaultTableModel table = new DefaultTableModel();

        table.addColumn("TotalProduk");

        try {
            Connection con = connectionmysql.koneksiDB();
            String sql = "select count(Nama) from keranjang";
            Statement S = con.createStatement();
            ResultSet R = S.executeQuery(sql);

            while (R.next()) {
                table.addRow(new Object[]{
                    R.getString(1)
                });
            }
            tblProduk.setModel(table);

        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void tunai(){
        String harga = txtTB.getText();
        String jumlah = txtTunai.getText();
        
        TotalBayar = Integer.parseInt(harga) + 200;
        
        try{
        int jumlahh = Integer.parseInt(jumlah);
        
        int total = jumlahh - TotalBayar;
        String kembali = Integer.toString(total);
        
        txtKembali.setText(kembali);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Only Number");
            txtTunai.setText(null);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tblTotalBiaya = new javax.swing.JTable();
        tblProduk = new javax.swing.JTable();
        tblKaryawan = new javax.swing.JTable();
        tblPelanggan = new javax.swing.JTable();
        tblPenjualan = new javax.swing.JTable();
        panelBorder1 = new apotek.swing.PanelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelKeranjang = new apotek.swing.Table();
        panelBorder2 = new apotek.swing.PanelBorder();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        TotalBiaya = new javax.swing.JLabel();
        txtTB = new javax.swing.JTextField();
        TotalBiaya1 = new javax.swing.JLabel();
        txtTunai = new javax.swing.JTextField();
        txtKembali = new javax.swing.JTextField();
        TotalBiaya2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TotalBiaya3 = new javax.swing.JLabel();
        txtNP = new javax.swing.JTextField();
        TotalBiaya4 = new javax.swing.JLabel();
        TotalBiaya5 = new javax.swing.JLabel();
        cbmPelanggan = new javax.swing.JComboBox<>();
        cbmKaryawan = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        tblTotalBiaya.setModel(new javax.swing.table.DefaultTableModel(
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

        tblProduk.setModel(new javax.swing.table.DefaultTableModel(
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

        tblKaryawan.setModel(new javax.swing.table.DefaultTableModel(
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

        tblPelanggan.setModel(new javax.swing.table.DefaultTableModel(
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

        tblPenjualan.setModel(new javax.swing.table.DefaultTableModel(
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

        setBackground(new java.awt.Color(242, 242, 242));
        setForeground(new java.awt.Color(255, 255, 255));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        tabelKeranjang.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelKeranjang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelKeranjangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelKeranjang);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apotek/image/print.png"))); // NOI18N
        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apotek/image/credit-card.png"))); // NOI18N
        jButton1.setText("Payment");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Checkout");

        TotalBiaya.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        TotalBiaya.setForeground(new java.awt.Color(51, 51, 51));
        TotalBiaya.setText(" Total biaya :      ");

        txtTB.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        TotalBiaya1.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        TotalBiaya1.setForeground(new java.awt.Color(51, 51, 51));
        TotalBiaya1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TotalBiaya1.setText(" Tunai :");

        txtTunai.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTunai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTunaiActionPerformed(evt);
            }
        });
        txtTunai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTunaiKeyReleased(evt);
            }
        });

        txtKembali.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        TotalBiaya2.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        TotalBiaya2.setForeground(new java.awt.Color(51, 51, 51));
        TotalBiaya2.setText(" Kembali :");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(127, 127, 127));
        jLabel2.setText("Informasi");

        TotalBiaya3.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        TotalBiaya3.setForeground(new java.awt.Color(51, 51, 51));
        TotalBiaya3.setText(" No Penjualan ");

        txtNP.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        TotalBiaya4.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        TotalBiaya4.setForeground(new java.awt.Color(51, 51, 51));
        TotalBiaya4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TotalBiaya4.setText(" Id Karyawan");

        TotalBiaya5.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        TotalBiaya5.setForeground(new java.awt.Color(51, 51, 51));
        TotalBiaya5.setText(" Id Pelanggan");

        cbmPelanggan.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        cbmKaryawan.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("* Pajak Rp 200");

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addComponent(TotalBiaya1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTunai, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelBorder2Layout.createSequentialGroup()
                                    .addComponent(jButton1)
                                    .addGap(41, 41, 41)
                                    .addComponent(jButton2))
                                .addGroup(panelBorder2Layout.createSequentialGroup()
                                    .addComponent(TotalBiaya)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTB, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addComponent(TotalBiaya2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(txtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addComponent(TotalBiaya4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(cbmKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addComponent(TotalBiaya3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNP, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addComponent(TotalBiaya5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbmPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(122, 122, 122))
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TotalBiaya)
                            .addComponent(txtTB, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TotalBiaya1)
                            .addComponent(txtTunai, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TotalBiaya2)
                            .addComponent(txtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TotalBiaya3)
                            .addComponent(txtNP, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TotalBiaya4)
                            .addComponent(cbmKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TotalBiaya5)
                            .addComponent(cbmPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tabelKeranjangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKeranjangMouseClicked
        int baris = tabelKeranjang.rowAtPoint(evt.getPoint());
        
        Kode = tabelKeranjang.getValueAt(baris, 0).toString();
        Jumlah = tabelKeranjang.getValueAt(baris, 3).toString();
        Stok = tabelKeranjang.getValueAt(baris, 2).toString();
    }//GEN-LAST:event_tabelKeranjangMouseClicked

    private void txtTunaiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTunaiKeyReleased
        tunai();
    }//GEN-LAST:event_txtTunaiKeyReleased

    private void txtTunaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTunaiActionPerformed
         
    }//GEN-LAST:event_txtTunaiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int hari, bulan, tahun;
        GregorianCalendar date = new GregorianCalendar();
        hari = date.get(Calendar.DAY_OF_MONTH);
        bulan = date.get(Calendar.MONTH);
        tahun = date.get(Calendar.YEAR);
        String tgl = Integer.toString(tahun) + "-" + (bulan + 1) + "-" + Integer.toString(hari);
        Tanggal = tgl;
        System.out.println(Tanggal);
        
        int i = 0;
        int pajak = 200;
        int tbayar = 0;
        int np = 0;
        int kolom = tabelKeranjang.getRowCount() - 1;
        while (i <= kolom){
            Kode1 = tabelKeranjang.getValueAt(i, 0).toString();
            Jumlah1 = tabelKeranjang.getValueAt(i, 3).toString();
            Total1 = tabelKeranjang.getValueAt(i, 4).toString();
            tbayar = Integer.parseInt(Total1) + 200;
            try {
            Connection con = connectionmysql.koneksiDB();  
            String sql = "INSERT INTO penjualan VALUES ('"+ (Integer.parseInt(txtNP.getText()) + np) +"','"+ Kode1 +"','"+ cbmKaryawan.getSelectedItem() +"','"+ cbmPelanggan.getSelectedItem() +"','"+ Tanggal +"','"+ Jumlah1 +"','"+ Total1 +"','"+ pajak +"','"+ Integer.toString(tbayar) +"')";
            Statement S = con.createStatement();
            S.execute(sql);
            
            JOptionPane.showMessageDialog(null, "Transaksi Berhasil");
        } catch (Exception e){ 
                System.out.println(e);
        }
            np = np + 1;
            i = i + 1;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int hari, bulan, tahun;
        GregorianCalendar date = new GregorianCalendar();
        String namabulan[] = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        hari = date.get(Calendar.DAY_OF_MONTH);
        bulan = date.get(Calendar.MONTH);
        tahun = date.get(Calendar.YEAR);
        String tgl = Integer.toString(hari) + " " + namabulan[bulan] + " " + Integer.toString(tahun);
        
        File reportFile = new File(".");
        String dirr = "";
        try {
            Connection con = connectionmysql.koneksiDB();
            String sql = "select * from keranjang";
            Statement S = con.createStatement();
            dirr = reportFile.getCanonicalPath() + "/src/apotek/report/";
            JasperDesign design = JRXmlLoader.load(dirr + "struk.jrxml");
            HashMap hash = new HashMap();
            hash.put("tgl", tgl);
            hash.put("total", txtTB.getText());
            hash.put("uang", txtTunai.getText());
            hash.put("kembalian", txtKembali.getText());
            JasperReport jr = JasperCompileManager.compileReport(design);
            ResultSet rs = S.executeQuery(sql);
            JRResultSetDataSource rsDataSource = new JRResultSetDataSource(rs);
            JasperPrint jp = JasperFillManager.fillReport(jr, hash, rsDataSource);
            JasperViewer.viewReport(jp);
            try {
            Connection conn = connectionmysql.koneksiDB();  
            String sqll = "delete from keranjang";
            Statement S1 = conn.createStatement();
            S1.execute(sqll);
            new ApotekPenjualan().setVisible(false);
            new ApotekPenjualan().setVisible(true);
        } catch (Exception e){
            
        }
        } catch (SQLException | IOException ex) {
            JOptionPane.showMessageDialog(null, "\nGagal Mencetak\n" + ex, "Kesalahan", JOptionPane.ERROR_MESSAGE);
        } catch (JRException ex) {
            
        } 
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TotalBiaya;
    private javax.swing.JLabel TotalBiaya1;
    private javax.swing.JLabel TotalBiaya2;
    private javax.swing.JLabel TotalBiaya3;
    private javax.swing.JLabel TotalBiaya4;
    private javax.swing.JLabel TotalBiaya5;
    private javax.swing.JComboBox<String> cbmKaryawan;
    private javax.swing.JComboBox<String> cbmPelanggan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private apotek.swing.PanelBorder panelBorder1;
    private apotek.swing.PanelBorder panelBorder2;
    private apotek.swing.Table tabelKeranjang;
    private javax.swing.JTable tblKaryawan;
    private javax.swing.JTable tblPelanggan;
    private javax.swing.JTable tblPenjualan;
    private javax.swing.JTable tblProduk;
    private javax.swing.JTable tblTotalBiaya;
    private javax.swing.JTextField txtKembali;
    private javax.swing.JTextField txtNP;
    private javax.swing.JTextField txtTB;
    private javax.swing.JTextField txtTunai;
    // End of variables declaration//GEN-END:variables
}
