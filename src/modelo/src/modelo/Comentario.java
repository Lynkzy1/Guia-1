package modelo;

/**
 * Representa un comentario realizado por un visitante a un stand.
 */
public class Comentario {
    private Visitante visitante;
    private String mensaje;
    private int calificacion; // 1 a 5

    public Comentario(Visitante visitante, String mensaje, int calificacion) {
        this.visitante = visitante;
        this.mensaje = mensaje;
        this.calificacion = calificacion;
    }

    // Getters y setters
    public Visitante getVisitante() { return visitante; }
    public void setVisitante(Visitante visitante) { this.visitante = visitante; }
    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
    public int getCalificacion() { return calificacion; }
    public void setCalificacion(int calificacion) { this.calificacion = calificacion; }
}
