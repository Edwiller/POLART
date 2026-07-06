package control;

import model.Usuario;
import repository.UsuarioRepository;
import java.util.Collection;
import exception.UsuarioException;
import util.Validacao;
public class UsuarioController {

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void cadastrarUsuario(Usuario usuario) {

    if (repository.buscarPorId(usuario.getId()) != null) {
        throw new UsuarioException("Já existe um usuário com esse ID.");
    }

    if (Validacao.textoVazio(usuario.getNome())) {
        throw new UsuarioException("Nome é obrigatório.");
    }

    if (Validacao.textoVazio(usuario.getEmail())) {
        throw new UsuarioException("E-mail é obrigatório.");
    }

    if (Validacao.textoVazio(usuario.getSenha())) {
        throw new UsuarioException("Senha é obrigatória.");
    }

    if (repository.buscarPorEmail(usuario.getEmail()) != null) {
        throw new UsuarioException("E-mail já cadastrado.");
    }

    repository.salvar(usuario);
    }

    public Usuario login(String email, String senha) {

    if (Validacao.textoVazio(email))
        throw new UsuarioException("Informe o e-mail.");

    if (Validacao.textoVazio(senha))
        throw new UsuarioException("Informe a senha.");

    Usuario usuario = repository.buscarPorEmail(email);

    if (usuario == null)
        throw new UsuarioException("Usuário não encontrado.");

    if (!usuario.autenticar(email, senha))
        throw new UsuarioException("Senha incorreta.");

    return usuario;
}

    public Collection<Usuario> listarUsuarios() {
        return repository.listar();
    }

    public Usuario buscarUsuario(Integer id) {
        return repository.buscarPorId(id);
    }

    public void atualizarUsuario(Usuario usuario) {

        if (!repository.atualizar(usuario))
            throw new UsuarioException("Usuário não encontrado.");

    }

    public void removerUsuario(Integer id) {

        if (!repository.remover(id))
            throw new UsuarioException("Usuário não encontrado.");

    }

}