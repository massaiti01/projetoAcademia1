/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.controller;

import br.com.projetoAcademia.dao.AcompanhamentoDAOImpl;
import br.com.projetoAcademia.dao.GenericDAO;
import br.com.projetoAcademia.model.Acompanhamento;
import br.com.projetoAcademia.model.Aluno;
import br.com.projetoAcademia.model.Personal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ERICMASSAITIUEMURA
 */
@WebServlet(name = "SalvarMedidas", urlPatterns = {"/SalvarMedidas"})
public class SalvarMedidas extends HttpServlet {

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
        Acompanhamento medida = new Acompanhamento();
        
        Aluno aluno = new Aluno();
        aluno.setIdPessoa(Integer.parseInt(request.getParameter("idAluno")));
        medida.setAluno(aluno);
        
        Personal personal = new Personal();
        personal.setIdPessoa(Integer.parseInt(request.getParameter("idPersonal")));
        medida.setPersonal(personal);
        
        medida.setOmbro(Double.parseDouble(request.getParameter("ombroAluno")));
        medida.setPeitoral(Double.parseDouble(request.getParameter("peitoralAluno")));
        medida.setBracoD(Double.parseDouble(request.getParameter("bracoDAluno")));
        medida.setBracoE(Double.parseDouble(request.getParameter("bracoEAluno")));
        medida.setAnteBracoD(Double.parseDouble(request.getParameter("anteBracoDAluno")));
        medida.setAnteBracoE(Double.parseDouble(request.getParameter("anteBracoEAluno")));
        medida.setCintura(Double.parseDouble(request.getParameter("cinturaAluno")));
        medida.setGluteo(Double.parseDouble(request.getParameter("gluteoAluno")));
        medida.setQuadril(Double.parseDouble(request.getParameter("quadrilAluno")));
        medida.setPernaD(Double.parseDouble(request.getParameter("pernaDAluno")));
        medida.setPernaE(Double.parseDouble(request.getParameter("pernaEAluno")));
        medida.setPanturrilhaD(Double.parseDouble(request.getParameter("panturrilhaDAluno")));
        medida.setPanturrilhaE(Double.parseDouble(request.getParameter("panturrilhaEAluno")));
        medida.setData( new Date(System.currentTimeMillis()));
       
        try (PrintWriter out = response.getWriter()) {
            GenericDAO dao = new AcompanhamentoDAOImpl();
                if (dao.cadastrar(medida)) {
                    mensagem = "Medidas cadastrada com sucesso!";
                } else {
                    mensagem = "Problemas ao cadastrar Medidas!";
                }
                 request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("DadosMedida?idAluno="+request.getParameter("idAluno")).forward(request, response);
        }catch(Exception ex){
            System.out.println("Problemas ao salvar Medidas! Erro:"+ex.getMessage());
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
