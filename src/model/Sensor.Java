package model;

public class Sensor {

    private Integer id;
    private String codigo;
    private String modelo;
    private Integer salaId;
    private Boolean ativo;

    public Sensor(Integer id,
            String codigo,
            String modelo,
            Integer salaId) {

        this.id = id;
        this.codigo = codigo;
        this.modelo = modelo;
        this.salaId = salaId;
        this.ativo = true;

    }

    public Integer getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getSalaId() {
        return salaId;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setSalaId(Integer salaId) {
        this.salaId = salaId;
    }

    @Override
    public String toString() {

        return "Sensor{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", modelo='" + modelo + '\'' +
                ", salaId=" + salaId +
                ", ativo=" + ativo +
                '}';

    }
}

