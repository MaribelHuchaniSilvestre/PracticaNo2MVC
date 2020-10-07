package com.emergentes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginSession", urlPatterns = {"/LoginSession"})
public class LoginSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String login =(String) sesion.getAttribute("login");
        if(login.equals("OK")){
            sesion.invalidate();
            response.sendRedirect("index.jsp");
        }
        else{
            response.sendRedirect("login.jsp");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession ses = request.getSession();
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        if ((usuario.equals("Mary")) && (password.equals("1234"))){
            ses.setAttribute("login", "OK");
            ses.setAttribute("usuario",usuario);
            
            response.sendRedirect("panel.jsp");
        }
        else{
            ses.setAttribute("error","Usuario sin Autorizacion");
            response.sendRedirect("login.jsp");
        }
    }
}
