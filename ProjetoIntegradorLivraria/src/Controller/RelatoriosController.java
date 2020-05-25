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
    
    public static boolean pesquisarDia(String data){
        
        Relatorios rDia = new Relatorios();
        rDia.setData(data);
        
        return RelatoriosDAO.pesquisaDia(rDia);
    }
    
    public static boolean pesquisarPeriodo(String dataI, String dataF){
        
        Relatorios rPeriodo = new Relatorios();
        
        rPeriodo.setDataI(dataI);
        rPeriodo.setDataF(dataF);
        
        return RelatoriosDAO.pesquisaPer(rPeriodo);
    }
    
    public static boolean pesquisarMes(String mes, String ano){
        
        Relatorios rMes = new Relatorios();
        
        rMes.setMes(mes);
        rMes.setAno(ano);
        
        return RelatoriosDAO.pesquisarMes(rMes);
    }
    
}
