package reporte;

import gestor.*;
import modelo.*;

public class GeneradorReporte {
    private GestorEmpresas gestorEmpresas;
    private GestorStands gestorStands;
    private GestorVisitantes gestorVisitantes;
    private GestorInteraccion gestorInteraccion;

    public GeneradorReporte(GestorEmpresas ge, GestorStands gs, GestorVisitantes gv, GestorInteraccion gi) {
        this.gestorEmpresas = ge;
        this.gestorStands = gs;
        this.gestorVisitantes = gv;
        this.gestorInteraccion = gi;
    }

    // Reporte 1: Empresas y Stands asignados
    public void reporteEmpresasStands() {
        System.out.println("---- Empresas y sus Stands asignados ----");
        for (Empresa e : gestorEmpresas.listarEmpresas()) {
            System.out.print("Empresa: " + e.getNombre());
            boolean encontrado = false;
            for (Stand s : gestorStands.listarStands()) {
                if (s.getEmpresaAsignada() != null && s.getEmpresaAsignada().getNombre().equals(e.getNombre())) {
                    System.out.print(" | Stand: " + s.getNumero() + " (" + s.getUbicacion() + ")");
                    encontrado = true;
                }
            }
            if (!encontrado) System.out.print(" | Sin stand asignado");
            System.out.println();
        }
        System.out.println();
    }

    // Reporte 2: Visitantes y Stands visitados
    public void reporteVisitantesStands(GestorInteraccion gi) {
        System.out.println("---- Visitantes y Stands visitados ----");
        for (Visitante v : gestorVisitantes.listarVisitantes()) {
            System.out.print("Visitante: " + v.getNombre() + " (" + v.getIdentificacion() + ")");
            boolean visitado = false;
            for (Comentario c : gi.listarPorVisitante(v.getIdentificacion())) {
                System.out.print(" | Stand: " + c.getStand().getNumero() + " [" + c.getCalificacion() + "★]");
                visitado = true;
            }
            if (!visitado) System.out.print(" | Sin visitas registradas");
            System.out.println();
        }
        System.out.println();
    }

    // Reporte 3: Promedio calificación por stand
    public void reportePromedioStands(GestorInteraccion gi) {
        System.out.println("---- Promedio de calificación por Stand ----");
        for (Stand s : gestorStands.listarStands()) {
            double promedio = gi.promedioCalificacionStand(s.getNumero());
            System.out.println("Stand: " + s.getNumero() + " | Promedio: " + (promedio > 0 ? promedio : "Sin calificaciones"));
        }
        System.out.println();
    }
}
