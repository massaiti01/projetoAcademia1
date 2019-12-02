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
import java.util.Date;
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
                auxiliarMedio= null, suprailiaca = null , biestiloide = null , bicondiliano = null,soma7 = null,pGordura=null,
                pesodeGordura=null,massaMagra=null,pesoResidual=null,a=null,b=null,d=null,pesoOsseo=null,pesoMuscular= null,
                soma3 = null;
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
         biestiloide=Double.parseDouble(request.getParameter("biestiloide"));
        bicondiliano=Double.parseDouble(request.getParameter("bicondiliano"));
         a= biestiloide/100;
        b= bicondiliano/100;
        Double Potencia = Math.pow(altura,2);
        d= (Potencia)*a*b*400;
        if(request.getParameter("tipo").equals("7dobras")){
        sexo=request.getParameter("sexo");
        triciptal=Double.parseDouble(request.getParameter("triciptal"));
        subescapular=Double.parseDouble(request.getParameter("subescapular"));
        auxiliarMedio=Double.parseDouble(request.getParameter("auxiliarMedio"));
        suprailiaca=Double.parseDouble(request.getParameter("suprailiaca"));
       
        
        
        soma7 = triciptal+peitoral+subescapular+auxiliarMedio+suprailiaca+abdominal+coxa;
        if(sexo.equals("m")){
        pGordura=((4.95/((1.112-(0.00043499*soma7)+(0.00000055*(soma7*soma7))-(0.00028826*idade)))-4.5)*100);
        bio.setGorduraDobras(pGordura);
        }else if(sexo.equals("f")){
        pGordura=((4.95/((1.112-(0.00046971*soma7)+(0.00000056*(soma7*soma7))-(0.00012828*idade)))-4.5)*100);
        bio.setGorduraDobras(pGordura);
        }
        pesodeGordura = peso * pGordura / 100;
        massaMagra = peso - pesodeGordura;
        pesoResidual = peso * 24.1 / 100;
        
       
        Potencia = Math.pow(d,0.712);
        pesoOsseo= 3.02*(Potencia);
        pesoMuscular= peso - pesoResidual - pesodeGordura - pesoOsseo;
        bio.setTipo("7Dobras");
        bio.setPesodeGorduraDobras(pesodeGordura);
        bio.setMassaMagraDobras(massaMagra);
        bio.setPesoOsseoDobras(pesoOsseo);
        bio.setPesoMuscularDobras(pesoMuscular);
        bio.setPesoResidualDobras(pesoResidual);
        
        }else if(request.getParameter("tipo").equals("3dobras")){
        soma3 = abdominal+coxa+peitoral;
        pGordura = (4.95/((1.10938-(0.0008267*soma3)+(0.0000016*(soma3*soma3))-(0.0002574*idade)))-4.5)*100;
        pesodeGordura = peso * pGordura / 100;
        massaMagra = peso-pesodeGordura;
        Potencia = Math.pow(altura,2);
        d= (Potencia)*a*b*400;
        Potencia = Math.pow(d,0.712);
        pesoOsseo = 3.02*Potencia;
        pesoResidual = peso * 24.1 / 100;
        pesoMuscular = peso-pesoResidual-pesodeGordura-pesoOsseo;
        bio.setTipo("3Dobras");
        bio.setPesodeGorduraDobras(pesodeGordura);
        bio.setGorduraDobras(pGordura);
        bio.setMassaMagraDobras(massaMagra);
        bio.setPesoOsseoDobras(pesoOsseo);
        bio.setPesoMuscularDobras(pesoMuscular);
        bio.setPesoResidualDobras(pesoResidual);
        
        }
        Double teste = Math.pow(peso,(1/3)); 
        Double finalx = Math.pow((peso/altura),-0.109);
        bio.setIndicePonderal((altura*100)/teste);
        bio.setImc(peso/(altura*altura));
        bio.setIndiceConicidade(finalx);
         bio.setData( new Date(System.currentTimeMillis()));
        
          try (PrintWriter out = response.getWriter()) {
              BioimpedanciaDAOImpl dao = new BioimpedanciaDAOImpl();  
              if (dao.cadastrar(bio)) {
                    mensagem = "Treino cadastrado com sucesso!";
                } else {
                    mensagem = "Problemas ao cadastrar Aparelho!";
                }
                
                 request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("DadosBioimpedancia?idAluno="+request.getParameter("idAluno")).forward(request, response);
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
