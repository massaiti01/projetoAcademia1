/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.controller;

import br.com.projetoAcademia.dao.ExercicioDAOImpl;
import br.com.projetoAcademia.dao.ExercicioTreinoDAOImpl;
import br.com.projetoAcademia.model.Aparelho;
import br.com.projetoAcademia.model.Exercicio;
import br.com.projetoAcademia.model.ExercicioTreino;
import br.com.projetoAcademia.model.GrupoMuscular;
import br.com.projetoAcademia.model.Treino;
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
@WebServlet(name = "SalvarExercicioTreino", urlPatterns = {"/SalvarExercicioTreino"})
public class SalvarExercicioTreino extends HttpServlet {

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
        ExercicioTreino et = new ExercicioTreino();
        Aparelho aparelho = new Aparelho();
        GrupoMuscular grupoMuscular = new GrupoMuscular();
        Treino treino = new Treino();
        Exercicio exercicio = new Exercicio();
        aparelho.setIdAparelho(Integer.parseInt(request.getParameter("aparelho")));
        et.setAparelho(aparelho);
        grupoMuscular.setIdGrupoMuscular(Integer.parseInt(request.getParameter("grupomuscular")));
        et.setGrupoMuscular(grupoMuscular);
        treino.setIdTreino(Integer.parseInt(request.getParameter("idTreino")));
        et.setTreino(treino);
        et.setDescricaoExercicioTreino(request.getParameter("descricaoExercicioTreino"));
        et.setCargaTreino(Integer.parseInt(request.getParameter("cargaTreino")));
        et.setRepeticoesTreino(Integer.parseInt(request.getParameter("repeticoesTreino")));
        et.setSeriesTreino(Integer.parseInt(request.getParameter("numeroDeSeries")));

          try (PrintWriter out = response.getWriter()) {
              ExercicioDAOImpl dao1 = new ExercicioDAOImpl();
               exercicio.setIdExercicio(dao1.pegarId(request.getParameter("exercicio")));
        et.setExercicio(exercicio);
              ExercicioTreinoDAOImpl dao = new ExercicioTreinoDAOImpl();
                if (dao.cadastrar(et)) {
                    mensagem = "Exercicio Adicionado ao Treino com sucesso!";
                } else {
                    mensagem = "Problemas ao Adicionar Exercicio ao Treino!";
                }
                 request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("DadosTreino?idAluno="+request.getParameter("idAluno")).forward(request, response);
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
