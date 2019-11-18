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
public class Personal extends Pessoa{
    private Integer idPersonal;
    private String crefPersonal;
    private Academia academia;

    public Academia getAcademia() {
        return academia;
    }

    public void setAcademia(Academia academia) {
        this.academia = academia;
    }
    

    public Integer getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Integer idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getCrefPersonal() {
        return crefPersonal;
    }

    public void setCrefPersonal(String crefPersonal) {
        this.crefPersonal = crefPersonal;
    }
    
}
