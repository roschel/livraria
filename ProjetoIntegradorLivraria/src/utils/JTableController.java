/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import controller.ClienteController;
import controller.VendaController;
import model.Cliente;
import model.Produto;
import java.util.ArrayList;
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
    
    public static void adicionarProduto(JTable tbProduto, JTable tbVenda, JLabel lblTotal) {
        DefaultTableModel modelProduto = (DefaultTableModel)tbProduto.getModel();
        DefaultTableModel modelVenda = (DefaultTableModel)tbVenda.getModel();
        
        int indice = tbProduto.getSelectedRow();
        int indice2 = 0;
        int qtd = 1;
        boolean verificar = false;
        double total = Double.parseDouble(lblTotal.getText());
        double preco = (double)modelProduto.getValueAt(indice, 3);
        double totalProduto = 0;

        for (int i = 0; i < modelVenda.getRowCount(); i++) {
            //verificar se o produto já está na tbVenda
            if (verificar = ((int)modelProduto.getValueAt(indice, 0) == (int)modelVenda.getValueAt(i, 0))) {
                indice2 = i;
                qtd = (int)modelVenda.getValueAt(i, 2) + 1;
                break;
            }
        }
        
        if (verificar) {
            modelVenda.setValueAt(qtd, indice2, 2);
            modelVenda.setValueAt(qtd * preco, indice2, 3);
            total += preco;
        } else {
            modelVenda.addRow(new Object[] {
                modelProduto.getValueAt(indice, 0),
                modelProduto.getValueAt(indice, 1),
                qtd,
                preco * qtd
            });
            total += preco;
        }
        
        lblTotal.setText(String.valueOf(total));
    }
    
    public static void removerProduto(JTable tbVenda, JLabel lblTotal) {
        DefaultTableModel modelVenda = (DefaultTableModel)tbVenda.getModel();

        int indice = tbVenda.getSelectedRow();
        int qtd = (int)modelVenda.getValueAt(indice, 2);
        double preco = (double)modelVenda.getValueAt(indice, 3) / qtd;
        
        if ((qtd -= 1) > 0) {
            modelVenda.setValueAt(qtd, indice, 2);
            modelVenda.setValueAt(preco * qtd, indice, 3);
        } else {
            modelVenda.removeRow(indice);
        }
        
        lblTotal.setText(String.valueOf(Double.parseDouble(lblTotal.getText()) - preco));
    }
    
    public static Object getInfo(JTable table, int indiceLinha, int indiceColuna) { 
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        
        return model.getValueAt(indiceLinha, indiceColuna);
    }
}
