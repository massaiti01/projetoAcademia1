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
public class GrupoTreinado {
    
    private Integer idGrupoTreinado;
    private Treino treino;
    private GrupoMuscular grupoMuscular;

    public Integer getIdGrupoTreinado() {
        return idGrupoTreinado;
    }

    public void setIdGrupoTreinado(Integer idGrupoTreinado) {
        this.idGrupoTreinado = idGrupoTreinado;
    }

    public Treino getTreino() {
        return treino;
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }

    public GrupoMuscular getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(GrupoMuscular grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }
    
    
    
    
}
