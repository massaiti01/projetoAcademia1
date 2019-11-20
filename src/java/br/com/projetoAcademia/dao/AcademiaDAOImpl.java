/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.dao;

import br.com.projetoAcademia.model.Academia;
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
public class AcademiaDAOImpl implements GenericDAO{
 private Connection conn;

    public AcademiaDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    @Override
    public Boolean cadastrar(Object object) {
       
        Academia academia = (Academia) object;
        PreparedStatement stmt = null;
        String sql = "insert into academia(cnpj_academia,status_academia,id_pessoa) values(?,'I',?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, academia.getCnpjAcademia());
            stmt.setInt(2, new PessoaDAOImpl().cadastrarP(academia));
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar Academia! Erro: " + ex.getMessage());
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
        List<Object> academias = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from academia a inner join pessoa p on p.id_pessoa = a.id_pessoa";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Academia academia = new Academia();
                academia.setIdAcademia(rs.getInt("id_academia"));
                academia.setIdPessoa(rs.getInt("id_pessoa"));
                academia.setNomePessoa(rs.getString("nome_pessoa"));
                academia.setTipoPessoa(rs.getString("tipo_pessoa"));
                academia.setTelefonePessoa(rs.getString("telefone_pessoa"));
                academia.setLoginPessoa(rs.getString("login_pessoa"));
                academia.setSenhaPessoa(rs.getString("senha_pessoa"));
                academia.setCnpjAcademia(rs.getString("cnpj_academia"));
                academia.setStatusAcademia(rs.getString("status_academia"));
                academias.add(academia);
                
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar academia! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return academias;
    }

    @Override
    public Boolean excluir(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object carregar(int idObject) {
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Academia academia = null;

        String sql = "select * from academia a inner join pessoa p on p.id_pessoa = a.id_pessoa where p.id_pessoa = ?";
                
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                academia = new Academia();
                academia.setIdAcademia(rs.getInt("id_academia"));
                academia.setCnpjAcademia(rs.getString("cnpj_academia"));
                academia.setNomePessoa(rs.getString("nome_pessoa"));
                academia.setStatusAcademia(rs.getString("status_academia"));
                academia.setTipoPessoa(rs.getString("tipo_pessoa"));
                academia.setTelefonePessoa(rs.getString("telefone_pessoa"));
                academia.setLoginPessoa(rs.getString("login_pessoa"));
                academia.setSenhaPessoa(rs.getString("senha_pessoa"));
                academia.setIdAcademia(rs.getInt("id_pessoa"));
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
        return academia;
    }
    
     public Integer pegarId(int idObject) {
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer idAcademia = null;

        String sql = "select id_academia from academia a inner join pessoa p on p.id_pessoa = a.id_pessoa where p.id_pessoa = ?";
                
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                idAcademia = rs.getInt("id_academia");
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
        return idAcademia;
        
    }

    @Override
    public Boolean alterar(Object object) {
        Academia academia = (Academia) object;
        PreparedStatement stmt = null;
        String sql = "update academia set cnpj_academia=?,status_academia=? where id_pessoa=? values(?,?,?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, academia.getCnpjAcademia());
            stmt.setString(2, academia.getStatusAcademia());
            stmt.setInt(3, new PessoaDAOImpl().alterarU(academia));
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao alterar Academia! Erro: " + ex.getMessage());
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
    
}
