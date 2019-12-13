/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;

/**
 *
 * @author igor
 */
@WebServlet(name="AutenticarServlet", urlPatterns={"/AutenticarServlet"})
public class AutenticarServlet extends HttpServlet {

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        Usuario u = UsuarioDAO.buscarUsuario(email);
        
        if (u == null || ! u.getSenha().equals(senha)) {
            // Autentição falhou. Email/senha incorretos
            request.setAttribute("erro", "Email/senha inválidos. Tente novamente");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            
            // Login feito com sucesso
//            request.setAttribute("usuario", u);
//            request.getRequestDispatcher("home.jsp").forward(request, response);
            
            HttpSession session = request.getSession();
            
            session.setAttribute("usuario", u);

            response.sendRedirect("HomeServlet");
                        
        }
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
