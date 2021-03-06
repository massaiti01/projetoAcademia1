/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.dao;

import br.com.projetoAcademia.model.GrupoMuscular;
import br.com.projetoAcademia.model.GrupoTreinado;
import br.com.projetoAcademia.model.Personal;
import br.com.projetoAcademia.model.Treino;
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
public class GrupoTreinadoDAOImpl implements GenericDAO{
         private Connection conn;   
    
   public GrupoTreinadoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        GrupoTreinado grupotreinado = (GrupoTreinado) object;
        PreparedStatement stmt = null;
        String sql = "insert into grupotreinado(id_treino,id_grupo_muscular) values(?,?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, grupotreinado.getTreino().getIdTreino());
            stmt.setInt(2, grupotreinado.getGrupoMuscular().getIdGrupoMuscular());
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar Grupo Treinado! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
            return true;
        }
    }

    @Override
    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Object> listarT(int idObject) {
        List<Object> gts = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select t.id_personal,* from grupotreinado gt inner join treino t on gt.id_treino = t.id_treino inner join personal p on p.id_personal = t.id_personal inner join pessoa pe on pe.id_pessoa = p.id_pessoa inner join grupomuscular gm on gt.id_grupo_muscular = gm.id_grupo_muscular where t.id_treino = ? ";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                GrupoTreinado gt = new GrupoTreinado();
                Treino treino = new Treino();
                GrupoMuscular gm = new GrupoMuscular();
                gt.setIdGrupoTreinado(rs.getInt("id_grupo_treinado"));
                gm.setIdGrupoMuscular(rs.getInt("id_grupo_muscular"));
                gm.setNomeGrupoMuscular(rs.getString("nome_grupo_muscular"));
                gt.setGrupoMuscular(gm);
                treino.setIdTreino(rs.getInt("id_treino"));
                treino.setNomeTreino(rs.getString("nome_treino"));
                treino.setDataTreino(rs.getString("data_treino"));
                Personal personal = new Personal();
                personal.setNomePessoa(rs.getString("nome_pessoa"));
                personal.setIdPersonal(rs.getInt("id_personal"));
                treino.setPersonal(personal);
                gt.setTreino(treino);
                gts.add(gt);
                
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
        return gts;
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
