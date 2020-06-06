/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_correto;

import model.Relatorios;
import utils.GerenciadorConexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;

/**
 *
 * @author paulo
 */
public class RelatoriosDAO {
    
    public static boolean pesquisaDia(Relatorios pRelatorio, DefaultTableModel tabela, JLabel total){
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ResultSet resultado;
        Statement st = null;
        
        String data = pRelatorio.getData();
                        
        try {           
            conexao = GerenciadorConexao.abrirConexao();
            
            tabela.setNumRows(0);
            
            String linhapesq = "select cliente.nome, livro.id, livro.titulo, livro.preco, venda.dt_compra from venda "
                    + "join livro on venda.id = livro.id "
                    + "join cliente on venda.cpf = cliente.cpf where dt_compra = '"
                    + data + "'";
            
            resultado = st.executeQuery(linhapesq);
            
            while (resultado.next()) {
                tabela.addRow(new Object[]{
                    resultado.getString("dt_compra"),
                    resultado.getString("nome"),
                    resultado.getString("preco")
                }
                );
            }
            
            double soma = 0;
            for(int i = 0; i < tabela.getRowCount(); i++){
                double valor = Double.parseDouble((String) tabela.getValueAt(i, 2));
                soma += valor;
            }
            total.setText(String.valueOf(soma));
            retorno = true;
        } catch (Exception e) {
            retorno = false;
            JOptionPane.showMessageDialog(null, "Erro!");
        }        
        return retorno;
    }
    
    public static boolean pesquisaPer(Relatorios pRelatorio, DefaultTableModel tabela, JLabel total) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ResultSet resultado;
        Statement st = null;
        String dataI = pRelatorio.getDataI();
        String dataF = pRelatorio.getDataF();
                
        try {
            conexao = GerenciadorConexao.abrirConexao();
            
            tabela.setNumRows(0);
            
            String linhapesq = "select cliente.nome, livro.id, livro.titulo, livro.preco, venda.dt_compra from venda "
                    + "join livro on venda.id = livro.id "
                    + "join cliente on venda.cpf = cliente.cpf where date(dt_compra) between '"
                    + dataI + "' and '" + dataF + "' order by venda.dt_compra";
            
            resultado = st.executeQuery(linhapesq);
            
            while (resultado.next()) {
                tabela.addRow(new Object[]{
                    resultado.getString("dt_compra"),
                    resultado.getString("nome"),
                    resultado.getString("preco")
                }
                );
            }
            
            double soma = 0;
            for(int i = 0; i < tabela.getRowCount(); i++){
                double valor = Double.parseDouble((String) tabela.getValueAt(i, 2));
                soma += valor;
            }
            total.setText(String.valueOf(soma));
            retorno = true;
        } catch (Exception e) {
            retorno = false;
            JOptionPane.showMessageDialog(null, "Erro");
        }
        return retorno;
    }
    
    public static boolean pesquisarMes(Relatorios pRelatorio, DefaultTableModel tabela, JLabel total){
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ResultSet resultado;
        Statement st = null;
        
        String mes = pRelatorio.getMes();
        String ano = pRelatorio.getAno();
        
        try {           
            conexao = GerenciadorConexao.abrirConexao();
            
            tabela.setNumRows(0);
            
            String linhapesq = "select cliente.nome, livro.id, livro.titulo, livro.preco, venda.dt_compra from venda "
                    + "join livro on venda.id = livro.id "
                    + "join cliente on venda.cpf = cliente.cpf where month(dt_compra) = "
                    + mes + " and year(dt_compra) = " 
                    + ano + " order by venda.dt_compra";
            
            resultado = st.executeQuery(linhapesq);
            while (resultado.next()) {
                tabela.addRow(new Object[]{
                    resultado.getString("dt_compra"),
                    resultado.getString("nome"),
                    resultado.getString("preco")
                }
                );
            }
                       
            double soma = 0;
            for(int i = 0; i < tabela.getRowCount(); i++){
                double valor = Double.parseDouble((String) tabela.getValueAt(i, 2));
                soma += valor;
            }
            total.setText(String.valueOf(soma));
            retorno = true;
        } catch (Exception e) {
            retorno = false;
            JOptionPane.showMessageDialog(null, "Erro");
        }
        return retorno;
    }
    
}