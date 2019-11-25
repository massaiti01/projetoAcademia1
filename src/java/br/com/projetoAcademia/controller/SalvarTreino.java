/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.controller;

import br.com.projetoAcademia.dao.GrupoTreinadoDAOImpl;
import br.com.projetoAcademia.dao.TreinoDAOImpl;
import br.com.projetoAcademia.model.Aluno;
import br.com.projetoAcademia.model.GrupoMuscular;
import br.com.projetoAcademia.model.GrupoTreinado;
import br.com.projetoAcademia.model.Personal;
import br.com.projetoAcademia.model.Treino;
import br.com.projetoAcademia.util.Conversoes;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ERICMASSAITIUEMURA
 */
@WebServlet(name = "SalvarTreino", urlPatterns = {"/SalvarTreino"})
public class SalvarTreino extends HttpServlet {

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
        Treino treino = new Treino();
        Aluno aluno = new Aluno();
        GrupoTreinado gt = new GrupoTreinado();
        GrupoMuscular gm = new GrupoMuscular();
        Personal personal = new Personal();
        treino.setNomeTreino(request.getParameter("nomeTreino"));
        treino.setDataTreino(request.getParameter("dataTreino"));
        System.out.println("teste"+request.getParameter("dataTreino"));
        aluno.setIdAluno(Integer.parseInt(request.getParameter("idAluno")));
        personal.setIdPersonal(Integer.parseInt(request.getParameter("idPersonal")));
        treino.setAluno(aluno);
        treino.setPersonal(personal);
        String[] musculos= request.getParameterValues("grupomuscular");

          try (PrintWriter out = response.getWriter()) {
             TreinoDAOImpl dao = new TreinoDAOImpl();
             GrupoTreinadoDAOImpl dao1 = new GrupoTreinadoDAOImpl();
             Integer idTreino = dao.cadastrarT(treino);
             treino.setIdTreino(idTreino);
             gt.setTreino(treino);
                for(int i = 0;i<musculos.length;i++){
                    gm.setIdGrupoMuscular(Integer.parseInt(musculos[i]));
                    gt.setGrupoMuscular(gm);
                if (dao1.cadastrar(gt)) {
                    mensagem = "Treino cadastrado com sucesso!";
                } else {
                    mensagem = "Problemas ao cadastrar Aparelho!";
                }
                }
                 request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("aluno/listar.jsp").forward(request, response);
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
