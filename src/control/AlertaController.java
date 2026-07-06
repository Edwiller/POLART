package control;

import model.Alerta;
import repository.AlertaRepository;

import java.util.Collection;

import exception.AlertaException;

public class AlertaController {

    private final AlertaRepository repository;

    public AlertaController(AlertaRepository repository) {
        this.repository = repository;
    }

    public void salvarAlerta(Alerta alerta) {

        repository.salvar(alerta);

    }

    public Collection<Alerta> listarAlertas() {
        return repository.listar();
    }

    public void resolverAlerta(Integer id) {

        Alerta alerta = repository.buscarPorId(id);

        if (alerta == null)
            throw new AlertaException("Alerta não encontrado.");

        alerta.setResolvido(true);

        repository.atualizar(alerta);

    }

}