package services;

import java.util.List;

import models.PuestoModel;

public class PuestosService {
    // private static PuestosService instance;
    private static List<PuestoModel> listPuestos;

    public PuestosService() {
        listPuestos = new java.util.ArrayList<>();
        testPuestos();
    }

    // public static PuestosService get() {
    // return instance;
    // }

    // public static PuestosService init() {
    // instance = new PuestosService();
    // listPuestos = new ArrayList<>();

    // instance.testPuestos();

    // return instance;
    // }

    public List<PuestoModel> getListPuestos() {
        return listPuestos;
    }

    public void addPuesto(PuestoModel puesto) {
        listPuestos.add(puesto);
    }

    public void removePuesto(PuestoModel puesto) {
        listPuestos.remove(puesto);
    }

    public void updatePuesto(PuestoModel puesto) {
        for (PuestoModel p : listPuestos) {
            if (p.getId() == puesto.getId()) {
                p.setDescripcion(puesto.getDescripcion());
            }
        }
    }

    public PuestoModel getPuestoById(int id) {
        for (PuestoModel p : listPuestos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void removePuestoById(int id) {
        for (PuestoModel p : listPuestos) {
            if (p.getId() == id) {
                PuestosService.listPuestos.remove(p);
            }
        }
    }

    public void testPuestos() {
        listPuestos.add(new PuestoModel(1, "Gerente"));
        listPuestos.add(new PuestoModel(2, "Subgerente"));
        listPuestos.add(new PuestoModel(3, "Jefe"));
        listPuestos.add(new PuestoModel(4, "Empleado"));
        listPuestos.add(new PuestoModel(5, "Gerente"));
        listPuestos.add(new PuestoModel(6, "Subgerente"));
        listPuestos.add(new PuestoModel(7, "Jefe"));
        listPuestos.add(new PuestoModel(8, "Empleado"));
    }
}
