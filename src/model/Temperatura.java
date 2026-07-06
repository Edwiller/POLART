package model;

import java.time.LocalDateTime;

public class Temperatura {

    private Integer id;
    private Integer sensorId;
    private Double valor;
    private LocalDateTime dataHora;

    public Temperatura(Integer id,
                       Integer sensorId,
                       Double valor) {

        this.id = id;
        this.sensorId = sensorId;
        this.valor = valor;
        this.dataHora = LocalDateTime.now();

    }

    public Integer getId() {
        return id;
    }

    public Integer getSensorId() {
        return sensorId;
    }

    public Double getValor() {
        return valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    @Override
    public String toString() {

        return "Temperatura{" +
                "id=" + id +
                ", sensorId=" + sensorId +
                ", valor=" + valor +
                ", dataHora=" + dataHora +
                '}';

    }

}