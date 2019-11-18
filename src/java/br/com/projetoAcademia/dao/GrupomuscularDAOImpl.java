/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.dao;

import br.com.projetoAcademia.model.GrupoMuscular;
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
public class GrupomuscularDAOImpl implements GenericDAO{
 private Connection conn;

    public GrupomuscularDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    @Override
    public Boolean cadastrar(Object object) {
       
        GrupoMuscular grupomuscular = (GrupoMuscular) object;
        PreparedStatement stmt = null;
        String sql = "insert into grupomuscular(nome_grupo_muscular) values(?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, grupomuscular.getNomeGrupoMuscular());
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar Grupo Muscular! Erro: " + ex.getMessage());
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
        List<Object> grupomusculares = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from grupomuscular";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                GrupoMuscular grupomuscular = new GrupoMuscular();
                grupomuscular.setIdGrupoMuscular(rs.getInt("id_grupo_muscular"));
                grupomuscular.setNomeGrupoMuscular(rs.getString("nome_grupo_muscular"));
                grupomusculares.add(grupomuscular);
                
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Grupo Musculares! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return grupomusculares;
    }

    @Override
    public Boolean excluir(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object carregar(int idObject) {
       
        PreparedStatement stmt = null;
        ResultSet rs = null;
        GrupoMuscular grupomuscular = null;

        String sql = "select * from grupomuscular where id_grupo_muscular = ?";
                
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                grupomuscular = new GrupoMuscular();
                grupomuscular.setIdGrupoMuscular(rs.getInt("id_grupo_muscular"));
                grupomuscular.setNomeGrupoMuscular(rs.getString("nome_grupo_muscular"));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar Grupo Muscular! Erro: " + ex.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
            }
        }
        return grupomuscular;
    }

    @Override
    public Boolean alterar(Object object) {
        GrupoMuscular grupomuscular = (GrupoMuscular) object;
        PreparedStatement stmt = null;
        String sql = "update grupomuscular set nome_grupo_muscular = ? where id_grupo_muscular = ?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, grupomuscular.getNomeGrupoMuscular());
            stmt.setInt(2, grupomuscular.getIdGrupoMuscular());
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao Alterar Grupo Muscular! Erro: " + ex.getMessage());
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
