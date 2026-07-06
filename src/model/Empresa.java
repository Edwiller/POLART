package model;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private int id;

    private String nome;

    private String cnpj;

    private List<SalaRefrigerada> salas;

    public Empresa(int id, String nome, String cnpj) {

        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.salas = new ArrayList<>();

    }

    public void adicionarSala(SalaRefrigerada sala){

        salas.add(sala);

    }

    public void removerSala(SalaRefrigerada sala){

        salas.remove(sala);

    }

    public int getId() {

        return id;

    }

    public String getNome() {

        return nome;

    }

    public String getCnpj() {

        return cnpj;

    }

    public List<SalaRefrigerada> getSalas() {

        return salas;

    }

}