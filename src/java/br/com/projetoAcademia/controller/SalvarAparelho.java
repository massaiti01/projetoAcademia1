/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.controller;

import br.com.projetoAcademia.dao.AcademiaDAOImpl;
import br.com.projetoAcademia.dao.AparelhoDAOImpl;
import br.com.projetoAcademia.dao.GenericDAO;
import br.com.projetoAcademia.model.Academia;
import br.com.projetoAcademia.model.Aparelho;
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
@WebServlet(name = "SalvarAparelho", urlPatterns = {"/SalvarAparelho"})
public class SalvarAparelho extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String mensagem = null;
        Aparelho aparelho = new Aparelho();
        aparelho.setNomeAparelho(request.getParameter("nomeAparelho"));
          Academia academia = new Academia();
        academia.setIdAcademia(Integer.parseInt(request.getParameter("idAcademia")));
        aparelho.setAcademia(academia);
        try (PrintWriter out = response.getWriter()) {
            GenericDAO dao = new AparelhoDAOImpl();
            if (request.getParameter("idAparelho").equals("")) {
                if (dao.cadastrar(aparelho)) {
                    mensagem = "Aparelho cadastrado com sucesso!";
                } else {
                    mensagem = "Problemas ao cadastrar Aparelho!";
                }
                 request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("ListarAparelho").forward(request, response);
            } 
           
        }catch(Exception ex){
            System.out.println("Problemas ao salvar Aparelho! Erro:"+ex.getMessage());
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
