package modelo;

/**
 */
public class Empresa {
    private String nombre;
    private String rubro;

    public Empresa(String nombre, String rubro) {
        this.nombre = nombre;
        this.rubro = rubro;
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getRubro() { return rubro; }
    public void setRubro(String rubro) { this.rubro = rubro; }
}
