package control;

import model.SalaRefrigerada;
import repository.SalaRepository;
import java.util.Collection;
import exception.SalaException;
import util.Validacao;

public class SalaController {

    private final SalaRepository repository;

    public SalaController(SalaRepository repository) {
        this.repository = repository;
    }

    public void cadastrarSala(SalaRefrigerada sala) {

    if (repository.buscarPorId(sala.getId()) != null) {
        throw new SalaException("Já existe uma sala com esse ID.");
    }

    if (Validacao.textoVazio(sala.getNome())) {
        throw new SalaException("Nome da sala é obrigatório.");
    }

    if (Validacao.textoVazio(sala.getLocalizacao())) {
        throw new SalaException("Localização é obrigatória.");
    }

    if (!Validacao.temperaturaValida(
            sala.getTemperaturaMinima(),
            sala.getTemperaturaMaxima())) {

        throw new SalaException(
                "A temperatura mínima deve ser menor que a máxima.");
    }

    repository.salvar(sala);
}

    public SalaRefrigerada buscarSala(Integer id) {
        return repository.buscarPorId(id);
    }

    public Collection<SalaRefrigerada> listarSalas() {
        return repository.listar();
    }

    public void atualizarSala(SalaRefrigerada sala) {

        if (!repository.atualizar(sala))
            throw new SalaException("Sala não encontrada.");

    }

    public void removerSala(Integer id) {

        if (!repository.remover(id))
            throw new SalaException("Sala não encontrada.");

    }

}