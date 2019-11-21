package servlet;

import dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

@WebServlet(name = "RemoverUsuarioServlet", urlPatterns = {"/RemoverUsuarioServlet"})
public class RemoverUsuarioServlet extends HttpServlet {

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

        request.getRequestDispatcher("removeUsuario.jsp").forward(request, response);
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

        String email = request.getParameter("email");

        Usuario u = UsuarioDAO.procurarUsuarioPorEmail(email);

        if (u != null) {

            boolean removido = UsuarioDAO.removerUsuario(u);
            if (removido) {
                request.setAttribute("mensagem", "Usuário removido com sucesso");
            } else {
                request.setAttribute("menasgem", "Aconteceu algum erro ao tentar remover. Tente novamente");
            }

        } else {
            request.setAttribute("mensagem", "Usuário não é cadastrado");
        }

        request.getRequestDispatcher("removeUsuario.jsp").forward(request, response);
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
