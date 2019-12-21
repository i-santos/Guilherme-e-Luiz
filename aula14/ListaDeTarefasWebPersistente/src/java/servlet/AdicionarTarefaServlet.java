/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.TarefaDAO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import modelo.Tarefa;
import modelo.Usuario;

/**
 *
 * @author igor
 */
@WebServlet(name = "AdicionarTarefaServlet", urlPatterns = {"/AdicionarTarefaServlet"})
@MultipartConfig
public class AdicionarTarefaServlet extends HttpServlet {

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

        HttpSession session = request.getSession();

        Usuario u = (Usuario) session.getAttribute("usuario");

        String titulo = request.getParameter("titulo");

        String imagem = null;
        Part arqImagem = request.getPart("imagem");
        String nomeImagem = Paths.get(arqImagem.getSubmittedFileName()).getFileName().toString();

        String uploadsDiretorio = "/home/igor/uploads_lista_tarefas";
        
        String idUsuario = String.valueOf(u.getId());
        
        // /home/igor/uploads_lista_tarefas/1
        File uploadsDir = new File(uploadsDiretorio, idUsuario);
        
        if (uploadsDir.exists() || uploadsDir.mkdir()) {
            
            // /home/igor/uploads_lista_tarefas/1/imagem.png
            File caminhoImagem = new File(uploadsDir, nomeImagem);
            
            try (InputStream stream = arqImagem.getInputStream()) {
                Files.copy(stream, caminhoImagem.toPath(), StandardCopyOption.REPLACE_EXISTING);
                
                imagem = nomeImagem;
            }
            
        }
        
        Tarefa t = new Tarefa();
        t.setTitulo(titulo);
        t.setFinalizada(false);
        t.setIdUsuario(u.getId());
        t.setNomeImagem(imagem);

        boolean sucesso = TarefaDAO.inserirTarefa(t);

        if (sucesso) {
            response.sendRedirect("HomeServlet");
        } else {
            request.setAttribute("erro", "Não foi possível adicionar a nova tarefa. Tente novamente");
            request.getRequestDispatcher("home.jsp").forward(request, response);
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
