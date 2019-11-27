/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.dao;

import br.com.projetoAcademia.model.Aparelho;
import br.com.projetoAcademia.model.Exercicio;
import br.com.projetoAcademia.model.ExercicioTreino;
import br.com.projetoAcademia.model.GrupoMuscular;
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
public class ExercicioTreinoDAOImpl implements GenericDAO{
  private Connection conn;   
    
   public ExercicioTreinoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
   
    @Override
    public Boolean cadastrar(Object object) {
        ExercicioTreino exerciciot = (ExercicioTreino) object;
        PreparedStatement stmt = null;
        String sql = "insert into exerciciotreino(descricao_exercicio_treino,carga_treino,series_treino,repeticoes_treino,id_aparelho,id_exercicio,id_grupo_muscular,id_treino) values(?,?,?,?,?,?,?,?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, exerciciot.getDescricaoExercicioTreino());
            stmt.setInt(2,exerciciot.getCargaTreino());
            stmt.setInt(3,exerciciot.getSeriesTreino());
            stmt.setInt(4,exerciciot.getRepeticoesTreino());
            stmt.setInt(5, exerciciot.getAparelho().getIdAparelho());
            stmt.setInt(6, exerciciot.getExercicio().getIdExercicio());
            stmt.setInt(7, exerciciot.getGrupoMuscular().getIdGrupoMuscular());
            stmt.setInt(8, exerciciot.getTreino().getIdTreino());
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao Adicionar Exercicio ao Treino! Erro: " + ex.getMessage());
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
        List<Object> ets = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from exerciciotreino e inner join treino t on e.id_treino = t.id_treino inner join aparelho a on a.id_aparelho = e.id_aparelho "
                + "inner join exercicio ex on e.id_exercicio = ex.id_exercicio inner join grupomuscular gm on gm.id_grupo_muscular = e.id_grupo_muscular ";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                ExercicioTreino et = new ExercicioTreino();
                Aparelho aparelho = new Aparelho();
                Exercicio exercicio = new Exercicio();
                GrupoMuscular gm = new GrupoMuscular();
                Treino treino = new Treino();
                et.setIdExercicioTreino(rs.getInt("id_exercicio_treino"));
                et.setDescricaoExercicioTreino(rs.getString("descricao_exercicio_treino"));
                et.setRepeticoesTreino(rs.getInt("repeticoes_treino"));
                et.setCargaTreino(rs.getInt("carga_treino"));
                et.setSeriesTreino(rs.getInt("series_treino"));
                aparelho.setIdAparelho(rs.getInt("id_aparelho"));
                aparelho.setNomeAparelho(rs.getString("nome_aparelho"));
                et.setAparelho(aparelho);
                exercicio.setIdExercicio(rs.getInt("id_exercicio"));
                exercicio.setNomeExercicio(rs.getString("nome_exercicio"));
                et.setExercicio(exercicio);
                gm.setIdGrupoMuscular(rs.getInt("id_grupo_muscular"));
                gm.setNomeGrupoMuscular(rs.getString("nome_grupo_muscular"));
                et.setGrupoMuscular(gm);
                treino.setIdTreino(rs.getInt("id_treino"));
                treino.setNomeTreino(rs.getString("nome_treino"));
                et.setTreino(treino);
                ets.add(et);
                
            }
        } catch (Exception ex) {
            System.out.println("Problemas ao listar treinos! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return ets;
    }

    @Override
    public Boolean excluir(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "delete from exerciciotreino WHERE id_exercicio_treino = ?;";

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
