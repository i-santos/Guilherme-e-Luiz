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
import modelo.Usuario;

/**
 *
 * @author igor
 */
@WebServlet(name="CadastrarServlet", urlPatterns={"/CadastrarServlet"})
public class CadastrarServlet extends HttpServlet {

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
        
        Usuario u = new Usuario();
        u.setEmail(email);
        u.setSenha(senha);
        
        boolean inserido = UsuarioDAO.inserirUsuario(u);
        
        if (inserido) {
            
            request.getRequestDispatcher("WEB-INF/cadastroSucesso.html").forward(request, response);
            
        } else {
            
            request.setAttribute("erro", "Não foi possível cadastrar. Tente novamente");
            request.getRequestDispatcher("cadastro.jsp").forward(request, response);
            
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
