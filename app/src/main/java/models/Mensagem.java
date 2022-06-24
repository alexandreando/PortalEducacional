package models;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Mensagem implements Serializable {
    private String Mensagem;
    private LocalDateTime CriadoEm;
    private String Foto;
    private int UserId;

    public Mensagem(){

    }
    public Mensagem( int userId, String mensagem, String foto)
    {
        UserId = userId;

        Mensagem = mensagem;
        Foto = foto;

        CriadoEm = LocalDateTime.now();
    }

    public int getUserId() { return UserId; }

    public Boolean sameUser(int id) { return  id == UserId; }

    public String getMensagem(){
        return Mensagem;
    }

    public void setMensagem(String mensagem){
        Mensagem = mensagem;
    }

    public String getFoto(){
        return Foto;
    }

    public void setFoto(String foto){
        Foto = foto;
    }

    public LocalDateTime getCriadoEm(){
        return CriadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm){
        CriadoEm = criadoEm;
    }
}
