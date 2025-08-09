package gestor;

import modelo.Comentario;
import modelo.Stanÿd;
import modelo.Visitante;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Gestiona las interacciones entre visitantes y stands.
 */
public class GestorInteraccion {
    private List<Comentario> comentarios = new ArrayList<>();

    public void agregarComentario(Comentario comentario) {
        comentarios.add(comentario);
    }

    public List<Comentario> listarPorStand(String numeroStand) {
        return comentarios.stream()
                .filter(c -> c.getStand().getNumero().equalsIgnoreCase(numeroStand))
                .collect(Collectors.toList());
    }

    public List<Comentario> listarPorVisitante(String idVisitante) {
        return comentarios.stream()
                .filter(c -> c.getVisitante().getIdentificacion().equalsIgnoreCase(idVisitante))
                .collect(Collectors.toList());
    }

    public List<Comentario> listarComentarios() {
        return comentarios;
    }

    public double promedioCalificacionStand(String numeroStand) {
        List<Comentario> lista = listarPorStand(numeroStand);
        if (lista.isEmpty()) return 0;
        double suma = 0;
        for (Comentario c : lista) {
            suma += c.getCalificacion();
        }
        return suma / lista.size();
    }
}
