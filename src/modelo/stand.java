package modelo;

/**
 * Representa un stand en la feria.
 */
public class Stand {
    private String numero; // único
    private String ubicacion;
    private String tamano; // pequeño, mediano, grande
    private Empresa empresaAsignada; // null si libre

    public Stand(String numero, String ubicacion, String tamano) {
        this.numero = numero;
        this.ubicacion = ubicacion;
        this.tamano = tamano;
        this.empresaAsignada = null;
    }

    public String getNumero() { return numero; }
    public String getUbicacion() { return ubicacion; }
    public String getTamano() { return tamano; }
    public Empresa getEmpresaAsignada() { return empresaAsignada; }
    public void setEmpresaAsignada(Empresa empresa) { this.empresaAsignada = empresa; }

    public boolean estaDisponible() {
        return empresaAsignada == null;
    }

    @Override
    public String toString() {
        return "Stand{" +
                "numero='" + numero + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", tamano='" + tamano + '\'' +
                ", empresaAsignada=" + (empresaAsignada == null ? "Disponible" : empresaAsignada.getNombre()) +
                '}';
    }
}
