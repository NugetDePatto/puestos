package repositories;

import java.util.ArrayList;
import java.util.List;

import models.PuestoModel;

public class PuestosRepository {

    private PuestosRepository() {
    }

    public static List<PuestoModel> getAllPuestosModels() {
        List<PuestoModel> puestos = new ArrayList<>();

        MySQLService.getTable("call tienda.obtenerTodosLosPuestos()", new String[] { "id", "descripcion" })
                .forEach(row -> {
                    puestos.add(new PuestoModel(Integer.parseInt(row.get("id")), row.get("descripcion")));
                });

        return puestos;
    }

    public static boolean addPuestoModel(String descripcion) {
        return MySQLService.addRow("call tienda.AgregarPuesto(?)", new String[] { "descripcion" },
                new String[] { descripcion });
    }

    public static boolean updatePuestoModel(int id, String descripcion) {
        return MySQLService.updateRow("call tienda.ActualizarPuestoById(?, ?)", new String[] { "id", "descripcion" },
                new String[] { Integer.toString(id), descripcion });
    }

    public static boolean deletePuestoModel(int id) {
        return MySQLService.deleteRow("call tienda.aunnosehace", new String[] { "id" },
                new String[] { Integer.toString(id) });
    }
}
