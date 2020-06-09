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
import javax.swing.JOptionPane;

/**
 *
 * @author Sillas
 */
public class VendaDAO {

    private static Connection conexao = null;
    private static PreparedStatement sql = null;
    private static ResultSet rs = null;

    //insert na tabela compra
    public static void inserirVenda(Venda venda) {

        try {
            //abrindo conexao
            conexao = GerenciadorConexao.abrirConexao();

            //executando instrucao sql
            sql = conexao.prepareStatement("insert into venda(dt_venda, total, cpf) values(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            sql.setDate(1, venda.getDtVenda());
            sql.setDouble(2, venda.getTotal());
            sql.setString(3, venda.getCpf());

            int linhasAfetadas = sql.executeUpdate();

            if (linhasAfetadas > 0) {
                rs = sql.getGeneratedKeys();
                if (rs.next()) {
                    venda.setIdVenda(rs.getInt(1));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            //exibir erro no log
            System.out.println(e.getMessage());
        } finally {
            GerenciadorConexao.liberarMemoria(conexao, sql);
        }
    }

    /**
     * @author Paulo Honorato
     * @param tipo
     * @param dataI
     * @param dataF
     * @return retorna um arraylist do tipo venda com os dados para um relatório
     */
    public static ArrayList<Venda> consultarRelatorio(int tipo, String dataI, String dataF) {

        ArrayList<Venda> vendas = new ArrayList<>();

        try {
            //abrir conexão com o banco de dados
            conexao = GerenciadorConexao.abrirConexao();

            //executar comando de consulta no banco de dados de acordo com o tipo (1- relatório diário; 2- relatório periódico; 3- relatório mensal
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

            //preencher o arraylist enquantou houver dados na data informada
            while (rs.next()) {
                Venda vdia = new Venda();
                vdia.setIdVenda(rs.getInt("id_venda"));
                vdia.setDtVenda(rs.getDate("dt_venda"));
                vdia.setNome(rs.getString("nome"));
                vdia.setTotal(rs.getDouble("total"));
                vendas.add(vdia);
            }
        } catch (SQLException | ClassNotFoundException e) {
            //exibir mensagem de erro caso não consiga executar as instruções do bloco try
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            //encerrar conexão com o banco de dados
            GerenciadorConexao.liberarMemoria(conexao, sql, rs);
        }
        return vendas;
    }

}
