/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import controller.ClienteController;
import controller.DetalheVendaController;
import controller.ProdutoController;
import controller.VendaController;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import model.Cliente;
import model.Produto;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.DetalheVenda;
import model.Venda;

/**
 *
 * @author sillas.clpinto
 */
public class JTableController {
    /**
     * @author Sillas
     * @param tbClientes objeto do tipo JTable
     * @param campo objeto do tipo int
     * @param filtro objeto do tipo String
     */
    public static void carregarClientes(JTable tbClientes, int campo, String filtro) {
        DefaultTableModel model = (DefaultTableModel)tbClientes.getModel();
        
        model.setNumRows(0);
        
        if (campo == 0) {
            ClienteController.Consultar(filtro).forEach((Cliente cliente) -> {
                model.addRow(new Object[] {
                    cliente.getCpf(),
                    cliente.getNome()
                });
            }); 
        } else {
            ClienteController.consultarNome(filtro).forEach((Cliente cliente) -> {
                model.addRow(new Object[] {
                    cliente.getCpf(),
                    cliente.getNome()
                });
            }); 
        }
    }
    
    /**
     * @author Sillas
     * @param tbProdutos objeto do tipo JTable
     * @param campo objeto do tipo int
     * @param filtro objeto do tipo String
     */
    public static void carregarProdutos(JTable tbProdutos, int campo, String filtro) {
        DefaultTableModel model = (DefaultTableModel)tbProdutos.getModel();
        
        model.setNumRows(0);
        
        if (campo == 0) {
            ProdutoController.ConsultarId(Integer.parseInt(filtro)).forEach((Produto produto) -> {
                model.addRow(new Object[] {
                    produto.getId(),
                    produto.getTitulo(),
                    produto.getQtd_estoque(),
                    String.format("%.2f", produto.getPreco())
                });
            });
        } else {
            ProdutoController.Consultar(filtro).forEach((Produto produto) -> {
                model.addRow(new Object[] {
                    produto.getId(),
                    produto.getTitulo(),
                    produto.getQtd_estoque(),
                    String.format("%.2f", produto.getPreco())
                });
            });
        }
    }
    
    /**
     * @author Sillas
     * @param table objeto do tipo JTable
     * @param label objeto do tipo JLabel
     */
    public static void getNome(JTable table, JLabel label) {
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        
        label.setText(model.getValueAt(table.getSelectedRow(), 1).toString());
    }
    
    /**
     * @author Sillas
     * @param tbProdutos objeto do tipo JTable
     * @param tbVenda objeto do tipo JTable
     * @param lblTotal objeto do tipo JLabel
     */
    public static void adicionarProduto(JTable tbProdutos, JTable tbVenda, JLabel lblTotal) {
        DefaultTableModel modelProduto = (DefaultTableModel)tbProdutos.getModel();
        DefaultTableModel modelVenda = (DefaultTableModel)tbVenda.getModel();
        
        int indiceProduto = tbProdutos.getSelectedRow();
        int indiceVenda = 0;
        int qtdVenda = 1;
        int qtdEstoque;
        boolean verificar = false;
        double total = Double.parseDouble(lblTotal.getText().replace(',', '.'));
        double preco = Double.parseDouble(modelProduto.getValueAt(indiceProduto, 3).toString().replace(',', '.'));
        
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
            modelVenda.setValueAt(String.format("%.2f", qtdVenda * preco).replace('.', ','), indiceVenda, 3);
            total += preco;
        } else {
            modelVenda.addRow(new Object[] {
                modelProduto.getValueAt(indiceProduto, 0),
                modelProduto.getValueAt(indiceProduto, 1),
                qtdVenda,
                String.format("%.2f", preco * qtdVenda).replace('.', ',')
            });
            total += preco;
        }
        
        lblTotal.setText(String.format("%.2f", total).replace('.', ','));
    }
    
    /**
     * @author Sillas
     * @param tbVenda objeto do tipo JTable
     * @param lblTotal objeto do tipo JLabel
     */
    public static void removerProduto(JTable tbVenda, JLabel lblTotal) {
        DefaultTableModel modelVenda = (DefaultTableModel)tbVenda.getModel();

        int indice = tbVenda.getSelectedRow();
        int qtd = (int)modelVenda.getValueAt(indice, 2);
        String precoString = modelVenda.getValueAt(indice, 3).toString().replace(',', '.');
        double precoUnit = Double.parseDouble(precoString) / qtd;
        
        if ((qtd -= 1) > 0) {
            modelVenda.setValueAt(qtd, indice, 2);
            modelVenda.setValueAt(String.format("%.2f", precoUnit * qtd), indice, 3);
        } else {
            modelVenda.removeRow(indice);
        }
        
        precoString = lblTotal.getText().replace(',', '.');
        lblTotal.setText(String.format("%.2f", Double.parseDouble(precoString) - precoUnit).replace('.', ','));
    }
    
    public static Object getInfo(JTable table, int indiceLinha, int indiceColuna) { 
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        
        return model.getValueAt(indiceLinha, indiceColuna);
    }
    
    
    /**
     * @author Paulo Honorato
     * @author Sillas
     * @param tblDiaria
     * @param lblTotalD
     * @param tipo
     * @param dataI
     * @param dataF 
     */
    public static void carregarRetalorio(JTable tblDiaria, JLabel lblTotalD, int tipo, Date dataI, Date dataF){
        
        DefaultTableModel tabela = (DefaultTableModel) tblDiaria.getModel();
        tabela.setNumRows(0);
                        
        ArrayList<Venda> vendas = VendaController.consultarRelatorio(tipo, dataI, dataF);
        
        double totalDia = 0;
                
        for(Venda venda : vendas){
            tabela.addRow(new Object[]{  
                venda.getIdVenda(),
                venda.getDtVenda(),
                venda.getNome(),
                String.format("%.2f", venda.getTotal())
            });
            
            totalDia += venda.getTotal();
        }
        
        lblTotalD.setText(String.format("%.2f", totalDia));
    }
    
    
    /**
     * @author Paulo Honorato
     * @author Sillas
     * @param tblDiaria
     * @param tblDiariaDet 
     */
    public static void carregarRetalorioDet(JTable tblDiaria, JTable tblDiariaDet){
        DefaultTableModel tabela = (DefaultTableModel) tblDiaria.getModel();
        DefaultTableModel tabelaDet = (DefaultTableModel) tblDiariaDet.getModel();
        tabelaDet.setNumRows(0);
        
        int idVenda = (int) tblDiaria.getValueAt(tblDiaria.getSelectedRow(), 0);
                
        ArrayList<DetalheVenda> vendasDet = DetalheVendaController.consultarRelatorioDet(idVenda);
        
        for(DetalheVenda vendaDet : vendasDet){
            tabelaDet.addRow(new Object[]{  
                vendaDet.getIdLivro(),
                vendaDet.getTitulo(),
                vendaDet.getQtdLivro(),
                String.format("%.2f", vendaDet.getPreco())
            });
        }
    }
    
    
    /**
     * @author Paulo Honorato
     * @param data
     * @return retorna uma data com formato para o banco de dados.
     */
    public static String formatarData(Date data) {

        //formatar a data para que seja possível consultar os dados no banco de dados no formato que o comando entenda
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        String dataFormatada = formatador.format(data);
        return dataFormatada;
    }
    
}
