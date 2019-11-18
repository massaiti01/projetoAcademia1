/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.controller;

import br.com.projetoAcademia.dao.AlunoDAOImpl;
import br.com.projetoAcademia.dao.GenericDAO;
import br.com.projetoAcademia.model.Academia;
import br.com.projetoAcademia.model.Aluno;
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
@WebServlet(name = "SalvarAluno", urlPatterns = {"/SalvarAluno"})
public class SalvarAluno extends HttpServlet {

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
        Aluno aluno = new Aluno();
        Academia academia = new Academia();
        academia.setIdPessoa(Integer.parseInt(request.getParameter("idAcademia")));
        aluno.setAcademia(academia);
        aluno.setNomePessoa(request.getParameter("nomePessoa"));
        aluno.setCpfAluno(request.getParameter("cpfAluno"));
        aluno.setTelefonePessoa(request.getParameter("telefonePessoa"));
        aluno.setTelefoneEmergencia(request.getParameter("telefoneEmergencia"));
        aluno.setLoginPessoa(request.getParameter("loginPessoa"));
        aluno.setSenhaPessoa(request.getParameter("senhaPessoa"));
        
        aluno.setTipoPessoa("ALU");

        
        try (PrintWriter out = response.getWriter()) {
            GenericDAO dao = new AlunoDAOImpl();
            if (request.getParameter("idPessoa").equals("")) {
                if (dao.cadastrar(aluno)) {
                    mensagem = "Aluno cadastrado com sucesso!";
                } else {
                    mensagem = "Problemas ao cadastrar Aluno!";
                }
                 request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("aluno/salvar.jsp").forward(request, response);
            } else {
                aluno.setIdPessoa(Integer.parseInt(request.getParameter("idPessoa")));
                if(dao.alterar(aluno)){
                    mensagem="Aluno alterado com sucesso!";
                }else{
                    mensagem="Problemas ao alterar Aluno!";
                }
             request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("ListarAluno").forward(request, response);
            }
           
        }catch(Exception ex){
            System.out.println("Problemas ao salvar Aluno! Erro:"+ex.getMessage());
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
