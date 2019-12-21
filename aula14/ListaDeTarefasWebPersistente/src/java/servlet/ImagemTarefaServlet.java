package servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;

@WebServlet(name = "ImagemTarefaServlet", urlPatterns = {"/ImagemTarefaServlet"})
public class ImagemTarefaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomeImagem = request.getParameter("imagem");

        HttpSession session = request.getSession();

        Usuario u = (Usuario) session.getAttribute("usuario");

        String idUsuario = String.valueOf(u.getId());

        String uploadsDiretorio = "/home/igor/uploads_lista_tarefas";

        File pastaUsuario = new File(uploadsDiretorio, idUsuario);

        if (pastaUsuario.exists()) {

            File caminhoImagem = new File(pastaUsuario, nomeImagem);

            try (InputStream stream = Files.newInputStream(caminhoImagem.toPath(), StandardOpenOption.READ)) {

                String contentType = URLConnection.guessContentTypeFromStream(stream);
                response.setContentType(contentType);
                
                byte[] buffer = new byte[10240];
                while (stream.read(buffer) != -1) {
                    
                    response.getOutputStream().write(buffer);
                    
                }

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
