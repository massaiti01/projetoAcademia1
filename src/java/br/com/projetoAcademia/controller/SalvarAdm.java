/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.controller;

import br.com.projetoAcademia.dao.AdministradorDAOImpl;
import br.com.projetoAcademia.model.Administrador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eric
 */
@WebServlet(name = "SalvarAdm", urlPatterns = {"/SalvarAdm"})
public class SalvarAdm extends HttpServlet {

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
        Administrador adm = new Administrador();
        adm.setNomePessoa(request.getParameter("nomePessoa"));
        adm.setTelefonePessoa(request.getParameter("telefonePessoa"));
        adm.setTelefoneAdministrador(request.getParameter("telefoneAdm"));
        adm.setEmailAdministrador(request.getParameter("emailAdm"));
        adm.setLoginPessoa(request.getParameter("loginPessoa"));
        adm.setSenhaPessoa(request.getParameter("senhaPessoa"));
        adm.setTipoPessoa("ADM");

        
        try (PrintWriter out = response.getWriter()) {
            AdministradorDAOImpl dao = new AdministradorDAOImpl();
            if (request.getParameter("idPessoa").equals("")) {
                if (dao.cadastrar(adm)) {
                    mensagem = "Administrador cadastrado com sucesso!";
                } else {
                    mensagem = "Problemas ao cadastrar Aluno!";
                }
                 request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("administrador/salvar.jsp").forward(request, response);
            } else {
                adm.setIdPessoa(Integer.parseInt(request.getParameter("idPessoa")));
                if(dao.alterar(adm)){
                    mensagem="Aluno alterado com sucesso!";
                }else{
                    mensagem="Problemas ao alterar Aluno!";
                }
             request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("Redirect").forward(request, response);
            }
           
        }catch(Exception ex){
            System.out.println("Problemas ao salvar Adm! Erro:"+ex.getMessage());
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
