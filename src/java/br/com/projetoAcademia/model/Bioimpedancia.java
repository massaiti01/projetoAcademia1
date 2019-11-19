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
public class Bioimpedancia {
     private Integer idBioimpedancia;
    private Date data;
    private Aluno aluno;
    private Personal personal;
    private Integer idade;
    private Double altura;
    private Double peso;
    private Double triciptal;
    private Double peitoral;
    private Double subescapular;
    private Double auxiliarMedio;
    private Double suprailiaca;
    private Double abdominal;
    private Double coxa;
    private Double biestiloide;
    private Double bicondiliano;        
    private Double indicePonderal;

    public Integer getIdBioimpedancia() {
        return idBioimpedancia;
    }

    public void setIdBioimpedancia(Integer idBioimpedancia) {
        this.idBioimpedancia = idBioimpedancia;
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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getTriciptal() {
        return triciptal;
    }

    public void setTriciptal(Double triciptal) {
        this.triciptal = triciptal;
    }

    public Double getPeitoral() {
        return peitoral;
    }

    public void setPeitoral(Double peitoral) {
        this.peitoral = peitoral;
    }

    public Double getSubescapular() {
        return subescapular;
    }

    public void setSubescapular(Double subescapular) {
        this.subescapular = subescapular;
    }

    public Double getAuxiliarMedio() {
        return auxiliarMedio;
    }

    public void setAuxiliarMedio(Double auxiliarMedio) {
        this.auxiliarMedio = auxiliarMedio;
    }

    public Double getSuprailiaca() {
        return suprailiaca;
    }

    public void setSuprailiaca(Double suprailiaca) {
        this.suprailiaca = suprailiaca;
    }

    public Double getAbdominal() {
        return abdominal;
    }

    public void setAbdominal(Double abdominal) {
        this.abdominal = abdominal;
    }

    public Double getCoxa() {
        return coxa;
    }

    public void setCoxa(Double coxa) {
        this.coxa = coxa;
    }

    public Double getBiestiloide() {
        return biestiloide;
    }

    public void setBiestiloide(Double biestiloide) {
        this.biestiloide = biestiloide;
    }

    public Double getBicondiliano() {
        return bicondiliano;
    }

    public void setBicondiliano(Double bicondiliano) {
        this.bicondiliano = bicondiliano;
    }

    public Double getIndicePonderal() {
        return indicePonderal;
    }

    public void setIndicePonderal(Double indicePonderal) {
        this.indicePonderal = indicePonderal;
    }
    
    
    
}
