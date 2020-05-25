/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Relatorios;
import database.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author paulo
 */
public class RelatoriosDAO {

    public PreparedStatement st;
    public ResultSet resultado;
    
    public static boolean pesquisaDia(Relatorios pRelatorio, DefaultTableModel tabela){
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
                        
        try {
            conexao = GerenciadorConexao.abrirConexao();
            
            tabela = (DefaultTableModel) tblDiaria.getModel();
            tabela.setNumRows(0);
            
            instrucaoSQL = conexao.prepareStatement("select cliente.nome, livro.id, livro.titulo, livro.preco, venda.dt_compra from venda "
                    + "join livro on venda.id = livro.id "
                    + "join cliente on venda.cpf = cliente.cpf where (dt_compra) VALUES(?)");
            instrucaoSQL.setString(0, pRelatorio.getData());
            
            resultado = st.executeQuery(instrucaoSQL);
            
            while (resultado.next()) {
                tabela.addRow(new Object[]{
                    resultado.getString("dt_compra"),
                    resultado.getString("nome"),
                    resultado.getString("preco")
                }
                );
            }
            
            double soma = 0;
            for(int i = 0; i < tblDiaria.getRowCount(); i++){
                double valor = Double.parseDouble((String) tblDiaria.getValueAt(i, 2));
                soma += valor;
            }
            lblTotalD.setText(String.valueOf(soma));
            retorno = true;
        } catch (Exception e) {
            retorno = false;
            JOptionPane.showMessageDialog(null, e);
        }
        return retorno;
    }
    
    public static boolean pesquisaPer(Relatorios pRelatorio, DefaultTableModel tabela){
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        String dataI = pRelatorio.getDataI();
        String dataF = pRelatorio.getDataF();
                
        try {
            conexao = GerenciadorConexao.abrirConexao();
            
            DefaultTableModel tabela = (DefaultTableModel) tblPeriodo.getModel();
            tabela = (DefaultTableModel) tblPeriodo.getModel();
            tabela.setNumRows(0);
            
            instrucaoSQL = conexao.prepareStatement("select cliente.nome, livro.id, livro.titulo, livro.preco, venda.dt_compra from venda "
                    + "join livro on venda.id = livro.id "
                    + "join cliente on venda.cpf = cliente.cpf where date(dt_compra) between '?' and '?' order by venda.dt_compra");
            instrucaoSQL.setString(0, dataI);
            instrucaoSQL.setString(1, dataF);
            
            resultado = st.executeQuery(instrucaoSQL);
            
            while (resultado.next()) {
                tabela.addRow(new Object[]{
                    resultado.getString("dt_compra"),
                    resultado.getString("nome"),
                    resultado.getString("preco")
                }
                );
            }
            
            double soma = 0;
            for(int i = 0; i < tblPeriodo.getRowCount(); i++){
                double valor = Double.parseDouble((String) tblPeriodo.getValueAt(i, 2));
                soma += valor;
            }
            lblTotalP.setText(String.valueOf(soma));
            retorno = true;
        } catch (Exception e) {
            retorno = false;
            JOptionPane.showMessageDialog(null, e);
        }
        return retorno;
    }
    
    public static boolean pesquisarMes(Relatorios pRelatorio, DefaultTableModel tabela){
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try {
            conexao = GerenciadorConexao.abrirConexao();
            
            DefaultTableModel tabela = (DefaultTableModel) tblMensal.getModel();
            tabela = (DefaultTableModel) tblMensal.getModel();
            tabela.setNumRows(0);
            
            instrucaoSQL = conexao.prepareStatement("select cliente.nome, livro.id, livro.titulo, livro.preco, venda.dt_compra from venda "
                    + "join livro on venda.id = livro.id "
                    + "join cliente on venda.cpf = cliente.cpf where month(dt_compra) = ? and year(dt_compra) = ?"
                    + " order by venda.dt_compra");
            instrucaoSQL.setString(0, mes);
            instrucaoSQL.setString(1, ano);
            
            resultado = st.executeQuery(instrucaoSQL);
            while (resultado.next()) {
                tabela.addRow(new Object[]{
                    resultado.getString("dt_compra"),
                    resultado.getString("nome"),
                    resultado.getString("preco")
                }
                );
            }
                       
            double soma = 0;
            for(int i = 0; i < tblMensal.getRowCount(); i++){
                double valor = Double.parseDouble((String) tblMensal.getValueAt(i, 2));
                soma += valor;
            }
            lblTotalM.setText(String.valueOf(soma));
            retorno = true;
        } catch (Exception e) {
            retorno = false;
            JOptionPane.showMessageDialog(null, e);
        }
        return retorno;
    }
    
}
