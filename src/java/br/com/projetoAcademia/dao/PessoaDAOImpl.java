/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.dao;

import br.com.projetoAcademia.model.Academia;
import br.com.projetoAcademia.model.Pessoa;
import br.com.projetoAcademia.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ERICMASSAITIUEMURA
 */
public class PessoaDAOImpl implements GenericDAO{
     private Connection conn;

    public PessoaDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    
    public Integer cadastrarP(Pessoa pessoa) {
        Integer idPessoa = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        String sql = "insert into pessoa(nome_pessoa,telefone_pessoa,login_pessoa,senha_pessoa,tipo_pessoa) values(?,?,?,md5(?),?) returning id_pessoa;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNomePessoa());
            stmt.setString(2, pessoa.getTelefonePessoa());
            stmt.setString(3, pessoa.getLoginPessoa());
            stmt.setString(4, pessoa.getSenhaPessoa());
            stmt.setString(5, pessoa.getTipoPessoa());
            rs = stmt.executeQuery();
            if (rs.next()) {
                idPessoa = rs.getInt("id_pessoa");
            }
        } catch (Exception ex) {
            System.out.println("Problemas ao Cadastrar Pessoa ! Erro: " + ex.getMessage());
            ex.printStackTrace();
           
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
            
        }
        return idPessoa;
    }
    
    public Integer alterarU(Pessoa pessoa) {
        PreparedStatement stmt = null;
        String sql = "update pessoa set nome_pessoa=?, telefone_pessoa=?, login_pessoa=?, senha_pessoa=md5(?), tipo_pessoa=? where id_pessoa =?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNomePessoa());
            stmt.setString(2, pessoa.getTelefonePessoa());
            stmt.setString(3, pessoa.getLoginPessoa());
            stmt.setString(4, pessoa.getSenhaPessoa());
            stmt.setString(5, pessoa.getTipoPessoa());
            stmt.setInt(6, pessoa.getIdPessoa());
            stmt.execute();
           
        } catch (Exception ex) {
            System.out.println("Problemas ao Alterar Pessoa ! Erro: " + ex.getMessage());
            ex.printStackTrace();
           
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
            
        }
        return pessoa.getIdPessoa();


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
    

    @Override
    public Boolean cadastrar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Pessoa logarPessoa(String login, String senha) throws SQLException {

        Pessoa pessoa = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from pessoa where login_pessoa=? and senha_pessoa = md5(?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            if (rs.next()) {
                pessoa = new Pessoa();
                pessoa.setIdPessoa(rs.getInt("id_pessoa"));
                pessoa.setLoginPessoa(rs.getString("login_pessoa"));
                pessoa.setNomePessoa(rs.getString("nome_pessoa"));
                pessoa.setTipoPessoa(rs.getString("tipo_pessoa"));
                pessoa.setTelefonePessoa(rs.getString("telefone_pessoa"));
                
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao Logar ! Erro:" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro:" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return pessoa;
    }
    
}
