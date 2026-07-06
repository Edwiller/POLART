package control;

import model.Sensor;
import repository.SensorRepository;
import java.util.Collection;
import exception.SensorException;
import util.Validacao;

public class SensorController {

    private final SensorRepository repository;

    public SensorController(SensorRepository repository) {
        this.repository = repository;
    }

    public void cadastrarSensor(Sensor sensor) {

        if (repository.buscarPorId(sensor.getId()) != null)
            throw new SensorException("Sensor já cadastrado.");

        if (Validacao.textoVazio(sensor.getCodigo()))
            throw new SensorException("Código é obrigatório.");

        if (Validacao.textoVazio(sensor.getModelo()))
            throw new SensorException("Modelo é obrigatório.");

        repository.salvar(sensor);

    }

    public Sensor buscarSensor(Integer id) {
        return repository.buscarPorId(id);
    }

    public Collection<Sensor> listarSensores() {
        return repository.listar();
    }

    public void atualizarSensor(Sensor sensor) {

        if (!repository.atualizar(sensor))
            throw new SensorException("Sensor não encontrado.");

    }

    public void removerSensor(Integer id) {

        if (!repository.remover(id))
            throw new SensorException("Sensor não encontrado.");

    }

}