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

    public List<Visitante> getVisitantes() {
        return visitantes;
    }
}
