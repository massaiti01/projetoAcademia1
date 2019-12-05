/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.model;

/**
 *
 * @author ERICMASSAITIUEMURA
 */
public class Administrador extends Pessoa{
    private Integer idAdministrador;
    private String emailAdministrador;
    private String telefoneAdministrador;

    public Integer getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getEmailAdministrador() {
        return emailAdministrador;
    }

    public void setEmailAdministrador(String emailAdministrador) {
        this.emailAdministrador = emailAdministrador;
    }

    public String getTelefoneAdministrador() {
        return telefoneAdministrador;
    }

    public void setTelefoneAdministrador(String telefoneAdministrador) {
        this.telefoneAdministrador = telefoneAdministrador;
    }
    
    
}
