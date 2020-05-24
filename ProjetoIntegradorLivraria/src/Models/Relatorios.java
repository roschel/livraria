/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author paulo
 */
public class Relatorios {
    public String data;
    public String dia;
    public String mes;
    public String ano;

    public Relatorios() {
    }

    public Relatorios(String data, String dia, String mes, String ano) {
        this.data = data;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
    
           
    
}
