package gestor;

import modelo.Stand;
import modelo.Empresa;
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

    public Stand buscarPorNumero(String numero) {
        for (Stand s : stands) {
            if (s.getNumero().equalsIgnoreCase(numero)) {
                return s;
            }
        }
        return null;
    }

    public void asignarStand(String numero, Empresa empresa) {
        Stand s = buscarPorNumero(numero);
        if (s != null && s.estaDisponible()) {
            s.setEmpresaAsignada(empresa);
        }
    }

    public void liberarStand(String numero) {
        Stand s = buscarPorNumero(numero);
        if (s != null) {
            s.setEmpresaAsignada(null);
        }
    }

    public List<Stand> listarDisponibles() {
        List<Stand> disponibles = new ArrayList<>();
        for (Stand s : stands) {
            if (s.estaDisponible()) disponibles.add(s);
        }
        return disponibles;
    }

    public List<Stand> listarOcupados() {
        List<Stand> ocupados = new ArrayList<>();
        for (Stand s : stands) {
            if (!s.estaDisponible()) ocupados.add(s);
        }
        return ocupados;
    }

    public List<Stand> listarStands() {
        return stands;
    }
}
