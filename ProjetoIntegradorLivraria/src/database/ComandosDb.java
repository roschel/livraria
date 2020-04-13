/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Sillas
 */
public class ComandosDb {
    Connection con;
    Statement st;
    ResultSet rs;
    
    public void executarDml(String linhaSql){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/livraria", "root", "");
            st = (Statement)con.createStatement();
            st.executeUpdate(linhaSql);
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro: " + e);
        }
    }
}
