/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.dao;

import br.com.projetoAcademia.model.Academia;
import br.com.projetoAcademia.model.Aluno;
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
public class AlunoDAOImpl implements GenericDAO{
   private Connection conn;

    public AlunoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    
    @Override
    public Boolean cadastrar(Object object) {
        Aluno aluno = (Aluno) object;
        PreparedStatement stmt = null;
        String sql = "insert into aluno(telefone_emergencia,id_academia,cpf_aluno,id_pessoa) values(?,?,?,?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getTelefoneEmergencia());
            stmt.setInt(2, aluno.getAcademia().getIdAcademia());
            stmt.setString(3, aluno.getCpfAluno());
            stmt.setInt(4, new PessoaDAOImpl().cadastrarP(aluno));
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar Aluno! Erro: " + ex.getMessage());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public List<Object> listarA(int idObject) {
        List<Object> alunos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from aluno a inner join pessoa p on p.id_pessoa = a.id_pessoa where id_academia = ?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setIdAluno(rs.getInt("id_aluno"));
                aluno.setIdPessoa(rs.getInt("id_pessoa"));
                aluno.setNomePessoa(rs.getString("nome_pessoa"));
                aluno.setCpfAluno(rs.getString("cpf_aluno"));
                aluno.setTipoPessoa(rs.getString("tipo_pessoa"));
                aluno.setTelefonePessoa(rs.getString("telefone_pessoa"));
                aluno.setLoginPessoa(rs.getString("login_pessoa"));
                aluno.setSenhaPessoa(rs.getString("senha_pessoa"));
                aluno.setTelefoneEmergencia(rs.getString("telefone_emergencia"));
                Academia academia = new Academia();
                academia.setIdPessoa(rs.getInt("id_academia"));
                aluno.setAcademia(academia);
                alunos.add(aluno);
                
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
        return alunos;
    }

    @Override
    public Boolean excluir(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object carregar(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Aluno aluno = null;

        String sql = "select * from aluno a inner join pessoa p on p.id_pessoa = a.id_pessoa where p.id_pessoa = ?";
                
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                aluno = new Aluno();
                Academia academia = new Academia();
                aluno.setIdAluno(rs.getInt("id_aluno"));
                aluno.setIdPessoa(rs.getInt("id_pessoa"));
                aluno.setNomePessoa(rs.getString("nome_pessoa"));
                aluno.setCpfAluno(rs.getString("cpf_aluno"));
                aluno.setTipoPessoa(rs.getString("tipo_pessoa"));
                aluno.setTelefonePessoa(rs.getString("telefone_pessoa"));
                aluno.setLoginPessoa(rs.getString("login_pessoa"));
                aluno.setSenhaPessoa(rs.getString("senha_pessoa"));
                academia.setIdAcademia(rs.getInt("id_academia"));
                aluno.setAcademia(academia);
                aluno.setTelefoneEmergencia(rs.getString("telefone_emergencia"));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar Aluno! Erro: " + ex.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
            }
        }
        return aluno;
    }

    @Override
    public Boolean alterar(Object object) {
        Aluno aluno = (Aluno) object;
        PreparedStatement stmt = null;
        String sql = "update aluno set telefone_emergencia=? where id_pessoa=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getTelefoneEmergencia());
            stmt.setInt(2, new PessoaDAOImpl().alterarU(aluno));
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao alterar Aluno! Erro: " + ex.getMessage());
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
