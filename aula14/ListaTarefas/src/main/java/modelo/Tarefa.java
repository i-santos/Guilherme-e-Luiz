package modelo;

public class Tarefa {

    private int id;
    private String titulo;
    private boolean finalizada;
    private int idUsuario;
    private byte[] imagem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] nomeImagem) {
        this.imagem = nomeImagem;
    }

}
