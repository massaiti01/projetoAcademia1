/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.controller;

import br.com.projetoAcademia.dao.BioimpedanciaDAOImpl;
import br.com.projetoAcademia.model.Aluno;
import br.com.projetoAcademia.model.Bioimpedancia;
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
@WebServlet(name = "SalvarBioimpedancia", urlPatterns = {"/SalvarBioimpedancia"})
public class SalvarBioimpedancia extends HttpServlet {

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
        String mensagem = null,sexo = null;
        Integer idAluno = null,idade = null;
        Double altura=null , peso = null, abdominal = null, coxa = null,peitoral =  null,  triciptal = null, subescapular = null,
                auxiliarMedio= null, suprailiaca = null , biestiloide = null , bicondiliano = null;
        Bioimpedancia bio= new Bioimpedancia();
        Aluno aluno = new Aluno();
        Personal personal = new Personal();
        personal.setIdPersonal(Integer.parseInt(request.getParameter("idPersonal")));
        bio.setPersonal(personal);
        aluno.setIdAluno(Integer.parseInt(request.getParameter("idAluno")));
        bio.setAluno(aluno);
        idade = Integer.parseInt(request.getParameter("idade"));
        altura =Double.parseDouble(request.getParameter("altura"));
        peso=Double.parseDouble(request.getParameter("peso"));
        abdominal=Double.parseDouble(request.getParameter("abdominal"));
        coxa=Double.parseDouble(request.getParameter("coxa"));
        peitoral=Double.parseDouble(request.getParameter("peitoral"));
        if(request.getParameter("tipo").equals("7dobras")){
        sexo=request.getParameter("sexo");
        triciptal=Double.parseDouble(request.getParameter("triciptal"));
        subescapular=Double.parseDouble(request.getParameter("subescapular"));
        auxiliarMedio=Double.parseDouble(request.getParameter("auxiliarMedio"));
        suprailiaca=Double.parseDouble(request.getParameter("suprailiaca"));
        biestiloide=Double.parseDouble(request.getParameter("biestiloide"));
        bicondiliano=Double.parseDouble(request.getParameter("bicondiliano"));
        }else if(request.getParameter("tipo").equals("3dobras")){
            
        
        }
        Double teste = Math.pow(peso,(1/3)); 
        Double finalx = Math.pow((peso/altura),-0.109);
        bio.setIndicePonderal((altura*100)/teste);
        bio.setImc(peso/(altura*altura));
        bio.setIndiceConicidade(finalx);
          try (PrintWriter out = response.getWriter()) {
              BioimpedanciaDAOImpl dao = new BioimpedanciaDAOImpl();  
              if (dao.cadastrar(bio)) {
                    mensagem = "Treino cadastrado com sucesso!";
                } else {
                    mensagem = "Problemas ao cadastrar Aparelho!";
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
