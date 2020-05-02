/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


/**
 *
 * @author joaom
 */
public class ClienteCRUD {
    
    public static boolean Salvar(Cliente p){
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try {
            //Passo 1
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Passo 2
            String URL = "jdbc:mysql://localhost:3306/livraria?useTimezone=true&serverTimezone=UTC&useSSL=false";
            
            conexao = DriverManager.getConnection(URL, "root", "");
        } catch (Exception e) {
        }
        
        
        
        return retorno;
    }
}
