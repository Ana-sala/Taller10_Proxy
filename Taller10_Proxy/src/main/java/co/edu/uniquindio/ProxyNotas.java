package co.edu.uniquindio;

// PROXY: implementa la misma interfaz, controla el acceso y delega al real.
// Es proxy de PROTECCIÓN (cambiarNota) y de REGISTRO (verNota, reto).
public class ProxyNotas implements RegistroNotas {          // (1) implements RegistroNotas
    private RegistroNotas real;                             // (2) TIENE el real (composición), private
    private String rol;

    public ProxyNotas(RegistroNotas real, String rol) {     //     recibidos por el constructor
        this.real = real;
        this.rol = rol;
    }

    @Override
    public String verNota(String estudiante) {
        // Reto: proxy de registro
        System.out.println("[LOG] " + rol + " consulto la nota de " + estudiante);
        return real.verNota(estudiante);                    // (4) cualquiera puede ver: siempre delega
    }

    @Override
    public void cambiarNota(String estudiante, double nota) {
        if (!rol.equals("DOCENTE")) {                       // (3) controla antes
            System.out.println("Acceso denegado: " + rol + " no puede cambiar notas");
            return;                                         //     sin el return la nota se cambiaría igual
        }
        real.cambiarNota(estudiante, nota);                 // (4) delega al real
    }
}
