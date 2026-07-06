package repository;

import model.Usuario;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UsuarioRepository {

    private final Map<Integer, Usuario> usuarios;

    public UsuarioRepository() {

        usuarios = new HashMap<>();

    }

    public void salvar(Usuario usuario) {

        usuarios.put(usuario.getId(), usuario);

    }

    public Usuario buscarPorId(Integer id) {

        return usuarios.get(id);

    }

    public Usuario buscarPorEmail(String email) {

        for (Usuario usuario : usuarios.values()) {

            if (usuario.getEmail().equalsIgnoreCase(email)) {
                return usuario;
            }

        }

        return null;

    }

    public Collection<Usuario> listar() {

        return usuarios.values();

    }

    public boolean atualizar(Usuario usuario) {

        if (!usuarios.containsKey(usuario.getId()))
            return false;

        usuarios.put(usuario.getId(), usuario);

        return true;

    }

    public boolean remover(Integer id) {

        return usuarios.remove(id) != null;

    }

}