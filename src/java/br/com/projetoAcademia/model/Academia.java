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
public class Academia extends Pessoa{
    private Integer idAcademia;
    private String cnpjAcademia;
    private String statusAcademia;

    public Integer getIdAcademia() {
        return idAcademia;
    }

    public void setIdAcademia(Integer idAcademia) {
        this.idAcademia = idAcademia;
    }

    public String getCnpjAcademia() {
        return cnpjAcademia;
    }

    public void setCnpjAcademia(String cnpjAcademia) {
        this.cnpjAcademia = cnpjAcademia;
    }

    public String getStatusAcademia() {
        return statusAcademia;
    }

    public void setStatusAcademia(String statusAcademia) {
        this.statusAcademia = statusAcademia;
    }

    
}
