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
public class ExercicioTreino{
 private Integer idExercicioTreino;
 private String descricaoExercicioTreino;
 private GrupoMuscular grupoMuscular;
 private Exercicio exercicio;
 private Aparelho aparelho;
 private Treino treino;
 private Integer seriesTreino;
 private Integer cargaTreino;
 private Integer repeticoesTreino;

    public Integer getIdExercicioTreino() {
        return idExercicioTreino;
    }

    public void setIdExercicioTreino(Integer idExercicioTreino) {
        this.idExercicioTreino = idExercicioTreino;
    }

    public String getDescricaoExercicioTreino() {
        return descricaoExercicioTreino;
    }

    public void setDescricaoExercicioTreino(String descricaoExercicioTreino) {
        this.descricaoExercicioTreino = descricaoExercicioTreino;
    }

    public GrupoMuscular getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(GrupoMuscular grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    public Aparelho getAparelho() {
        return aparelho;
    }

    public void setAparelho(Aparelho aparelho) {
        this.aparelho = aparelho;
    }

    public Treino getTreino() {
        return treino;
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }

    public Integer getSeriesTreino() {
        return seriesTreino;
    }

    public void setSeriesTreino(Integer seriesTreino) {
        this.seriesTreino = seriesTreino;
    }

    public Integer getCargaTreino() {
        return cargaTreino;
    }

    public void setCargaTreino(Integer cargaTreino) {
        this.cargaTreino = cargaTreino;
    }

    public Integer getRepeticoesTreino() {
        return repeticoesTreino;
    }

    public void setRepeticoesTreino(Integer repeticoesTreino) {
        this.repeticoesTreino = repeticoesTreino;
    }
 
 
}
