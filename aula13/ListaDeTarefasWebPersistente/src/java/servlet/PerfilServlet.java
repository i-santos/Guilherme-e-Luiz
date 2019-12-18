package servlet;

import dao.UsuarioDAO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import modelo.Usuario;

@WebServlet(name="PerfilServlet", urlPatterns={"/PerfilServlet"})
@MultipartConfig
public class PerfilServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        request.getRequestDispatcher("WEB-INF/perfil.jsp").forward(request, response);
        
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Usuario u = (Usuario) session.getAttribute("usuario");
        
        String senha = request.getParameter("senha");
        Part imagem = request.getPart("imagem");
        
        InputStream iStream = imagem.getInputStream();
        ByteArrayOutputStream oStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[10240];
        
        while (iStream.read(buffer) > 0 ) {
            oStream.write(buffer);
        }
        
        u.setSenha(senha);
        u.setImagem(oStream.toByteArray());
        
        boolean atualizado = UsuarioDAO.atualizarUsuario(u);
        
        String msg = "";
        
        if (atualizado) {
            msg = "Dados atualizados com sucesso";
        } else {
            msg = "Erro ao atulizar os dados. Tente novamente";
        }
        
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("WEB-INF/perfil.jsp").forward(request, response);
        
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
