package com.emergentes.controlador;

import com.emergentes.modelo.RegistroLibro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControladorRegistro_libro", urlPatterns = {"/ControladorRegistro_libro"})
public class ControladorRegistro_libro extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       int op =Integer.parseInt(request.getParameter("op"));
       int id,pos;
       HttpSession ses= request.getSession();
       ArrayList<RegistroLibro> lista=(ArrayList<RegistroLibro>) ses.getAttribute("listalibro");
       if(op==1){
          RegistroLibro p =new  RegistroLibro();
          request.setAttribute("Reg_Libro",p);
          request.getRequestDispatcher("editaregistro_libro.jsp").forward(request,response);
       }
       if(op==2){
           id=Integer.parseInt(request.getParameter("id"));
           pos=buscarIndice(request,id);
           RegistroLibro p1= lista.get(pos);
           request.setAttribute("Reg_Libro",p1);
           request.getRequestDispatcher("editaregistro_libro.jsp").forward(request,response);
       }
       if(op==3){
           id=Integer.parseInt(request.getParameter("id"));
           pos=buscarIndice(request,id);
           lista.remove(pos);
           ses.setAttribute("listalibro",lista);
           response.sendRedirect("registro_libro.jsp");
       }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       int id= Integer.parseInt(request.getParameter("id"));
       String titulo= request.getParameter("titulo");
       String autor= request.getParameter("autor");
       String resumen= request.getParameter("resumen");
       String medio=request.getParameter("medio");
       String nuevo= request.getParameter("nuevo");
       int pos;
       
       RegistroLibro per = new RegistroLibro();

       per.setId(id);
       per.setTitulo(titulo);
       per.setAutor(autor);
       per.setResumen(resumen);
       per.setMedio(medio);
       
       HttpSession ses=request.getSession();
       ArrayList<RegistroLibro> lista = (ArrayList<RegistroLibro>) ses.getAttribute("listalibro");
       
       if(nuevo.equals("true")){
           lista.add(per);
       }
       else{
           pos=buscarIndice(request,id);
           lista.set(pos,per);
           
       }
       response.sendRedirect("registro_libro.jsp");
    }
    private int buscarIndice(HttpServletRequest request,int id)
    {
        HttpSession ses=request.getSession();
        ArrayList<RegistroLibro> lista=(ArrayList<RegistroLibro>) ses.getAttribute("listalibro");
        int i=0;
        if(lista.size()>0){
            while(i<lista.size()){
                if(lista.get(i).getId()==id){
                    break;
                }
                else{
                    i++;
                }
            }
        }
        return i;
    }
}
