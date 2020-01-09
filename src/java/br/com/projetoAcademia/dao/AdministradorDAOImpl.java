/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.dao;

import br.com.projetoAcademia.model.Administrador;
import br.com.projetoAcademia.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Eric
 */
public class AdministradorDAOImpl implements GenericDAO{
  private Connection conn;

    public AdministradorDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
   public Integer pegarId(int idObject) {
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer idAdministrador = null;

        String sql = "select id_administrador from administrador where id_pessoa = ?";
                
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                idAdministrador = rs.getInt("id_administrador");
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
        return idAdministrador;
        
    }
    
    @Override
    public Boolean cadastrar(Object object) {
        
        Administrador adm = (Administrador) object;
        PreparedStatement stmt = null;
        String sql = "insert into administrador(telefone_administrador,email_administrador,id_pessoa) values(?,?,?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, adm.getTelefoneAdministrador());
            stmt.setString(2, adm.getEmailAdministrador());
            stmt.setInt(3, new PessoaDAOImpl().cadastrarP(adm));
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar Administrador! Erro: " + ex.getMessage());
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
