/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Date;

/**
 *
 * @author Sillas
 */
public class Compra {
    private Date dtCompra;
    private int id;
    private String cpf;
    
    public Compra(){}
    
    public Date getDtCompra(){
        return dtCompra;
    }
    
    public void setDtCompra(Date dtCompra){
        this.dtCompra = dtCompra;
    }
    
    
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    
    
    public String getCpf(){
        return cpf;
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
}
