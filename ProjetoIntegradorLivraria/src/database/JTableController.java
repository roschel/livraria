/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Controller.ClienteController;
import Controller.VendaController;
import Models.Cliente;
import Models.Produto;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sillas.clpinto
 */
public class JTableController {
    public static void carregarClientes(JTable table, String filtro) {
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        
        model.setNumRows(0);
        
        ClienteController.Consultar(filtro).forEach((Cliente cliente) -> {
            model.addRow(new Object[] {
                cliente.getCpf(),
                cliente.getNome()
            });
        });
    }
    
    public static void carregarProdutos(JTable table, String campo, String filtro) {
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        
        model.setNumRows(0);
        
        VendaController.consultarProduto(campo, filtro).forEach((Produto produto) -> {
            model.addRow(new Object[] {
                produto.getId(),
                produto.getTitulo(),
                produto.getQtd_estoque(),
                produto.getPreco()
            });
        });
    }
    
    public static void getNome(JTable table, JLabel label) {
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        
        label.setText(model.getValueAt(table.getSelectedRow(), 1).toString());
    }
    
    public static void getProdutos(JTable table1, JTable table2, JLabel label) {
        int indice = table1.getSelectedRow();
        double total = Double.parseDouble(label.getText());
        DefaultTableModel model1 = (DefaultTableModel)table1.getModel();
        DefaultTableModel model2 = (DefaultTableModel)table2.getModel();

        model2.addRow(new Object[] {
            model1.getValueAt(indice, 0),
            model1.getValueAt(indice, 1),
            model1.getValueAt(indice, 2),
            total += (double)model1.getValueAt(indice, 3)
        });
        
        label.setText(String.valueOf(total));
    }
    
    public static Object getInfo(JTable table, int indiceLinha, int indiceColuna) { 
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        
        return model.getValueAt(indiceLinha, indiceColuna);
    }
}
