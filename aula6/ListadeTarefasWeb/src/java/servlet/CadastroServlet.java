package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

@WebServlet(name = "CadastroServlet", urlPatterns = {"/CadastroServlet"})
public class CadastroServlet extends HttpServlet {

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
        // Escrever o código para processar o request que usa GET

        request.setAttribute("erroSenha", "");
        request.setAttribute("erroEmail", "");

        request.getRequestDispatcher("cadastro.jsp").forward(request, response);
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
        String password = request.getParameter("password");

        // Validar email e password
        // Se tiver ok
        boolean okSenha = true;
        boolean okEmail = true;

        if (password.length() < 6 || password.length() > 15) {
            okSenha = false;
        }

        if (!email.contains("@")) {
            okEmail = false;
        }

        if (okSenha) {

            request.setAttribute("erroSenha", "");

        } else {

            request.setAttribute("erroSenha", "A senha precisa ter entre 6 e 15 caracteres");

        }

        if (okEmail) {

            request.setAttribute("erroEmail", "");

        } else {

            request.setAttribute("erroEmail", "O email precisa ter um @");

        }

        if (!okSenha || !okEmail) {
            
            request.getRequestDispatcher("cadastro.jsp").forward(request, response);
            
        } else {
        
            response.sendRedirect("index.html");
            
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
