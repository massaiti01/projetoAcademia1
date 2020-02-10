/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.controller;

import br.com.projetoAcademia.dao.EmailDAOImpl;
import br.com.projetoAcademia.dao.PessoaDAOImpl;
import br.com.projetoAcademia.model.Pessoa;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eric
 */
@WebServlet(name = "RedefinirSenha", urlPatterns = {"/RedefinirSenha"})
public class RedefinirSenha extends HttpServlet {

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
        Random random = new Random();
        int numero = random.nextInt();
         String mensagem = null;
         
         String senha1 = ""+numero;
         Pessoa pessoa = new Pessoa();
         pessoa.setSenhaPessoa(senha1);
         pessoa.setEmailPessoa(request.getParameter("emailPessoa"));
         
         try (PrintWriter out = response.getWriter()) {
             PessoaDAOImpl daop = new PessoaDAOImpl();
             EmailDAOImpl daoe = new EmailDAOImpl();
                if (daop.redefinirSenha(pessoa)) {
                     System.out.println("Senha Redefinida com Sucesso");
                    if(daoe.EnviarSenha(pessoa)){
                        System.out.println("Senha Enviada com sucesso");
                    }else{
                        System.out.println("Falha ao Enviar o Email");
                    }
                    mensagem = "Senha Redefinida Verique Seu E-mail";
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("login/login.jsp").forward(request, response);
                } else {
                    mensagem = "Problemas ao Redefinir Sua senha!";
                     request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("login/login.jsp").forward(request, response);
            
           
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
