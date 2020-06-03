/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UsuarioDAO;
import Models.Usuario;

/**
 *
 * @author joaom
 */
public class UserController {
    public static boolean Salvar(String nome, String senha){
        boolean retorno = false;
        
        Usuario u = new Usuario();
        u.setNome(nome);
        u.setSenha(senha);
        
        retorno = UsuarioDAO.Salvar(u);
        
        
        return retorno;
    }
    
    public static boolean Atualizar(String nome, String senha){
        boolean retorno = false;
        
        Usuario u = new Usuario();
        u.setNome(nome);
        u.setSenha(senha);
        
        //retorno = UsuarioDAO.Atualizar(u);
        
        
        return retorno;
    }
    
    public static boolean Consultar(String nome, String senha){
        boolean retorno = false;
        
        Usuario u = new Usuario();
        u.setNome(nome);
        u.setSenha(senha);
        
        //retorno = UsuarioDAO.Consultar(u);
        
        
        return retorno;
    }
    
    public static boolean Excluir(int id){
        boolean retorno=false;
        
        
        
        return  retorno;
    }
}
