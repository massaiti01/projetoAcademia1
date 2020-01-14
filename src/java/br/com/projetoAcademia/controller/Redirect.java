/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.controller;

import br.com.projetoAcademia.dao.AcademiaDAOImpl;
import br.com.projetoAcademia.dao.AdministradorDAOImpl;
import br.com.projetoAcademia.dao.AlunoDAOImpl;
import br.com.projetoAcademia.dao.PersonalDAOImpl;
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
 * @author ERICMASSAITIUEMURA
 */
@WebServlet(name = "Redirect", urlPatterns = {"/Redirect"})
public class Redirect extends HttpServlet {

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
        
        try{
         HttpSession session = request.getSession(true);
        Pessoa pessoa = (Pessoa) session.getAttribute("pessoa");
        if(session.getAttribute("pessoa")!=null){ 
        if(pessoa.getTipoPessoa().equals("ALU")){
             AlunoDAOImpl dao1 = new AlunoDAOImpl();
                             Integer idAluno = dao1.pegarId(pessoa.getIdPessoa());
                             session.setAttribute("aluno",idAluno);
             request.getRequestDispatcher("DadosAluno?idAluno="+pessoa.getIdPessoa()+"&&idAA="+idAluno).forward(request, response);
        }else if(pessoa.getTipoPessoa().equals("ACA")){
               AcademiaDAOImpl dao1 = new AcademiaDAOImpl();
                            Integer idAcademia = dao1.pegarId(pessoa.getIdPessoa());
                            session.setAttribute("academia",idAcademia);
                            request.getRequestDispatcher("DadosAcademia?idAcademia="+pessoa.getIdPessoa()).forward(request, response);
        }else if(pessoa.getTipoPessoa().equals("PER")){
        
                            PersonalDAOImpl dao1 = new PersonalDAOImpl();
                            Integer idPersonal = dao1.pegarId(pessoa.getIdPessoa());
                            Integer idAcademia = dao1.pegarIdA(pessoa.getIdPessoa());
                            session.setAttribute("personal",idPersonal);
                            session.setAttribute("academia",idAcademia);
                            request.getRequestDispatcher("DadosPersonal?idPersonal="+pessoa.getIdPessoa()+"&&idAcademia="+idAcademia).forward(request, response);
        }else if (pessoa.getTipoPessoa().equalsIgnoreCase("adm")) {
                            AdministradorDAOImpl dao1 = new AdministradorDAOImpl();
                            Integer idAdministrador = dao1.pegarId(pessoa.getIdPessoa());
                            session.setAttribute("idAdministrador", idAdministrador);
                            request.getRequestDispatcher("DadosAdministrador?idAdministrador=" + idAdministrador).forward(request, response);

        }else{
        request.getRequestDispatcher("login/login.jsp").forward(request, response);
        }
        }else{
        request.getRequestDispatcher("login/login.jsp").forward(request, response);
        }
    }catch (Exception ex) {
        System.out.println("Problemas ao Redirecionar! Erro: " + ex.getMessage());
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
