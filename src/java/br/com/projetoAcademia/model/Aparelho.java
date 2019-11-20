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
public class Aparelho {
    private Integer idAparelho;
    private String nomeAparelho;
    private Academia academia;

    public Academia getAcademia() {
        return academia;
    }

    public void setAcademia(Academia academia) {
        this.academia = academia;
    }

    public Integer getIdAparelho() {
        return idAparelho;
    }

    public void setIdAparelho(Integer idAparelho) {
        this.idAparelho = idAparelho;
    }

    public String getNomeAparelho() {
        return nomeAparelho;
    }

    public void setNomeAparelho(String nomeAparelho) {
        this.nomeAparelho = nomeAparelho;
    }
    
}
