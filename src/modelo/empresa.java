package modelo;

public class Empresa {
    private String nombre;
    private String sector;
    private String correo;

    public Empresa(String nombre, String sector, String correo) {
        this.nombre = nombre;
        this.sector = sector;
        this.correo = correo;
    }

    // Métodos getters y setters aquí

    public void editarEmpresa(String nombre, String sector, String correo) {
        this.nombre = nombre;
        this.sector = sector;
        this.correo = correo;
    }
}
