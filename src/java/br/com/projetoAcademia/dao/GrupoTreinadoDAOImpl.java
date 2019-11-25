/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.dao;

import br.com.projetoAcademia.model.GrupoTreinado;
import br.com.projetoAcademia.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
