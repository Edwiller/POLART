package repository;

import model.SalaRefrigerada;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SalaRepository {

    private final Map<Integer, SalaRefrigerada> salas;

    public SalaRepository() {
        this.salas = new HashMap<>();
    }

    public void salvar(SalaRefrigerada sala) {
        salas.put(sala.getId(), sala);
    }

    public SalaRefrigerada buscarPorId(Integer id) {
        return salas.get(id);
    }

    public Collection<SalaRefrigerada> listar() {
        return salas.values();
    }

    public boolean atualizar(SalaRefrigerada sala) {

        if (!salas.containsKey(sala.getId())) return false;

        salas.put(sala.getId(), sala);
        return true;
    }

    public boolean remover(Integer id) {

        return salas.remove(id) != null;

    }

}