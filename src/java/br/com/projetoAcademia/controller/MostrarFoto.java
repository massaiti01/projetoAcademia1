/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.controller;

import br.com.projetoAcademia.dao.ExercicioDAOImpl;
import br.com.projetoAcademia.model.Exercicio;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileUploadException;

/**
 *
 * @author ERICMASSAITIUEMURA
 */
@WebServlet(name = "MostrarFoto", urlPatterns = {"/MostrarFoto"})
public class MostrarFoto extends HttpServlet {

    private static final int BYTES_DOWNLOAD = 1024;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException,FileUploadException {
        
        Integer idExercicio = Integer.parseInt(request.getParameter("idExercicio"));
      
        try{
            
           ExercicioDAOImpl dao = new ExercicioDAOImpl();
           Exercicio exercicio = dao.getFile(idExercicio);
           
           InputStream inputstream = exercicio.getFotoExercicio();
           OutputStream outputstream = response.getOutputStream();
           
           response.setHeader("Content-Disposition", "attachment; filename = " + exercicio.getNomeExercicio()+ ".jpg");
           
           int read = 0;
           final byte[] bytes = new byte[BYTES_DOWNLOAD];
          
           while ((read = inputstream.read(bytes)) != -1 ){
            outputstream.write(bytes, 0, read);
            outputstream.flush();
           }  
        }catch(Exception ex){
            System.out.println("Problema ao carregar imagem do Exercicio! Erro: "+ ex.getMessage());
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
        } catch (FileUploadException ex) {
            Logger.getLogger(MostrarFoto.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MostrarFoto.class.getName()).log(Level.SEVERE, null, ex);
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
