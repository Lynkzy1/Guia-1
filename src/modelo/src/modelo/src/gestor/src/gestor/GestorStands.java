package gestor;

import modelo.Stand;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestiona los stands de la feria.
 */
public class GestorStands {
    private List<Stand> stands = new ArrayList<>();

    public void agregarStand(Stand stand) {
        stands.add(stand);
    }

    public List<Stand> getStands() {
        return stands;
    }
}
