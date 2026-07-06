package model;

public class Administrador extends Usuario {

    public Administrador(Integer id,String nome,String email,String senha){
        super(id, nome, email, senha);
    }

    @Override
    public String toString() {
        return "[Administrador] " + super.toString();
    }

}