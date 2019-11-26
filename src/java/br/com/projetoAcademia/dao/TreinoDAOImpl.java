/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.dao;

import br.com.projetoAcademia.model.Personal;
import br.com.projetoAcademia.model.Treino;
import br.com.projetoAcademia.util.ConnectionFactory;
import br.com.projetoAcademia.util.Conversoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ERICMASSAITIUEMURA
 */
public class TreinoDAOImpl implements GenericDAO{
     private Connection conn;

    public TreinoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public Integer cadastrarT(Object object) {
         Treino treino = (Treino) object;
        Integer idTreino = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        String sql = "insert into treino(nome_treino,data_treino,id_aluno,id_personal) values(?,?,?,?) returning id_treino;";
            
 
  
        try {
            java.util.Date dataUtil = new java.util.Date();
            dataUtil = Conversoes.converterData(treino.getDataTreino());
  java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, treino.getNomeTreino());
            stmt.setDate(2, dataSql );
            stmt.setInt(3, treino.getAluno().getIdAluno());
            stmt.setInt(4, treino.getPersonal().getIdPersonal());
            rs = stmt.executeQuery();
            if (rs.next()) {
                idTreino = rs.getInt("id_treino");
            }
        } catch (Exception ex) {
            System.out.println("Problemas ao Cadastrar Treino ! Erro: " + ex.getMessage());
            ex.printStackTrace();
           
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
            
        }
        return idTreino;
    }

 public List<Object> listarI(int idObject) {
        List<Object> treinos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select t.id_personal,* from treino t inner join personal p on t.id_personal = p.id_personal inner join pessoa pe on p.id_pessoa = pe.id_pessoa where t.id_aluno = ?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Treino treino = new Treino();
                treino.setIdTreino(rs.getInt("id_treino"));
                treino.setNomeTreino(rs.getString("nome_treino"));
                treino.setDataTreino(rs.getString("data_treino"));
                Personal personal = new Personal();
                personal.setNomePessoa(rs.getString("nome_pessoa"));
                personal.setIdPersonal(rs.getInt("id_personal"));
                treino.setPersonal(personal);
                treinos.add(treino);
                
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar animal! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return treinos;
}
 
    @Override
    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean excluir(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "delete from treino cascate WHERE id_treino = ?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao Excluir Grupo Muscular!  Erro: " + ex.getMessage());
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
       
        Treino treino = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select t.id_personal,* from treino t inner join personal p on t.id_personal = p.id_personal inner join pessoa pe on p.id_pessoa = pe.id_pessoa where t.id_aluno = ?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                treino = new Treino();
                treino.setIdTreino(rs.getInt("id_treino"));
                treino.setNomeTreino(rs.getString("nome_treino"));
                treino.setDataTreino(rs.getString("data_treino"));
                Personal personal = new Personal();
                personal.setNomePessoa(rs.getString("nome_pessoa"));
                personal.setIdPersonal(rs.getInt("id_personal"));
                treino.setPersonal(personal);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar animal! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
          return treino;
        }
    }

    @Override
    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
