package repository;

import model.Sensor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SensorRepository {

    private final Map<Integer, Sensor> sensores;

    public SensorRepository() {
        sensores = new HashMap<>();
    }

    public void salvar(Sensor sensor) {
        sensores.put(sensor.getId(), sensor);
    }

    public Sensor buscarPorId(Integer id) {
        return sensores.get(id);
    }

    public Collection<Sensor> listar() {
        return sensores.values();
    }

    public boolean atualizar(Sensor sensor) {

        if (!sensores.containsKey(sensor.getId())) return false;

        sensores.put(sensor.getId(), sensor);

        return true;

    }

    public boolean remover(Integer id) {

        return sensores.remove(id) != null;

    }

}