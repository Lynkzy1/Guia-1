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

    public List<Empresa> getEmpresas() {
        return empresas;
    }
}
