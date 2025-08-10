package feria;

import gestor.*;
import modelo.*;
import reporte.GeneradorReporte;

import java.time.LocalDate;
import java.util.Scanner;

public class FeriaEmpresarial {
    public static void main(String[] args) {
        GestorEmpresas gestorEmpresas = new GestorEmpresas();
        GestorStands gestorStands = new GestorStands();
        GestorVisitantes gestorVisitantes = new GestorVisitantes();
        GestorInteraccion gestorInteraccion = new GestorInteraccion();
        GeneradorReporte generadorReporte = new GeneradorReporte(gestorEmpresas, gestorStands, gestorVisitantes, gestorInteraccion);

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("----- Menú Feria Empresarial -----");
            System.out.println("1. Registrar empresa");
            System.out.println("2. Editar empresa");
            System.out.println("3. Eliminar empresa");
            System.out.println("4. Registrar stand");
            System.out.println("5. Asignar stand a empresa");
            System.out.println("6. Listar stands disponibles/ocupados");
            System.out.println("7. Registrar visitante");
            System.out.println("8. Editar visitante");
            System.out.println("9. Eliminar visitante");
            System.out.println("10. Visitar stand y dejar comentario");
            System.out.println("11. Reporte: Empresas y Stands asignados");
            System.out.println("12. Reporte: Visitantes y Stands visitados");
            System.out.println("13. Reporte: Calificación promedio por stand");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Nombre empresa: ");
                    String nombreE = scanner.nextLine();
                    System.out.print("Sector: ");
                    String sector = scanner.nextLine();
                    System.out.print("Correo: ");
                    String correoE = scanner.nextLine();
                    gestorEmpresas.agregarEmpresa(new Empresa(nombreE, sector, correoE));
                    System.out.println("Empresa registrada.\n");
                    break;
                case 2:
                    System.out.print("Nombre empresa a editar: ");
                    String nombreEditar = scanner.nextLine();
                    Empresa empresaEditar = gestorEmpresas.buscarPorNombre(nombreEditar);
                    if (empresaEditar != null) {
                        System.out.print("Nuevo nombre: ");
                        String nuevoNombreE = scanner.nextLine();
                        System.out.print("Nuevo sector: ");
                        String nuevoSector = scanner.nextLine();
                        System.out.print("Nuevo correo: ");
                        String nuevoCorreoE = scanner.nextLine();
                        gestorEmpresas.editarEmpresa(nombreEditar, nuevoNombreE, nuevoSector, nuevoCorreoE);
                        System.out.println("Empresa editada.\n");
                    } else {
                        System.out.println("Empresa no encontrada.\n");
                    }
                    break;
                case 3:
                    System.out.print("Nombre empresa a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    gestorEmpresas.eliminarEmpresa(nombreEliminar);
                    System.out.println("Empresa eliminada (si existía).\n");
                    break;
                case 4:
                    System.out.print("Número de stand: ");
                    String numero = scanner.nextLine();
                    System.out.print("Ubicación (Ej: Pabellón A, Stand 10): ");
                    String ubicacion = scanner.nextLine();
                    System.out.print("Tamaño (pequeño/mediano/grande): ");
                    String tamano = scanner.nextLine();
                    gestorStands.agregarStand(new Stand(numero, ubicacion, tamano));
                    System.out.println("Stand registrado.\n");
                    break;
                case 5:
                    System.out.print("Número de stand: ");
                    String numStand = scanner.nextLine();
                    System.out.print("Nombre de empresa a asignar: ");
                    String nombreEmp = scanner.nextLine();
                    Empresa emp = gestorEmpresas.buscarPorNombre(nombreEmp);
                    if (emp != null) {
                        gestorStands.asignarStand(numStand, emp);
                        System.out.println("Stand asignado.\n");
                    } else {
                        System.out.println("Empresa no encontrada.\n");
                    }
                    break;
                case 6:
                    System.out.println("Stands disponibles:");
                    for (Stand s : gestorStands.listarDisponibles()) {
                        System.out.println(s);
                    }
                    System.out.println("Stands ocupados:");
                    for (Stand s : gestorStands.listarOcupados()) {
                        System.out.println(s);
                    }
                    break;
                case 7:
                    System.out.print("Nombre visitante: ");
                    String nombreV = scanner.nextLine();
                    System.out.print("Identificación: ");
                    String idV = scanner.nextLine();
                    System.out.print("Correo: ");
                    String correoV = scanner.nextLine();
                    gestorVisitantes.agregarVisitante(new Visitante(nombreV, idV, correoV));
                    System.out.println("Visitante registrado.\n");
                    break;
                case 8:
                    System.out.print("Identificación visitante a editar: ");
                    String idEditar = scanner.nextLine();
                    Visitante vEditar = gestorVisitantes.buscarPorId(idEditar);
                    if (vEditar != null) {
                        System.out.print("Nuevo nombre: ");
                        String nNombre = scanner.nextLine();
                        System.out.print("Nueva identificación: ");
                        String nId = scanner.nextLine();
                        System.out.print("Nuevo correo: ");
                        String nCorreo = scanner.nextLine();
                        gestorVisitantes.editarVisitante(idEditar, nNombre, nId, nCorreo);
                        System.out.println("Visitante editado.\n");
                    } else {
                        System.out.println("Visitante no encontrado.\n");
                    }
                    break;
                case 9:
                    System.out.print("Identificación visitante a eliminar: ");
                    String idEliminar = scanner.nextLine();
                    gestorVisitantes.eliminarVisitante(idEliminar);
                    System.out.println("Visitante eliminado (si existía).\n");
                    break;
                case 10:
                    System.out.print("Identificación visitante: ");
                    String idVis = scanner.nextLine();
                    Visitante visitante = gestorVisitantes.buscarPorId(idVis);
                    if (visitante != null) {
                        System.out.print("Número de stand a visitar: ");
                        String nStand = scanner.nextLine();
                        Stand stand = gestorStands.buscarPorNumero(nStand);
                        if (stand != null) {
                            System.out.print("Comentario: ");
                            String comentario = scanner.nextLine();
                            System.out.print("Calificación (1-5): ");
                            int calif = Integer.parseInt(scanner.nextLine());
                            gestorInteraccion.agregarComentario(new Comentario(
                                    visitante, stand, comentario, calif, LocalDate.now()
                            ));
                            System.out.println("Comentario registrado.\n");
                        } else {
                            System.out.println("Stand no encontrado.\n");
                        }
                    } else {
                        System.out.println("Visitante no encontrado.\n");
                    }
                    break;
                case 11:
                    generadorReporte.reporteEmpresasStands();
                    break;
                case 12:
                    generadorReporte.reporteVisitantesStands(gestorInteraccion);
                    break;
                case 13:
                    generadorReporte.reportePromedioStands(gestorInteraccion);
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.\n");
            }
        } while (opcion != 0);
    }
}
