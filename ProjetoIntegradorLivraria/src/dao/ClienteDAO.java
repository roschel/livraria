/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Cliente;
import utils.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author joaom
 */
public class ClienteDAO {

    /**
     * 
     * @param cliente
     * @return boolean - true: Cliente cadastrado com sucesso, false: Cliente não cadastrado
     */
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
            instrucaoSQL.setDate(5, new java.sql.Date(cliente.getData_de_nascimento().getTime()));
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

    /**
     * 
     * @param cliente
     * @return boolean - true: Cliente cadastrado com sucesso, false: Cliente não cadastrado
     */
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
            instrucaoSQL.setDate(3, new java.sql.Date(cliente.getData_de_nascimento().getTime()));
            instrucaoSQL.setString(4, cliente.getEstado_civil());
            instrucaoSQL.setString(5, cliente.getTelefone());
            instrucaoSQL.setString(6, cliente.getEndereço());
            instrucaoSQL.setString(7, cliente.getEmail());
            instrucaoSQL.setString(8, cliente.getCpf());

            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
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

        return retorno;
    }

    /**
     * 
     * @param cliente
     * @return ArrayList com os dados do cliente
     */
    public static ArrayList<Cliente> Consultar(Cliente cliente) {

        ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
        Connection conexao;
        PreparedStatement instrucaoSQL = null;
        ResultSet rs = null;

        try {
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE cpf LIKE ?");

            instrucaoSQL.setString(1, cliente.getCpf() + "%");

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCpf(rs.getString("cpf"));
                c.setNome(rs.getString("nome"));
                c.setSexo(rs.getString("sexo"));
                
                DateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
                
                String data_nascimento = formatar.format(rs.getDate("dt_nascimento"));
                
                Date nascimento = formatar.parse(data_nascimento);
                
                c.setData_de_nascimento(nascimento);
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

    /**
     * 
     * @param cliente
     * @return boolean - true: Cliente cadastrado com sucesso, false: Cliente não cadastrado
     */
    public static boolean Excluir(Cliente cliente) {
        boolean retorno = false;
        Connection conexao;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = GerenciadorConexao.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("DELETE FROM cliente WHERE cpf=?");

            instrucaoSQL.setString(1, cliente.getCpf());
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
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

        return retorno;
    }
}