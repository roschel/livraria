/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import controller_correto.ClienteController;
import controller_correto.ProdutoController;
import controller_correto.VendaController;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.text.ParseException;
import model.Cliente;
import model.Produto;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Venda;
import static utils.JTableController.formatarData;

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
        
        ProdutoController.Consultar(filtro).forEach((Produto produto) -> {
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
        
        int indiceProduto = tbProduto.getSelectedRow();
        int indiceVenda = 0;
        int qtdVenda = 1;
        int qtdEstoque = 0;
        boolean verificar = false;
        double total = Double.parseDouble(lblTotal.getText());
        double preco = (double)modelProduto.getValueAt(indiceProduto, 3);
        
        for (int i = 0; i < modelVenda.getRowCount(); i++) {
            //verificar se o produto já está na tbVenda
            if (verificar = ((int)modelProduto.getValueAt(indiceProduto, 0) == (int)modelVenda.getValueAt(i, 0))) {
                indiceVenda = i;
                qtdEstoque = (int)modelProduto.getValueAt(indiceProduto, 2);
                qtdVenda = (int)modelVenda.getValueAt(i, 2) + 1;
                if (qtdVenda > qtdEstoque) {
                    JOptionPane.showMessageDialog(null, "Acabaram os livros do Estoque.");
                    return;
                }
                break;
            }
        }
        
        if (verificar) {
            modelVenda.setValueAt(qtdVenda, indiceVenda, 2);
            modelVenda.setValueAt(qtdVenda * preco, indiceVenda, 3);
            total += preco;
        } else {
            modelVenda.addRow(new Object[] {
                modelProduto.getValueAt(indiceProduto, 0),
                modelProduto.getValueAt(indiceProduto, 1),
                qtdVenda,
                preco * qtdVenda
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
    
    public static void carregarRetalorio(JTable tblDiaria, JLabel lblTotalD, int tipo, Date dataI, Date dataF){
        
        DefaultTableModel tabela = (DefaultTableModel) tblDiaria.getModel();
        tabela.setNumRows(0);
                
        ArrayList<Venda> vendas = VendaController.consultarRelatorio(tipo, dataI, dataF);
        
        double totalDia = 0;
                
        for(Venda venda : vendas){
            tabela.addRow(new Object[]{  
                venda.getDtVenda(),
                venda.getNome(),
                venda.getTotal()
            });
            
            totalDia += venda.getTotal();
        }
        
        lblTotalD.setText(String.valueOf(totalDia));
    }
    
    public static String formatarData(Date data) {

        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        String dataFormatada = formatador.format(data);
        return dataFormatada;
    }
    
    public static String formatarDataMes(Date data) {

        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM");
        String dataFormatada = formatador.format(data);
        return dataFormatada;
    }
    
}
