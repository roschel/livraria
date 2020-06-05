/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.DetalheVenda;
import utils.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sillas.clpinto
 */
public class DetalheVendaDAO {
    private static Connection conexao = null;
    private static PreparedStatement sql = null;
    
    public static boolean inserirDetalheVenda(DetalheVenda detalheVenda) {
        boolean retorno;
        
        try {
            conexao = GerenciadorConexao.abrirConexao();
            
            sql = conexao.prepareStatement("insert into detalhe_venda(qtd_livro, id_livro, id_venda) values(?, ?, ?)");
            sql.setInt(1, detalheVenda.getQtdLivro());
            sql.setInt(2, detalheVenda.getIdLivro());
            sql.setInt(3, detalheVenda.getIdVenda());
            
            sql.executeUpdate();
            retorno = true;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            retorno = false;
        } finally {
            GerenciadorConexao.liberarMemoria(conexao, sql);
        }
        
        return retorno;
    }
    
    public static ArrayList<DetalheVenda> consultarDetalheVenda(){
        ArrayList<DetalheVenda> detalhes = new ArrayList<>();
        
        return detalhes;
    } 
}
