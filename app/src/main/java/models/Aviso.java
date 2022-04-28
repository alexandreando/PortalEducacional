package models;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Aviso implements Serializable {
    private String Mensagem;
    private LocalDateTime CriadoEm;

    public Aviso(String mensagem)
    {
        Mensagem = mensagem;

        CriadoEm = LocalDateTime.now();
    }

    public String getMensagem(){
        return Mensagem;
    }

    public void setMensagem(String mensagem){
        Mensagem = mensagem;
    }
}
