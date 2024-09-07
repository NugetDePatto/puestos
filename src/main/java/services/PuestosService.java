package services;

import java.util.ArrayList;
import java.util.List;

import models.PuestoModel;

public class PuestosService {
    private static List<PuestoModel> puestos = new ArrayList<>();

    private PuestosService() {
    }

    public static List<PuestoModel> getAllPuestosModels() {
        MySQLService.getTable("call tienda.obtenerTodosLosPuestos()", new String[] { "id", "descripcion" })
                .forEach(row -> {
                    puestos.add(new PuestoModel(Integer.parseInt(row.get("id")), row.get("descripcion")));
                });

        return puestos;
    }

    public static boolean addPuestoModel(String descripcion) {
        if (MySQLService.addRow("call tienda.AgregarPuesto(?)", new String[] { "descripcion" },
                new String[] { descripcion })) {
            for (PuestoModel p : getAllPuestosModels()) {
                System.out.println(p.getId());
            }
            return true;
        }
        return false;
    }

    public static boolean updatePuestoModel(int id, String descripcion) {
        if (MySQLService.updateRow("call tienda.ActualizarPuestoById(?, ?)", new String[] { "id", "descripcion" },
                new String[] { Integer.toString(id), descripcion })) {
            for (PuestoModel p : getAllPuestosModels()) {
                System.out.println(p.getId());
            }
            return true;
        }
        return false;
    }

    public static boolean deletePuestoModel(int id) {
        if (MySQLService.deleteRow("call tienda.EliminarPuesto(?)", new String[] { "id" },
                new String[] { Integer.toString(id) })) {
            for (PuestoModel p : getAllPuestosModels()) {
                System.out.println(p.getId());
            }
            return true;
        }
        return false;
    }
}
