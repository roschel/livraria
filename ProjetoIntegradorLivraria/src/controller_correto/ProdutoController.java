/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_correto;

import dao_correto.ProdutoDAO;
import model.Produto;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author danil
 */
public class ProdutoController {
    
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

    public static ArrayList<Produto> Consultar(String titulo) {
        ArrayList<Produto> listaProduto = ProdutoDAO.Consultar(titulo);

        return listaProduto;
    }
    
    public static ArrayList<Produto> ConsultarId(int id) {
        Produto produto = new Produto();
        produto.setId(id);

        ArrayList<Produto> listaProduto = ProdutoDAO.ConsultarId(produto);

        return listaProduto;
    }
    
    public static boolean Excluir(int id){
        boolean retorno = false;
        
        Produto produto = new Produto();
        produto.setId(id);
        
        retorno=ProdutoDAO.Excluir(produto);
        
        return retorno;
    }
}