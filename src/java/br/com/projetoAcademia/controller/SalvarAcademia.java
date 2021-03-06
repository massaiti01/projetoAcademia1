/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.controller;

import br.com.projetoAcademia.dao.AcademiaDAOImpl;
import br.com.projetoAcademia.dao.EmailDAOImpl;
import br.com.projetoAcademia.dao.GenericDAO;
import br.com.projetoAcademia.model.Academia;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ERICMASSAITIUEMURA
 */
@WebServlet(name = "SalvarAcademia", urlPatterns = {"/SalvarAcademia"})
public class SalvarAcademia extends HttpServlet {

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
        Academia academia = new Academia();
        academia.setNomePessoa(request.getParameter("nomePessoa"));
        academia.setTelefonePessoa(request.getParameter("telefonePessoa"));
        academia.setLoginPessoa(request.getParameter("loginPessoa"));
        academia.setEmailPessoa(request.getParameter("emailPessoa"));
        academia.setSenhaPessoa(request.getParameter("senhaPessoa"));
        academia.setTipoPessoa("ACA");
        academia.setStatusAcademia("I");
        academia.setCnpjAcademia(request.getParameter("cnpjAcademia"));
        
        try (PrintWriter out = response.getWriter()) {
            GenericDAO dao = new AcademiaDAOImpl();
            EmailDAOImpl daoe = new EmailDAOImpl();
            if (request.getParameter("idPessoa").equals("")) {
                if (dao.cadastrar(academia)) {
                    if(daoe.EnviarEmail(academia)){
                        System.out.println("Email Enviado com Sucesso");
                    }else{
                        System.out.println("Falha ao Enviar o Email");
                    }
                    mensagem = "Academia cadastrada com sucesso!!Por favor ative seu cadastro!";
                } else {
                    mensagem = "Problemas ao cadastrar Academia!";
                }
                 request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("login/login.jsp").forward(request, response);
            } else {
                academia.setIdPessoa(Integer.parseInt(request.getParameter("idPessoa")));
                if(dao.alterar(academia)){
                    mensagem="Academia alterado com sucesso!";
                }else{
                    mensagem="Problemas ao alterar Academia!";
                }
             request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("PerfilAcademia").forward(request, response);
            }
           
        }catch(Exception ex){
            System.out.println("Problemas ao salvar Academia! Erro:"+ex.getMessage());
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
