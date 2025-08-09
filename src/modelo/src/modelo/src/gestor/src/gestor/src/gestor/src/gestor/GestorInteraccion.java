package gestor;

import modelo.Comentario;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestiona las interacciones entre visitantes y stands.
 */
public class GestorInteraccion {
    private List<Comentario> comentarios = new ArrayList<>();

    public void agregarComentario(Comentario comentario) {
        comentarios.add(comentario);
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }
}
