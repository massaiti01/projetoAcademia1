/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.dao;

import br.com.projetoAcademia.model.Academia;
import br.com.projetoAcademia.model.Exercicio;
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
public class ExercicioDAOImpl implements GenericDAO{
      private Connection conn;   
    
   public ExercicioDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    @Override
    public Boolean cadastrar(Object object) {
        
        Exercicio exercicio = (Exercicio) object;
        PreparedStatement stmt = null;
        String sql = "insert into exercicio(nome_exercicio,foto_exercicio,id_academia) values(?,?,?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, exercicio.getNomeExercicio());
            stmt.setBinaryStream(2, exercicio.getFotoExercicio(), exercicio.getFile());
            stmt.setInt(3, exercicio.getAcademia().getIdAcademia());
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar Exercicio! Erro: " + ex.getMessage());
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
          List<Object> exercicios = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from exercicio";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Exercicio exercicio = new Exercicio();
                exercicio.setIdExercicio(rs.getInt("id_exercicio"));
                exercicio.setNomeExercicio(rs.getString("nome_exercicio"));
                exercicios.add(exercicio);
                
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar exercicios! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return exercicios;
    }
    
    public List<Object> listarA(int idObject) {
          List<Object> exercicios = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from exercicio where id_academia = ? or id_academia = 1 ";

        try {
              
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Exercicio exercicio = new Exercicio();
                exercicio.setIdExercicio(rs.getInt("id_exercicio"));
                exercicio.setNomeExercicio(rs.getString("nome_exercicio"));
                Academia academia = new Academia();
                academia.setIdAcademia(rs.getInt("id_academia"));
                exercicio.setAcademia(academia);
                exercicios.add(exercicio);
                
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar exercicios! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return exercicios;
    }

    @Override
    public Boolean excluir(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "delete from exercicio WHERE id_exercicio = ?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao Excluir Exercicio!  Erro: " + ex.getMessage());
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
        Exercicio exercicio = null;
        String sql = "select * from exercicio where id_exercicio = ?";

        try {
              
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                exercicio = new Exercicio();
                exercicio.setIdExercicio(rs.getInt("id_exercicio"));
                exercicio.setNomeExercicio(rs.getString("nome_exercicio"));
                Academia academia = new Academia();
                academia.setIdAcademia(rs.getInt("id_academia"));
                exercicio.setAcademia(academia);
               
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar exercicios! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return exercicio;
    }
    

    @Override
    public Boolean alterar(Object object) {
        Exercicio exercicio = (Exercicio) object;
        PreparedStatement stmt = null;
        String sql = "update exercicio set nome_exercicio=?,foto_exercicio=?,id_academia=? where id_exercicio=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, exercicio.getNomeExercicio());
            stmt.setBinaryStream(2, exercicio.getFotoExercicio(), exercicio.getFile());
            stmt.setInt(3, exercicio.getAcademia().getIdAcademia());
            stmt.setInt(4,exercicio.getIdExercicio());
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao Alterar Exercicio! Erro: " + ex.getMessage());
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
    
    public Exercicio getFile(int idExercicio){
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Exercicio exercicio = null;
        
        String sql = "select foto_exercicio from exercicio where id_exercicio = ?;";
        
        try{
            
            stmt = conn.prepareStatement(sql);
             stmt.setInt(1,idExercicio);
            rs = stmt.executeQuery();
            while(rs.next()){
                exercicio = new Exercicio();                                
                exercicio.setFotoExercicio(rs.getBinaryStream("foto_exercicio"));
            }                                  
                
            
        } catch(SQLException ex){	
            System.out.println("Problemas na DAO ao baixar aquivo do Exercicio! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
        
        return exercicio;
        
    }
    
     public Integer pegarId(String idObject) {
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer idExercicio = null;

        String sql = "select id_exercicio from exercicio where nome_exercicio = ?";
                
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                idExercicio = rs.getInt("id_exercicio");
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao pegar id! Erro: " + ex.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
            }
        }
        return idExercicio;
        
    }
}
