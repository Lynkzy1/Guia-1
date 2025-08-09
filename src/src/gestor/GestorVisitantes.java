package gestor;

import modelo.Visitante;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestiona los visitantes de la feria.
 */
public class GestorVisitantes {
    private List<Visitante> visitantes = new ArrayList<>();

    public void agregarVisitante(Visitante visitante) {
        visitantes.add(visitante);
    }

    public Visitante buscarPorId(String identificacion) {
        for (Visitante v : visitantes) {
            if (v.getIdentificacion().equalsIgnoreCase(identificacion)) {
                return v;
            }
        }
        return null;
    }

    public void eliminarVisitante(String identificacion) {
        visitantes.removeIf(v -> v.getIdentificacion().equalsIgnoreCase(identificacion));
    }

    public void editarVisitante(String identificacion, String nuevoNombre, String nuevoId, String nuevoCorreo) {
        Visitante v = buscarPorId(identificacion);
        if (v != null) {
            v.editar(nuevoNombre, nuevoId, nuevoCorreo);
        }
    }

    public List<Visitante> listarVisitantes() {
        return visitantes;
    }
}
