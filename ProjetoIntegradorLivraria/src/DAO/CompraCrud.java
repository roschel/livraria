/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Cliente;
import Models.Compra;
import Models.Produto;
import database.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sillas
 */
public class CompraCrud {
    //insert na tabela compra
    public static boolean inserir(Compra compra){
        boolean retorno;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try {
            //abrindo conexao
            conexao = GerenciadorConexao.abrirConexao();
            
            //executando instrucao sql
            instrucaoSQL = conexao.prepareStatement("insert into compra(dt_compra, id, cpf) values(?, ?, ?)");
            instrucaoSQL.setDate(0, compra.getDtCompra());
            instrucaoSQL.setInt(1, compra.getId());
            instrucaoSQL.setString(2, compra.getCpf());
            
            instrucaoSQL.executeUpdate();
            retorno = true;
        } catch (SQLException | ClassNotFoundException e) {
            //exibir erro no log
            System.out.println(e.getMessage());
            retorno = false;
        } finally {
            //liberando recursos de memoria e fechando conexao
            try {
                if(instrucaoSQL != null){
                    instrucaoSQL.close();
                }
                if(conexao != null){
                    conexao.close();
                }
            } catch (SQLException e) {
            }
        }
        
        return retorno;
    }
    
    
    
    //busca de cliente e livro para teste
    
    
    public static ArrayList<Cliente> consultarClientes(String campo, String filtro){
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        ArrayList<Cliente> clientes = new ArrayList<>();

        try {
            conexao = GerenciadorConexao.abrirConexao();
            
            instrucaoSQL = conexao.prepareStatement("select * from cliente where " + campo + " like '%" + filtro + "%'");
            
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next()){
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
            try {
                if(rs != null){
                    rs.close();
                }
                if(instrucaoSQL != null){
                    instrucaoSQL.close();
                }
                if(conexao != null){
                    conexao.close();
                }
            } catch (SQLException e) {
            }
        }
        
        return clientes;
    }
    
    
    public static ArrayList<Produto> consultarLivros(String campo, String filtro){
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        ArrayList<Produto> produtos = new ArrayList<>();

        try {
            conexao = GerenciadorConexao.abrirConexao();
            
            instrucaoSQL = conexao.prepareStatement("select * from livro where " + campo + " like '%" + filtro + "%'");
            
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next()){
                Produto produto = new Produto();
                //produto.setId(rs.getInt("id"));
                produto.setTitulo(rs.getString("titulo"));
                produto.setQtd_estoque(rs.getInt("qtd_estoque"));
                produto.setPreco(rs.getDouble("preco"));
                
                //adicionando cliente na lista
                produtos.add(produto);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            produtos = null;
        } finally {
            try {
                if(rs != null){
                    rs.close();
                }
                if(instrucaoSQL != null){
                    instrucaoSQL.close();
                }
                if(conexao != null){
                    conexao.close();
                }
            } catch (SQLException e) {
            }
        }
        
        return produtos;
    }
}
