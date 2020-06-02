/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.RelatoriosDAO;
import Models.Relatorios;
import database.GerenciadorConexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author paulo
 */
public class RelatoriosController {
    
    Connection conexao;

    public RelatoriosController() throws ClassNotFoundException, SQLException {
        conexao = GerenciadorConexao.abrirConexao();
    }  
    

    private static Date rdia;
    
    public static boolean pesquisarDia(String data, DefaultTableModel tabela, JLabel total){
        
        Relatorios rDia = new Relatorios();
        rDia.setData(data);
        
        return RelatoriosDAO.pesquisaDia(rDia, tabela, total);
    }
    
    public static boolean pesquisarPeriodo(String dataI, String dataF, DefaultTableModel tabela, JLabel total){
        
        Relatorios rPeriodo = new Relatorios();
        
        rPeriodo.setDataI(dataI);
        rPeriodo.setDataF(dataF);
        
        return RelatoriosDAO.pesquisaPer(rPeriodo, tabela, total);
    }
    
    public static boolean pesquisarMes(String mes, String ano, DefaultTableModel tabela, JLabel total){
        
        Relatorios rMes = new Relatorios();
        
        rMes.setMes(mes);
        rMes.setAno(ano);
        
        return RelatoriosDAO.pesquisarMes(rMes, tabela, total);
    }
    
}
