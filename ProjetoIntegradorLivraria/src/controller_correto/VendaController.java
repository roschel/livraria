/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_correto;

import dao_correto.VendaDAO;
import model.Produto;
import model.Venda;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author sillas.clpinto
 */
public class VendaController {
    public static int inserirVenda(Date dtVenda, double total, String cpf) {
        Venda venda = new Venda();
        venda.setDtVenda(dtVenda);
        venda.setTotal(total);
        venda.setCpf(cpf);
        
        return VendaDAO.inserirVenda(venda);
    }
    
    /////////////////////////////////////////////////////////////////////////////
    public static ArrayList<Produto> consultarProduto(String campo, String filtro) {
        return VendaDAO.consultarLivros(campo, filtro);
    }
}