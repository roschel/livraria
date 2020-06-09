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
 * @author danilo
 */
public class ProdutoDAO {
    
    /**
     * @author Danilo
     * @param produto
     * @return retorna um boleano verdadeiro (True) caso haja a iserção de dados, para cadastro de um novo livro.
     */
    
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
    
    
    /**
     * @author Danilo
     * @param produto
     * @return retorna um boleano verdadeiro (True) caso haja alteração de dados em um livro já cadastrado.
     */

    public static boolean Atualizar(Produto produto) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            //abrir conexão
            conexao = GerenciadorConexao.abrirConexao();
            //executar instrução sql
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
    
    /**
     * @author Danilo
     * @param idLivro
     * @param qtd
     * @return retorna um boleano verdadeiro (True) caso haja alteração de quantidade em estoque de um livro já cadastrado, através do seu Id.
     */
    
    public static boolean Atualizar(int idLivro, int qtd) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            //abrir conexão
            conexao = GerenciadorConexao.abrirConexao();
            //executar instrução sql
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

    /**
     * @author Danilo
     * @param titulo
     * @return retorna um ArrayList que preenche a tabela com os dados devidos de forma geral, ou através do título do livro.
     */
    
    public static ArrayList<Produto> Consultar(String titulo) {

        ArrayList<Produto> listaProduto = new ArrayList<Produto>();
        Connection conexao;
        PreparedStatement instrucaoSQL = null;
        ResultSet rs = null;

        try {
            //abrir conexão
            conexao = GerenciadorConexao.abrirConexao();
            //executar instrução sql
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM livro WHERE titulo LIKE ?");

            instrucaoSQL.setString(1, titulo + "%");

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
    
    /**
     * @author Danilo
     * @param produto
     * @return retorna um ArrayList que preenche a tabela com os dados devidos através do Id do livro.
     */
    
    public static ArrayList<Produto> ConsultarId(Produto produto) {

        ArrayList<Produto> listaProduto = new ArrayList<Produto>();
        Connection conexao;
        PreparedStatement instrucaoSQL = null;
        ResultSet rs = null;

        try {
            //abrir conexão
            conexao = GerenciadorConexao.abrirConexao();
            //executar instrução sql
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
    
    /**
     * @author Danilo
     * @param id
     * @return retorna um inteiro, para alterar a quantidade em estoque de livros, após a venda realizada.
     */
    
    public static int ConsultarId_string(String id) {

        Connection conexao;
        PreparedStatement instrucaoSQL = null;
        ResultSet rs = null;
        int qtd=0;

        try {
            //abrir conexão
            conexao = GerenciadorConexao.abrirConexao();
            //executar instrução sql
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM livro WHERE id_livro = ?");

            instrucaoSQL.setString(1, id);

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                
                qtd = rs.getInt("qtd_estoque");
                

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

        return qtd;
    }

    /**
     * author Danilo
     * @param produto
     * @return retorna um boleano verdadeiro (true) em caso de exclusão de produto selecionado através do Id.
     */
    
    public static boolean Excluir(Produto produto) {
        boolean retorno = false;
        Connection conexao;
        PreparedStatement instrucaoSQL = null;

        try {
            //abrir conexão
            conexao = GerenciadorConexao.abrirConexao();
            //executar instrução sql
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