/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.controller;

import br.com.projetoAcademia.dao.AcademiaDAOImpl;
import br.com.projetoAcademia.dao.ExercicioDAOImpl;
import br.com.projetoAcademia.dao.GenericDAO;
import br.com.projetoAcademia.model.Academia;
import br.com.projetoAcademia.model.Exercicio;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author ERICMASSAITIUEMURA
 */
@WebServlet(name = "SalvarExercicio", urlPatterns = {"/SalvarExercicio"})
public class SalvarExercicio extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws org.apache.commons.fileupload.FileUploadException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException ,FileUploadException {
       
          Exercicio exercicio = new Exercicio();
        
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);        

        if (isMultipart) {

            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            upload.setSizeMax(50 * 1024 * 1024);

            List items = upload.parseRequest(request);

            InputStream is = null;
            Iterator it = items.iterator();

            while (it.hasNext()) {

                FileItem fileItem = (FileItem) it.next();
                if (!fileItem.isFormField()) {
                    is = fileItem.getInputStream();
                    exercicio.setFotoExercicio(is);
                    exercicio.setFile((int)fileItem.getSize());
                } else {
                    String dados = fileItem.getFieldName();
                    if (dados.equals("nomeExercicio")) {
                        exercicio.setNomeExercicio(fileItem.getString());
                    }else if (dados.equals("idAcademia")) {
                        Academia academia = new Academia();
                    academia.setIdAcademia(Integer.parseInt(fileItem.getString()));
                     exercicio.setAcademia(academia);
                    }
                }
            }
        }

        String mensagem = null;

        try {
            GenericDAO dao = new ExercicioDAOImpl();
            if (dao.cadastrar(exercicio)) {
                mensagem = "Exercicio cadastrado com sucesso!";
            } else {
                mensagem = "Problema ao cadastrar Exercicio!";
            }

            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("ListarExercicio").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao Cadastrar Exercicio! Erro: " + ex.getMessage());
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
        try {
            processRequest(request, response);
        }catch(FileUploadException ex) {
            Logger.getLogger(SalvarExercicio.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(SalvarExercicio.class.getName()).log(Level.SEVERE, null, ex);
        }
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
