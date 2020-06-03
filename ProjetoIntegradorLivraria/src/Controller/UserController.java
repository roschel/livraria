/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UsuarioDAO;
import Models.Usuario;
import java.util.ArrayList;

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
    
    public static ArrayList<Usuario> Consultar(String nome){
        Usuario u = new Usuario();
        u.setNome(nome);
        ArrayList<Usuario> listaUsuarios = UsuarioDAO.Consultar(u);
        
        return listaUsuarios;
    }
    
    public static boolean Excluir(int id){
        boolean retorno=false;
        
        
        
        return  retorno;
    }
}
