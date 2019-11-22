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
@WebServlet(name="AlterarServlet", urlPatterns={"/AlterarServlet"})
public class AlterarServlet extends HttpServlet {

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

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
        
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        
        Usuario u = new Usuario();
        u.setId(id);
        u.setEmail(email);
        u.setSenha(senha);
        
        boolean atualizado = UsuarioDAO.atualizarUsuario(u);
        
        String mensagem = "";
        
        if (atualizado) {
            // Sucesso
            mensagem = "Dados salvos com sucesso!";
        } else {
            // Erro
            mensagem = "Aconteceu algum erro. Tente novamente!";
        }
        
        request.setAttribute("usuario", u);
        request.setAttribute("mensagem", mensagem);
        request.getRequestDispatcher("perfil.jsp").forward(request, response);
        
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
