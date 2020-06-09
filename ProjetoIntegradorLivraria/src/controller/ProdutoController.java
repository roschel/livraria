/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProdutoDAO;
import model.Produto;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author danilo
 */
public class ProdutoController {
    
    /**
     * @author Danilo
     * @param ano
     * @param qtd_estoque
     * @param preco
     * @param titulo
     * @param autor
     * @param editora
     * @param edicao
     * @return retorna um boleano para salvar as informações passadas no Banco de dados, caso tenham ocorrido alterações
     */
    
    public static boolean Salvar(int ano, int qtd_estoque,
            Double preco, String titulo, String autor,
            String editora, String edicao) {

        boolean retorno = false;

        Produto p = new Produto();
        p.setAno(ano);
        p.setQtd_estoque(qtd_estoque);
        p.setPreco(preco);
        p.setTitulo(titulo);
        p.setAutor(autor);
        p.setEditora(editora);
        p.setEdicao(edicao);
       
        retorno = ProdutoDAO.Salvar(p);

        return retorno;
    }
    
    /**
     * @author Danilo
     * @param id
     * @param ano
     * @param qtd_estoque
     * @param preco
     * @param titulo
     * @param autor
     * @param editora
     * @param edicao
     * @return caso haja alguma alteração no produto, retorna um booleano verdadeiro, para que ocorra a alteração.
     */

    public static boolean Atualizar(int id, int ano, int qtd_estoque,
            Double preco, String titulo, String autor,
            String editora, String edicao) {
        boolean retorno = false;

        Produto p = new Produto();
        p.setId(id);
        p.setAno(ano);
        p.setQtd_estoque(qtd_estoque);
        p.setPreco(preco);
        p.setTitulo(titulo);
        p.setAutor(autor);
        p.setEditora(editora);
        p.setEdicao(edicao);

        retorno = ProdutoDAO.Atualizar(p);

        return retorno;
    }

    /**
     * @author Danilo
     * @param titulo
     * @return retorna um ArrayList com o objetivo de consultar um livro através do título dele.
     */
    
    public static ArrayList<Produto> Consultar(String titulo) {
        ArrayList<Produto> listaProduto = ProdutoDAO.Consultar(titulo);

        return listaProduto;
    }
    
    /**
     * @author Danilo
     * @param id
     * @return retorna um ArrayList com o objetivo de consultar um livro através do seu Id.
     */
    
    public static ArrayList<Produto> ConsultarId(int id) {
        Produto produto = new Produto();
        produto.setId(id);

        ArrayList<Produto> listaProduto = ProdutoDAO.ConsultarId(produto);

        return listaProduto;
    }
    
    /**
     * @author Danilo
     * @param id
     * @return retorna um boleano com o objetivo de excluir um livro através do seu Id.
     */
    
    public static boolean Excluir(int id){
        boolean retorno = false;
        
        Produto produto = new Produto();
        produto.setId(id);
        
        retorno=ProdutoDAO.Excluir(produto);
        
        return retorno;
    }
}