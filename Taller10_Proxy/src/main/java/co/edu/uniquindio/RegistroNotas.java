package co.edu.uniquindio;

// SUBJECT: la interfaz común que usa todo el sistema
public interface RegistroNotas {
    String verNota(String estudiante);
    void cambiarNota(String estudiante, double nota);
}
