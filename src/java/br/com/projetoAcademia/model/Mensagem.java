/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.model;

import java.util.Date;

/**
 *
 * @author Eric
 */
public class Mensagem {
    private Integer idMensagem;
    private Pessoa Remetente;
    private Ticket ticket;
    private String Mensagem;
    private Date Data;

    public Integer getIdMensagem() {
        return idMensagem;
    }

    public void setIdMensagem(Integer idMensagem) {
        this.idMensagem = idMensagem;
    }

    public Pessoa getRemetente() {
        return Remetente;
    }

    public void setRemetente(Pessoa Remetente) {
        this.Remetente = Remetente;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getMensagem() {
        return Mensagem;
    }

    public void setMensagem(String Mensagem) {
        this.Mensagem = Mensagem;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }
    

}
