package gestor;

import modelo.Empresa;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestiona las empresas participantes en la feria.
 */
public class GestorEmpresas {
    private List<Empresa> empresas = new ArrayList<>();

    public void agregarEmpresa(Empresa empresa) {
        empresas.add(empresa);
    }

    public Empresa buscarPorNombre(String nombre) {
        for (Empresa e : empresas) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return e;
            }
        }
        return null;
    }

    public void eliminarEmpresa(String nombre) {
        empresas.removeIf(e -> e.getNombre().equalsIgnoreCase(nombre));
    }

    public void editarEmpresa(String nombre, String nuevoNombre, String nuevoSector, String nuevoCorreo) {
        Empresa e = buscarPorNombre(nombre);
        if (e != null) {
            e.editar(nuevoNombre, nuevoSector, nuevoCorreo);
        }
    }

    public List<Empresa> listarEmpresas() {
        return empresas;
    }
}
