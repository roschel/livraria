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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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

            instrucaoSQL = conexao.prepareStatement("UPDATE cliente SET nome=?,"
                    + "sexo=?,"
                    + "dt_nascimento=?,"
                    + "estado_civil=?,"
                    + "telefone=?, "
                    + "endereco=?, "
                    + "email=? "
                    + "WHERE cpf=?");
            
            instrucaoSQL.setString(1, cliente.getNome());
            instrucaoSQL.setString(2, cliente.getSexo());
            instrucaoSQL.setString(3, cliente.getData_de_nascimento());
            instrucaoSQL.setString(4, cliente.getEstado_civil());
            instrucaoSQL.setString(5, cliente.getTelefone());
            instrucaoSQL.setString(6, cliente.getEndereço());
            instrucaoSQL.setString(7, cliente.getEmail());
            instrucaoSQL.setString(8, cliente.getCpf());
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if (linhasAfetadas>0) {
                retorno=true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            try {
                if (instrucaoSQL!=null) {
                    instrucaoSQL.close();
                    GerenciadorConexao.fecharConexao();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

        return retorno;
    }
    
    public static ArrayList<Cliente> Consultar(Cliente cliente) {

        ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
        Connection conexao;
        PreparedStatement instrucaoSQL = null;
        ResultSet rs = null;

        try {
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE cpf LIKE ?");

            instrucaoSQL.setString(1, cliente.getCpf()+ "%");

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCpf(rs.getString("cpf"));
                c.setNome(rs.getString("nome"));
                c.setSexo(rs.getString("sexo"));
                c.setData_de_nascimento(rs.getString("dt_nascimento"));
                c.setEstado_civil(rs.getString("estado_civil"));
                c.setTelefone(rs.getString("telefone"));
                c.setEndereço(rs.getString("endereco"));
                c.setEmail(rs.getString("email"));
                

                listaCliente.add(c);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {

            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();

                    GerenciadorConexao.fecharConexao();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }

        return listaCliente;
    }
    
    
    public static boolean Excluir(Cliente cliente){
        boolean retorno = false;
        Connection conexao;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = GerenciadorConexao.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("DELETE FROM cliente WHERE cpf=?");

            instrucaoSQL.setString(1, cliente.getCpf());
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if (linhasAfetadas>0) {
                retorno=true;
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            try {
                if (instrucaoSQL!=null) {
                    instrucaoSQL.close();
                    GerenciadorConexao.fecharConexao();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        
        return retorno;
    }
}
