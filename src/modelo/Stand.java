package modelo;

/**
 * Representa un stand en la feria.
 */
public class Stand {
    private String codigo;
    private Empresa empresaAsignada;

    public Stand(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public Empresa getEmpresaAsignada() { return empresaAsignada; }
    public void setEmpresaAsignada(Empresa empresa) { this.empresaAsignada = empresa; }
}
