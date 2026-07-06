package repository;

import model.Manutencao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ManutencaoRepository {

    private final Map<Integer, Manutencao> manutencoes;

    public ManutencaoRepository() {

        manutencoes = new HashMap<>();

    }

    public void salvar(Manutencao manutencao) {

        manutencoes.put(manutencao.getId(), manutencao);

    }

    public Manutencao buscarPorId(Integer id) {

        return manutencoes.get(id);

    }

    public Collection<Manutencao> listar() {

        return manutencoes.values();

    }

    public boolean atualizar(Manutencao manutencao) {

        if (!manutencoes.containsKey(manutencao.getId()))
            return false;

        manutencoes.put(manutencao.getId(), manutencao);

        return true;

    }

    public boolean remover(Integer id) {

        return manutencoes.remove(id) != null;

    }

}