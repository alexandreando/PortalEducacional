package models;

import com.google.firebase.Timestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Aviso implements Serializable {
    private String Mensagem;
    private Timestamp Criacao;

    public Aviso(){}
    public Aviso(String mensagem)
    {
        Mensagem = mensagem;
    }

    public String getMensagem(){
        return Mensagem;
    }

    public void setMensagem(String mensagem){
        Mensagem = mensagem;
    }

    public Timestamp getCriacao() {
        return Criacao;
    }

    public void setCriacao(Timestamp criacao) {
        Criacao = criacao;
    }
}
