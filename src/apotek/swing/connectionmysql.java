/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek.swing;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author win10nov19
 */
public class connectionmysql {
    
    Connection koneksi = null;
    public static Connection koneksiDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection filekoneksi = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/apotek2_baru", "root", "");
            return filekoneksi;
        } catch (Exception e){
            return null;
        }
        
        
    }
    
}
