/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author sillas.clpinto
 */
public class DetalheVenda {
    private int idDetalheVenda;
    private int qtdLivro;
    private int idLivro;
    private int idVenda;
    
    public DetalheVenda() {}

    public int getIdDetalheVenda() {
        return idDetalheVenda;
    }

    public void setIdDetalheVenda(int idDetalheVenda) {
        this.idDetalheVenda = idDetalheVenda;
    }

    public int getQtdLivro() {
        return qtdLivro;
    }

    public void setQtdLivro(int qtdLivro) {
        this.qtdLivro = qtdLivro;
    }
    
    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }
    
    
}
