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
import java.sql.SQLException;

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
}
