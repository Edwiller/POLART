package repository;

import model.Temperatura;

import java.util.*;

public class TemperaturaRepository {

    private final Map<Integer, Temperatura> temperaturas;

    public TemperaturaRepository() {

        temperaturas = new HashMap<>();

    }

    public void salvar(Temperatura temperatura) {

        temperaturas.put(temperatura.getId(), temperatura);

    }

    public Temperatura buscarPorId(Integer id) {

        return temperaturas.get(id);

    }

    public Collection<Temperatura> listar() {

        return temperaturas.values();

    }

    public boolean remover(Integer id) {

        return temperaturas.remove(id) != null;

    }

}