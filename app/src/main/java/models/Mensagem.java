package models;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Mensagem implements Serializable {
    private String Mensagem;
    private LocalDateTime CriadoEm;
    private String Foto;

    public Mensagem(String mensagem, String foto)
    {
        Mensagem = mensagem;
        Foto = foto;

        CriadoEm = LocalDateTime.now();
    }

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
}
