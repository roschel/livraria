/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_correto;

import dao_correto.VendaDAO;
import model.Venda;
import java.sql.Date;
import java.util.ArrayList;
import static utils.JTableController.formatarData;

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
        VendaDAO.inserirVenda(venda);

        return venda.getIdVenda();
    }
    
    /**
     * @author Paulo Honorato
     * @author Sillas
     * @param tipo
     * @param dataI
     * @param dataF
     * @return retorna um arraylist do tipo venda com os dados para uma tabela de relatório.
     */
    public static ArrayList<Venda> consultarRelatorio(int tipo, Date dataI, Date dataF){
        
        String dateI = formatarData(dataI);
        String dateF = formatarData(dataF);
        
        ArrayList<Venda> venda = VendaDAO.consultarRelatorio(tipo, dateI, dateF);
                
        return venda;
    }
    
}

