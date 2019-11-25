/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.dao;

import br.com.projetoAcademia.model.Acompanhamento;
import br.com.projetoAcademia.model.Aluno;
import br.com.projetoAcademia.model.Personal;
import br.com.projetoAcademia.util.ConnectionFactory;
import br.com.projetoAcademia.util.Conversoes;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ERICMASSAITIUEMURA
 */
public class AcompanhamentoDAOImpl implements GenericDAO {
     private Connection conn;

    public AcompanhamentoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Acompanhamento medidas = (Acompanhamento) object;
        PreparedStatement stmt = null;
        String sql = "insert into acompanhamento(id_aluno,id_personal,data_acompanhamento,ombro_aluno,peitoral_aluno,"
                + "braco_d_aluno,braco_e_aluno,antebraco_d_aluno,antebraco_e_aluno,cintura_aluno,gluteo_aluno,quadril_aluno,"
                + "perna_d_aluno,perna_e_aluno,panturrilha_d_aluno,panturrilha_e_aluno) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

        try {
             java.util.Date dataUtil = new java.util.Date();
            dataUtil = medidas.getData();
  java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, medidas.getAluno().getIdPessoa());
            stmt.setInt(2, medidas.getPersonal().getIdPessoa());
            stmt.setDate(3, dataSql);
            stmt.setDouble(4,medidas.getOmbro());
            stmt.setDouble(5,medidas.getPeitoral());
            stmt.setDouble(6,medidas.getBracoD());
            stmt.setDouble(7,medidas.getBracoE());
            stmt.setDouble(8,medidas.getAnteBracoD());
            stmt.setDouble(9,medidas.getAnteBracoE());
            stmt.setDouble(10,medidas.getCintura());
            stmt.setDouble(11,medidas.getGluteo());
            stmt.setDouble(12,medidas.getQuadril());
            stmt.setDouble(13,medidas.getPernaD());
            stmt.setDouble(14,medidas.getPernaE());
            stmt.setDouble(15,medidas.getPanturrilhaD());
            stmt.setDouble(16,medidas.getPanturrilhaE());
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar medidas! Erro: " + ex.getMessage());
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

    @Override
    public List<Object> listar() {
        List<Object> medidas = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from acompanhamento order by data_acompanhamento";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Acompanhamento medida = new Acompanhamento();
                medida.setIdAcompanhamento(rs.getInt("id_acompanhamento"));
                Aluno aluno = new Aluno();
                aluno.setIdPessoa(rs.getInt("id_aluno"));
                medida.setAluno(aluno);
                Personal personal = new Personal();
                personal.setIdPessoa(rs.getInt("id_personal"));
                medida.setPersonal(personal);
                medida.setOmbro(rs.getDouble("ombro_aluno"));
                medida.setPeitoral(rs.getDouble("peitoral_aluno"));
                medida.setBracoD(rs.getDouble("braco_d_aluno"));
                medida.setBracoE(rs.getDouble("braco_E_aluno"));
                medida.setAnteBracoD(rs.getDouble("antebraco_d_aluno"));
                medida.setAnteBracoE(rs.getDouble("antebraco_e_aluno"));
                medida.setCintura(rs.getDouble("cintura_aluno"));
                medida.setGluteo(rs.getDouble("gluteo_aluno"));
                medida.setQuadril(rs.getDouble("quadril_aluno"));
                medida.setPernaD(rs.getDouble("perna_d_aluno"));
                medida.setPernaE(rs.getDouble("perna_e_aluno"));
                medida.setPanturrilhaD(rs.getDouble("panturrilha_d_aluno"));
                medida.setPanturrilhaE(rs.getDouble("panturrilha_e_aluno"));
                medida.setData(rs.getDate("data_medida"));
                medidas.add(medida);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar medidas! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return medidas;
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
