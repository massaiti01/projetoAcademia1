/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.controller;

import br.com.projetoAcademia.dao.AcademiaDAOImpl;
import br.com.projetoAcademia.dao.GenericDAO;
import br.com.projetoAcademia.dao.PersonalDAOImpl;
import br.com.projetoAcademia.model.Academia;
import br.com.projetoAcademia.model.Personal;
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
@WebServlet(name = "SalvarPersonal", urlPatterns = {"/SalvarPersonal"})
public class SalvarPersonal extends HttpServlet {

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
        Academia academia = new Academia();
        Integer idAcademia = null;
        String mensagem = null;
        Personal personal = new Personal();
        academia.setIdAcademia(Integer.parseInt(request.getParameter("idAcademia")));
        personal.setAcademia(academia);
        personal.setNomePessoa(request.getParameter("nomePessoa"));
        personal.setTelefonePessoa(request.getParameter("telefonePessoa"));
        personal.setCrefPersonal(request.getParameter("crefPersonal"));
        personal.setLoginPessoa(request.getParameter("loginPessoa"));
        personal.setEmailPessoa(request.getParameter("emailPessoa"));
        personal.setSenhaPessoa(request.getParameter("senhaPessoa"));
        personal.setTipoPessoa("PER");

        
        try (PrintWriter out = response.getWriter()) {
            GenericDAO dao = new PersonalDAOImpl();
            if (request.getParameter("idPessoa").equals("")) {
                if (dao.cadastrar(personal)) {
                    mensagem = "Personal cadastrado com sucesso!";
                } else {
                    mensagem = "Problemas ao cadastrar Personal!";
                }
                 request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("personal/salvar.jsp").forward(request, response);
            } else {
                personal.setIdPessoa(Integer.parseInt(request.getParameter("idPessoa")));
                if(dao.alterar(personal)){
                    mensagem="Personal alterado com sucesso!";
                }else{
                    mensagem="Problemas ao alterar Personal!";
                }
             request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("ListarPersonal").forward(request, response);
            }
           
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
