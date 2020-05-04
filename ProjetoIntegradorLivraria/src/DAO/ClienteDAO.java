/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Cliente;
import database.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author joaom
 */
public class ClienteDAO {

    public static boolean Salvar(Cliente cliente) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            //abrir conexão            
            conexao = GerenciadorConexao.abrirConexao();

            //executando instrução sql
            instrucaoSQL = conexao.prepareStatement("insert into cliente (cpf,nome,email,estado_civil,dt_nascimento,endereco,telefone,sexo) values(?, ?, ?, ?, ?, ?, ?, ?)");

            instrucaoSQL.setString(1, cliente.getCpf());
            instrucaoSQL.setString(2, cliente.getNome());
            instrucaoSQL.setString(3, cliente.getEmail());
            instrucaoSQL.setString(4, cliente.getEstado_civil());
            instrucaoSQL.setString(5, cliente.getData_de_nascimento());
            instrucaoSQL.setString(6, cliente.getEndereço());
            instrucaoSQL.setString(7, cliente.getTelefone());
            instrucaoSQL.setString(8, cliente.getSexo());

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            retorno = false;
        } finally {
            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                conexao.close();

            } catch (SQLException ex) {
            }
        }

        return retorno;
    }

    public static boolean Atualizar(Cliente cliente) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = GerenciadorConexao.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("UPDATE cliente SET nome=?,email=?,estado_civil=?,dt_nascimento=?,endereco=?,telefone=?,sexo=?, WHERE cpf=?");
            
            instrucaoSQL.setString(1, cliente.getNome());
            instrucaoSQL.setString(2, cliente.getEmail());
            instrucaoSQL.setString(3, cliente.getEstado_civil());
            instrucaoSQL.setString(4, cliente.getData_de_nascimento());
            instrucaoSQL.setString(5, cliente.getEndereço());
            instrucaoSQL.setString(6, cliente.getTelefone());
            instrucaoSQL.setString(7, cliente.getSexo());
            instrucaoSQL.setString(8, cliente.getCpf());
        } catch (Exception e) {
        }

        return retorno;
    }
}
