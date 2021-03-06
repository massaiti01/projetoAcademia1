/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.controller;

import br.com.projetoAcademia.dao.PessoaDAOImpl;
import br.com.projetoAcademia.model.Pessoa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Eric
 */
@WebServlet(name = "AlterarSenha", urlPatterns = {"/AlterarSenha"})
public class AlterarSenha extends HttpServlet {

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
        String mensagem = null;
         Pessoa pessoa = new Pessoa();
          HttpSession session = request.getSession(true);
         pessoa = (Pessoa) session.getAttribute("pessoa");
         pessoa.setIdPessoa(pessoa.getIdPessoa());
         pessoa.setSenhaPessoa(request.getParameter("senha"));
         
         try (PrintWriter out = response.getWriter()) {
             PessoaDAOImpl daop = new PessoaDAOImpl();
                if (daop.alterarSenha(pessoa)) {
                     System.out.println("Senha Redefinida com Sucesso");
                                     mensagem = "Senha Alterada com Sucesso";
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("Redirect").forward(request, response);
                } else {
                    mensagem = "Problemas ao Alterar Sua senha!";
                     request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("Redirect").forward(request, response);
            
           
                }
            
        }catch(Exception ex){
            System.out.println("Problemas ao Alterar Senha! Erro:"+ex.getMessage());
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
