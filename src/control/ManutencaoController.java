package control;

import model.Manutencao;
import repository.ManutencaoRepository;
import java.util.Collection;
import exception.ManutencaoException;
import util.Validacao;

public class ManutencaoController {

    private final ManutencaoRepository repository;

    public ManutencaoController(ManutencaoRepository repository) {
        this.repository = repository;
    }

    public void cadastrarManutencao(Manutencao manutencao) {

        if (Validacao.textoVazio(manutencao.getDescricao())) throw new ManutencaoException("Descrição obrigatória.");
        repository.salvar(manutencao);

    }

    public Collection<Manutencao> listarManutencoes() {
        return repository.listar();
    }

    public void atualizarManutencao(Manutencao manutencao) {

        if (!repository.atualizar(manutencao))
            throw new ManutencaoException("Manutenção não encontrada.");

    }

    public void removerManutencao(Integer id) {

        if (!repository.remover(id))
            throw new ManutencaoException("Manutenção não encontrada.");

    }

}