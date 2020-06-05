/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sillas
 */
public class GerenciadorConexao {
    public static String STATUS = "nao encontrado";
    public static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String SERVER = "localhost";
    public static String DATABASE = "livraria";
    public static String LOGIN = "root";
    public static String SENHA = "";
    public static String URL = "";
    
    public static Connection CONEXAO;
            
    public static Connection abrirConexao() throws ClassNotFoundException, SQLException{
        URL = "jdbc:mysql://" + SERVER + ":3306/" + DATABASE + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
        
        if(CONEXAO == null){
            try {
                Class.forName(DRIVER);
                CONEXAO = DriverManager.getConnection(URL, LOGIN, SENHA);
                
                if(CONEXAO != null){
                    STATUS = "Conexao realizada com sucesso";
                } else {
                    STATUS = "Conexao nao foi realizada com sucesso";
                }
            } catch(ClassNotFoundException e) {
                throw new ClassNotFoundException("O Driver especificado nao foi encontrado");
            } catch(SQLException e){
                throw new SQLException("Erro ao tentar estabelecer a conexao");
            }
        }else{
            try {
                if(CONEXAO.isClosed()){
                    CONEXAO = DriverManager.getConnection(URL, LOGIN, SENHA);
                }
            } catch (SQLException e) {
                throw new SQLException("Falha ao fechar a conexao");
            }
        }
        
        return CONEXAO;
    }
    
    public String getStatus(){
        return STATUS;
    }
    
    public static boolean fecharConexao() throws SQLException{
        boolean retorno;
        
        try {
            if(CONEXAO != null){
                if(!CONEXAO.isClosed()){
                    CONEXAO.close();
                }
            }
            
            STATUS = "Nao conectado";
            retorno = true;
        } catch (SQLException e) {
            retorno = false;
        }
        
        return retorno;
    }
    
    public static void liberarMemoria(Connection conexao, PreparedStatement sql) {
        try {
            if (conexao != null) {
                conexao.close();
            }
            
            if (sql != null) {
                sql.close();
            }
        } catch (SQLException e) {
        }
    }
    
    public static void liberarMemoria(Connection conexao, PreparedStatement sql, ResultSet rs) {
        try {
            if (conexao != null) {
                conexao.close();
            }
            
            if (sql != null) {
                sql.close();
            }
            
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
        }
    }
}
