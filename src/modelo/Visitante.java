package modelo;

/**
 * Representa un visitante de la feria.
 */
public class Visitante {
    private String nombre;

    public Visitante(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
