/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_correto;

import dao_correto.DetalheVendaDAO;
import java.util.ArrayList;
import model.DetalheVenda;

/**
 *
 * @author sillas.clpinto
 */
public class DetalheVendaController {
    public static boolean inserirDetalheVenda(int qtdLivro, int idLivro, int idVenda) {
        DetalheVenda detalheVenda = new DetalheVenda();
        detalheVenda.setQtdLivro(qtdLivro);
        detalheVenda.setIdLivro(idLivro);
        detalheVenda.setIdVenda(idVenda);
        
        return DetalheVendaDAO.inserirDetalheVenda(detalheVenda);
    }    
    
    public static ArrayList<DetalheVenda> consultarRelatorioDet(int idVenda){
        
        ArrayList<DetalheVenda> venda = DetalheVendaDAO.consultarRelatorioDet(idVenda);
                
        return venda;
    }
}