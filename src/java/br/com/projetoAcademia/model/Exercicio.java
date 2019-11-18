/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.model;

import java.io.InputStream;

/**
 *
 * @author ERICMASSAITIUEMURA
 */
public class Exercicio {
    private Integer idExercicio;
    private String nomeExercicio;
    private Integer File;
    private InputStream fotoExercicio;

    public Integer getIdExercicio() {
        return idExercicio;
    }

    public void setIdExercicio(Integer idExercicio) {
        this.idExercicio = idExercicio;
    }

    public String getNomeExercicio() {
        return nomeExercicio;
    }

    public void setNomeExercicio(String nomeExercicio) {
        this.nomeExercicio = nomeExercicio;
    }

    public Integer getFile() {
        return File;
    }

    public void setFile(Integer File) {
        this.File = File;
    }

    public InputStream getFotoExercicio() {
        return fotoExercicio;
    }

    public void setFotoExercicio(InputStream fotoExercicio) {
        this.fotoExercicio = fotoExercicio;
    }
    
}
