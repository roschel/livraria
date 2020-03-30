/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author joaom
 */
public class Cliente {
    
    public String nome;
    public String cpf;
    public String endereço;
    public String telefone;
    public String email;
    public String sexo;
    public String estado_civil;
    public String data_de_nascimento;

    public Cliente() {
    }

    public Cliente(String nome, String cpf, String endereço, String telefone, String email, String sexo, String estado_civil, String data_de_nascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereço = endereço;
        this.telefone = telefone;
        this.email = email;
        this.sexo = sexo;
        this.estado_civil = estado_civil;
        this.data_de_nascimento = data_de_nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getData_de_nascimento() {
        return data_de_nascimento;
    }

    public void setData_de_nascimento(String data_de_nascimento) {
        this.data_de_nascimento = data_de_nascimento;
    }
    
    
    public boolean isValid(String cpfSemTraco){
        boolean valid=true;
        int soma=0, validador1=0,validador2=0;
        
        
        if(cpfSemTraco.equals("00000000000") || 
            cpfSemTraco.equals("11111111111") ||
            cpfSemTraco.equals("22222222222") ||
            cpfSemTraco.equals("33333333333") ||
            cpfSemTraco.equals("44444444444") ||
            cpfSemTraco.equals("55555555555") ||
            cpfSemTraco.equals("66666666666") ||
            cpfSemTraco.equals("77777777777") ||
            cpfSemTraco.equals("88888888888") ||
            cpfSemTraco.equals("99999999999") ||
            cpfSemTraco.length() != 11){
            valid=false;
        }else if(valid){
            for (int i = 0; i < cpfSemTraco.length()-2; i++) {
                char dig = cpfSemTraco.charAt(i);
                soma += Character.getNumericValue(dig) *(10-i);                
            }
            
            if(!((11-soma%11)>9)){
                validador1=11-soma%11;
            }
            
            if(!(Character.getNumericValue(cpfSemTraco.charAt(9)) == validador1)){
                return valid=false;
            }
            
            soma=0;
            for (int i = 0; i < cpfSemTraco.length()-1; i++) {
                char dig = cpfSemTraco.charAt(i);
                soma += Character.getNumericValue(dig) *(11-i);
                
            }
            if(!((11-soma%11)>9)){
                validador2=11-soma%11;
            }
            
            if(!(Character.getNumericValue(cpfSemTraco.charAt(10)) == validador2)){
                return valid=false;
            }
            
        }
        
        return valid;
    }
    
}