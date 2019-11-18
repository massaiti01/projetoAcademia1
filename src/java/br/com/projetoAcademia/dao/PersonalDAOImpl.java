/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.dao;

import br.com.projetoAcademia.model.Academia;
import br.com.projetoAcademia.model.Personal;
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
public class PersonalDAOImpl implements GenericDAO{
     private Connection conn;

    public PersonalDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Personal personal = (Personal) object;
        PreparedStatement stmt = null;
        String sql = "insert into personal(cref_personal,id_pessoa,id_academia) values(?,?,?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, personal.getCrefPersonal());
            stmt.setInt(2, new PessoaDAOImpl().cadastrarP(personal));
            stmt.setInt(3, personal.getAcademia().getIdPessoa());
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar Personal! Erro: " + ex.getMessage());
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
        
          List<Object> personais = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from personal p inner join pessoa pe on pe.id_pessoa = p.id_pessoa";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Personal personal = new Personal();
                personal.setIdPersonal(rs.getInt("id_personal"));
                personal.setIdPessoa(rs.getInt("id_pessoa"));
                personal.setNomePessoa(rs.getString("nome_pessoa"));
                personal.setTipoPessoa(rs.getString("tipo_pessoa"));
                personal.setTelefonePessoa(rs.getString("telefone_pessoa"));
                personal.setLoginPessoa(rs.getString("login_pessoa"));
                personal.setSenhaPessoa(rs.getString("senha_pessoa"));
                personal.setCrefPersonal(rs.getString("cref_personal"));
                Academia academia = new Academia();
                academia.setIdPessoa(rs.getInt("id_academia"));
                personal.setAcademia(academia);
                personais.add(personal);
                
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
        return personais;
    }

    @Override
    public Boolean excluir(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object carregar(int idObject) {
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Personal personal = null;

        String sql = "select * from personal p inner join pessoa pe on pe.id_pessoa = p.id_pessoa where pe.id_pessoa = ?";
                
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                personal = new Personal();
                personal.setIdPersonal(rs.getInt("id_personal"));
                personal.setIdPessoa(rs.getInt("id_pessoa"));
                personal.setNomePessoa(rs.getString("nome_pessoa"));
                personal.setTipoPessoa(rs.getString("tipo_pessoa"));
                personal.setTelefonePessoa(rs.getString("telefone_pessoa"));
                personal.setLoginPessoa(rs.getString("login_pessoa"));
                personal.setSenhaPessoa(rs.getString("senha_pessoa"));
                personal.setCrefPersonal(rs.getString("cref_personal"));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar Personal! Erro: " + ex.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
            }
        }
        return personal;
    }

    @Override
    public Boolean alterar(Object object) {
        Personal personal = (Personal) object;
        PreparedStatement stmt = null;
        String sql = "update personal set cref_personal=? where id_pessoa=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, personal.getCrefPersonal());
            stmt.setInt(2, new PessoaDAOImpl().alterarU(personal));
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao alterar Personal! Erro: " + ex.getMessage());
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
