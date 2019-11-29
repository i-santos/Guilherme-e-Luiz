/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import dao.TarefaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Tarefa;
import modelo.Usuario;

/**
 *
 * @author igor
 */
@WebServlet(name="FinalizarTarefaServlet", urlPatterns={"/FinalizarTarefaServlet"})
public class FinalizarTarefaServlet extends HttpServlet {

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
        
        HttpSession session = request.getSession();
        
        Usuario u = (Usuario) session.getAttribute("usuario");
        
        String[] tarefasId = request.getParameterValues("tarefas");
        
        boolean erro = false;
        for(String tId : tarefasId) {
            
            Tarefa t = new Tarefa();
            
            int id = Integer.parseInt(tId);
            t.setId(id);
            t.setIdUsuario(u.getId());
            
            boolean sucesso = TarefaDAO.finalizarTarefa(t);
            
            if(!sucesso) {
                erro = true;
            }
        }
        
        if (erro) {
            request.setAttribute("erroFinalizar", "Ocorreu algum erro ao finalizar as tarefas. Tente novamente");
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
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
