/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.dao;

import br.com.projetoAcademia.model.Aluno;
import br.com.projetoAcademia.model.Bioimpedancia;
import br.com.projetoAcademia.model.Personal;
import br.com.projetoAcademia.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ERICMASSAITIUEMURA
 */
public class BioimpedanciaDAOImpl implements GenericDAO{
    private Connection conn;

    public BioimpedanciaDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
    
        Bioimpedancia bio = (Bioimpedancia) object;
        PreparedStatement stmt = null;
        String sql = "insert into bioimpedancia(tipo,p_gordura,indice_conicidade,indice_ponderal,imc,peso_gordura,massa_magra,peso_osseo,peso_residual,id_aluno,id_personal,data_bio,peso_muscular) values(?,?,?,?,?,?,?,?,?,?,?,?,?);";

        try {
             java.util.Date dataUtil = new java.util.Date();
            dataUtil = bio.getData();
  java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, bio.getTipo());
            stmt.setDouble(2, bio.getGorduraDobras());
            stmt.setDouble(3, bio.getIndiceConicidade());
            stmt.setDouble(4, bio.getIndicePonderal());
            stmt.setDouble(5, bio.getImc());
            stmt.setDouble(6, bio.getPesodeGorduraDobras());
            stmt.setDouble(7, bio.getMassaMagraDobras());
            stmt.setDouble(8, bio.getPesoOsseoDobras());
            stmt.setDouble(9, bio.getPesoResidualDobras());
            stmt.setInt(10,bio.getAluno().getIdAluno());
            stmt.setInt(11,bio.getPersonal().getIdPersonal());
            stmt.setDate(12,  dataSql);
            stmt.setDouble(13, bio.getPesoMuscularDobras());
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

     public List<Object> listarA(int idObject) {
        List<Object> bios = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select b.id_bioimpedancia, round(b.peso_muscular,4) as peso_convertido,b.id_aluno,b.id_personal,"
                + "pe.nome_pessoa,round(b.imc,4) as imc_convertido,"
                + "round(b.indice_conicidade,2) as indice_c_convertido,round(b.indice_ponderal,4) as indice_p_convertido,"
                + "round(b.p_gordura,4) as p_gordura_convertido,round(b.massa_magra,4) as massa_magra_convertido,"
                + "round(b.peso_osseo,4) as peso_osseo_convertido,round(b.peso_residual,4) as peso_residual_convertido,"
                + "round(b.peso_gordura,4) as peso_gordura_convertido,b.tipo,b.data_bio"
                + " from bioimpedancia b "
                + " inner join personal p on p.id_personal = b.id_personal inner join pessoa pe on pe.id_pessoa = p.id_pessoa"
                + " where b.id_aluno = ? order by id_bioimpedancia ";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Bioimpedancia bio = new Bioimpedancia();
                bio.setIdBioimpedancia(rs.getInt("id_bioimpedancia"));
                Aluno aluno = new Aluno();
                aluno.setIdAluno(rs.getInt("id_aluno"));
                bio.setAluno(aluno);
                Personal personal = new Personal();
                personal.setIdPersonal(rs.getInt("id_personal"));
                personal.setNomePessoa(rs.getString("nome_pessoa"));
                bio.setPersonal(personal);
                bio.setImc(rs.getDouble("imc_convertido"));
                bio.setIndiceConicidade(rs.getDouble("indice_c_convertido"));
                bio.setIndicePonderal(rs.getDouble("indice_p_convertido"));
                bio.setGorduraDobras(rs.getDouble("p_gordura_convertido"));
                bio.setMassaMagraDobras(rs.getDouble("massa_magra_convertido"));
                bio.setPesoOsseoDobras(rs.getDouble("peso_osseo_convertido"));
                bio.setPesoResidualDobras(rs.getDouble("peso_residual_convertido"));
                bio.setPesodeGorduraDobras(rs.getDouble("peso_gordura_convertido"));
                bio.setPesoMuscularDobras(rs.getDouble("peso_convertido"));
                bio.setTipo(rs.getString("tipo"));
                bio.setData(rs.getDate("data_bio"));
                bios.add(bio);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar bioimpedancia! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return bios ;
    }
    
    @Override
    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean excluir(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "delete from bioimpedancia WHERE id_bioimpedancia = ?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao Excluir Bioimpedancia!  Erro: " + ex.getMessage());
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
