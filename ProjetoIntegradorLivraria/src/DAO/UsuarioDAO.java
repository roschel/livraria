/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Usuario;
import database.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author joaom
 */
public class UsuarioDAO {

    public static boolean Salvar(Usuario u) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            //abrir conexão
            conexao = GerenciadorConexao.abrirConexao();

            //executar instrução SQL
            instrucaoSQL = conexao.prepareStatement("insert into usuario (nome, senha) values (?,?)");

            instrucaoSQL.setString(1, u.getNome());
            instrucaoSQL.setString(2, u.getSenha());

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
            } catch (Exception e) {
            }
        }

        return retorno;
    }

    public static ArrayList<Usuario> Consultar(Usuario u) {

        ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ResultSet rs = null;

        try {
            //abrir conexão
            conexao = GerenciadorConexao.abrirConexao();

            //instrução sql
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM usuario WHERE nome LIKE ?");

            instrucaoSQL.setString(1, u.getNome() + "%");
            
            rs=instrucaoSQL.executeQuery();
            
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id_usuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                
                listaUsuario.add(usuario);
            }
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            try {
                if (instrucaoSQL!=null) {
                    instrucaoSQL.close();
                }
                
                conexao.close();
            } catch (Exception e) {
            }
        }
        
        return listaUsuario;
    }
}
