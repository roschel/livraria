/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Cliente;
import DAO.ClienteDAO;
import java.util.ArrayList;

/**
 *
 * @author joaom
 */
public class ClienteController {

    public static boolean Salvar(String cpf, String nome,
            String data_nascimento, String email, String endereco,
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

    public static boolean Alterar() {
        boolean retorno = false;

        Cliente c = new Cliente();

        retorno = ClienteDAO.Atualizar(c);

        return retorno;
    }

    public static ArrayList<Cliente> Consultar(String cpf) {
        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);

        ArrayList<Cliente> listaClientes = ClienteDAO.Consultar(cliente);

        return listaClientes;
    }
}
