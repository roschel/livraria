/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import Models.Venda;
import database.ComandosDb;

/**
 *
 * @author Sillas
 */
public class VendaCrud {
    ComandosDb com = new ComandosDb();
    
    public void inserirVenda(Venda camposVenda){
        String linhaSql = String.format("insert into compra values('%s', '%d', '%s')", camposVenda.getDtCompra(), camposVenda.getId(), camposVenda.getCpf());
        com.executarDml(linhaSql);
    }
}
