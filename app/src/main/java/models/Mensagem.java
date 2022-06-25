package models;

import com.google.firebase.Timestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class Mensagem implements Serializable {
    private String Mensagem;
    private String Foto;
    private int UserId;
    private Timestamp Criacao;

    public Mensagem(){

    }
    public Mensagem( int userId, String mensagem, String foto)
    {
        UserId = userId;

        Mensagem = mensagem;
        Foto = foto;

        Criacao = Timestamp.now();
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

    public Timestamp getCriacao() {
        return Criacao;
    }

    public void setCriacao(Timestamp criacao) {
        Criacao = criacao;
    }

}
