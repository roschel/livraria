/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Cliente;
import DAO.ClienteDAO;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author joaom
 */
public class ClienteController {

    public static boolean Salvar(String cpf, String nome,
            Date data_nascimento, String email, String endereco,
            String estado_civil, String sexo, String telefone) {

        boolean retorno = false;

        Cliente p = new Cliente();
        p.setCpf(cpf);
        p.setNome(nome);
        p.setData_de_nascimento(data_nascimento);
        p.setEmail(email);
        p.setEndereço(endereco);
        p.setSexo(sexo);
        p.setTelefone(telefone);
        p.setEstado_civil(estado_civil);

        retorno = ClienteDAO.Salvar(p);

        return retorno;
    }

    public static boolean Atualizar(String cpf, String nome,
            String sexo, Date nascimento, String estado_civil,
            String telefone, String endereco, String email) {
        boolean retorno = false;

        Cliente c = new Cliente();
        c.setCpf(cpf);
        c.setEmail(email);
        c.setNome(nome);
        c.setEndereço(endereco);
        c.setSexo(sexo);
        c.setTelefone(telefone);
        c.setEstado_civil(estado_civil);
        c.setData_de_nascimento(nascimento);

        retorno = ClienteDAO.Atualizar(c);

        return retorno;
    }

    public static ArrayList<Cliente> Consultar(String cpf) {
        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);

        ArrayList<Cliente> listaClientes = ClienteDAO.Consultar(cliente);

        return listaClientes;
    }
    
    public static boolean Excluir(String cpf){
        boolean retorno = false;
        
        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);
        
        retorno=ClienteDAO.Excluir(cliente);
        
        return retorno;
    }
}
