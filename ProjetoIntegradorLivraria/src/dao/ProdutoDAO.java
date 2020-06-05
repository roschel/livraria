/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Produto;
import utils.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author danil
 */
public class ProdutoDAO {
    
    public static boolean Salvar(Produto produto) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            //abrir conexão            
            conexao = GerenciadorConexao.abrirConexao();

            //executando instrução sql
            instrucaoSQL = conexao.prepareStatement("insert into livro (ano,qtd_estoque,preco,titulo,autor,editora,edicao) values(?, ?, ?, ?, ?, ?, ?)");

            instrucaoSQL.setInt(1, produto.getAno());
            instrucaoSQL.setInt(2, produto.getQtd_estoque());
            instrucaoSQL.setDouble(3, produto.getPreco());
            instrucaoSQL.setString(4, produto.getTitulo());
            instrucaoSQL.setString(5, produto.getAutor());
            instrucaoSQL.setString(6, produto.getEditora());
            instrucaoSQL.setString(7, produto.getEdicao());

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

    public static boolean Atualizar(Produto produto) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = GerenciadorConexao.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("UPDATE livro SET ano=?,"
                    + "qtd_estoque=?,"
                    + "preco=?,"
                    + "titulo=?,"
                    + "autor=?, "
                    + "editora=?, "
                    + "edicao=? "
                    + "WHERE id_livro=?");

            instrucaoSQL.setInt(1, produto.getAno());
            instrucaoSQL.setInt(2, produto.getQtd_estoque());
            instrucaoSQL.setDouble(3, produto.getPreco());
            instrucaoSQL.setString(4, produto.getTitulo());
            instrucaoSQL.setString(5, produto.getAutor());
            instrucaoSQL.setString(6, produto.getEditora());
            instrucaoSQL.setString(7, produto.getEdicao());
            instrucaoSQL.setInt(8, produto.getId());
            
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
    
    public static boolean Atualizar(int idLivro, int qtd) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = GerenciadorConexao.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("UPDATE livro SET qtd_estoque=? WHERE id_livro=?");

            instrucaoSQL.setInt(1, qtd);
            instrucaoSQL.setInt(2, idLivro);
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
            }
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            GerenciadorConexao.liberarMemoria(conexao, instrucaoSQL);
        }

        return retorno;
    }

    public static ArrayList<Produto> Consultar(Produto produto) {

        ArrayList<Produto> listaProduto = new ArrayList<Produto>();
        Connection conexao;
        PreparedStatement instrucaoSQL = null;
        ResultSet rs = null;

        try {
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM livro WHERE titulo LIKE ?");

            instrucaoSQL.setString(1, produto.getTitulo() + "%");

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                
                p.setId(rs.getInt("id_livro"));
                p.setAno(rs.getInt("ano"));
                p.setQtd_estoque(rs.getInt("qtd_estoque"));
                p.setPreco(rs.getDouble("preco"));
                p.setTitulo(rs.getString("titulo"));
                p.setAutor(rs.getString("autor"));
                p.setEditora(rs.getString("editora"));
                p.setEdicao(rs.getString("edicao"));

                listaProduto.add(p);
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

        return listaProduto;
    }
    
    public static ArrayList<Produto> ConsultarId(Produto produto) {

        ArrayList<Produto> listaProduto = new ArrayList<Produto>();
        Connection conexao;
        PreparedStatement instrucaoSQL = null;
        ResultSet rs = null;

        try {
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM livro WHERE id_livro = ?");

            instrucaoSQL.setInt(1, produto.getId());

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                
                p.setId(rs.getInt("id_livro"));
                p.setAno(rs.getInt("ano"));
                p.setQtd_estoque(rs.getInt("qtd_estoque"));
                p.setPreco(rs.getDouble("preco"));
                p.setTitulo(rs.getString("titulo"));
                p.setAutor(rs.getString("autor"));
                p.setEditora(rs.getString("editora"));
                p.setEdicao(rs.getString("edicao"));

                listaProduto.add(p);
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

        return listaProduto;
    }

    public static boolean Excluir(Produto produto) {
        boolean retorno = false;
        Connection conexao;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = GerenciadorConexao.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("DELETE FROM livro WHERE id_livro=?");

            instrucaoSQL.setInt(1, produto.getId());
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
