package co.edu.uniquindio;

/*
 *
 *
 * 1. Piezas del patrón:
 *    - Subject:     RegistroNotas (la interfaz común)
 *    - RealSubject: RegistroNotasReal (guarda y cambia las notas de verdad)
 *    - Proxy:       ProxyNotas (verifica el rol y registra antes de delegar al real)
 *    - Cliente:     Main (solo conoce la interfaz RegistroNotas)
 *
 * Reto: ¿tuviste que modificar RegistroNotasReal o el main?
 *    No. Para agregar el registro ([LOG]) solo se cambió el proxy; RegistroNotasReal
 *    y el main quedaron igual. Lo explica el Principio Abierto/Cerrado (OCP): se
 *    agrega comportamiento nuevo sin tocar el código que ya funcionaba. También se
 *    relaciona con el de Responsabilidad Única (SRP): el real solo guarda notas y el
 *    control de acceso y el registro son responsabilidad del proxy.
 */
// CLIENTE: las variables son del tipo de la interfaz
public class Main {
    public static void main(String[] args) {
        RegistroNotas real = new RegistroNotasReal();          // UN solo registro real

        RegistroNotas docente    = new ProxyNotas(real, "DOCENTE");
        RegistroNotas estudiante = new ProxyNotas(real, "ESTUDIANTE");

        estudiante.cambiarNota("Luis", 5.0);                   // se niega
        docente.cambiarNota("Luis", 4.0);                      // se permite
        System.out.println(estudiante.verNota("Luis"));        // ve el cambio del docente
    }
}
