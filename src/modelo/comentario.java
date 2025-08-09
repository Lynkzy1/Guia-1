package modelo;

import java.time.LocalDate;

/**
 * Representa un comentario realizado por un visitante a un stand.
 */
public class Comentario {
    private Visitante visitante;
    private String mensaje;
    private int calificacion; // 1 a 5
    private LocalDate fecha;
    private Stand stand;

    public Comentario(Visitante visitante, Stand stand, String mensaje, int calificacion, LocalDate fecha) {
        this.visitante = visitante;
        this.stand = stand;
        this.mensaje = mensaje;
        this.calificacion = calificacion;
        this.fecha = fecha;
    }

    public Visitante getVisitante() { return visitante; }
    public Stand getStand() { return stand; }
    public String getMensaje() { return mensaje; }
    public int getCalificacion() { return calificacion; }
    public LocalDate getFecha() { return fecha; }

    @Override
    public String toString() {
        return "Comentario{" +
                "visitante=" + visitante.getNombre() +
                ", stand=" + stand.getNumero() +
                ", mensaje='" + mensaje + '\'' +
                ", calificacion=" + calificacion +
                ", fecha=" + fecha +
                '}';
    }
}
