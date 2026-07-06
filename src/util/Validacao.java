package util;

public class Validacao {

    public static boolean textoVazio(String texto) {

        return texto == null || texto.trim().isEmpty();

    }

    public static boolean temperaturaValida(
            double min,
            double max) {

        return min < max;

    }

}