package Models;

import java.sql.Date;


public class Produto {

    private Date ano;
    private int qtdEstoque;
    private double preco;
    private String titulo;
    private String autor;
    private String editora;
    private String edicao;

    public Produto() {
    }
    
    public Date getAno(){
       return this.ano;
    }
    
    public void setAno(Date ano){
        this.ano=ano;
    }
    
    public int getQtdEstoque(){
        return this.qtdEstoque;
    }
    
    public void setQtdEstoque(int qtdEstoque){
        this.qtdEstoque=qtdEstoque;
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
