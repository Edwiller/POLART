package model;

public class SalaRefrigerada {

    private Integer id;
    private String nome;
    private String localizacao;
    private Double temperaturaMinima;
    private Double temperaturaMaxima;
    private StatusSala status;

    public SalaRefrigerada(Integer id,
                           String nome,
                           String localizacao,
                           Double temperaturaMinima,
                           Double temperaturaMaxima) {

        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
        this.status = StatusSala.NORMAL;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Double getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(Double temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public Double getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(Double temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public StatusSala getStatus() {
        return status;
    }

    public void setStatus(StatusSala status) {
        this.status = status;
    }

    @Override
    public String toString() {

        return "SalaRefrigerada{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", localizacao='" + localizacao + '\'' +
                ", temperaturaMinima=" + temperaturaMinima +
                ", temperaturaMaxima=" + temperaturaMaxima +
                ", status=" + status +
                '}';

    }

}