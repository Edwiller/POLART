package model;

public class Operador extends Usuario {

    public Operador(Integer id,String nome,String email,String senha) {
        super(id, nome, email, senha);
    }

    @Override
    public String toString() {
        return "[Operador] " + super.toString();
    }

}