package model;

import java.time.LocalDate;

public class Manutencao {

    private Integer id;
    private Integer sensorId;
    private String descricao;
    private TipoManutencao tipo;
    private StatusManutencao status;
    private LocalDate data;

    public Manutencao(Integer id,
                      Integer sensorId,
                      String descricao,
                      TipoManutencao tipo) {

        this.id = id;
        this.sensorId = sensorId;
        this.descricao = descricao;
        this.tipo = tipo;
        this.status = StatusManutencao.PENDENTE;
        this.data = LocalDate.now();

    }

    public Integer getId() {
        return id;
    }

    public Integer getSensorId() {
        return sensorId;
    }

    public String getDescricao() {
        return descricao;
    }

    public TipoManutencao getTipo() {
        return tipo;
    }

    public StatusManutencao getStatus() {
        return status;
    }

    public void setStatus(StatusManutencao status) {
        this.status = status;
    }

    public LocalDate getData() {
        return data;
    }

}