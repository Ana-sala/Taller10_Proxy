package co.edu.uniquindio;

import java.util.HashMap;
import java.util.Map;

// REAL SUBJECT: guarda las notas de verdad (copiada tal cual, NO se modifica)
public class RegistroNotasReal implements RegistroNotas {
    private Map<String, Double> notas = new HashMap<>();

    public RegistroNotasReal() {
        notas.put("Ana", 4.2);
        notas.put("Luis", 3.1);
    }

    @Override
    public String verNota(String estudiante) {
        return estudiante + ": " + notas.get(estudiante);
    }

    @Override
    public void cambiarNota(String estudiante, double nota) {
        notas.put(estudiante, nota);
        System.out.println("Nota de " + estudiante + " cambiada a " + nota);
    }
}
