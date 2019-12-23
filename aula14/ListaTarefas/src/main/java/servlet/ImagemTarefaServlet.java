package servlet;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Tarefa;
import modelo.Usuario;

@WebServlet(name = "ImagemTarefaServlet", urlPatterns = {"/ImagemTarefaServlet"})
public class ImagemTarefaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idTarefa = request.getParameter("tarefa");
        int id = Integer.parseInt(idTarefa);

        HttpSession session = request.getSession();

        Usuario u = (Usuario) session.getAttribute("usuario");

        Tarefa tarefa = null;
        for (Tarefa t : u.getTarefas()) {
            if (t.getId() == id) {
                tarefa = t;
                break;
            }
        }
        
        try (InputStream stream = new BufferedInputStream(new ByteArrayInputStream(tarefa.getImagem())) ) {

            String contentType = URLConnection.guessContentTypeFromStream(stream);
            response.setContentType(contentType);

            byte[] buffer = new byte[10240];
            while (stream.read(buffer) != -1) {

                response.getOutputStream().write(buffer);

            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
