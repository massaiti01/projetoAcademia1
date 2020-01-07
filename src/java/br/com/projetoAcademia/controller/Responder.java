/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.controller;

import br.com.projetoAcademia.dao.MensagemDAOImpl;
import br.com.projetoAcademia.model.Mensagem;
import br.com.projetoAcademia.model.Pessoa;
import br.com.projetoAcademia.model.Ticket;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eric
 */
@WebServlet(name = "Responder", urlPatterns = {"/Responder"})
public class Responder extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Mensagem mesagem = new Mensagem();
        Ticket ticket = new Ticket();
        Pessoa pessoa = new Pessoa();
        String mensagem = null;
        Date Datae = new Date(System.currentTimeMillis());
        pessoa.setIdPessoa(Integer.parseInt(request.getParameter("idPessoa")));
        mesagem.setRemetente(pessoa);
        mesagem.setData(Datae);
        mesagem.setMensagem(request.getParameter("mensagem"));
        ticket.setIdTicket(Integer.parseInt(request.getParameter("idTicket")));
        mesagem.setTicket(ticket);
        
        try (PrintWriter out = response.getWriter()) {
            MensagemDAOImpl dao1 = new MensagemDAOImpl();
          if(dao1.cadastrar(mesagem)) {
                    mensagem = "Ticket enviado com sucesso!";
                } else {
                    mensagem = "Problemas ao cadastrar Personal!";
                }
                 request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("CarregarTicket?idTicket="+request.getParameter("idTicket")).forward(request, response);
       
           
        }catch(Exception ex){
            System.out.println("Problemas ao salvar Personal! Erro:"+ex.getMessage());
            ex.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
