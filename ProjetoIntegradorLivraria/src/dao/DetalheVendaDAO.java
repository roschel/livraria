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
import javax.swing.JOptionPane;

/**
 *
 * @author sillas.clpinto
 */
public class DetalheVendaDAO {
    private static Connection conexao = null;
    private static PreparedStatement sql = null;
    private static ResultSet rs = null;
    
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
    
    
    /**
     * @author Paulo Honorato
     * @author Sillas
     * @param idVenda
     * @return retorna um array do tipo detalhe venda com os dados para um relatório detalhado da venda selecionada.
     */
    public static ArrayList<DetalheVenda> consultarRelatorioDet(int idVenda) {

        ArrayList<DetalheVenda> detalhes = new ArrayList<>();

        try {
            
            //abrir conexão com o banco de dados
            conexao = GerenciadorConexao.abrirConexao();
            
            //executar comando de consulta no banco de dados
            sql = conexao.prepareStatement("select detalhe_venda.id_livro, livro.titulo, detalhe_venda.qtd_livro, livro.preco from detalhe_venda \n"
                + "inner join livro on livro.id_livro = detalhe_venda.id_livro where id_venda = ?");
            sql.setInt(1, idVenda);

            rs = sql.executeQuery();

            //preencher o arraylist enquanto houver dados na data informada            
            while (rs.next()) {
                DetalheVenda vdiaDet = new DetalheVenda();
                vdiaDet.setIdLivro(rs.getInt("id_livro"));
                vdiaDet.setTitulo(rs.getString("titulo"));
                vdiaDet.setQtdLivro(rs.getInt("qtd_livro"));
                vdiaDet.setPreco(rs.getDouble("preco"));
                detalhes.add(vdiaDet);
            }
        } catch (SQLException | ClassNotFoundException e) {
            //exibir erro caso não consiga realizar o procedimento do bloco try
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            //encerrar a conexão com o banco de dados
            GerenciadorConexao.liberarMemoria(conexao, sql, rs);
        }
        return detalhes;
    }
}