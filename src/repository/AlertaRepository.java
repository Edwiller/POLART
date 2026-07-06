package repository;

import model.Alerta;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AlertaRepository {

    private final Map<Integer, Alerta> alertas;

    public AlertaRepository() {

        alertas = new HashMap<>();

    }

    public void salvar(Alerta alerta) {

        alertas.put(alerta.getId(), alerta);

    }

    public Alerta buscarPorId(Integer id) {

        return alertas.get(id);

    }

    public Collection<Alerta> listar() {

        return alertas.values();

    }

    public boolean atualizar(Alerta alerta) {

        if (!alertas.containsKey(alerta.getId()))
            return false;

        alertas.put(alerta.getId(), alerta);

        return true;

    }

    public boolean remover(Integer id) {

        return alertas.remove(id) != null;

    }

}