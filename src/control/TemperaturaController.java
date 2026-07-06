package control;

import model.*;
import repository.AlertaRepository;
import repository.SalaRepository;
import repository.SensorRepository;
import repository.TemperaturaRepository;
import java.util.Collection;
import exception.TemperaturaException;

public class TemperaturaController {

    private final TemperaturaRepository temperaturaRepository;
    private final SensorRepository sensorRepository;
    private final SalaRepository salaRepository;
    private final AlertaRepository alertaRepository;

    public TemperaturaController(
            TemperaturaRepository temperaturaRepository,
            SensorRepository sensorRepository,
            SalaRepository salaRepository,
            AlertaRepository alertaRepository) {

        this.temperaturaRepository = temperaturaRepository;
        this.sensorRepository = sensorRepository;
        this.salaRepository = salaRepository;
        this.alertaRepository = alertaRepository;
    }

    public void registrarTemperatura(Temperatura temperatura) {

        if (temperatura.getValor() < -100 || temperatura.getValor() > 100) {
        throw new TemperaturaException("Temperatura inválida.");
        }

    // 2. Busca o sensor
         Sensor sensor = sensorRepository.buscarPorId(temperatura.getSensorId());

    // 3. VALIDA O SENSOR ANTES DE USÁ-LO
    if (sensor == null) {
        throw new TemperaturaException("Sensor inexistente.");
    }

    // 4. Agora sim é seguro pegar o salaId
    SalaRefrigerada sala = salaRepository.buscarPorId(sensor.getSalaId());

    if (sala == null) {
        throw new TemperaturaException("Sala inexistente.");
    }
        temperaturaRepository.salvar(temperatura);

        if (temperatura.getValor() < sala.getTemperaturaMinima()
                || temperatura.getValor() > sala.getTemperaturaMaxima()) {

            sala.setStatus(StatusSala.ALERTA);

            Alerta alerta = new Alerta(temperatura.getId(),sala.getId(),
                    "Temperatura fora da faixa permitida.",
                    NivelAlerta.ALTO);

            alertaRepository.salvar(alerta);

        } else {

            sala.setStatus(StatusSala.NORMAL);

        }

    }

    public Collection<Temperatura> listarTemperaturas() {
        return temperaturaRepository.listar();
    }

}