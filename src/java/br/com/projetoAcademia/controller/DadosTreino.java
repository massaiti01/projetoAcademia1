/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.controller;

import br.com.projetoAcademia.dao.AparelhoDAOImpl;
import br.com.projetoAcademia.dao.ExercicioDAOImpl;
import br.com.projetoAcademia.dao.ExercicioTreinoDAOImpl;
import br.com.projetoAcademia.dao.GenericDAO;
import br.com.projetoAcademia.dao.GrupoTreinadoDAOImpl;
import br.com.projetoAcademia.dao.GrupomuscularDAOImpl;
import br.com.projetoAcademia.dao.TreinoDAOImpl;
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
 * @author ERICMASSAITIUEMURA
 */
@WebServlet(name = "DadosTreino", urlPatterns = {"/DadosTreino"})
public class DadosTreino extends HttpServlet {

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
        Integer idAluno = Integer.parseInt(request.getParameter("idAluno"));
        
          HttpSession session = request.getSession(true);
        Integer idAcademia = (Integer) session.getAttribute("academia"); 
         try {
            ExercicioTreinoDAOImpl daoet = new ExercicioTreinoDAOImpl();
            GrupomuscularDAOImpl dao = new GrupomuscularDAOImpl();
            TreinoDAOImpl daot = new TreinoDAOImpl();
            AparelhoDAOImpl daoa = new AparelhoDAOImpl();
            ExercicioDAOImpl daoe = new ExercicioDAOImpl();
            
            request.setAttribute("exerciciotreinos",daoet.listar());
            request.setAttribute("treinos",daot.listarI(idAluno));
            request.setAttribute("grupomusculares", dao.listar());
            request.setAttribute("idAluno",idAluno);
            request.getRequestDispatcher("personal/treino/salvar.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("Problemas no servlet ao listar Grupo Musculares!! Erro: " + e.getMessage());
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
