/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.dao;

import br.com.projetoAcademia.model.Pessoa;
import br.com.projetoAcademia.model.Ticket;
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
public class TicketDAOImpl implements GenericDAO{
     private Connection conn;

    public TicketDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Ticket ticket = (Ticket) object;
        PreparedStatement stmt = null;
        String sql = "insert into ticket(id_pessoa,titulo_ticket,mensagem_ticket,status_ticket,data_ticket) values(?,?,?,?,?);";

        try {
            java.util.Date dataUtil = new java.util.Date();
            dataUtil = ticket.getData();
  java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ticket.getPessoa().getIdPessoa());
            stmt.setString(2,ticket.getTitulo());
            stmt.setString(3,ticket.getMensagem());
            stmt.setString(4, ticket.getStatus());
            stmt.setDate(5, dataSql);
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao salvar Ticket! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
    
    public List<Object> listarA(int idObject) {
        List<Object> tickets = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from ticket where id_pessoa = ?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Ticket ticket = new Ticket();
                ticket.setIdTicket(rs.getInt("id_ticket"));
                ticket.setTitulo(rs.getString("titulo_ticket"));
                ticket.setMensagem(rs.getString("mensagem_ticket"));
                ticket.setStatus(rs.getString("status_ticket"));
                ticket.setData(rs.getDate("data_ticket"));
                tickets.add(ticket);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Tickets! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar par�metros de conex�o! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return tickets ;
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
