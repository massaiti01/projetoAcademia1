/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.model;

import java.util.Date;

/**
 *
 * @author ERICMASSAITIUEMURA
 */
public class Acompanhamento {
    private Integer idAcompanhamento;
    private Double Ombro;
    private Double peitoral;
    private Double bracoD;
    private Double bracoE;
    private Double anteBracoD;
    private Double anteBracoE;
    private Double cintura;
    private Double quadril;
    private Double gluteo;
    private Double pernaD;
    private Double pernaE;
    private Double panturrilhaD;
    private Double panturrilhaE;
    private Date data = new Date();
    private Aluno aluno;
    private Personal personal;

    public Integer getIdAcompanhamento() {
        return idAcompanhamento;
    }

    public void setIdAcompanhamento(Integer idAcompanhamento) {
        this.idAcompanhamento = idAcompanhamento;
    }

    public Double getPernaD() {
        return pernaD;
    }

    public void setPernaD(Double pernaD) {
        this.pernaD = pernaD;
    }

    public Double getPernaE() {
        return pernaE;
    }

    public void setPernaE(Double pernaE) {
        this.pernaE = pernaE;
    }

    public Double getPanturrilhaD() {
        return panturrilhaD;
    }

    public void setPanturrilhaD(Double panturrilhaD) {
        this.panturrilhaD = panturrilhaD;
    }

    public Double getPanturrilhaE() {
        return panturrilhaE;
    }

    public void setPanturrilhaE(Double panturrilhaE) {
        this.panturrilhaE = panturrilhaE;
    }

    public Double getCintura() {
        return cintura;
    }

    public void setCintura(Double cintura) {
        this.cintura = cintura;
    }

    public Double getQuadril() {
        return quadril;
    }

    public void setQuadril(Double quadril) {
        this.quadril = quadril;
    }

    public Double getGluteo() {
        return gluteo;
    }

    public void setGluteo(Double gluteo) {
        this.gluteo = gluteo;
    }

    public Double getPeitoral() {
        return peitoral;
    }

    public void setPeitoral(Double peitoral) {
        this.peitoral = peitoral;
    }

    public Double getBracoD() {
        return bracoD;
    }

    public void setBracoD(Double bracoD) {
        this.bracoD = bracoD;
    }

    public Double getBracoE() {
        return bracoE;
    }

    public void setBracoE(Double bracoE) {
        this.bracoE = bracoE;
    }

    public Double getAnteBracoD() {
        return anteBracoD;
    }

    public void setAnteBracoD(Double anteBracoD) {
        this.anteBracoD = anteBracoD;
    }

    public Double getAnteBracoE() {
        return anteBracoE;
    }

    public void setAnteBracoE(Double anteBracoE) {
        this.anteBracoE = anteBracoE;
    }

    public Double getOmbro() {
        return Ombro;
    }

    public void setOmbro(Double Ombro) {
        this.Ombro = Ombro;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    
}
