/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Cliente;
import model.Venda;
import model.Produto;
import utils.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Sillas
 */
public class VendaDAO {
    
    private static Connection conexao = null;
    private static PreparedStatement sql = null;
        
    //insert na tabela compra
    public static int inserirVenda(Venda venda) {
        int pk = 0;
        
        try {
            //abrindo conexao
            conexao = GerenciadorConexao.abrirConexao();
            
            SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
            
            //executando instrucao sql
            sql = conexao.prepareStatement("insert into venda(dt_venda, total, cpf) values(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            sql.setString(1, formatador.format(venda.getDtVenda()));
            sql.setDouble(2, venda.getTotal());
            sql.setString(3, venda.getCpf());
            
            pk = sql.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            //exibir erro no log
            System.out.println(e.getMessage());
        } finally {
            GerenciadorConexao.liberarMemoria(conexao, sql);
        }
        
        return pk;
    }
    
    
    
    //consultar clientes e livros
    private static ResultSet rs = null;
    public static ArrayList<Cliente> consultarClientes(String campo, String filtro) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        try {
            conexao = GerenciadorConexao.abrirConexao();
            
            sql = conexao.prepareStatement("select * from cliente where ? like concat('%', ?, '%')");
            sql.setString(1, campo);
            sql.setString(2, filtro);
            
            rs = sql.executeQuery();
            
            while(rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                
                //adicionando cliente na lista
                clientes.add(cliente);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            clientes = null;
        } finally {
            GerenciadorConexao.liberarMemoria(conexao, sql, rs);
        }
        
        return clientes;
    }
    
    
    public static ArrayList<Produto> consultarLivros(String campo, String filtro) {        
        ArrayList<Produto> produtos = new ArrayList<>();

        try {
            conexao = GerenciadorConexao.abrirConexao();
            
            sql = conexao.prepareStatement("select * from livro where " + campo + " like concat('%', ?, '%')");
            sql.setString(1, filtro);

            rs = sql.executeQuery();
            
            while(rs.next()){
                Produto produto = new Produto();
                produto.setId(rs.getInt("id_livro"));
                produto.setTitulo(rs.getString("titulo"));
                produto.setQtd_estoque(rs.getInt("qtd_estoque"));
                produto.setPreco(rs.getDouble("preco"));
                
                produtos.add(produto);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            produtos = null;
        } finally {
            GerenciadorConexao.liberarMemoria(conexao, sql, rs);
        }
        
        return produtos;
    }
}
