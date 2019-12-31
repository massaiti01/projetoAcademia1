/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.dao;

import br.com.projetoAcademia.model.Mensagem;
import br.com.projetoAcademia.model.Ticket;
import br.com.projetoAcademia.model.Pessoa;
import br.com.projetoAcademia.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eric
 */
public class MensagemDAOImpl implements GenericDAO{
private Connection conn;

    public MensagemDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    @Override
    public Boolean cadastrar(Object object) {
        Mensagem msg = (Mensagem) object;
        PreparedStatement stmt = null;
        String sql = "insert into mensagem(id_pessoa,id_ticket,mensagem,data) values(?,?,?,?);";

        try {
            java.util.Date dataUtil = new java.util.Date();
            dataUtil = msg.getData();
  java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
  
  
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, msg.getRemetente().getIdPessoa());
            stmt.setInt(2, msg.getTicket().getIdTicket());
            stmt.setString(3, msg.getMensagem());
            stmt.setDate(4,dataSql);
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar Mensagem! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os par√¢metros de conex√£o! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    public List<Object> listarA(int idObject) {
        List<Object> mensagens = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from mensagem m inner join pessoa p on m.id_pessoa = p.id_pessoa where m.id_pessoa = ?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Mensagem msg = new Mensagem();
                Ticket ticket = new Ticket();
                Pessoa pessoa = new Pessoa();
                pessoa.setNomePessoa(rs.getString("nome_pessoa"));
                msg.setRemetente(pessoa);
                msg.setIdMensagem(rs.getInt("id_mensagem"));
                ticket.setIdTicket(rs.getInt("id_ticket"));
                msg.setTicket(ticket);
                msg.setMensagem(rs.getString("mensagem"));
                msg.setData(rs.getDate("data"));
                mensagens.add(msg);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar msg! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar par‚metros de conex„o! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return mensagens ;
    }
    
    @Override
    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean excluir(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object carregar(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
