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
import br.com.projetoAcademia.dao.PessoaDAOImpl;
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
@WebServlet(name = "LogarPessoa", urlPatterns = {"/LogarPessoa"})
public class LogarPessoa extends HttpServlet {

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
        if (request.getParameter("acao").equals("logar")) {
                try {
                    PessoaDAOImpl dao = new PessoaDAOImpl();
                    Pessoa pessoa = dao.logarPessoa(request.getParameter("login"),request.getParameter("senha"));
                    if (pessoa != null) {
                        HttpSession session = request.getSession(true);
                        session.setAttribute("pessoa", pessoa);

                        mensagem = "Seja bem-vindo Sr.(a) " + pessoa.getNomePessoa() + "!";

                        session.setAttribute("saudacao", mensagem);

                        if (pessoa.getTipoPessoa().equalsIgnoreCase("aca")) {
                            AcademiaDAOImpl dao1 = new AcademiaDAOImpl();
                            Integer idAcademia = dao1.pegarId(pessoa.getIdPessoa());
                            session.setAttribute("academia", idAcademia);
                            request.getRequestDispatcher("DadosAcademia?idAcademia=" + pessoa.getIdPessoa()).forward(request, response);

                        } else if (pessoa.getTipoPessoa().equalsIgnoreCase("alu")) {
                            AlunoDAOImpl dao1 = new AlunoDAOImpl();
                            Integer idAluno = dao1.pegarId(pessoa.getIdPessoa());
                            session.setAttribute("idAluno", idAluno);
                            request.getRequestDispatcher("DadosAluno?idAluno=" + pessoa.getIdPessoa() + "&&idAA=" + idAluno).forward(request, response);

                        } else if (pessoa.getTipoPessoa().equalsIgnoreCase("per")) {
                            PersonalDAOImpl dao1 = new PersonalDAOImpl();
                            Integer idPersonal = dao1.pegarId(pessoa.getIdPessoa());
                            Integer idAcademia = dao1.pegarIdA(pessoa.getIdPessoa());
                            session.setAttribute("personal", idPersonal);
                            session.setAttribute("academia", idAcademia);
                            request.getRequestDispatcher("DadosPersonal?idPersonal=" + pessoa.getIdPessoa() + "&&idAcademia=" + idAcademia).forward(request, response);

                        } else if (pessoa.getTipoPessoa().equalsIgnoreCase("adm")) {
                            AdministradorDAOImpl dao1 = new AdministradorDAOImpl();
                            Integer idAdministrador = dao1.pegarId(pessoa.getIdPessoa());
                            session.setAttribute("idAdministrador", idAdministrador);
                            request.getRequestDispatcher("DadosAdministrador?idAdministrador=" + idAdministrador).forward(request, response);

                        } else {
                            response.sendRedirect("login/login.jsp");
                        }
                    } else {
                        mensagem = "Usuario e/ou Senha Inv�lidos!";
                        request.setAttribute("mensagem", mensagem);
                        request.getRequestDispatcher("login/login.jsp").forward(request, response);
                    }
                } catch (Exception ex) {
                    System.out.println("Problemas ao logar! Erro: " + ex.getMessage());
                    ex.printStackTrace();
                }
            

                mensagem = "Usuário/Senha inválidos!";
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("pessoa/salvar.jsp").forward(request, response);
            
        } else if (request.getParameter("acao").equals("sair")) {
            HttpSession session = request.getSession(true);
            session.invalidate();
            response.sendRedirect("login/login.jsp");
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
