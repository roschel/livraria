/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_correto;

import model.Venda;
import utils.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import javax.swing.JOptionPane;
import model.DetalheVenda;

/**
 *
 * @author Sillas
 */
public class VendaDAO {

    private static Connection conexao = null;
    private static PreparedStatement sql = null;
    private static ResultSet rs = null;

    //insert na tabela compra
    public static int inserirVenda(Venda venda) {
        int pk = 0;

        try {
            //abrindo conexao
            conexao = GerenciadorConexao.abrirConexao();

            //executando instrucao sql
            sql = conexao.prepareStatement("insert into venda(dt_venda, total, cpf) values(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            sql.setDate(1, venda.getDtVenda());
            sql.setDouble(2, venda.getTotal());
            sql.setString(3, venda.getCpf());

            pk = sql.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            //exibir erro no log
            System.out.println(e.getMessage());
        } finally {
            GerenciadorConexao.liberarMemoria(conexao, sql);
        }

        return pk;
    }

    public static ArrayList<Venda> consultarRelatorio(int tipo, String dataI, String dataF) {

        ArrayList<Venda> vendas = new ArrayList<>();

        try {
            conexao = GerenciadorConexao.abrirConexao();
            switch (tipo) {
                case 1:
                    sql = conexao.prepareStatement("select venda.id_venda, venda.dt_venda, cliente.nome, venda.total from venda \n"
                            + "inner join cliente where cliente.cpf = venda.cpf and dt_venda like ?");
                    sql.setString(1, dataI + "%");
                    break;
                case 2:
                    sql = conexao.prepareStatement("select venda.id_venda, venda.dt_venda, cliente.nome, venda.total from venda \n"
                            + "inner join cliente where cliente.cpf = venda.cpf and dt_venda between ? and ?");
                    sql.setString(1, dataI);
                    sql.setString(2, dataF);
                    break;
                case 3:
                    sql = conexao.prepareStatement("select venda.id_venda, venda.dt_venda, cliente.nome, venda.total from venda \n"
                            + "inner join cliente where cliente.cpf = venda.cpf and dt_venda like ?");
                    sql.setString(1, dataI.substring(0, 7) + "%");
                    break;
            }

            rs = sql.executeQuery();

            while (rs.next()) {
                Venda vdia = new Venda();
                vdia.setIdVenda(rs.getInt("id_venda"));
                vdia.setDtVenda(rs.getDate("dt_venda"));
                vdia.setNome(rs.getString("nome"));
                vdia.setTotal(rs.getDouble("total"));
                vendas.add(vdia);
            }
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            GerenciadorConexao.liberarMemoria(conexao, sql, rs);
        }
        return vendas;
    }    

}
