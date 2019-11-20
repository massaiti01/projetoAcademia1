/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.dao;

import br.com.projetoAcademia.model.Academia;
import br.com.projetoAcademia.model.Aparelho;
import br.com.projetoAcademia.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ERICMASSAITIUEMURA
 */
public class AparelhoDAOImpl implements GenericDAO{
       private Connection conn;

    public AparelhoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Aparelho aparelho = (Aparelho) object;
        PreparedStatement stmt = null;
        String sql = "insert into aparelho(nome_aparelho,id_academia) values(?,?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, aparelho.getNomeAparelho());
            stmt.setInt(2, aparelho.getAcademia().getIdAcademia());
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar Aparelho! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
            return true;
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> aparelhos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from aparelho where id_academia = ?";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Aparelho aparelho = new Aparelho();
                aparelho.setIdAparelho(rs.getInt("id_aparelho"));
                aparelho.setNomeAparelho(rs.getString("nome_aparelho"));
                Academia academia = new Academia();
                academia.setIdAcademia(rs.getInt("id_academia"));
                aparelho.setAcademia(academia);
                aparelhos.add(aparelho);
                
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar aparelho! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return aparelhos;
    }
    
     public List<Object> listarA(int idObject) {
        List<Object> aparelhos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from aparelho where id_academia = ?";
        try {
            stmt = conn.prepareStatement(sql);
             stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Aparelho aparelho = new Aparelho();
                aparelho.setIdAparelho(rs.getInt("id_aparelho"));
                aparelho.setNomeAparelho(rs.getString("nome_aparelho"));
                Academia academia = new Academia();
                academia.setIdAcademia(rs.getInt("id_academia"));
                aparelho.setAcademia(academia);
                aparelhos.add(aparelho);
                
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar aparelho! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return aparelhos;
    }

    @Override
    public Boolean excluir(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "delete from aparelho WHERE id_aparelho = ?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao Excluir Aparelho!  Erro: " + ex.getMessage());
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
            }
        }
    }

    @Override
    public Object carregar(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Aparelho aparelho = null;

        String sql = "select * from aparelho where id_aparelho = ?";
                
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                aparelho = new Aparelho();
                aparelho.setIdAparelho(rs.getInt("id_aparelho"));
                aparelho.setNomeAparelho(rs.getString("nome_aparelho"));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar Aparelho! Erro: " + ex.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
            }
        }
        return aparelho;
    }

    @Override
    public Boolean alterar(Object object) {
       
        Aparelho aparelho = (Aparelho) object;
        PreparedStatement stmt = null;
        String sql = "update aparelho set nome_aparelho = ? where id_aparelho = ? and id_academia = ?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, aparelho.getNomeAparelho());
            stmt.setInt(2, aparelho.getIdAparelho());
            stmt.setInt(3, aparelho.getAcademia().getIdAcademia());
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao Alterar Aparelho! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
            return true;
        }
    }
    
}
