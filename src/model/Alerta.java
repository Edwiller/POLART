package model;

import java.time.LocalDateTime;

public class Alerta {

    private Integer id;
    private Integer salaId;
    private String mensagem;
    private NivelAlerta nivel;
    private Boolean resolvido;
    private LocalDateTime dataHora;

    public Alerta(Integer id,
                  Integer salaId,
                  String mensagem,
                  NivelAlerta nivel) {

        this.id = id;
        this.salaId = salaId;
        this.mensagem = mensagem;
        this.nivel = nivel;
        this.resolvido = false;
        this.dataHora = LocalDateTime.now();

    }

    public Integer getId() {
        return id;
    }

    public Integer getSalaId() {
        return salaId;
    }

    public String getMensagem() {
        return mensagem;
    }

    public NivelAlerta getNivel() {
        return nivel;
    }

    public Boolean getResolvido() {
        return resolvido;
    }

    public void setResolvido(Boolean resolvido) {
        this.resolvido = resolvido;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

}