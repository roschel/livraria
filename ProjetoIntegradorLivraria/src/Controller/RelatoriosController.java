/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.RelatoriosDAO;
import Models.Relatorios;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author paulo
 */
public class RelatoriosController {

    private static Date rdia;
    
    public static boolean pesquisarDia(String data, DefaultTableModel tabela){
        
        Relatorios rDia = new Relatorios();
        rDia.setData(data);
        
        return RelatoriosDAO.pesquisaDia(rDia, tabela);
    }
    
    public static boolean pesquisarPeriodo(String dataI, String dataF, DefaultTableModel tabela){
        
        Relatorios rPeriodo = new Relatorios();
        
        rPeriodo.setDataI(dataI);
        rPeriodo.setDataF(dataF);
        
        return RelatoriosDAO.pesquisaPer(rPeriodo, tabela);
    }
    
    public static boolean pesquisarMes(String mes, String ano, DefaultTableModel tabela){
        
        Relatorios rMes = new Relatorios();
        
        rMes.setMes(mes);
        rMes.setAno(ano);
        
        return RelatoriosDAO.pesquisarMes(rMes, tabela);
    }
    
}
