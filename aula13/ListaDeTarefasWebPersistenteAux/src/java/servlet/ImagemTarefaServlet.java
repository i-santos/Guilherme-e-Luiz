package servlet;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
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

        HttpSession session = request.getSession();
        Usuario u = (Usuario) session.getAttribute("usuario");

        String imagem = request.getParameter("imagem");

        File file = new File(AdicionarTarefaServlet.UPLOAD_DIR, String.valueOf(u.getId()));

        if (file.exists()) {

            File imageFile = new File(file, imagem);
            try (InputStream fileStream = Files.newInputStream(imageFile.toPath(), StandardOpenOption.READ)) {

                String contentType = URLConnection.guessContentTypeFromStream(fileStream);
                response.setContentType(contentType);

                byte[] buffer = new byte[10240];
                while (fileStream.read(buffer) != -1) {
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
