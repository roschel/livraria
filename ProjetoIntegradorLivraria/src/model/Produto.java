package model;

import java.util.Date;


public class Produto {

    private int id;
    private int ano;
    private int qtd_estoque;
    private Double preco;
    private String titulo;
    private String autor;
    private String editora;
    private String edicao;

    public Produto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getAno(){
       return this.ano;
    }
    
    public void setAno(int ano){
        this.ano=ano;
    }
    
    public int getQtd_estoque(){
        return this.qtd_estoque;
    }
    
    public void setQtd_estoque(int qtd_estoque){
        this.qtd_estoque=qtd_estoque;
    }
    
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
     public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
    
    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    

    

    


    
    
    
}
