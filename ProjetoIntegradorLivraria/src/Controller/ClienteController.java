/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Cliente;
import DAO.ClienteDAO;
/**
 *
 * @author joaom
 */
public class ClienteController {
    public static boolean Salvar(Cliente p){
        boolean retorno = ClienteDAO.Salvar(p);
        return retorno;
    }
}
